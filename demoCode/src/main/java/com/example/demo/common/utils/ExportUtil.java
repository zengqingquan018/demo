package com.example.demo.common.utils;

import java.util.concurrent.Semaphore;

/**
 * Created by zhangkefeng on 2017/8/23.
 */
public class ExportUtil {

    //导出限流器
//    public static final RateLimiter EXPORT_LIMIT = RateLimiter.create(5);
    public static final Semaphore EXPORT_LIMIT = new Semaphore(2, true);

    //限流时提示信息
    public static final String failMsg = "请求数较多，请稍候重试";
    //SXSSFWorkbook 填充指定行数的数据 刷入硬盘
    public static final int EXCEL_FLUSH_LIMIT = 1000;


    //excel sheet 数据条数上限
    public static final int EXCEL_SHEET_SIZE = 1000000;

    // 一次性读取数据条数限制
    public static final int QUERY_MAX_ROW = 50000;

    //sheet 写满数据要进行的读取次数
    public static final int SHEET_QUERY_COUNT = 5;

    //销项发票统计
    public static final String[] SALE_COLLECTION_EXPORT_FIELD = {
            "c_orderno", "c_kprqd", "c_kptypename", "c_invoice_line", "fpdm",
            "fphm", "c_buyername", "c_buyertaxnum", "c_buyerphone",
            "c_buyeraccount", "c_buyeraddress",
            "c_goodsname", "c_spec", "c_unit",
            "i_num", "f_price", "f_taxrate",
            "f_tax_amount",
            "c_hsbzname", "f_ordertotal_calc",
            "f_bhtaxtotal_calc", "f_taxtotal_calc", "c_remark",
            "c_salename", "c_saletaxnum", "c_saleaccount", "c_saleaddress"
            , "c_salephone", "c_clerk", "deptid", "request_src"
    };
    //不含明细销项发票统计
    public static final String[] SALE_COLLECTION_WITHOUT_DETAIL_EXPORT_FIELD = {
            "c_orderno", "c_kprqd", "c_kptypename", "c_invoice_line", "fpdm",
            "fphm", "c_buyername", "c_buyertaxnum", "c_buyerphone",
            "c_buyeraccount", "c_buyeraddress", "f_ordertotal_calc",
            "f_bhtaxtotal_calc", "f_taxtotal_calc", "c_remark",
            "c_salename", "c_saletaxnum", "c_saleaccount", "c_saleaddress"
            , "c_salephone", "c_clerk", "deptid", "request_src"
    };
    //销项发票统计导出-有明细
    public static final String[] SALE_COLLECTION_EXPORT_TITLES = {"订单号", "开票日期", "开票类型", "发票种类", "发票代码", "发票号码", "购方名称", "购方税号", "购方电话", "购方开户银行账号",
            "购方地址", "商品名称", "规格型号", "单位", "数量", "单价", "税率", "金额", "含税标志", "订单总价",
            "合计金额", "合计税额", "备注", "销方名称", "销方税号", "销方开户银行账号", "销方地址", "销方电话", "开票员", "部门门店", "开票方式"};
    //销项发票统计导出-无明细
    public static final String[] SALE_COLLECTION_WITHOUT_DETAIL_EXPORT_TITLES = {"订单号", "开票日期", "开票类型", "发票种类",
            "发票代码", "发票号码", "购方名称", "购方税号", "购方电话", "购方开户银行账号", "购方地址", "订单总价", "合计金额", "合计税额", "备注",
            "销方名称", "销方税号", "销方开户银行账号", "销方地址", "销方电话", "开票员", "部门门店", "开票方式"};


