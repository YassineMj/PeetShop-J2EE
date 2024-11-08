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

import Model.Model_Pets;
import Model.Model_User;

/**
 * Servlet implementation class Servlet_Controller_InfoCart
 */
@WebServlet("/servletinfoCart.do")
public class Servlet_Controller_InfoCart extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model_User user=(Model_User) request.getSession().getAttribute("SUser");
		int count=0;
		float somme=0;

		try{  
			   Class.forName("com.mysql.cj.jdbc.Driver");
			    
			   Connection ma_connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_shop","root","");  
			   			   
			   PreparedStatement pst =ma_connexion.prepareStatement("select COUNT(*) ,SUM(c.quantite*p.prix) from pets p INNER JOIN cart c on p.id_pet = c.id_pet WHERE c.id_user=?");
			   pst.setInt(1,user.getId_user());
			   
			   ResultSet mon_resultat = pst.executeQuery();
			   if(mon_resultat.next()) {
				   count=mon_resultat.getInt(1);
				   somme=mon_resultat.getFloat(2);
			   }
			   
			   ma_connexion.prepareStatement("select COUNT(*) ,SUM(c.quantite*p.prix) from product p INNER JOIN cart c on p.id_product = c.id_product WHERE c.id_user=?");
			   pst.setInt(1,user.getId_user());
			   
			   mon_resultat = pst.executeQuery();
			   if(mon_resultat.next()) {
				   count=count+mon_resultat.getInt(1);
				   somme=somme+mon_resultat.getFloat(2);
			   }
			   
			   request.setAttribute("count", count);
			   request.setAttribute("somme", somme);

			   }catch(Exception e){
			    System.out.println(e);
			   } 
		
		
		request.getRequestDispatcher("cartInfo.jsp").forward(request, response);
	}

	
}
