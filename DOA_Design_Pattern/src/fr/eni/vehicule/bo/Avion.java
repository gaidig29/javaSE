package fr.eni.vehicule.bo;

public class Avion {
	private Long id;
	private String marque;
	private String Couleur;
	public Avion(Long id, String marque, String couleur) {
		super();
		this.id = id;
		this.marque = marque;
		Couleur = couleur;
	}
	public Avion(String marque, String couleur) {
		super();
		this.marque = marque;
		Couleur = couleur;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getCouleur() {
		return Couleur;
	}
	public void setCouleur(String couleur) {
		Couleur = couleur;
	}
	
}
