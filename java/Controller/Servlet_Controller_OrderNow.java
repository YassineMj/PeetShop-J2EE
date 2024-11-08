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
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import Model.Model_User;

/**
 * Servlet implementation class Servlet_Controller_OrderNow
 */
@WebServlet("/servletordernow.do")
public class Servlet_Controller_OrderNow extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getSession().getAttribute("SUser")==null) {
			response.sendRedirect("servletuser.do");
		}
		else {
			if(request.getParameter("type").equals("pet")) {
				
				Model_User user=(Model_User) request.getSession().getAttribute("SUser");
				int id_user =user.getId_user();
				int id_pets =Integer.parseInt(request.getParameter("id").toString());
				int quantite=Integer.parseInt(request.getParameter("quantite").toString());
				
				try{  
					   Class.forName("com.mysql.cj.jdbc.Driver");
					    
					   Connection ma_connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_shop","root","");  

					   PreparedStatement pst =ma_connexion.prepareStatement("insert into cart (id_user,id_pet,quantite) values(?,?,?)");
					   pst.setInt(1, id_user);
					   pst.setInt(2, id_pets);					   
					   pst.setInt(3, quantite);

					   pst.executeUpdate();			   
					
					   response.sendRedirect("servletAchat.do");

					   }catch(Exception e){
					    System.out.println(e);
					   }
			}
			else {
				Model_User user=(Model_User) request.getSession().getAttribute("SUser");
				int id_user =user.getId_user();
				int id_product =Integer.parseInt(request.getParameter("id").toString());
				int quantite=Integer.parseInt(request.getParameter("quantite").toString());
				
				try{  
					   Class.forName("com.mysql.cj.jdbc.Driver");
					    
					   Connection ma_connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_shop","root","");  

					   PreparedStatement pst =ma_connexion.prepareStatement("insert into cart (id_user,id_product,quantite) values(?,?,?)");
					   pst.setInt(1, id_user);
					   pst.setInt(2, id_product);					   
					   pst.setInt(3, quantite);

					   pst.executeUpdate();			   
					
					   response.sendRedirect("servletAchat.do");

					   }catch(Exception e){
					    System.out.println(e);
					   }
			}
					
		}
	}
	
}
