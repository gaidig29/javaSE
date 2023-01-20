package devEnCouche.fr.eni.couches.Bo;

public class Employe {

	private long id;
	private String prenom;
	public Employe() {
		super();
	}
	
	public Employe(long id, String prenom) {
		super();
		this.id = id;
		this.prenom = prenom;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
}
