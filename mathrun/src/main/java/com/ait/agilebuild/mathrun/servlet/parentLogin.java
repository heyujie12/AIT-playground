package com.ait.agilebuild.mathrun.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.Document;

import com.ait.agilebuild.mathrun.impl.ParentDAO;
import com.ait.agilebuild.mathrun.model.Student;

/**
 * Servlet implementation class parentLogin
 */
@WebServlet("/parentLogin")
public class parentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private ParentDAO parentDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public parentLogin() {
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
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		System.out.println(parentDAO);
		System.out.println(username+" "+email);
		if(parentDAO.checkParents(username, email)){
			Student stu=parentDAO.fetchChildinfo(email);
			HttpSession session = request.getSession();	
			session.setAttribute("stu", stu);
			session.setAttribute("username", username);
			response.sendRedirect("childinfo.jsp");
		}else{
			System.out.println("wrong user info");
		}
	}

}
