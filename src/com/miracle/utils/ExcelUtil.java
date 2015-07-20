package com.miracle.utils;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.miracle.service.QueryService;
import com.miracle.spring.SpringContextHolder;


public class ExcelUtil {
	public static QueryService getQueryService() {
		if (queryService == null) {
			queryService = (QueryService) SpringContextHolder
					.getBean("queryService");
		}
		return queryService;
	}

	public static void setQueryService(QueryService queryService) {
		ExcelUtil.queryService = queryService;
	}

	private static QueryService queryService;

	public static HSSFWorkbook excel(String name, List<String> biaotou,List<String> col,List dataList) {
		try {
			// 第一步，创建一个webbook，对应一个Excel文件
			HSSFWorkbook wb = new HSSFWorkbook();
			// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
			HSSFSheet sheet = wb.createSheet(name);
			// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
			HSSFRow row = sheet.createRow((int) 0);
			// 第四步，创建单元格，并设置值表头 设置表头居中
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

			for (int i = 0; i < biaotou.size(); i++) {
				String biaotouStr = biaotou.get(i);
				HSSFCell cell = row.createCell(i);
				cell.setCellValue(biaotouStr);
				cell.setCellStyle(style);

			}
			// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
			for (int j = 0; j < dataList.size(); j++) {
				Object object = dataList.get(j);
				row = sheet.createRow(j + 1);
				for (int i = 0; i < col.size(); i++) {
					String colName = col.get(i);
					colName = "get" + colName.substring(0, 1).toUpperCase()
							+ colName.substring(1);
					Method method = object.getClass().getMethod(colName);
					Object value = method.invoke(object);
					if (value instanceof String) {
						row.createCell(i).setCellValue((String) value);
					} else if (value instanceof Double) {
						row.createCell(i).setCellValue((Double) value);
					} else if (value instanceof Short) {
						row.createCell(i).setCellValue((Short) value);
					} else if (value instanceof Integer) {
						row.createCell(i).setCellValue((Integer) value);
					} else if (value instanceof Long) {
						row.createCell(i).setCellValue((Long) value);
					} else if (value instanceof BigDecimal) {
						row.createCell(i).setCellValue(value.toString());
					} else {
						if (null == value) {
							row.createCell(i).setCellValue("");
						} else {
							row.createCell(i)
									.setCellValue(value.toString());
						}
					}
				}
			}
			return wb;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