    //发票列表
    public static final String[] INVOICE_LIST_EXPORT_FIELD = {
            "c_orderno", "c_kprqd", "c_kptypename", "c_invoice_line", "c_fpdm",
            "c_fphm", "c_buyername", "c_buyertaxnum", "c_buyerphone",
            "c_buyeraccount", "c_buyeraddress",
            "c_goodsname", "c_spec", "c_unit", "i_num", "f_price", "f_taxrate",
            "f_tax_amount", "c_hsbzname",
            "f_ordertotal_calc",
            "f_bhtaxtotal_calc",
            "f_taxtotal_calc", "c_remark", "c_salename", "c_saletaxnum",
            "c_saleaccount", "c_saleaddress", "c_salephone", "c_clerk",
            "deptid", "request_src"

    };
    public static final String[] INVOICE_LIST_EXPORT_WITHOUT_DETAIL_FIELD = {
            "c_orderno", "c_kprqd", "c_kptypename", "c_invoice_line",
            "c_fpdm", "c_fphm", "c_buyername", "c_buyertaxnum",
            "c_buyerphone", "c_buyeraccount", "c_buyeraddress",
            "f_ordertotal_calc", "f_bhtaxtotal_calc",
            "f_taxtotal_calc", "deptid", "request_src"

    };
    public static final String[] INVOICE_LIST_EXPORT_TITLES = {"订单号", "创建时间", "开票类型", "发票种类", "发票代码", "发票号码", "购方名称", "购方税号", "购方电话", "购方开户银行账号", "购方地址",
            "商品名称", "规格型号", "单位", "数量", "单价", "税率", "金额", "含税标志", "订单总价", "合计金额",
            "合计税额", "备注", "销方名称", "销方税号", "销方开户银行账号", "销方地址", "销方电话", "开票员", "部门门店", "开票方式"};


    public static final String[] INVOICE_LIST_EXPORT_WITHOUT_DETAIL_TITLES = {"订单号", "创建时间", "开票类型", "发票种类", "发票代码", "发票号码", "购方名称",
            "购方税号", "购方电话", "购方开户银行账号", "购方地址", "订单总价", "合计金额", "合计税额",
            "部门门店", "开票方式"};


    //发票归集
    public static final String[] COLLECTION_INVOICE_EXPORT_FIELD = {
            "orderNo", "invoiceTime", "collectionSource", "invoiceLine", "invoiceNumber",
            "invoiceCode", "buyerName", "taxNo", "phone", "bankAccount", "address",
            "goodsName", "caleOrderAmount", "calcExcludingTaxAmount", "calcTaxAmount",
            "saleName", "sellerTaxNo", "sellerBandAccount", "sellerAddress", "sellerPhone",
            "remark", "clerk"
    };
    public static final String[] COLLECTION_INVOICE_TITLES = {"订单号", "开票日期", "开票类型", "发票种类", "发票号码", "发票代码", "购方名称", "购方税号", "购方电话", "购方开户银行账号", "购方地址", "商品名称", "订单总价", "合计金额",
            "合计税额", "销方名称", "销方税号", "销方开户银行账号", "销方地址", "销方电话", "备注", "开票员"};

    //发票池invoicePool
    public static final String[] INVOICE_POOL_EXPORT_FIELD = {
            "invoiceTime", "source", "invoiceLine", "fpdm",
            "fphm", "buyerName", "taxnum", "telephone", "buyerAccount", "buyerAddress",
            "goodsName", "totalAmount", "excludedTaxAmount", "taxAmount",
            "salerName", "salerTaxnum", "salerAccount", "salerAddress", "salerPhone",
            "remark", "clerkName"
    };

    //发票池
    public static final String[] INVOICE_POOL_TITLES = {"开票日期", "开票类型", "发票种类", "发票号码", "发票代码",
            "购方名称", "购方税号", "购方电话", "购方开户银行账号", "购方地址", "商品名称", "订单总价", "合计金额",
            "合计税额", "销方名称", "销方税号", "销方开户银行账号", "销方地址", "销方电话", "备注", "开票员"};


