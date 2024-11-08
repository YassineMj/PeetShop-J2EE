package Model;

import com.mysql.cj.jdbc.Blob;

public class Model_Product {
	private int id_product;
	private String nom_product;
	private String desc_product;
	private String image_product;
	private int id_category;
	private float prix_product;
	private boolean promotion;
	
	
	public boolean isPromotion() {
		return promotion;
	}
	public void setPromotion(boolean promotion) {
		this.promotion = promotion;
	}
	public String getImage_product() {
		return image_product;
	}
	public void setImage_product(String image_product) {
		this.image_product = image_product;
	}
	public String getDesc_product() {
		return desc_product;
	}
	public void setDesc_product(String desc_product) {
		this.desc_product = desc_product;
	}
	
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public String getNom_product() {
		return nom_product;
	}
	public void setNom_product(String nom_product) {
		this.nom_product = nom_product;
	}
	
	public int getId_category() {
		return id_category;
	}
	public void setId_category(int id_category) {
		this.id_category = id_category;
	}
	public float getPrix_product() {
		return prix_product;
	}
	public void setPrix_product(float prix_product) {
		this.prix_product = prix_product;
	}
	
	
}
