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
import javax.servlet.http.HttpSession;

import Model.Model_Pets;
import Model.Model_User;

/**
 * Servlet implementation class Servlet_Contriller_User
 */
@WebServlet("/servletuser.do")
public class Servlet_Controller_User extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Model_User user=new Model_User();

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		user=null;
		resp.sendRedirect("myaccount.jsp");
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username=request.getParameter("username").toString();
		String password=request.getParameter("password").toString();

		try{  
			   Class.forName("com.mysql.cj.jdbc.Driver");
			    
			   Connection ma_connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_shop","root","");  

			   PreparedStatement pst =ma_connexion.prepareStatement("select * from utilisateur where username=? and password=?");
			   pst.setString(1, username);
			   pst.setString(2, password);
			   
			   ResultSet mon_resultat = pst.executeQuery();

			   if(mon_resultat.next()) {
				   user=new Model_User();
				   user.setId_user(Integer.parseInt(mon_resultat.getString(1)));
				   user.setSalaire(Float.parseFloat(mon_resultat.getString(8)));
				   user.setUsername(mon_resultat.getString(2).toString());
				   user.setPassword(mon_resultat.getString(3).toString());
				   user.setEmail(mon_resultat.getString(4).toString());
				   user.setPhone(mon_resultat.getString(5).toString());
				   user.setCompany(mon_resultat.getString(6).toString());
				   user.setAdresse(mon_resultat.getString(7).toString());
				   session.setAttribute("SUser",user);

				   //request.setAttribute("user", user);

			   }
			   
				request.getRequestDispatcher("myaccount.jsp").forward(request, response);

			   }catch(Exception e){
			    System.out.println(e);
			   } 

	}

}
