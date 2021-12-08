package ojttask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CopyExelRead {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Document document = Jsoup.parse(new File("user.html"), "UTF-8");
		System.out.println(document);

		Elements rows=document.getElementsByTag("tr");

		System.out.println("Numbber of elements :- " +rows.size());

		XSSFWorkbook workbook= new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet();

		XSSFRow xclrow;

		for(int i=0;i<rows.size();i++)
		{
			xclrow=sheet.createRow(i);
			Element row=rows.get(i);
			Elements cols=row.select("td");
			int cellid=0;
			for(Element columnelement:cols)
			{
				Cell cell= xclrow.createCell(cellid++);
				cell.setCellValue(columnelement.html());
			}
			System.out.println("Record added");

		}
		workbook.write(new FileOutputStream("users1.xlsx"));
		System.out.println("Excel is created...");
	}

}
