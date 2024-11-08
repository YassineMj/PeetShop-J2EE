package Model;

import com.mysql.cj.jdbc.Blob;

public class Model_Pets {
	private int id_pet;
	private int id_category;
	private String nom_pet;
	private String desc_pet; 
	private String color_pet;
	private String image_pet;
	private float prix_pet;
	private boolean promontion_pet;
	private boolean special_pet;
	private int quantite;
	
	

	public String getImage_pet() {
		return image_pet;
	}
	public void setImage_pet(String image_pet) {
		this.image_pet = image_pet;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	public int getId_pet() {
		return id_pet;
	}
	public void setId_pet(int id_pet) {
		this.id_pet = id_pet;
	}
	public int getId_category() {
		return id_category;
	}
	public void setId_category(int id_category) {
		this.id_category = id_category;
	}
	public String getNom_pet() {
		return nom_pet;
	}
	public void setNom_pet(String nom_pet) {
		this.nom_pet = nom_pet;
	}
	public String getDesc_pet() {
		return desc_pet;
	}
	public void setDesc_pet(String desc_pet) {
		this.desc_pet = desc_pet;
	}
	public String getColor_pet() {
		return color_pet;
	}
	public void setColor_pet(String color_pet) {
		this.color_pet = color_pet;
	}
	public float getPrix_pet() {
		return prix_pet;
	}
	public void setPrix_pet(float prix_pet) {
		this.prix_pet = prix_pet;
	}
	public boolean isPromontion_pet() {
		return promontion_pet;
	}
	public void setPromontion_pet(boolean promontion_pet) {
		this.promontion_pet = promontion_pet;
	}
	public boolean isSpecial_pet() {
		return special_pet;
	}
	public void setSpecial_pet(boolean special_pet) {
		this.special_pet = special_pet;
	}
	
	
	
}
