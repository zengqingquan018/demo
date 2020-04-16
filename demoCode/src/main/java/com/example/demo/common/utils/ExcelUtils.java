package com.example.demo.common.utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    /**
     * 描述:获取EXCEL的数据，入参为MultipartFile，出参为List<String []>，String[]为每一行的数据，空行跳过
     *
     * @param file
     * @return {@link List< String[]>}
     * @throws
     * @author
     * @date 2020/4/16 10:48
     */
    public static List<String[]> getExcelData(MultipartFile file) throws IOException, InvalidFormatException {
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
     * @author zqq
     * @date 2020/4/16 10:48
     */
    public static List<String[]> getExcelData(InputStream inputStream) throws IOException, InvalidFormatException {

        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        //getPhysicalNumberOfRows是实际不为空的行数，如果中间有空行，造成最后行的数据无法获取
        //int rows = sheet.getPhysicalNumberOfRows();
        int rows = sheet.getLastRowNum();
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
                if (null != cell) {
                    cell.setCellType(CellType.STRING);
                    cellBody[j] = cell.getStringCellValue();
                } else {
                    cellBody[j] = null;
                    continue;
                }
            }
            result.add(cellBody);
        }
        return result;
    }
}
