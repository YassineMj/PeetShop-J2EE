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

import Model.Model_Achat_User;
import Model.Model_User;

/**
 * Servlet implementation class Servlet_Controller_Achat_User
 */
@WebServlet("/servletcontrollerachatuser.do")
public class Servlet_Controller_Achat_User extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idUser=request.getParameter("iduser").toString();

		try{  
			   Class.forName("com.mysql.cj.jdbc.Driver");
			    
			   Connection ma_connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_shop","root","");  

			   PreparedStatement pst =ma_connexion.prepareStatement("SELECT utilisateur.username, pets.nom_pets,SUM(achatpets.quantite) , utilisateur.salaire  FROM pets inner JOIN achatpets on pets.id_pet=achatpets.id_pet inner join utilisateur on achatpets.id_user=utilisateur.id_user where achatpets.id_user=? group BY achatpets.id_pet");
			   pst.setString(1, idUser);
			   
			   ResultSet mon_resultat = pst.executeQuery();
			   String nomuser="";
			   String soldeuser="";
			   ArrayList<Model_Achat_User> listAchatUserPets = new ArrayList<>();

			   while(mon_resultat.next()) {
				   Model_Achat_User achat_User=new Model_Achat_User();
				   nomuser=mon_resultat.getString(1).toString();
				   achat_User.nomP=mon_resultat.getString(2).toString();
				   achat_User.quantiteP=mon_resultat.getString(3).toString();
				   soldeuser=mon_resultat.getString(4).toString();
				   
				   listAchatUserPets.add(achat_User);
			   }
			   
				request.setAttribute("listAchatUserPets", listAchatUserPets);
				request.setAttribute("nomuser", nomuser);
				request.setAttribute("soldeuser", soldeuser);
				
				
				
				pst =ma_connexion.prepareStatement("SELECT utilisateur.username, product.nom_product,SUM(achatproduct.quantite) , utilisateur.salaire FROM product inner JOIN achatproduct on product.id_product=achatproduct.id_product inner join utilisateur on achatproduct.id_user=utilisateur.id_user where achatproduct.id_user=? group BY achatproduct.id_product");
				pst.setString(1, idUser);
				mon_resultat = pst.executeQuery();
				ArrayList<Model_Achat_User> listAchatUserProduct = new ArrayList<>();
				
		        while(mon_resultat.next()) {
					   Model_Achat_User achat_User=new Model_Achat_User();
					   nomuser=mon_resultat.getString(1).toString();
					   achat_User.nomP=mon_resultat.getString(2).toString();
					   achat_User.quantiteP=mon_resultat.getString(3).toString();
					   soldeuser=mon_resultat.getString(4).toString();
					   
					   listAchatUserProduct.add(achat_User);
				   }
				   
					request.setAttribute("listAchatUserProduct", listAchatUserProduct);
					request.setAttribute("nomuser", nomuser);
					request.setAttribute("soldeuser", soldeuser);
					
					request.getRequestDispatcher("affichageAchat.jsp").forward(request, response);

			   
			   }catch(Exception e){
			    System.out.println(e);
			   } 
	}

}
