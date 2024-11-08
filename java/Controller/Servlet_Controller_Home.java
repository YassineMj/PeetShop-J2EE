package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Blob;

import Model.Model_Pets;

/**
 * Servlet implementation class Servlet_Controller
 */
@WebServlet("/servlethome.do")
public class Servlet_Controller_Home extends HttpServlet {  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   Model_Pets pet;
		   ArrayList<Model_Pets> listpetsFeatured=new ArrayList<>();
		   ArrayList<Model_Pets> listNewpets=new ArrayList<>();

		try{  
			   Class.forName("com.mysql.cj.jdbc.Driver");
			    
			   Connection ma_connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_shop","root","");  

			   java.sql.Statement mon_statement = ma_connexion.createStatement();
			   
			   ResultSet mon_resultat = mon_statement.executeQuery("select a.id_pet,p.nom_pets,p.desc_pets,SUM(a.quantite) ,p.image_pets from achatpets a INNER JOIN pets p on a.id_pet=p.id_pet GROUP by a.id_pet ORDER by SUM(a.quantite) DESC LIMIT 2");
			   
			   while (mon_resultat.next()) { 
				   pet=new Model_Pets();
				   pet.setId_pet(Integer.parseInt(mon_resultat.getString(1).toString()));
				   pet.setNom_pet(mon_resultat.getString(2).toString());
				   pet.setDesc_pet(mon_resultat.getString(3).toString());
				   pet.setQuantite(Integer.parseInt(mon_resultat.getString(4).toString()));
				   pet.setImage_pet(mon_resultat.getString(5)); 
				   listpetsFeatured.add(pet);
				   }
				request.setAttribute("listpetsFeatured", listpetsFeatured);
				
				mon_resultat = mon_statement.executeQuery("SELECT p.id_pet , p.nom_pets,p.desc_pets,p.image_pets FROM pets p ORDER by p.id_pet desc LIMIT 3");
				   while (mon_resultat.next()) { 
					   pet=new Model_Pets();
					   pet.setId_pet(Integer.parseInt(mon_resultat.getString(1).toString()));
					   pet.setNom_pet(mon_resultat.getString(2).toString());
					   pet.setDesc_pet(mon_resultat.getString(3).toString());
					   pet.setImage_pet(mon_resultat.getString(4)); 

					   listNewpets.add(pet);
					   }
					request.setAttribute("listNewpets", listNewpets);

			   }catch(Exception e){
			    System.out.println(e);
			   } 
		
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
		
}
