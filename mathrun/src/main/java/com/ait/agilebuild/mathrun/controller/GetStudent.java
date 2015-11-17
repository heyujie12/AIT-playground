//package com.ait.agilebuild.mathrun.controller;
//
//import java.io.IOException;
//
//import javax.inject.Inject;
////import javax.ejb.EJB;
//import javax.servlet.ServletException;
////import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import com.ait.agilebuild.mathrun.model.Student;
//import com.ait.agilebuild.mathrun.impl.MathRunDao;
////import model.ejb.StudentDAO;
//
////@WebServlet(name = "GetStudent", urlPatterns = {"/GetStudent"})
//public class GetStudent extends HttpServlet {
//    
//	private static final long serialVersionUID = 1L;
////	private StudentDAO studentDAO;
//	@Inject
//	private MathRunDao mathrunDao;
//    
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String id = request.getParameter("id");       
//        Student student = studentDAO.getStudent(id);
//        request.setAttribute("student", student);
//        request.getRequestDispatcher("studentinfo.jsp").forward(request, response);
//    }
//
//    
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }
//}
