package fr.eni.papeterie.bo;

import java.util.ArrayList;
import java.util.List;

public class Panier {
	private float montant;
	private List<Ligne> lignesPanier;

	public Panier() {
		super();
		lignesPanier = new ArrayList<Ligne>();
		
	}
	public final List<Ligne> getLignesPanier() {
		return lignesPanier;
	}
	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}
	
	public void addLigne(Article article, int qte) {
		Ligne ligneAdding = new Ligne(article,qte);
		lignesPanier.add(ligneAdding);
	}
	
	public final Ligne getLigne(int index) {
		return lignesPanier.remove(index);
	}
	
	public void removeLigne(int index) {
		lignesPanier.remove(index);
	}
	public void updateLigne(int index, int newQte) {
		this.getLigne(index).setQte(newQte);
	}
	
	@Override
	public String toString() {
		StringBuffer bf = new StringBuffer();
		bf.append("Panier : \n\n");
		for (Ligne ligne : lignesPanier) {
			bf.append("ligne " );
			bf.append( lignesPanier.indexOf(ligne) );
			bf.append( " :\t");
			bf.append(ligne.toString());
			bf.append("\n");
		}
		bf.append("\nValeur du panier : " + getMontant());
		bf.append("\n\n");
		return bf.toString();
	}
	
}
