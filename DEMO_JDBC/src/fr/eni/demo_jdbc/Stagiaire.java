package fr.eni.demo_jdbc;

import java.util.Date;

public class Stagiaire {
	
	private int noStagiaire;
	private String prenom;
	private String nom;
	private Date dateDeNaissance;
	private String motDePasse;
	
	//Constructeurs
	public Stagiaire() {
		super();
	}
	public Stagiaire(String prenom, String nom, Date dateDeNaissance, String motDePasse) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.dateDeNaissance = dateDeNaissance;
		this.motDePasse = motDePasse;
	}
	public Stagiaire(int noStagiaire, String prenom, String nom, Date dateDeNaissance, String motDePasse) {
		super();
		this.noStagiaire = noStagiaire;
		this.prenom = prenom;
		this.nom = nom;
		this.dateDeNaissance = dateDeNaissance;
		this.motDePasse = motDePasse;
	}
	
	public int getNoStagiaire() {
		return noStagiaire;
	}
	public void setNoStagiaire(int noStagiaire) {
		this.noStagiaire = noStagiaire;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	@Override
	public String toString() {
		return "Stagiaire [noStagiaire=" + noStagiaire + ", prenom=" + prenom + ", nom=" + nom + ", dateDeNaissance="
				+ dateDeNaissance + ", motDePasse=" + motDePasse + "]";
	}
	
	
}
