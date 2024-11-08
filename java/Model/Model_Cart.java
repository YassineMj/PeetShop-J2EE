package Model;

public class Model_Cart {

	private int id_cart;
	private String image;
	private String nom;
	private Float prix;
	private int quantite;
	private int id_pets;
	private int id_product;
	
	
	
	
	public int getId_pets() {
		return id_pets;
	}
	public void setId_pets(int id_pets) {
		this.id_pets = id_pets;
	}
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public int getId_cart() {
		return id_cart;
	}
	public void setId_cart(int id_cart) {
		this.id_cart = id_cart;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Float getPrix() {
		return prix;
	}
	public void setPrix(Float prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
}
