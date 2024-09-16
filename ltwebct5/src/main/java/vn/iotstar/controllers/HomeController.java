package vn.iotstar.controllers;

import vn.iotstar.dao.*;
import vn.iotstar.impl.UserDAOImpl;
import vn.iotstar.models.UserModel;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/home","/forgotPassword"})
public class HomeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    
		//req.getRequestDispatcher("/views/User.jsp").forward(req, resp);
        String path = req.getServletPath();

        // Kiểm tra xem URL có chứa 'forgotPassword' hay không
        if (path.contains("forgotPassword")) {
        	req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
        } else if (path.contains("home")) {
        	// Set the content   
    	    resp.setContentType("text/html");

    	    // Create a PrintWriter object to write the HTML content
    	    PrintWriter out = resp.getWriter();

    	    // Write the HTML code for the greeting message
    	    out.println("<!DOCTYPE html>");
    	    out.println("<html>");
    	    out.println("<head>");
    	    out.println("<title>Hello World</title>");
    	    out.println("</head>");
    	    out.println("<body>");
    	    out.println("<h1>Xin chào user!</h1>");
    	    out.println("</body>");
    	    out.println("</html>");
        } else {
            // Nếu có URL khác không khớp
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String username = req.getParameter("username");
			System.out.println(username);
			String email = req.getParameter("email");
			IUserDAO u = new UserDAOImpl();
			UserModel user = u.findByUserName(username);
			if(user.getEmail().equals(email))
			{
				resp.setContentType("text/html");

	    	    // Create a PrintWriter object to write the HTML content
	    	    PrintWriter out = resp.getWriter();
	    	    
	    	    // Write the HTML code for the greeting message
	    	    out.println("This is your password"+user.getPassword());
			}
			else
			{
				resp.setContentType("text/html");

	    	    // Create a PrintWriter object to write the HTML content
	    	    PrintWriter out = resp.getWriter();
	    	    out.println("Username không khớp với mật khẩu!");
			}
		 
	}

}
