package com.njut.jg.common.object;
/*excel生成的的类定义
 * 
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class GenExcelObject {
	
	//生成Excel文件的路径，由调用者指定
	private String excel_file_path;
	//调用者传入Excel表格字段
	private ArrayList<String> data_field;
	//调用者传入数据列表集合
	private ArrayList<ArrayList> data_list;
	//无参构造方法
	public GenExcelObject() {	
		this.excel_file_path=null;
		this.data_field =null;
		this.data_list=null;
	}
	
	//有参构造方法
	public GenExcelObject(String _file_path,ArrayList<String> _field, ArrayList<ArrayList> _list) {	
		this.excel_file_path=_file_path;
		this.data_field = _field;
		this.data_list=_list;			
	}
	//设置获取对象属性的方法
	public String getExcel_file_path() {
		return excel_file_path;
	}

	public void setExcel_file_path(String excel_file_path) {
		this.excel_file_path = excel_file_path;
	}

	public Object getData_list() {
		return data_list;
	}

	public void setData_list(ArrayList<ArrayList> data_list) {
		this.data_list = data_list;
	}
	//执行生成excel文件,无参情况
	public void generate_excel_file() {
		
		HSSFRow row=null;
		//创建一个生成excel文件对象
		HSSFWorkbook workbook = new HSSFWorkbook();
        //生成excel表格的一个页
		HSSFSheet sheet = workbook.createSheet("FirstSheet");
        //生成excel表格一页中的一行
        HSSFRow rowhead = sheet.createRow((short)0);
        //开始创建字段列
        for( int i=0 ; i<data_field.size() ; i++ ) 
        	rowhead.createCell(i).setCellValue(data_field.get(i));
        
        //将ArrayList集合里的数据添加到Excel里
        for(int j=0 ; j<data_list.size() ; j++) {
        	
        	row = sheet.createRow((short)(j+1));
        	
        	for(int k=0 ; k<data_list.get(j).size() ; k++) {
        		 
        		row.createCell(k).setCellValue(String.valueOf(data_list.get(j).get(k)));
        		System.out.println(data_list.get(j).get(k));
        		
                 
        	}
        	System.out.println("");
        }
        //创建一个文件输出流
            FileOutputStream fileOut=null;
		
			try {
				fileOut = new FileOutputStream(this.excel_file_path);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				workbook.write(fileOut);
				fileOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    System.out.println("Your excel file has been generated!");
					   	
	}
	//执行生成excel文件，有参情况
    public void generate_excel_file(String _file_path,ArrayList<String> _fields,ArrayList<ArrayList> _list) {
    	
    	this.setExcel_file_path(_file_path);
    	this.setData_colums(_fields);
    	this.setData_list(_list);
    	
    	HSSFRow row=null;
		//创建一个生成excel文件对象
		HSSFWorkbook workbook = new HSSFWorkbook();
        //生成excel表格的一个页
		HSSFSheet sheet = workbook.createSheet("FirstSheet");
        //生成excel表格一页中的一行
        HSSFRow rowhead = sheet.createRow((short)0);
        //开始创建字段列
        for( int i=0 ; i<data_field.size() ; i++ ) 
        	rowhead.createCell(i).setCellValue(data_field.get(i));
        
        //将ArrayList集合里的数据添加到Excel里
        for(int j=0 ; j<data_list.size() ; j++) {
        	
        	row = sheet.createRow((short)(j+1));
        	
        	for(int k=0 ; k<data_list.get(j).size() ; k++) {
        		 
        		row.createCell(k).setCellValue(String.valueOf(data_list.get(j).get(k)));
        		System.out.println(data_list.get(j).get(k));
        		
                 
        	}
        	System.out.println("");
        }
        //创建一个文件输出流
            FileOutputStream fileOut=null;
		
			try {
				fileOut = new FileOutputStream(this.excel_file_path);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				workbook.write(fileOut);
				fileOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    System.out.println("Your excel file has been generated!");
					   
    	
    }

	public ArrayList<String> getData_colums() {
		return data_field;
	}

	public void setData_colums(ArrayList<String> _field) {
		this.data_field = _field;
	}
	
	
}
