package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Model_Pets;
import Model.Model_Product;

/**
 * Servlet implementation class Servlet_Controller_Special
 */
@WebServlet("/servletspecial.do")
public class Servlet_Controller_Special extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model_Pets pet;
		ArrayList<Model_Pets> listpets=new ArrayList<>();

		try{  
			   Class.forName("com.mysql.cj.jdbc.Driver");
			    
			   Connection ma_connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_shop","root","");  

			   java.sql.Statement mon_statement = ma_connexion.createStatement();
			   
			   ResultSet mon_resultat = mon_statement.executeQuery("SELECT p.id_pet,p.nom_pets,c.id_category,p.desc_pets,p.prix,p.image_pets,c.nom_category FROM pets p INNER JOIN category c on p.id_category=c.id_category where p.special=true");
			   
			   // Remplir list de pets
			   while (mon_resultat.next()) { 
				   pet=new Model_Pets();
				   pet.setId_pet(Integer.parseInt(mon_resultat.getString(1).toString()));
				   pet.setNom_pet(mon_resultat.getString(2).toString());
				   pet.setDesc_pet(mon_resultat.getString(4));
				   pet.setPrix_pet(Float.parseFloat(mon_resultat.getString(5).toString()));
				   pet.setImage_pet(mon_resultat.getString(6));
				   listpets.add(pet);
				   }
				request.setAttribute("listpets", listpets);
				

			   }catch(Exception e){
			    System.out.println(e);
			   } 

		
		request.getRequestDispatcher("specialsPets.jsp").forward(request, response);
	}

}
