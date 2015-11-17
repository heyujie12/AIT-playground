package org.ait.msc.project;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ReportGenerator {
	
	void createClassReport(ArrayList<StudentReport> classReport)
	{	
		try {
			Document document = new Document();
			Rectangle rect = new Rectangle(PageSize.LETTER);
			document.setPageSize(rect);
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Calendar calendar = Calendar.getInstance();
			String pathname = "C:\\Users\\Cassidy\\ReportClass"+ df.format(calendar.getTime()) + ".pdf";
			File file = new File(pathname);
			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();
			for(int i = 0; i < classReport.size(); i++)
			{
				
				
				Paragraph paragraphHeading = new Paragraph();
				Paragraph paragraphResults = new Paragraph();
				paragraphHeading.setAlignment(Element.ALIGN_CENTER);
				paragraphHeading.add("StudentFuckU: " + classReport.get(i).getStudentName() + "\n");
				paragraphHeading.add("Parent: " + classReport.get(i).getParentName());
				paragraphHeading.add("Class: " + classReport.get(i).getStudentClass());
				document.add(paragraphHeading);
				System.out.println(classReport.get(i).getStudentName());
				paragraphResults.setAlignment(Element.ALIGN_LEFT);
				paragraphResults.add("Overall Progress:" + classReport.get(i).getOverallProgress() + "\n");
				System.out.println(classReport.get(i).getOverallProgress());
				paragraphResults.add(createFirstTable(classReport.get(i).getAdditionProficiency(), 
						classReport.get(i).getSubtractionProficiency(),classReport.get(i).getMultipicationProficiency(), classReport.get(i).getDivisionProficiency() ));
				paragraphResults.add("\nTables " + classReport.get(i).getStudentName() + " is good in:\n");
				paragraphResults.add(classReport.get(i).getStrongTables() + "\n\n");
				paragraphResults.add("Tables " + classReport.get(i).getStudentName() + " could improve in:\n");
				paragraphResults.add(classReport.get(i).getWeakTables());
				document.add(paragraphResults);
			}
			document.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	void createReport(StudentReport studentReport){
		String studentName = studentReport.getStudentName();
		String parentName = studentReport.getParentName();
		String overallProgress = studentReport.getOverallProgress();
		String additionProficiency = studentReport.getAdditionProficiency();
		String subtractionProficiency = studentReport.getSubtractionProficiency();
		String multipicationProficiency = studentReport.getMultipicationProficiency();
		String divisionProficiency = studentReport.getDivisionProficiency();
		String strongTables = studentReport.getStrongTables();
		String weakTables = studentReport.getWeakTables();
		String studentClass = studentReport.getStudentClass();
		Document document = new Document();
		Rectangle rect = new Rectangle(PageSize.LETTER);
		document.setPageSize(rect);
		try {
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Calendar calendar = Calendar.getInstance();
			String pathname = "C:\\Users\\Cassidy\\Report"+studentName+ df.format(calendar.getTime()) + ".pdf";
			File file = new File(pathname);
			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();
			Paragraph paragraphHeading = new Paragraph();
			Paragraph paragraphResults = new Paragraph();
			paragraphHeading.setAlignment(Element.ALIGN_CENTER);
			paragraphHeading.add("Student: " + studentName + "\n");
			paragraphHeading.add("Parent: " + parentName);
			paragraphHeading.add("Class: " + studentClass);
			document.add(paragraphHeading);
			paragraphResults.setAlignment(Element.ALIGN_LEFT);
			paragraphResults.add("Overall Progress:" + overallProgress + "\n");
			paragraphResults.add(createFirstTable(additionProficiency, subtractionProficiency, multipicationProficiency, divisionProficiency ));
			paragraphResults.add("\nTables " + studentName + " is good in:\n");
			paragraphResults.add(strongTables + "\n\n");
			paragraphResults.add("Tables " + studentName + " could improve in:\n");
			paragraphResults.add(weakTables);
			document.add(paragraphResults);
			document.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}		
	}
	
    public static PdfPTable createFirstTable(String additionProficiency, String subtractionProficiency, String multipicationProficiency, String divisionProficiency ) {
    	// a table with two columns
        PdfPTable table = new PdfPTable(4);
        // the cell object
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Proficiency in Addition"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Proficiency in Subtraction"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Proficiency in Multipication"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Proficiency in Division"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(additionProficiency));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(subtractionProficiency));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(multipicationProficiency));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(divisionProficiency));
        table.addCell(cell);
        return table;
    }
}
