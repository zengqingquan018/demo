package com.example.demo.common.utils;


import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author ZQQ
 * @Date 2020/2/14 15:55
 */
public class ExcelUtils {
    /**
     * 描述:获取EXCEL的数据，入参为MultipartFile，出参为List<String []>，String[]为每一行的数据，空行跳过
     *
     * @param file
     * @return {@link List< String[]>}
     * @throws
     * @author ZQQ
     *
     */
    public static List<String[]> getExcelData(MultipartFile file) throws IOException {
        InputStream inputStream;
        inputStream = file.getInputStream();
        return getExcelData(inputStream);
    }


    /**
     * 描述:获取EXCEL的数据，入参为流，出参为List<String []>，String[]为每一行的数据，空行跳过
     * <p> test</p>
     *
     * @param inputStream
     * @return {@link List< String[]>}
     * @throws
     * @author ZQQ
     *
     */
    public static List<String[]> getExcelData(InputStream inputStream) throws IOException {

        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        //getPhysicalNumberOfRows是实际不为空的行数，如果中间有空行，造成最后行的数据无法获取
        // getLastRowNum从0开始的 所以实际上需要加1
        int rows = sheet.getLastRowNum() + 1;
        List<String[]> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            Row row = sheet.getRow(i);
            //这一行为空，则跳过
            if (null == row) {
                continue;
            }
            int cellNum = row.getLastCellNum();
            String[] cellBody = new String[cellNum];
            for (int j = 0; j < cellNum; j++) {
                Cell cell = row.getCell(j);
                String cellValue = getCellValue(cell);
                cellBody[j] = cellValue;
            }
            result.add(cellBody);
        }
        return result;
    }

    /**
     * 描述:获取cell的值
     *
     * @param cell
     * @return {@link String}
     * @throws
     * @author ZQQ
     *
     */
    private static String getCellValue(Cell cell) {
        String cellValue = null;
        if (null != cell) {
            switch (cell.getCellType()) {
                case NUMERIC: {
                    if (DateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        cellValue = DateUtils.formatDateTime(date);
                    } else {
                        Object cellValueObject = judgeLongOrDouble(cell.getNumericCellValue());
                        cellValue = String.valueOf(cellValueObject);
                    }
                    break;
                }
                case STRING: {
                    cellValue = cell.getStringCellValue();
                    break;
                }
                case BOOLEAN: {
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                }
                // 公式算出来的值
                case FORMULA: {
                    try {
                        Object cellValueObject = judgeLongOrDouble(cell.getNumericCellValue());
                        cellValue = String.valueOf(cellValueObject);
                    } catch (IllegalStateException e) {
                        cellValue = String.valueOf(cell.getStringCellValue());
                    }
                    break;
                }
                default: {
                    cellValue = cell.toString();
                    break;
                }

            }
        }
        return cellValue;
    }


    /**
     * 描述:判断excel中数字的类型，excel中的1会被读成1.0，
     *
     * @param value
     * @return {@link Object}
     * @throws
     * @author ZQQ
     *
     */
    private static Object judgeLongOrDouble(Double value) {
        Object cellValueObject;
        Double doubleVal = value;
        long longVal = Math.round(doubleVal);
        if (new BigDecimal(longVal).compareTo(new BigDecimal(doubleVal)) == 0) {
            cellValueObject = longVal;
        } else {
            cellValueObject = doubleVal;
        }
        return cellValueObject;

    }

}
