package org.ait.msc.project;

import com.itextpdf.awt.PdfGraphics2D;
import java.awt.geom.Rectangle2D;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ReportGenerator {
	
	void createClassReport(ArrayList<StudentReport> classReport) throws SQLException, IOException
	{	
		try {
			
			Font font1 = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
	        Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 16,Font.ITALIC);
	        Font font3 = new Font(Font.FontFamily.TIMES_ROMAN, 27);
			Document document = new Document(PageSize.A4,50,50,PageSize.A4.getHeight()/2,50);
			Rectangle rect = new Rectangle(PageSize.LETTER);
			document.setPageSize(rect);
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Calendar calendar = Calendar.getInstance();
			String pathname = "C:\\Users\\Patrick Hall\\ClassReport"+ df.format(calendar.getTime()) + ".pdf";
			File file = new File(pathname);
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();
			
			PdfContentByte cb = writer.getDirectContent();
			float width = PageSize.A4.getWidth();
			float height = PageSize.A4.getHeight()/2-50;
			
			PdfTemplate pie = cb.createTemplate(width, height);
			Graphics2D g2d1 = new PdfGraphics2D(pie, width, height);
			Rectangle2D r2d1 = new Rectangle2D.Double(0,0,width,height);
			
			getPieChart(classReport).draw(g2d1, r2d1);
			g2d1.dispose();
			cb.addTemplate(pie,0,height);
			for(int i = 0; i < classReport.size(); i++)
			{
				Paragraph paragraphHeading = new Paragraph(25);
				Paragraph paragraphResults = new Paragraph(15);
				paragraphHeading.setAlignment(Element.ALIGN_CENTER);
				paragraphHeading.setFont(font1);
				paragraphHeading.add(" Student: " + classReport.get(i).getStudentName() + "\n");
				paragraphHeading.add(" Parent: " + classReport.get(i).getParentName() + "\n");
				paragraphHeading.add(" Class: " + classReport.get(i).getStudentClass()+ "\n");
				paragraphHeading.setSpacingAfter(50);
				document.add(paragraphHeading);
				
				paragraphResults.setAlignment(Element.ALIGN_LEFT);
				paragraphResults.setFont(font2);
				paragraphResults.add("Overall Progress: " + classReport.get(i).getOverallProgress() + "\n");
				
				paragraphResults.add("\nTables " + classReport.get(i).getStudentName() + " is good in: ");
				paragraphResults.add(classReport.get(i).getStrongTables() + "\n\n");
				paragraphResults.add("Tables " + classReport.get(i).getStudentName() + " could improve in: ");
				paragraphResults.add(classReport.get(i).getWeakTables());
				paragraphResults.add(createFirstTable(classReport.get(i).getAdditionProficiency(), 
						classReport.get(i).getSubtractionProficiency(),classReport.get(i).getMultipicationProficiency(), classReport.get(i).getDivisionProficiency() ));
				
				document.add(paragraphResults);
				document.setMargins(50,50,50,50);
				document.newPage();

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
	public static JFreeChart getPieChart(ArrayList<StudentReport> classReport) throws SQLException, IOException {
	    DefaultPieDataset dataset = new DefaultPieDataset();
	    Double goodProgress = 0.0;
	    Double medProgress = 0.0;
	    Double badProgress = 0.0;
	    for(int i = 0; i < classReport.size(); i++)
		{
	    	System.out.println(classReport.get(i).getOverallProgress());
	    	if(classReport.get(i).getOverallProgress().equals("good"))
	    		goodProgress = goodProgress + 20.0;
	    	else if(classReport.get(i).getOverallProgress().equals("medium"))
	    		medProgress = medProgress + 20.0;
	    	else if(classReport.get(i).getOverallProgress().equals("bad"))
	    		badProgress = badProgress + 20.0;
		}
	    dataset.setValue("Bad Progress", badProgress);
	    dataset.setValue("Medium Progress", medProgress);
	    dataset.setValue("Good Progress", goodProgress);
	    
	    return ChartFactory.createPieChart("Overall Progress of "+classReport.get(0).getStudentClass(), dataset,
	                true, true, false);
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
