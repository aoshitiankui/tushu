package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * 操作Excel表格的功能类
 */
public class ExcelOper {
	private String filePath;
	private InputStream inputStream;
	private File file;
	private int start;
	private HSSFWorkbook wb;
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
		try {
			setInputStream(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
		try {
			this.setInputStream(new FileInputStream(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
		try {
			wb = new HSSFWorkbook(new POIFSFileSystem(inputStream));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取Excel表格表头的内容
	 * @param InputStream
	 * @return String 表头内容的数组
	 */
	public String[] getExcelTitle() {
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow row = sheet.getRow(start);
		// 标题总列数
		int colNum = row.getPhysicalNumberOfCells();
		String[] title = new String[colNum];
		for (int i = 0; i < colNum; i++) {
			//title[i] = getStringCellValue(row.getCell((short) i));
			title[i] = getCellFormatValue(row.getCell((short) i));
		}
		return title;
	}

	/**
	 * 读取Excel数据内容
	 * @param InputStream
	 * @return Map 包含单元格数据内容的Map对象
	 */
	public List<List<String>> getExcelContent() {
		List<List<String>> content = new ArrayList<List<String>>();
		HSSFSheet sheet = wb.getSheetAt(0);
		// 得到总行数
		int rowNum = sheet.getLastRowNum();
		HSSFRow row  = sheet.getRow(start);
		int colNum = row.getPhysicalNumberOfCells();
		// 正文内容应该从第二行开始,第一行为表头的标题
		for (int i = start+1; i <= rowNum; i++) {
			row = sheet.getRow(i);
			int j = 0;
			List<String> temp = new ArrayList<String>();
			while (j < colNum) {
				temp.add(getCellFormatValue(row.getCell((short) j)).trim());
				j++;
			}
			content.add(temp);
		}
		return content;
	}

	/**
	 * 获取单元格数据内容为字符串类型的数据
	 * 
	 * @param cell Excel单元格
	 * @return String 单元格数据内容
	 */
	private String getStringCellValue(HSSFCell cell) {
		String strCell = "";
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_STRING:
			strCell = cell.getStringCellValue();
			break;
		case HSSFCell.CELL_TYPE_NUMERIC:
			strCell = String.valueOf(cell.getNumericCellValue());
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			strCell = String.valueOf(cell.getBooleanCellValue());
			break;
		case HSSFCell.CELL_TYPE_BLANK:
			strCell = "";
			break;
		default:
			strCell = "";
		break;
		}
		if (strCell.equals("") || strCell == null) {
			return "";
		}
		if (cell == null) {
			return "";
		}
		return strCell;
	}

	/**
	 * 获取单元格数据内容为日期类型的数据
	 * 
	 * @param cell
	 *            Excel单元格
	 * @return String 单元格数据内容
	 */
	private String getDateCellValue(HSSFCell cell) {
		String result = "";
		try {
			int cellType = cell.getCellType();
			if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
				Date date = cell.getDateCellValue();
				result = (date.getYear() + 1900) + "-" + (date.getMonth() + 1)
				+ "-" + date.getDate();
			} else if (cellType == HSSFCell.CELL_TYPE_STRING) {
				String date = getStringCellValue(cell);
				result = date.replaceAll("[年月]", "-").replace("日", "").trim();
			} else if (cellType == HSSFCell.CELL_TYPE_BLANK) {
				result = "";
			}
		} catch (Exception e) {
			System.out.println("日期格式不正确!");
			e.printStackTrace();
		}
		return result;
	}
	public void close(){
		if(inputStream!=null){
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 根据HSSFCell类型设置数据
	 * @param cell
	 * @return
	 */
	private String getCellFormatValue(HSSFCell cell) {
		String cellvalue = "";
		if (cell != null) {
			// 判断当前Cell的Type
			switch (cell.getCellType()) {
			// 如果当前Cell的Type为NUMERIC
			case HSSFCell.CELL_TYPE_NUMERIC:
			case HSSFCell.CELL_TYPE_FORMULA: {
				// 判断当前的cell是否为Date
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// 如果是Date类型则，转化为Data格式

					//方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
					//cellvalue = cell.getDateCellValue().toLocaleString();

					//方法2：这样子的data格式是不带带时分秒的：2011-10-12
					Date date = cell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					cellvalue = sdf.format(date);

				}
				// 如果是纯数字
				else {
					// 取得当前Cell的数值
					cellvalue = String.valueOf(cell.getNumericCellValue());
				}
				break;
			}
			// 如果当前Cell的Type为STRIN
			case HSSFCell.CELL_TYPE_STRING:
				// 取得当前的Cell字符串
				cellvalue = cell.getRichStringCellValue().getString();
				break;
				// 默认的Cell值
			default:
				cellvalue = " ";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;

	}
 public static void writeExcel(Map data,String path){
	 String title = (String) data.get(DwonLoadExcelInterface.title);
	 if(title==null){
		 return ;
	 }
	 List<String> titles = (List<String>) data.get(DwonLoadExcelInterface.titles);
	 if(titles==null){
		 return ;
	 }
	 List<List> content = (List<List>) data.get(DwonLoadExcelInterface.content);
//	 创建Excel的工作书册 Workbook,对应到一个excel文档
     HSSFWorkbook wb = new HSSFWorkbook();

     // 创建Excel的工作sheet,对应到一个excel文档的tab
     HSSFSheet sheet = wb.createSheet("sheet1");

     // 设置excel每列宽度
     sheet.setColumnWidth(0, 4000);
     sheet.setColumnWidth(1, 3500);

     // 创建字体样式
     HSSFFont font = wb.createFont();
     font.setFontName("Verdana");
     font.setBoldweight((short) 300);
     font.setFontHeight((short) 300);
     font.setColor(HSSFColor.BLACK.index);

     // 创建单元格样式
     HSSFCellStyle style = wb.createCellStyle();
     style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
     style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
     style.setFillForegroundColor(HSSFColor.WHITE.index);
     style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
     
     
     // 设置边框
     style.setBottomBorderColor(HSSFColor.BLACK.index);
     style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
     
     style.setLeftBorderColor(HSSFColor.BLACK.index);
     style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
     
     style.setRightBorderColor(HSSFColor.BLACK.index);
     style.setBorderRight(HSSFCellStyle.BORDER_THIN);
     
     style.setTopBorderColor(HSSFColor.BLACK.index);
     style.setBorderTop(HSSFCellStyle.BORDER_THIN);
     
     style.setFont(font);// 设置字体

     // 创建Excel的sheet的一行
     HSSFRow row = sheet.createRow(0);
     row.setHeight((short) 500);// 设定行的高度
     // 创建一个Excel的单元格
     HSSFCell cell = row.createCell(0);

     // 合并单元格(startRow，endRow，startColumn，endColumn)
     sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, titles.size()-1));

     // 给Excel的单元格设置样式和赋值
     cell.setCellStyle(style);
     cell.setCellValue(title);

     // 设置单元格内容格式
     HSSFCellStyle style1 = wb.createCellStyle();
//     style1.setDataFormat(HSSFDataFormat.getBuiltinFormat("h:mm:ss"));

     style1.setWrapText(true);// 自动换行
     HSSFFont font1 = wb.createFont();
     font1.setFontName("Verdana");
     font1.setBoldweight((short) 200);
     font1.setFontHeight((short) 200);
     font1.setColor(HSSFColor.BLACK.index);
     style1.setFont(font1);
     row = sheet.createRow(1);
     // 设置单元格的样式格式
//   设置边框
     style1.setBottomBorderColor(HSSFColor.BLACK.index);
     style1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
     
     style1.setLeftBorderColor(HSSFColor.BLACK.index);
     style1.setBorderLeft(HSSFCellStyle.BORDER_THIN);
     
     style1.setRightBorderColor(HSSFColor.BLACK.index);
     style1.setBorderRight(HSSFCellStyle.BORDER_THIN);
     
     style1.setTopBorderColor(HSSFColor.BLACK.index);
     style1.setBorderTop(HSSFCellStyle.BORDER_THIN);
     for(int i=0;i<titles.size();i++){
    	 cell = row.createCell(i);
         cell.setCellStyle(style1);
         cell.setCellValue(titles.get(i));
     }
     
     
     // 设置单元格内容格式
     HSSFCellStyle style2 = wb.createCellStyle();
//     style1.setDataFormat(HSSFDataFormat.getBuiltinFormat("h:mm:ss"));

     style1.setWrapText(true);// 自动换行
     // 设置单元格的样式格式
//   设置边框
     style2.setBottomBorderColor(HSSFColor.BLACK.index);
     style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
     
     style2.setLeftBorderColor(HSSFColor.BLACK.index);
     style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
     
     style2.setRightBorderColor(HSSFColor.BLACK.index);
     style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
     
     style2.setTopBorderColor(HSSFColor.BLACK.index);
     style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
     if(content!=null&&content.size()>0){
    	 for(int i=0;i<content.size();i++){
    		 row = sheet.createRow(i+2);
    		 List temp = content.get(i);
    		 for(int j=0;j<temp.size();j++){
    			 cell = row.createCell(j);
    	         cell.setCellStyle(style2);
    	         Object obj = temp.get(j);
    	         if ((obj instanceof Double) || obj instanceof Integer){
    	        	 cell.setCellValue(Double.parseDouble(obj.toString()));
    	         }else{
    	        	 if(obj==null){
    	        		 obj="";
    	        	 }
    	        	 cell.setCellValue((obj.toString()));
    	         }
    		 }
    	 }
     }
     // 创建超链接
//     HSSFHyperlink link = new HSSFHyperlink(HSSFHyperlink.LINK_URL);
//     link.setAddress("http://www.baidu.com");
//     cell = row.createCell(1);
//     cell.setCellValue("百度");
//     cell.setHyperlink(link);// 设定单元格的链接

     try {
		FileOutputStream os = new FileOutputStream(path);
		 wb.write(os);
		 os.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
 }
	public static void main(String[] args) {
		ExcelOper oper = new ExcelOper();
//		oper.setStart(1);
//		oper.setFilePath("e:\\20141225054856426.xls");
//		String[] ts = oper.getExcelTitle();
//		for (int i = 0; i < ts.length; i++) {
//			System.out.println(ts[i]);
//		}
//		List<List<String>> list = oper.getExcelContent();
//		for (Iterator iter = list.iterator(); iter.hasNext();) {
//			List<String> element = (List<String>) iter.next();
//			System.out.println(element);
//		}
//		oper.close();
		
		Map map = new HashMap();
		map.put(DwonLoadExcelInterface.title, "测试");
		List<String> titles = new ArrayList<String>();
		titles.add("姓名");
		titles.add("姓名1");
		titles.add("姓名2");
		titles.add("姓名3");
		map.put(DwonLoadExcelInterface.titles,titles);
		List<List> c = new ArrayList<List>();
		
		List test = new ArrayList();
		test.add(12);
		test.add(12.3);
		test.add("姓名2");
		test.add("姓名3");
		
		c.add(test);
		map.put(DwonLoadExcelInterface.content,c);
		oper.writeExcel(map,"e:\\test.xls");
		
		
	}
}