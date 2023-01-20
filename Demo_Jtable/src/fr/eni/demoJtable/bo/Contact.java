package fr.eni.demoJtable.bo;

public class Contact {
	
	private String nom;
	private String prenom;
	public Contact() {
		super();
	}
	public Contact(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@Override
	public String toString() {
		return "Contact [nom=" + nom + ", prenom=" + prenom + "]";
	}
	

}
