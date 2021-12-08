package ojttask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task3 {

	public static void main(String[] args) throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","root");
		PreparedStatement ps = con.prepareStatement("create table student(sid int,sname varchar(20),sphone int)");
		PreparedStatement ps1 = con.prepareStatement("create table student_clone(sid int,sname varchar(20),sphone int)");
       
		ps.executeUpdate();
        ps1.executeUpdate();
        
        System.out.println("table created");
        
		PreparedStatement sql1 = con.prepareStatement("insert into student values(101,'jbk@',1234)");
		PreparedStatement sql2 = con.prepareStatement("insert into student values(102,'kiran$',1224)");
		PreparedStatement sql3 = con.prepareStatement("insert into student values(103,'sweta',1278)");
		
		sql1.executeUpdate();
		sql2.executeUpdate();
		sql3.executeUpdate();
		
		System.out.println("value inserted successfully");
		
		PreparedStatement sql4 = con.prepareStatement("insert into Student_clone(select * from Student where sname like'%@')");
		PreparedStatement sql5 = con.prepareStatement("insert into Student_clone(select * from Student where sname like'%$')");

		sql4.executeUpdate();
		sql5.executeUpdate();
		
		System.out.println("table created successfully");
		
		
		
	}
}
