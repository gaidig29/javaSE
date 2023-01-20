package fr.eni.papeterie.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eni Ecole Le panier stocke les articles sÃ©lectionnÃ©s par
 *         l'utilisateur au cours de sa navigation. Le panier n'est pas
 *         sauvegardÃ©.
 */
public class Panier {

	// Attributs d'instance
	private List<Ligne> lignesPanier;
	private float montant;

	// Constructeurs
	public Panier() {
		float montant;
		lignesPanier = new ArrayList<Ligne>();
	}

	// Getters et Setters
	/**
	 * @return the lignesPanier
	 */
	public final List<Ligne> getLignesPanier() {
		return lignesPanier;
	}

	/**
	 * Ajouter une ligne au panier. Le prix de la ligne est calculÃ© (Qte*prix)
	 * 
	 * @param numero
	 * @param article
	 * @param qte
	 * 
	 */
	public void addLigne(Article article, int qte) {

		Ligne ligneAdding = new Ligne(article, qte);
		lignesPanier.add(ligneAdding);
	}

	/**
	 * Retourne la ligne sÃ©lectionnÃ©e du Panier ou null si pas trouvÃ©e
	 * 
	 * @param index
	 * @return
	 */
	public final Ligne getLigne(int index) {
		return lignesPanier.get(index);
	}

	/**
	 * PrÃ©senter le dÃ©tail du panier
	 */
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

	/**
	 * Supprimer la ligne du panier. La quantitÃ© en stock augmente de la
	 * quantitÃ© associÃ©e Ã  la ligne
	 * 
	 * @param numero
	 */
	public void removeLigne(int index) {
		lignesPanier.remove(index);
	}

	/**
	 * Modifier la quantitÃ© placÃ©e dans le panier La quantitÃ© en stock augment
	 * ou diminue en fonction de cette nouvelle qtÃ©
	 * 
	 * @param index
	 * @param newQte
	 * @throws PlusEnStockException
	 */
	public void updateLigne(int index, int newQte) {
		this.getLigne(index).setQte(newQte);
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

}
