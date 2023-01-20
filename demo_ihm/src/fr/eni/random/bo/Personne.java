package fr.eni.random.bo;

public class Personne {

	private Long id;
	private String nom;
	public Personne() {
		super();
	}
	public Personne(String nom) {
		super();
		this.nom = nom;
	}
	public Personne(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + "]";
	}

	
	
}
