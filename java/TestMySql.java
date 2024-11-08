import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import Model.Model_Pets;

public class TestMySql {
 
	public static void main(String[] args) {
		   Model_Pets pet=new Model_Pets();
 
		try{  
			   Class.forName("com.mysql.cj.jdbc.Driver");
			    
			   Connection ma_connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_shop","root","");  

			   java.sql.Statement mon_statement = ma_connexion.createStatement();
			   
			   ResultSet mon_resultat = mon_statement.executeQuery("SELECT nom_pets,desc_pets FROM pets");
			   
			   while (mon_resultat.next()) {
				   pet.setNom_pet(mon_resultat.getString("nom_pets").toString());
				   pet.setDesc_pet(mon_resultat.getString("desc_pets").toString());
				   }
			   
			   }catch(Exception e){
			    System.out.println(e);
			   }
		System.out.print(pet.getNom_pet().toString());
	}

}
