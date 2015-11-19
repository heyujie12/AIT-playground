package org.ait.msc.project;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.itextpdf.text.DocumentException;

public class ReportProviderImpl implements ReportProvider {
	
	ReportGenerator reportGenerator = new ReportGenerator();
	ReportDatatbaseHandler reportDatatbaseHandler = new ReportDatatbaseHandler();
	
	public void generateReport(String studentName) {
		StudentReport studentReport = ReportDatatbaseHandler.getStudentRecord(studentName);
		reportGenerator.createReport(studentReport);
	}
	public void generateClassReport(String studentClass) throws SQLException, IOException {
		ArrayList<StudentReport> classReport = ReportDatatbaseHandler.getClassRecord(studentClass);
		reportGenerator.createClassReport(classReport);
	}
	
	public static void main(String[] args) throws SQLException, IOException{
		ReportProviderImpl reportProviderImpl =  new ReportProviderImpl();
		//Generate Single Report for Parent
		
		//reportProviderImpl.generateClassReport("3rd Class");
		//Generate Report for a Class
		reportProviderImpl.generateReport("Peter");
		
	}

}
