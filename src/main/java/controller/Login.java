package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;
import dao.Dao;
@WebServlet("/userlogin")
public class Login extends HttpServlet {
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		
		Dao dao = new Dao();
		
		try {
			User u = dao.findByEmail(email);
			if(u!=null)
			{
				//verify the password
				if(u.getUserpassword().equals(password)){
					//login success
					
					HttpSession session = req.getSession();
					session.setAttribute("user", u);
					
					req.getRequestDispatcher("home.jsp").include(req, resp);	
				}
				else {
					req.getRequestDispatcher("login.jsp").include(req, resp);
				}
			}
			else {
				req.getRequestDispatcher("login.jsp").include(req, resp);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