    /**
     * @param preCid   上一行数据的 发票流水号
     * @param sheet    填充数据的sheet
     * @param rowNum   从指定行开始填充数据
     * @param invoices 要填充的数据
     */
  /*  public static <T> Map<String, Object> fillSheet(String preCid, Sheet sheet, int rowNum, List<T> invoices, ExportMode mode) throws ParseException {
    	Map<String, Object> returnMap = new HashMap<>();
    	BigDecimal taxAmount = new BigDecimal("0");
		BigDecimal excludingTaxAmount = new BigDecimal("0");
    	String[] fields = mode.getFields();
        for (int i = 0; i < invoices.size(); i++) {
            Map<String, Object> invoice = MapUtil.toMap(invoices.get(i));
            Row row = sheet.createRow(rowNum);
            if (mode == ExportMode.COLLECTION_INVOICE) {
            	taxAmount = taxAmount.add(new BigDecimal(MapUtils.getString(invoice, "calcTaxAmount")));
            	excludingTaxAmount = excludingTaxAmount.add(new BigDecimal(MapUtils.getString(invoice, "calcExcludingTaxAmount")));
            }
            for (int j = 0; j < fields.length; j++) {
                switch (mode) {
                    case SALE_COLLECTION:
                    case INVOICE_LIST:
                        if (!StringUtil.equals(preCid, MapUtils.getString(invoice, "cid"))) {
                            break;
                        }
                        //10-17 跳过invoice 主表数据 写入detail数据
                        if (j < 10) {
                            j = 10;
                        } else if (j > 17) {
                            j = fields.length;
                            continue;
                        }
                        break;
                    default:
                        break;
                }

                StringBuilder goodsName = new StringBuilder("");
                Object val;
                if (DemoStringUtils.equals(fields[j],"goodsName") && mode == ExportMode.COLLECTION_INVOICE) {
                	List<CollectionInvoiceDetailPersonal> invoiceDetails = (List<CollectionInvoiceDetailPersonal>)invoice.get("details");
                	if (invoiceDetails != null && invoiceDetails.size()>0) {
                		for(CollectionInvoiceDetailPersonal detail : invoiceDetails) {
                    		goodsName.append(detail.getGoodsName() + ",");
                    	}
                    	val = goodsName.substring(0, goodsName.length() - 1);
                	} else {
                		val = "";
                	}
                } else if (DemoStringUtils.equals(fields[j],"invoiceLine")) {
                	val = BillType.getNameByCode((String)invoice.get(fields[j]));
                } else if (DemoStringUtils.equals(fields[j],"collectionSource")) {
                	val = CollectionSourceEnum.getSourceNameBySourceValue(Integer.parseInt((String)invoice.get(fields[j])));
                } else if (DemoStringUtils.equals(fields[j],"invoiceTime")) {
//                	val = ((String)invoice.get(fields[j])).substring(0, 10);
                	val = DateUtil.getStringByPattern(DateUtil.parseDate((String)invoice.get(fields[j])), "yyyy-MM-dd");
                } else {
                	val = MapUtils.getObject(invoice, fields[j]);
                }

                if(DemoStringUtils.equals(fields[j],"deptid")&&(mode==ExportMode.INVOICE_LIST||mode==ExportMode.INVOICE_LIST_WITHOUT_DETAIL)){
                   val =  MapUtils.getString(InvoiceListServiceImpl.deptList,val,"");
                }

                Cell cell = row.createCell(j);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                if (val instanceof BigDecimal) {
                    cell.setCellValue(String.valueOf(((BigDecimal) val).setScale(2, BigDecimal.ROUND_HALF_UP)));
                } else if (val instanceof Date) {
                    cell.setCellValue(sdf.format(val));
                } else {
                    cell.setCellValue(val==null|| String.valueOf(val)==null?"": String.valueOf(val));
                }
            }
            returnMap.put("preCid", MapUtils.getString(invoice, "cid"));
            rowNum++;
        }
        returnMap.put("rowNum", rowNum);
        returnMap.put("taxAmount", taxAmount);
        returnMap.put("excludingTaxAmount", excludingTaxAmount);
        return returnMap;
    }

    *//**
     * 填充发票池中我的发票表格
     * @param sheet    填充数据的sheet
     * @param rowNum   从指定行开始填充数据
     * @param invoices 要填充的数据
     *//*
    public static Map<String, Object> fillMyInvoiceSheet(Sheet sheet, int rowNum, List<InvoicePool> invoices) {
        Map<String, Object> returnMap = new HashMap<>();
        BigDecimal taxAmount = new BigDecimal("0");
        BigDecimal excludingTaxAmount = new BigDecimal("0");
        String[] fields = INVOICE_POOL_EXPORT_FIELD;
        for (int i = 0; i < invoices.size(); i++) {
            InvoicePool invoicePool = invoices.get(i);
            if (invoicePool==null) {
                continue;
            }
            Map<String, Object> invoice = MapUtil.toMap(invoicePool);
            Row row = sheet.createRow(rowNum);
            taxAmount = taxAmount.add(new BigDecimal(MapUtils.getString(invoice, "taxAmount")));
            excludingTaxAmount = excludingTaxAmount.add(new BigDecimal(MapUtils.getString(invoice, "excludedTaxAmount")));
            for (int j = 0; j < fields.length; j++) {
                StringBuilder goodsName = new StringBuilder("");
                Object val;
                if (DemoStringUtils.equals(fields[j],"goodsName")) {
                    List<InvoiceDetailInfo> invoiceDetails = invoicePool.getDetailInfos();
                    if (invoiceDetails != null && invoiceDetails.size()>0) {
                        for(InvoiceDetailInfo detail : invoiceDetails) {
                            goodsName.append(detail.getGoodsName() + ",");
                        }
                        val = goodsName.substring(0, goodsName.length() - 1);
                    } else {
                        val = "";
                    }
                } else if (DemoStringUtils.equals(fields[j],"invoiceLine")) {
                    val = BillType.getNameByCode((String)invoice.get(fields[j]));
                } else if (DemoStringUtils.equals(fields[j],"source")) {
                    val = CollectionSourceEnum.getSourceNameBySourceValue(Integer.parseInt((String)invoice.get(fields[j])));
                } else if (DemoStringUtils.equals(fields[j],"invoiceTime")) {
                    val = DateUtil.getStringByPattern(DateUtil.parseDate((String)invoice.get(fields[j])), "yyyy-MM-dd");
                } else {
                    val = MapUtils.getObject(invoice, fields[j]);
                }

                Cell cell = row.createCell(j);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                if (val instanceof BigDecimal) {
                    cell.setCellValue(String.valueOf(((BigDecimal) val).setScale(2, BigDecimal.ROUND_HALF_UP)));
                } else if (val instanceof Date) {
                    cell.setCellValue(sdf.format(val));
                } else {
                    cell.setCellValue(val==null|| String.valueOf(val)==null?"": String.valueOf(val));
                }
            }
            rowNum++;
        }
        returnMap.put("rowNum", rowNum);
        returnMap.put("taxAmount", taxAmount);
        returnMap.put("excludingTaxAmount", excludingTaxAmount);
        return returnMap;
    }

    private static final boolean IS_PRINT = false;

    private static void printly(Object str) {
        if (IS_PRINT) {
            System.out.println(str);
        }
    }

    *//**
     * 获取导出线程
     *//*
    public static Boolean getExportThread(){
    	try {
			return EXPORT_LIMIT.tryAcquire(5000, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>(4);
        map.put("1", new BigDecimal("1.2002"));
        map.put("2", "abc");

        long start = System.nanoTime();
        for (int i = 0; i < 28; i++) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {

                Object value = entry.getValue();

                if (value instanceof BigDecimal) {
                    printly("bigDecimal : " + ((BigDecimal) value).toPlainString());
                } else {
                    printly(String.valueOf(value));
                }
            }

        }
        printly(System.nanoTime() - start);
//        DecimalFormat df = new DecimalFormat("#.##");
//        printly(df.format(0));

    }*/

}
