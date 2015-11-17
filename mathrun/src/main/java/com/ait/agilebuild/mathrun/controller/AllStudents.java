package com.ait.agilebuild.mathrun.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ait.agilebuild.mathrun.api.IMathRunDao;
import com.ait.agilebuild.mathrun.impl.MathRunDao;
import com.ait.agilebuild.mathrun.model.Student;
import com.ait.agilebuild.mathrun.model.Teacher;
//import model.ejb.StudentDAO;


@WebServlet(name = "AllStudents", urlPatterns = {"/AllStudents"})
public class AllStudents extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	@Inject
	private IMathRunDao mathrunDAO;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.println("process request");
    	
        List<Teacher> list = mathrunDAO.getTeachers();
        System.out.println("Size of the list" + list.size());
        for(Teacher t : list){
        	System.out.println(t.getEmail());
        	System.out.println(t.getName());
        	System.out.println(t.getPassword());
        }
        
        //        
//        request.setAttribute("list", list);
//        request.getRequestDispatcher("AllStudents.jsp").forward(request, response);
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	System.out.println("doGet process request");
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
