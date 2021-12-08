package ojttask;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Task1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pqr", "root", "root");
		Statement stmt=con.createStatement();
		
		String sql1 = "create table faculty(id int,name varchar(20),phone int)";
		String sql2 = "create table admin(id int,name varchar(20),phone int)";
		String sql3 = "create table student(id int,name varchar(20),phone int)";

		stmt.execute(sql1);
		stmt.execute(sql2);
		stmt.execute(sql3);
		
		FileInputStream fis = new FileInputStream(".\\task\\book1.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int rows = sheet.getLastRowNum();
		
		for (int r = 1; r <= rows; r++) {
			if (r==1 || r==3) {
				XSSFRow row = sheet.getRow(r);
				Double id = row.getCell(0).getNumericCellValue();
				String name = row.getCell(1).getStringCellValue();
				Double phone = row.getCell(2).getNumericCellValue();
				
				sql1="insert into faculty values('"+id+"','"+name+"','"+phone+"')";
				stmt.execute(sql1);
				stmt.execute("commit");
					
			}
			else if (r==2) {
				
				XSSFRow row = sheet.getRow(r);
				Double id = row.getCell(0).getNumericCellValue();
				String name = row.getCell(1).getStringCellValue();
				Double phone = row.getCell(2).getNumericCellValue();
				
				sql2="insert into admin values('"+id+"','"+name+"','"+phone+"')";
				stmt.execute(sql2);
				stmt.execute("commit");
			}
			else if (r==4 || r==5) {
				
				XSSFRow row = sheet.getRow(r);
				Double id = row.getCell(0).getNumericCellValue();
				String name = row.getCell(1).getStringCellValue();
				Double phone = row.getCell(2).getNumericCellValue();
				
				sql3 = "insert into student values('"+id+"','"+name+"','"+phone+"')";
				stmt.execute(sql3);
				stmt.execute("commit");
				
			}
			
		}
		wb.close();
		fis.close();
		con.close();
		
		System.out.println("task completed succesfully");
		

		

	}
}