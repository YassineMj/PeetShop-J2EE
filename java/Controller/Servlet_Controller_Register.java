package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Model_User;

/**
 * Servlet implementation class Servlet_Controller_Register
 */
@WebServlet("/servletregister.do")
public class Servlet_Controller_Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String company=request.getParameter("company");
		String adress=request.getParameter("adress");
	
		try{  
			   Class.forName("com.mysql.cj.jdbc.Driver");
			    
			   Connection ma_connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_shop","root","");  

			   PreparedStatement pst =ma_connexion.prepareStatement("insert into utilisateur (username,password,email,phone,company,adresse) values(?,?,?,?,?,?) ");
			   pst.setString(1, username);
			   pst.setString(2, password);
			   pst.setString(3, email);
			   pst.setString(4, phone);
			   pst.setString(5, company);
			   pst.setString(6, adress);

			   
			   pst.executeUpdate();			   
			
			   response.sendRedirect("servletuser.do");

			   }catch(Exception e){
			    System.out.println(e);
			   }
	}

}
