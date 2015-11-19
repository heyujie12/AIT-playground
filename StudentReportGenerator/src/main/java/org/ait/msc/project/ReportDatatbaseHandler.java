package org.ait.msc.project;

import java.sql.*;
import java.util.ArrayList;

public class ReportDatatbaseHandler {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/studentreport";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "admin";
	
	static ArrayList<StudentReport> getClassRecord(String classTitle)
	{
		ArrayList<StudentReport> classReport = new ArrayList<StudentReport>();
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM studentrecord WHERE studentrecord.CLASS='"+classTitle+"'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				StudentReport studentReport = new StudentReport();
				studentReport.setStudentName(rs.getString("STUDENT_ID"));
				studentReport.setParentName(rs.getString("PARENT"));
				studentReport.setOverallProgress(rs.getString("OVERALL_PROGRESS"));
				studentReport.setAdditionProficiency(rs.getString("PROGRESS_ADDITION"));
				studentReport.setSubtractionProficiency(rs.getString("PROGRESS_SUBTRACTION"));
				studentReport.setMultipicationProficiency(rs.getString("PROGRESS_MULTIPLICATION"));
				studentReport.setDivisionProficiency(rs.getString("PROGRESS_DIVISION"));
				studentReport.setStrongTables(rs.getString("STRONG_TABLES"));
				studentReport.setWeakTables(rs.getString("WEAK_TABLES"));
				studentReport.setStudentClass(rs.getString("CLASS"));
				
				classReport.add(studentReport);
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
		return classReport;

	}
	static StudentReport getStudentRecord(String name) {
		StudentReport studentReport = new StudentReport();
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM studentrecord WHERE studentrecord.STUDENT_ID='"+name+"'";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				studentReport.setStudentName(rs.getString("STUDENT_ID"));
				studentReport.setParentName(rs.getString("PARENT"));
				studentReport.setOverallProgress(rs.getString("OVERALL_PROGRESS"));
				studentReport.setAdditionProficiency(rs.getString("PROGRESS_ADDITION"));
				studentReport.setSubtractionProficiency(rs.getString("PROGRESS_SUBTRACTION"));
				studentReport.setMultipicationProficiency(rs.getString("PROGRESS_MULTIPLICATION"));
				studentReport.setDivisionProficiency(rs.getString("PROGRESS_DIVISION"));
				studentReport.setStrongTables(rs.getString("STRONG_TABLES"));
				studentReport.setWeakTables(rs.getString("WEAK_TABLES"));
				studentReport.setStudentClass(rs.getString("CLASS"));
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
		return studentReport;
	}// end main
}// end FirstExample
