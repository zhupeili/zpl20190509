package myWorld.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

public class ExcelExportUtils {

//    public static final Integer MAX_ROWS = 60000;


    /**
     * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符合一定条件的数据以EXCEL 的形式输出到指定IO设备上
     *
     * @param headMap        标题信息存储的MAp
     * @param headersChinese 中文标题数组
     * @param headersEnglish 英文标题数组
     * @param dataList       导出的数据
     * @param out            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
     */
    public static void exportEntities(
            OutputStream out,
            List<?> dataList,
            Map<String, String> headMap,
            String[] headersChinese,
            String[] headersEnglish) {
        HSSFWorkbook workbook = new HSSFWorkbook();  // 声明一个工作薄
  //    HSSFSheet sheet = workbook.createSheet(headMap.get("sheetTitle"));  // 生成一个表格    
        
        int num=50000;//每个excel表格所要插入的数据上限
     // sheet.setDefaultColumnWidth(20);   
        Map<String, HSSFFont> fontMap = getFontMap(workbook); //初始化字体MAP
        Map<String, HSSFCellStyle> cellStyleMap = getCellStyleMap(workbook, fontMap); //初始化样式map
        Integer columnSize = headersChinese.length;
       /* HSSFRow row = sheet.createRow(0);//标题行
        row.setHeightInPoints(25);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, (columnSize - 1)));
        row.createCell(0).setCellValue(headMap.get("title"));
        row.getCell(0).setCellStyle(cellStyleMap.get("titleStyle"));*/
        //设置表格标题行
  //      insertTitleRow(sheet, headersChinese, cellStyleMap.get("font12Style"));            
        // 遍历集合数据，产生数据行
        if (dataList != null && dataList.size() > 0) {
            Map<String, Method> classMethods = getClassMethods(dataList.get(0));
          //进行四舍五入取整
            int countExcel1=Math.round(dataList.size()/num);
            int countExcel=1;
            if((dataList.size()%num)!=0){
            	countExcel=countExcel1+1;
            }else{
            	countExcel=countExcel1;
            }
            List<HSSFSheet> list=new ArrayList<>();
            //创建sheet表格
//            String sheetName1 = "基本信息";
//            String sheetName2 = "目标号码";
//            String sheetName3 = "目标区域";
//            String[] headersChinese2 = { "目标号码", "卡号", "机身码", "姓名", "是否LBS监控(0是不监控，1是监控)", "监控停止时间" };
//			String[] headersEnglish2 = { "msisdn", "imsi", "imei", "name", "lbs", "endTime" };
//			String[] headersChinese3 = { "区域名称", "来源（1系统内置，2框选，3导入，4录入）" };
//			String[] headersEnglish3 = { "areaName", "areaSourceType" };
//			Map<String, String> map1 = new HashMap<>();
//			map1.put("sheetTitle", sheetName2);
//			map1.put("title", sheetName2);
//			Map<String, String> map2 = new HashMap<>();
//			map2.put("sheetTitle", sheetName3);
//			map2.put("title", sheetName3);
//            HSSFSheet sheet4=excelSheet(headMap, headersChinese, cellStyleMap, columnSize, workbook, sheetName1); 
//            HSSFSheet sheet2=excelSheet(map1, headersChinese2, cellStyleMap, columnSize, workbook, sheetName1); 
//            HSSFSheet sheet3=excelSheet(map2, headersChinese3, cellStyleMap, columnSize, workbook, sheetName1); 
//            list.add(sheet4);
//            list.add(sheet3);
//            list.add(sheet2);
            for(int i=1;i<countExcel;i++){
            	 //新建一个表格
                String nameExcel=headMap.get("sheetTitle")+i;
                HSSFSheet sheet1=excelSheet(headMap, headersChinese, cellStyleMap, columnSize, workbook, nameExcel); 
                list.add(sheet1);
            }
            int n=0;//所循环的sheet数
            //循环遍历所查询的数据
            for (Object baseEntity : dataList) {                  	
            	 HSSFSheet sheet1=list.get(n);//对表格进行初始化
            	 //当第一个表格数据已达上限时，循环遍历出第二个表格，依次循环
            //	 int s=sheet1.getLastRowNum();
                 if((sheet1.getLastRowNum())>=num){
                	 
                	//当excel表格中的数据大于或等于num时,将继续向下一个表格中插入数据
             		//Excel2003的最大行是65536行,超过这个行数将会发生错误
                 	//从Excel2007开始最大行是1048576，超过将无法添加行数
                	 //表格数加上1,循环下一个表格
                	 n=n+1;
                 	 /*for(int i=1;i<list.size();i++){
                 		 sheet1=list.get(i);
                      }*/
                 }         		
            	//	System.out.println("excel一行的数据存入");
            		//以下是excel中可以插入的数据
                    Object value = "";
                    HSSFCell cell;
                    HSSFRow newRow = sheet1.createRow(sheet1.getLastRowNum() + 1);
                    for (int i=0;i<headersEnglish.length;i++) {
                        cell = newRow.createCell(i);
                        try {
                            if (classMethods.get(headersEnglish[i].toLowerCase()) != null) {
                                value = classMethods.get(headersEnglish[i].toLowerCase()).invoke(baseEntity);
                            }
                            insertCellValue(cell, value, cellStyleMap.get("textStyle"), workbook.getFontAt((short) 0));
                        } catch (SecurityException | IllegalArgumentException | InvocationTargetException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }            	     	
            }
        }else{
        	excelSheet(headMap, headersChinese, cellStyleMap, columnSize, workbook, headMap.get("sheetTitle"));
        }
        try {
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //创建一个表格，当第一个表格的数据以满的话，就需要创建一个新的表格
	private static HSSFSheet excelSheet( Map<String, String> headMap, String[] headersChinese,
    	  Map<String, HSSFCellStyle> cellStyleMap,Integer columnSize,HSSFWorkbook workbook,String nameExcel){
    	  HSSFSheet sheet = workbook.createSheet(nameExcel);  // 生成一个表格
    	  sheet.setDefaultColumnWidth(20);
    	  HSSFRow row = sheet.createRow(0);//标题行
          row.setHeightInPoints(25);
          sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, (columnSize - 1)));
          row.createCell(0).setCellValue(headMap.get("title"));
          row.getCell(0).setCellStyle(cellStyleMap.get("titleStyle"));
          //设置表格标题行
          insertTitleRow(sheet, headersChinese, cellStyleMap.get("font12Style"));
          return sheet;
    }
    private static Map<String, Method> getClassMethods(Object baseEntity) {
        Map<String, Method> classMethods = new HashMap<>();
        // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
        for (Method method : baseEntity.getClass().getMethods()) {
            if (method.getName().startsWith("get")) {
                if (!classMethods.containsKey(method.getName().substring(3).toLowerCase())) {
                    classMethods.put(method.getName().substring(3).toLowerCase(), method);
                }
            } else if (method.getName().startsWith("is")) {
                if (!classMethods.containsKey(method.getName().substring(2).toLowerCase())) {
                    classMethods.put(method.getName().substring(2).toLowerCase(), method);
                }
            }
        }
        return classMethods;
    }

    //设置字体
    private static void setCellFont(HSSFFont font, Short fontSize, Short fontBoleWeight) {
        font.setFontName("宋体");
        font.setFontHeightInPoints(fontSize);//设置字体大小
        font.setBoldweight(fontBoleWeight);//粗体显示
    }

    private static void setCellStyle(HSSFCellStyle cellStyle, Short fillPattern, Short groundColor, HSSFFont font) {
        setCellStyleBorder(cellStyle);
        cellStyle.setFillPattern(fillPattern);
        cellStyle.setFillForegroundColor(groundColor);
        cellStyle.setWrapText(true);
        cellStyle.setFont(font);
    }

    //设置边框
    private static void setCellStyleBorder(HSSFCellStyle hssfCellStyle) {
        hssfCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN); //左边框
        hssfCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
        hssfCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN); //右边框
        hssfCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        //设置边框颜色
        hssfCellStyle.setTopBorderColor(HSSFColor.BLACK.index);
        hssfCellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
        hssfCellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
        hssfCellStyle.setRightBorderColor(HSSFColor.BLACK.index);
        hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
    }

    //初始化单元格格式map
    private static Map<String, HSSFCellStyle> getCellStyleMap(HSSFWorkbook workbook, Map<String, HSSFFont> fontMap) {
        Map<String, HSSFCellStyle> cellStyleMap = new HashMap<>();
        HSSFCellStyle titleStyle = workbook.createCellStyle();
        setCellStyle(titleStyle, HSSFCellStyle.SOLID_FOREGROUND, HSSFColor.LIGHT_ORANGE.index, fontMap.get("titleFont"));
        cellStyleMap.put("titleStyle", titleStyle);//添加标题样式

        HSSFCellStyle queryStyle = workbook.createCellStyle();
        setCellStyle(queryStyle, HSSFCellStyle.SOLID_FOREGROUND, HSSFColor.LIGHT_ORANGE.index, fontMap.get("textFont"));
        cellStyleMap.put("queryStyle", queryStyle);//添加查询样式

        HSSFCellStyle textStyle = workbook.createCellStyle();
        setCellStyle(textStyle, HSSFCellStyle.SOLID_FOREGROUND, HSSFColor.WHITE.index, fontMap.get("textFont"));
        cellStyleMap.put("textStyle", textStyle);//添加正文样式

        HSSFCellStyle statStatementsStyle = workbook.createCellStyle();
        setCellStyle(statStatementsStyle, HSSFCellStyle.SOLID_FOREGROUND, HSSFColor.LIGHT_ORANGE.index, fontMap.get("statStatementsFont16"));
        cellStyleMap.put("statStatementsStyle", statStatementsStyle);//添加统计报表查询样式

        HSSFCellStyle font12Style = workbook.createCellStyle();
        setCellStyle(font12Style, HSSFCellStyle.SOLID_FOREGROUND, HSSFColor.LIGHT_ORANGE.index, fontMap.get("textFont"));
        cellStyleMap.put("font12Style", font12Style);//添加12号字体样式

        HSSFCellStyle font12WhiteStyle = workbook.createCellStyle();
        setCellStyle(font12WhiteStyle, HSSFCellStyle.SOLID_FOREGROUND, HSSFColor.WHITE.index, fontMap.get("textFont"));
        cellStyleMap.put("font12WhiteStyle", font12WhiteStyle);//添加12号字体不带背景样式

        return cellStyleMap;
    }

    //初始化字体map
    private static Map<String, HSSFFont> getFontMap(HSSFWorkbook workbook) {
        Map<String, HSSFFont> fontMap = new HashMap<>();
        HSSFFont titleFont = workbook.createFont();
        setCellFont(titleFont, (short) 20, HSSFFont.BOLDWEIGHT_BOLD);
        fontMap.put("titleFont", titleFont);//添加标题字体

        HSSFFont textFont = workbook.createFont();
        setCellFont(textFont, (short) 12, HSSFFont.BOLDWEIGHT_BOLD);
        fontMap.put("textFont", textFont);//添加正文字体

        HSSFFont statStatementsFont16 = workbook.createFont();
        setCellFont(statStatementsFont16, (short) 16, HSSFFont.BOLDWEIGHT_BOLD);
        fontMap.put("statStatementsFont16", statStatementsFont16);//添加统计报表查询字体

        return fontMap;
    }

    //产生表格标题行
    private static void insertTitleRow(HSSFSheet sheet, String[] headersChinese, HSSFCellStyle cellStyle) {
        // 产生表格标题行
        HSSFRow row = sheet.createRow(sheet.getLastRowNum() + 1);
        row.setHeightInPoints(30);
        for (int i = 0; i < headersChinese.length; i++) {
            row.createCell(i).setCellStyle(cellStyle);
            row.getCell(i).setCellValue(new HSSFRichTextString(headersChinese[i]));
        }
    }

    //插入cell的值
    private static void insertCellValue(HSSFCell cell, Object value, HSSFCellStyle fontStyle, HSSFFont hssfFont) {
        String textValue;
        if (value instanceof Boolean) {
            textValue = value.toString();
        } else if (value instanceof Date) {
            textValue = new SimpleDateFormat("yyyy-MM-dd").format(value);
        } else {
            textValue = value == null ? "" : value.toString();
        }
        HSSFRichTextString richString = new HSSFRichTextString(textValue);
        hssfFont.setFontHeight((short) 240);
        hssfFont.setFontName("SansSerif");
        richString.applyFont(hssfFont);
        cell.setCellValue(richString);
        cell.setCellStyle(fontStyle);
    }

