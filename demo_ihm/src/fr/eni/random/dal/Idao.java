package fr.eni.random.dal;

import java.sql.Connection;
import java.util.List;

import fr.eni.random.bo.Personne;
import fr.eni.random.utilitaire.ConnexionSqlServeur;

public interface Idao {
	// récupérer la connexion  àa aprtir de l'utilitaire 'ConnexionSqlServer'

	public Connection connexion = ConnexionSqlServeur.getInstance();
	
	public List<Personne> getAll();
	public Personne getById(Long id);
	public boolean save(Personne user);
	public boolean update (Personne user);
	public boolean deleteById (Long id);
}