package com.ait.agilebuild.mathrun.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ait.agilebuild.mathrun.impl.ReportGenerator;

@WebServlet(name = "ReportServlet", urlPatterns = {"/report"})
public class ReportServlet extends HttpServlet{
	
	@Inject
	ReportGenerator rg;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	System.out.println("report doGet process request");
    	
//    	String studentId = request.getParameter("studentId");
//    	File pdfFile = rg.generateReport(Long.parseLong(studentId));
//    	InputStream in = new FileInputStream(pdfFile);
    	
    	// Load the directory as a resource	
		InputStream in = this.getClass().getResourceAsStream("/temp.txt");
		response.setContentType("application/force-download");
//			response.setContentLength((int)f.length());
		response.setContentLength(-1);
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Content-Disposition","attachment; filename=\"myPdf.txt\"");//fileName

		OutputStream out = response.getOutputStream();
		byte[] buffer = new byte[10240];

		    for (int length = 0; (length = in.read(buffer)) > 0;) {
		    	out.write(buffer, 0, length);
		    }
		in.close();
		out.flush();
		
    }
}
