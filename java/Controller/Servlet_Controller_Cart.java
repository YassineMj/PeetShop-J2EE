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

import Model.Model_Cart;
import Model.Model_Product;
import Model.Model_User;

/**
 * Servlet implementation class Servlet_Controller_AchatPets
 */
@WebServlet("/servletAchat.do")
public class Servlet_Controller_Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static ArrayList<Model_Cart> cartPets;
	public static ArrayList<Model_Cart> cartProduct;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("SUser")!=null)
		{
			Model_User user=(Model_User) request.getSession().getAttribute("SUser");
			int id_user =user.getId_user();
			
			try{  
				   Class.forName("com.mysql.cj.jdbc.Driver");
				    
				   Connection ma_connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_shop","root","");  

				   PreparedStatement pst =ma_connexion.prepareStatement("SELECT p.image_pets,p.nom_pets,p.prix,c.quantite, c.id_cart,p.id_pet from cart c inner join pets p on c.id_pet=p.id_pet where c.id_user=?");
				   pst.setInt(1, id_user);
				   
				   ResultSet mon_resultat = pst.executeQuery(); 
				   cartPets=new ArrayList<>();
				   Model_Cart c;
				   while(mon_resultat.next()) {
					   c=new Model_Cart();
					   c.setImage(mon_resultat.getString(1));
					   c.setNom(mon_resultat.getString(2));
					   c.setPrix(mon_resultat.getFloat(3));
					   c.setQuantite(mon_resultat.getInt(4));
					   c.setId_cart(mon_resultat.getInt(5));
					   c.setId_pets(mon_resultat.getInt(6));

					   cartPets.add(c);
				   }
				   
				   pst =ma_connexion.prepareStatement("SELECT p.image_product,p.nom_product,p.prix,c.quantite , c.id_cart , p.id_product from cart c inner join product p on c.id_product=p.id_product where c.id_user=?");
				   pst.setInt(1, id_user);
				   mon_resultat = pst.executeQuery(); 
				   cartProduct=new ArrayList<>();
				   while(mon_resultat.next()) {
					   c=new Model_Cart();
					   c.setImage(mon_resultat.getString(1));
					   c.setNom(mon_resultat.getString(2));
					   c.setPrix(mon_resultat.getFloat(3));
					   c.setQuantite(mon_resultat.getInt(4));
					   c.setId_cart(mon_resultat.getInt(5));
					   c.setId_product(mon_resultat.getInt(6));

					   cartProduct.add(c);
				   }
				   
				   response.sendRedirect("cart.jsp");
				   
				   
			}catch(Exception e){
				    System.out.println(e);
			}
		}
		else 
		{
				 response.sendRedirect("servletuser.do");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{  
			   Class.forName("com.mysql.cj.jdbc.Driver");
			    
			   Connection ma_connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_shop","root","");  

			   PreparedStatement pst =ma_connexion.prepareStatement("delete from cart where id_cart=?");
			   pst.setInt(1,Integer.parseInt(request.getParameter("id_cart")));
			   
			   pst.executeUpdate(); 
	   
		}catch(Exception e){
			    System.out.println(e);
		}
		
		doGet(request, response);
	}

}
