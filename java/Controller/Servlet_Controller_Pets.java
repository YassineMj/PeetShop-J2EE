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
 * Servlet implementation class Servlet_Controller_Pets
 */
@WebServlet("/servletcategory.do")
public class Servlet_Controller_Pets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public static ArrayList<Model_Pets> listpets;
	public static ArrayList<Model_Product> listProduct;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model_Pets pet;
		Model_Product product;
		listpets=new ArrayList<>();
		listProduct=new ArrayList<>();
		
		try{  
			   Class.forName("com.mysql.cj.jdbc.Driver");
			    
			   Connection ma_connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_shop","root","");  

			   java.sql.Statement mon_statement = ma_connexion.createStatement();
			   
			   ResultSet mon_resultat = mon_statement.executeQuery("SELECT p.id_pet,p.nom_pets,c.id_category,p.desc_pets,p.prix,p.image_pets,c.nom_category, p.promotion FROM pets p INNER JOIN category c on p.id_category=c.id_category");
			   
			   // Remplir list de pets
			   while (mon_resultat.next()) { 
				   pet=new Model_Pets();
				   pet.setId_pet(Integer.parseInt(mon_resultat.getString(1).toString()));
				   pet.setNom_pet(mon_resultat.getString(2).toString());
				   pet.setId_category(Integer.parseInt(mon_resultat.getString(3)));
				   pet.setDesc_pet(mon_resultat.getString(4).toString());
				   pet.setPrix_pet(Float.parseFloat(mon_resultat.getString(5).toString()));
				   pet.setImage_pet(mon_resultat.getString(6)); 
				   pet.setPromontion_pet(mon_resultat.getBoolean(8));
				   listpets.add(pet);
				   }
				request.setAttribute("listpets", listpets);
				
			   // Remplir list de product
				 mon_resultat = mon_statement.executeQuery("SELECT * FROM product p inner join category c on p.id_category=c.id_category WHERE c.id_category=3");
				   
				   while (mon_resultat.next()) { 
					   product= new Model_Product();
					   product.setId_product(Integer.parseInt(mon_resultat.getString(1)));
					   product.setNom_product(mon_resultat.getNString(2));
					   product.setDesc_product(mon_resultat.getNString(3));
					   product.setPrix_product(Float.parseFloat(mon_resultat.getString(6).toString()));
					   product.setImage_product(mon_resultat.getString(4)); 
					   product.setPromotion(mon_resultat.getBoolean(7));

					   listProduct.add(product);
					   }
					request.setAttribute("listProduct", listProduct);

			   }catch(Exception e){
			    System.out.println(e);
			   } 

		
		request.getRequestDispatcher("category.jsp").forward(request, response);
	}

}
