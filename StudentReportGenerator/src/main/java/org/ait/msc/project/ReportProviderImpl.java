package org.ait.msc.project;

import java.util.ArrayList;

public class ReportProviderImpl implements ReportProvider {
	
	ReportGenerator reportGenerator = new ReportGenerator();
	ReportDatatbaseHandler reportDatatbaseHandler = new ReportDatatbaseHandler();
	
	public void generateReport(String studentName) {
		StudentReport studentReport = ReportDatatbaseHandler.getStudentRecord(studentName);
		reportGenerator.createReport(studentReport);
	}
	public void generateClassReport(String studentClass) {
		ArrayList<StudentReport> classReport = ReportDatatbaseHandler.getClassRecord(studentClass);
		reportGenerator.createClassReport(classReport);
	}
	
	public static void main(String[] args){
		ReportProviderImpl reportProviderImpl =  new ReportProviderImpl();
		//Generate Single Report for Parent
		
		reportProviderImpl.generateClassReport("3rd Class");
		//Generate Report for a Class
		//reportProviderImpl.generateReport("3rd Class");
		
	}

}
