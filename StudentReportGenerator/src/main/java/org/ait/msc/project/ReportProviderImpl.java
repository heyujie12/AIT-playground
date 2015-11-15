package org.ait.msc.project;

public class ReportProviderImpl implements ReportProvider {
	
	ReportGenerator reportGenerator = new ReportGenerator();
	ReportDatatbaseHandler reportDatatbaseHandler = new ReportDatatbaseHandler();
	
	public void generateReport(String studentName) {
		StudentReport studentReport = ReportDatatbaseHandler.getStudentRecord(studentName);
		reportGenerator.createReport(studentReport);
	}
	
	public static void main(String[] args){
		ReportProviderImpl reportProviderImpl =  new ReportProviderImpl();
		//Generate Single Report for Parent
		reportProviderImpl.generateReport("Mary");
		//Generate Report for a Class
		reportProviderImpl.generateReport("3rd Class");
		
	}

}
