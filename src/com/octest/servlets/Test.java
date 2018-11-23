package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
        	for(Cookie cookie: cookies) {
        		if(cookie.getName().equals("mail")) {
        			request.setAttribute("mail", cookie.getValue());
        		}
        		else if(cookie.getName().equals("password")) {
        			request.setAttribute("password", cookie.getValue());
        		}
        	}
        }
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");

        
        HttpSession session = request.getSession();

        session.setAttribute("nom", nom);
        session.setAttribute("prenom", prenom);
        
        Cookie cookie = new Cookie("mail", mail);
        Cookie cookie1 = new Cookie("password", password);
        response.addCookie(cookie);
        response.addCookie(cookie1);
        this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
	}

}
