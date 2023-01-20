package fr.eni.random.bll;

import java.util.List;

import fr.eni.random.bo.Personne;

public interface Imetier {

	public List<Personne> recupToutLeMonde();
	
	public boolean enregistrerUnePersonneEnBase(Personne p);
	
	public void supprimerUnePersonneEnBase(Long Id);
	
	public Personne tirageAuSort (List<Personne> liste);
}
