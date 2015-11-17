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
//import com.ait.agilebuild.mathrun.impl.MathRunDao;
//import com.ait.agilebuild.mathrun.model.Student;
////import model.ejb.StudentDAO;
//
//
//
////@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
//public class StudentServlet<HttpServletRequest, HttpServletResponse> extends HttpServlet{
//
//	private static final long serialVersionUID = 1L;
////	private StudentDAO studentDAO;
//	
//	@Inject
//	private MathRunDao mathrundao;
//	
//	
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        int idStudent = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String age = request.getParameter("age");
//        String year = request.getParameter("year");
//        String operation = request.getParameter("operation");
//
//        Student student = new Student(idStudent, name, age,year);
//
//        if (operation.equalsIgnoreCase("Add")) {
//         //   studentDAO.addStudent(student);
//            mathrundao.addStudent(student);
//            response.setAttribute("student", student);
//        }
//        
//        else if (operation.equalsIgnoreCase("Edit")) {
//     //       studentDAO.editStudent(student);
//        	mathrundao.updateStudent(student);

//dao.find(
//        
//            Student searchedStudent = studentDAO.getStudent(studentID);
//            request.setAttribute("student", searchedStudent);
//        } else if (operation.equalsIgnoreCase("Delete")) {
//        //    studentDAO.deleteStudent(studentID);
//        	mathrundao.deleteStudent(student);
//        } else if (operation.equalsIgnoreCase("Search")) {
//            Student searchedStudent = studentDAO.getStudent(studentID);
//            request.setAttribute("student", searchedStudent);
//        }*/
//        request.getRequestDispatcher("studentinfo.jsp").forward(request, response);
//    }
//
//    
// //   @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//   
//  //  @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//}
