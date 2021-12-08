package ojttask;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Task5 {

	public static void main(String[] args) throws SQLException, IOException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "root");
		
		PreparedStatement ps =con.prepareStatement("insert into user2(id,name,phone,role) values(?,?,?,?)");

		Document document=Jsoup.parse(new File("user.html"), "UTF-8");//yaha pe jsoup ki parse methods se hame user.html ka content mil zayega aur document me store hoga
		//System.out.println(document);

		 Elements rows=document.getElementsByTag("tr");//it gives  all rows contained from table  and store in element consider as arraylist

		System.out.println("Number of elements are :- " + rows.size());//it gives size of elements is collection of rows

		for(int i=1;i<rows.size();i++)
		{
			Element row=rows.get(i);// it read rows of 1 read it give indivisual row

			Elements cols=row.select("td");//it give all column of table
		

			ps.setInt(1, Integer.parseInt(cols.get(0).html()));//0th column .html give value of it
			ps.setString(2, cols.get(1).html());
			ps.setString(3, cols.get(2).html());
			ps.setString(4, cols.get(3).html());
			ps.execute();
			System.out.println("Record added");
		}




	}	




	}

