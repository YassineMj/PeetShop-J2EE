package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_Controller_Contact
 */
@WebServlet("/servletcontact.do")
public class Servlet_Controller_Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String message=request.getParameter("message");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String company=request.getParameter("company");
	
		try{  
			   Class.forName("com.mysql.cj.jdbc.Driver");
			    
			   Connection ma_connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_shop","root","");  

			   PreparedStatement pst =ma_connexion.prepareStatement("insert into contact (username,message,email,phone,company) values(?,?,?,?,?) ");
			   pst.setString(1, username);
			   pst.setString(2, message);
			   pst.setString(3, email);
			   pst.setString(4, phone);
			   pst.setString(5, company);

			   
			   pst.executeUpdate();			   
			
				request.getRequestDispatcher("contact.jsp").forward(request, response);


			   }catch(Exception e){
			    System.out.println(e);
			   }
	}

}
