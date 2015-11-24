package com.ait.agilebuild.mathrun.servlet;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ait.agilebuild.mathrun.impl.MathRunDao;
import com.ait.agilebuild.mathrun.impl.ParentDAO;
import com.ait.agilebuild.mathrun.model.Student;

/**
 * Servlet implementation class allstudents
 */
@WebServlet("/allstudents")
public class allstudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private MathRunDao mathDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public allstudents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Student> ls = mathDAO.getStudents();
		HttpSession session = request.getSession();	
		session.setAttribute("stusinfo", ls);
		System.out.println(ls.get(0));
		response.sendRedirect("forallstudents.jsp");
	}

}
