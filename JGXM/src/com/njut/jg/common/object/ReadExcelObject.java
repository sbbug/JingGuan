package com.njut.jg.common.object;
/*
 * 
 * 此处类读取excel类包的定义
 * 用于操作excel文件
 */

//导入相关类包
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * 读取excel文件的类
 * 传入参数是excel文件路径
 *
 */
public class ReadExcelObject {
      
	//需要读取的excel文件路径
	private String excel_file_path;
	
	//无参构造方法
	public ReadExcelObject(){
		excel_file_path=null;
	}
	
	//有参构造方法
	public ReadExcelObject(String _file_path){
		this.excel_file_path = _file_path;
	}
	
	public String getExcel_file_path() {
		return excel_file_path;
	}

	public void setExcel_file_path(String excel_file_path) {
		this.excel_file_path = excel_file_path;
	}
    
    //	读取excel文件，有参构造方法
	
	public ArrayList<ArrayList> read_excel_data(String excel_file_path){
		
		this.setExcel_file_path(excel_file_path);
		
		 //创建一个二维集合，用于存放数据
		ArrayList<ArrayList> data_list=null;
		
		//创建一个文件输入流
		FileInputStream excelFile = null;
		//创建工作簿
		Workbook workbook = null;
		
		//每一条记录标识
		int data_line = 0;
		
		//测试使用
		System.out.println("===>"+this.excel_file_path);
		try {
			 
			 excelFile = new FileInputStream(new File(this.excel_file_path));
			 
			 workbook = new XSSFWorkbook(excelFile);
			 
			 //获取第一页
			 Sheet datatypeSheet = workbook.getSheetAt(0);
			 
			 //获取第一行
			 Iterator<Row> iterator = datatypeSheet.iterator();
			 
			//data_list分配空间
			 data_list = new ArrayList<ArrayList>();
			 
			 while (iterator.hasNext()) {
                    
				    //获取当前行
	                Row currentRow = iterator.next();
	                //获取一个行中的单元
	                Iterator<Cell> cellIterator = currentRow.iterator();
                    
	                //在data_list里分配一行
	                
	                data_list.add(new ArrayList<String>());
	                
	                while (cellIterator.hasNext()) {

	               
	                    Cell cell = cellIterator.next();
	                    
	                    //根据类型判断输出
						switch (cell.getCellType()) 
						{ 
						    case Cell.CELL_TYPE_STRING: 
//						    	System.out.print(cell.getStringCellValue() + "\t"); 
						    	data_list.get(data_line).add(cell.getStringCellValue());
						    	break; 
							case Cell.CELL_TYPE_NUMERIC: 
//								System.out.print(cell.getNumericCellValue() + "\t"); 
								data_list.get(data_line).add(cell.getNumericCellValue());
								break;
							case Cell.CELL_TYPE_BOOLEAN: 
//								System.out.print(cell.getBooleanCellValue() + "\t"); 
								data_list.get(data_line).add(cell.getBooleanCellValue());
								break; 
							default : 
						} 

	                }
	                data_line++;
//	                System.out.println("");

	            }
			 	 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data_list;
		
		
	}
	
	//读取excel文件，无参构造方法
	public ArrayList<ArrayList> read_excel_data(){
		
		
        //创建一个二维集合，用于存放数据
		ArrayList<ArrayList> data_list=null;
		
		//创建一个文件输入流
		FileInputStream excelFile = null;
		//创建工作簿
		Workbook workbook = null;
		
		//每一条记录标识
		int data_line = 0;
		
		//测试使用
		System.out.println("===>"+this.excel_file_path);
		try {
			 
			 excelFile = new FileInputStream(new File(this.excel_file_path));
			 
			 workbook = new XSSFWorkbook(excelFile);
			 
			 //获取第一页
			 Sheet datatypeSheet = workbook.getSheetAt(0);
			 
			 //获取第一行
			 Iterator<Row> iterator = datatypeSheet.iterator();
			 
			//data_list分配空间
			 data_list = new ArrayList<ArrayList>();
			 
			 while (iterator.hasNext()) {
                    
				    //获取当前行
	                Row currentRow = iterator.next();
	                //获取一个行中的单元
	                Iterator<Cell> cellIterator = currentRow.iterator();
                    
	                //在data_list里分配一行
	                
	                data_list.add(new ArrayList<String>());
	                
	                while (cellIterator.hasNext()) {

	               
	                    Cell cell = cellIterator.next();
	                    
	                    //根据类型判断输出
						switch (cell.getCellType()) 
						{ 
						    case Cell.CELL_TYPE_STRING: 
//						    	System.out.print(cell.getStringCellValue() + "\t"); 
						    	data_list.get(data_line).add(cell.getStringCellValue());
						    	break; 
							case Cell.CELL_TYPE_NUMERIC: 
//								System.out.print(cell.getNumericCellValue() + "\t"); 
								data_list.get(data_line).add(cell.getNumericCellValue());
								break;
							case Cell.CELL_TYPE_BOOLEAN: 
//								System.out.print(cell.getBooleanCellValue() + "\t"); 
								data_list.get(data_line).add(cell.getBooleanCellValue());
								break; 
							default : 
						} 

	                }
	                data_line++;
//	               System.out.println("");

	            }
			 	 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
		
		return data_list;
	}
	
	 
	
}
