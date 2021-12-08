package ojttask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Task2 {

	public static void main(String[] args) throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "root");
		PreparedStatement ps = con.prepareStatement("select * from user");
		ResultSet rs = ps.executeQuery();

		Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pqr", "root", "root");
		Statement st = con1.createStatement();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String name = rs.getString(2);
			int phone = rs.getInt(3);
			String role = rs.getString(4);
			
			if (role.equals("faculty")) {
				
				String sql1 = "insert into faculty values("+id+",'"+name+"',"+phone+")";
				st.execute(sql1);
				st.execute("commit");
				
			}
			else if (role.equals("admin")) {
				
				String sql2 = "insert into faculty values("+id+",'"+name+"',"+phone+")";
				st.execute(sql2);
				st.execute("commit");
				
			}
			else if (role.equals("sql3")) {
				
				String sql3 = "insert into faculty values("+id+",'"+name+"',"+phone+")";
				st.execute(sql3);
				st.execute("commit");
				
			}
		}
		con.close();
		con1.close();
		System.out.println("task2 complete successfully");
		
		
		
		

	}
}
