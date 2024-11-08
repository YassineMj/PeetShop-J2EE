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

import Model.Model_Cart;
import Model.Model_User;

/**
 * Servlet implementation class Servlet_Controller_Achat
 */
@WebServlet("/servletachatPetsProduct.do")
public class Servlet_Controller_Achat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{  
			Model_User user=(Model_User) req.getSession().getAttribute("SUser");
			int id_user =user.getId_user();
			
			   Class.forName("com.mysql.cj.jdbc.Driver");
			    
			   Connection ma_connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_shop","root","");  

			   if(Servlet_Controller_Cart.cartPets.size()>0)
			   {
				   for(Model_Cart p: Servlet_Controller_Cart.cartPets) {
					   PreparedStatement pst =ma_connexion.prepareStatement("insert into achatpets (id_user,id_pet,quantite) values(?,?,?)");
					   pst.setInt(1,id_user);
					   pst.setInt(2,p.getId_pets());
					   pst.setInt(3,p.getQuantite());
					   pst.executeUpdate();
				   }
			   }
			   
			   if(Servlet_Controller_Cart.cartProduct.size()>0)
			   {
				   for(Model_Cart p: Servlet_Controller_Cart.cartProduct) {
					   PreparedStatement pst =ma_connexion.prepareStatement("insert into achatproduct (id_user,id_product,quantite) values(?,?,?)");
					   pst.setInt(1,id_user);
					   pst.setInt(2,p.getId_product());
					   pst.setInt(3,p.getQuantite());
					   pst.executeUpdate();
				   }
			   }

			   PreparedStatement pst =ma_connexion.prepareStatement("delete from cart where id_user=?");
			   pst.setInt(1,id_user);
			   pst.executeUpdate(); 
			   
			   pst =ma_connexion.prepareStatement("update utilisateur set salaire=salaire-? where id_user=?");
			   pst.setFloat(1,Float.parseFloat(req.getParameter("somme").toString()));			   
			   pst.setInt(2,id_user);
			   pst.executeUpdate(); 
			   
			   resp.sendRedirect("servletAchat.do");
			   }catch(Exception e){
			    System.out.println(e);
			   }
		}

}
