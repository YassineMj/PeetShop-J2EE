package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Model_Admin;
import Model.Model_Pets;
import Model.Model_User;

/**
 * Servlet implementation class Servlet_Controllet_Admin
 */
@WebServlet("/servletadmin.do")
public class Servlet_Controllet_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{  
			Model_User user;
			ArrayList<Model_User> listuser=new ArrayList<>();

			   Class.forName("com.mysql.cj.jdbc.Driver");
			    
			   Connection ma_connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_shop","root","");  

			   PreparedStatement pst =ma_connexion.prepareStatement("select * from utilisateur");
			  
			   ResultSet mon_resultat = pst.executeQuery();

			   while(mon_resultat.next()) {
				   
				   user=new Model_User();
				   user.setId_user(Integer.parseInt(mon_resultat.getString(1)));
				   user.setUsername(mon_resultat.getString(2).toString());
				   user.setPassword(mon_resultat.getString(3).toString());
				   user.setEmail(mon_resultat.getString(4).toString());
				   user.setPhone(mon_resultat.getString(5).toString());
				   user.setCompany(mon_resultat.getString(6).toString());
				   user.setAdresse(mon_resultat.getString(7).toString());
				   user.setSalaire(Float.parseFloat(mon_resultat.getString(8)));
				   listuser.add(user);
				   
			   }
				
				request.setAttribute("listuser", listuser);

			   }catch(Exception e){
			    System.out.println(e);
			   } 
	}


	Model_Admin admin;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username=request.getParameter("usernameadmin").toString();
		String password=request.getParameter("passwordadmin").toString();

		try{  
			   Class.forName("com.mysql.cj.jdbc.Driver");
			    
			   Connection ma_connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_shop","root","");  

			   PreparedStatement pst =ma_connexion.prepareStatement("select * from admin where useradmin=? and passwordadmin=?");
			   pst.setString(1, username);
			   pst.setString(2, password);
			   
			   ResultSet mon_resultat = pst.executeQuery();

			   if(mon_resultat.next()) {
				   admin=new Model_Admin();
				   admin.setIdAdmin(Integer.parseInt(mon_resultat.getString(1)));
				   admin.setUserAdmin(mon_resultat.getString(3).toString());
				   admin.setPasswordAdmin(mon_resultat.getString(2).toString());
		
				   session.setAttribute("Admin",admin);
				   doGet(request, response);
				   
				   request.getRequestDispatcher("dashboardAdmin.jsp").forward(request, response);

			   }else
				   request.getRequestDispatcher("admin.jsp").forward(request, response);
			   
				

			   }catch(Exception e){
			    System.out.println(e);
			   } 
	}

}