//    private static void addMergedRegion1(HSSFSheet sheet, Integer cellLine, Integer rowStart, Integer endRow, HSSFWorkbook workBook) {
//        Integer startRow = rowStart;
//        HSSFCellStyle style = workBook.createCellStyle(); // 样式对象
//        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
//        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
//        //获取第一行的数据,以便后面进行比较
//        String s_will = sheet.getRow(startRow).getCell(cellLine).getStringCellValue();
//        int count = 0;
//        Boolean flag = false;
//        for (int i = 0; i < endRow; i++) {
//            String s_current = sheet.getRow(i).getCell(0).getStringCellValue();
//            if (s_will == s_current) {
//                s_will = s_current;
//                if (flag) {
//                    sheet.addMergedRegion(new CellRangeAddress(startRow - count, startRow, cellLine, cellLine));
//                    HSSFRow row = sheet.getRow(startRow - count);
//                    String cellValueTemp = sheet.getRow(startRow - count).getCell(0).getStringCellValue();
//                    HSSFCell cell = row.createCell(0);
//                    cell.setCellValue(cellValueTemp);// 跨单元格显示的数据
//                    cell.setCellStyle(style);// 样式
//                    count = 0;
//                    flag = false;
//                }
//                startRow = i;
//                count++;
//            } else {
//                flag = true;
//                s_will = s_current;
//            }
//            //由于上面循环中合并的单元放在有下一次相同单元格的时候做的，所以最后如果几行有相同单元格则要运行下面的合并单元格。
//            if (i == endRow && count > 0) {
//                sheet.addMergedRegion(new CellRangeAddress(endRow - count, endRow, cellLine, cellLine));
//                String cellValueTemp = sheet.getRow(startRow - count).getCell(0).getStringCellValue();
//                HSSFRow row = sheet.getRow(startRow - count);
//                HSSFCell cell = row.createCell(0);
//                cell.setCellValue(cellValueTemp); // 跨单元格显示的数据
//                cell.setCellStyle(style); // 样式
//            }
//        }
//    }
    
    
    
    
    
    

    
    public static void exportEntities(
            OutputStream out,
            List<?> dataList,
            Map<String, String> headMap,
            String[] headersChinese,
            byte[] picByte,
            String[] headersEnglish) {
        HSSFWorkbook workbook = new HSSFWorkbook();  // 声明一个工作薄
  //    HSSFSheet sheet = workbook.createSheet(headMap.get("sheetTitle"));  // 生成一个表格    
        int num=50000;//每个excel表格所要插入的数据上限
     // sheet.setDefaultColumnWidth(20);   
        Map<String, HSSFFont> fontMap = getFontMap(workbook); //初始化字体MAP
        Map<String, HSSFCellStyle> cellStyleMap = getCellStyleMap(workbook, fontMap); //初始化样式map
        Integer columnSize = headersChinese.length;
       /* HSSFRow row = sheet.createRow(0);//标题行
        row.setHeightInPoints(25);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, (columnSize - 1)));
        row.createCell(0).setCellValue(headMap.get("title"));
        row.getCell(0).setCellStyle(cellStyleMap.get("titleStyle"));*/
        //设置表格标题行
  //      insertTitleRow(sheet, headersChinese, cellStyleMap.get("font12Style"));            
        // 遍历集合数据，产生数据行
        if (dataList != null && dataList.size() > 0) {
            Map<String, Method> classMethods = getClassMethods(dataList.get(0));
          //进行四舍五入取整
            int countExcel1=Math.round(dataList.size()/num);
            int countExcel=1;
            if((dataList.size()%num)!=0){
            	countExcel=countExcel1+1;
            }else{
            	countExcel=countExcel1;
            }
            List<HSSFSheet> list=new ArrayList<>();
            //创建sheet表格
            for(int i=0;i<countExcel;i++){
            	 //新建一个表格
                String nameExcel=headMap.get("sheetTitle")+i;
                HSSFSheet sheet1=excelSheet(headMap, headersChinese, cellStyleMap, columnSize, workbook, nameExcel); 
                list.add(sheet1);
            }
            int n=0;//所循环的sheet数
            //循环遍历所查询的数据
            for (Object baseEntity : dataList) {                  	
            	 HSSFSheet sheet1=list.get(n);//对表格进行初始化
            	 //当第一个表格数据已达上限时，循环遍历出第二个表格，依次循环
            //	 int s=sheet1.getLastRowNum();
                 if((sheet1.getLastRowNum())>=num){
                	 
                	//当excel表格中的数据大于或等于num时,将继续向下一个表格中插入数据
             		//Excel2003的最大行是65536行,超过这个行数将会发生错误
                 	//从Excel2007开始最大行是1048576，超过将无法添加行数
                	 //表格数加上1,循环下一个表格
                	 n=n+1;
                 	 /*for(int i=1;i<list.size();i++){
                 		 sheet1=list.get(i);
                      }*/
                 }         		
            	//	System.out.println("excel一行的数据存入");
            		//以下是excel中可以插入的数据
                    Object value = "";
                    HSSFCell cell;
                    HSSFRow newRow = sheet1.createRow(sheet1.getLastRowNum() + 1);
                    for (int i=0;i<headersEnglish.length;i++) {
                        cell = newRow.createCell(i);
                        try {
                            if (classMethods.get(headersEnglish[i].toLowerCase()) != null) {
                                value = classMethods.get(headersEnglish[i].toLowerCase()).invoke(baseEntity);
                            }
                            insertCellValue(cell, value, cellStyleMap.get("textStyle"), workbook.getFontAt((short) 0));
                        } catch (SecurityException | IllegalArgumentException | InvocationTargetException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }     
                    
                    
                    HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();  
                    /** 
                     * 该构造函数有8个参数 
                     * 前四个参数是控制图片在单元格的位置，分别是图片距离单元格left，top，right，bottom的像素距离 
                     * 后四个参数，前连个表示图片左上角所在的cellNum和 rowNum，后天个参数对应的表示图片右下角所在的cellNum和 rowNum， 
                     * excel中的cellNum和rowNum的index都是从0开始的 
                     *  
                     */  
                  
                    //图片二导出到单元格C3到E5中，且图片的left和top距离边框50  
                    HSSFClientAnchor anchor1 = new HSSFClientAnchor(0, 0, 0, 0,  
                            (short) 0, 10, (short) 10, 4);  
          
                    // 插入图片  
                     
                    patriarch.createPicture(anchor1, workbook.addPicture(picByte, HSSFWorkbook.PICTURE_TYPE_JPEG));  
          
            }
        }else{
        	excelSheet(headMap, headersChinese, cellStyleMap, columnSize, workbook, headMap.get("sheetTitle"));
        }
        try {
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
