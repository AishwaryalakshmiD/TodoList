package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import dto.Task;
import dto.User;
@WebServlet("/updatetask")
public class UpdateTask extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int taskid = Integer.parseInt(req.getParameter("taskid"));
		String tasktitle = req.getParameter("tasktitle");
		String taskdescription = req.getParameter("taskdescription");
		String taskpriority = req.getParameter("taskpriority");
		String taskduedate = req.getParameter("taskduedate");
		String taskstatus = req.getParameter("taskstatus");
		
		User user = (User)req.getSession().getAttribute("user");
		int userid = Integer.parseInt(req.getParameter("userid"));
		
		
		Dao dao = new Dao();
		try {
			
			Task task = new Task(taskid, tasktitle, taskdescription, taskpriority, taskduedate,taskstatus, userid);
			
			int res = dao.Updatetask(task);
			
			if(res>0)
			{
				
				
				req.setAttribute("tasks", dao.getalltaskByUserid(userid));
				
				RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
				rd.include(req, resp);
				
			}
			else
			{
				resp.getWriter().println("failed");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	
	}

}
