package fr.eni.papeterie.bll;

import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;
import fr.eni.papeterie.dal.DAOFactory;

public class CatalogueManager {
	
// Iforas
	private ArticleDAO daoArticles;

	private static CatalogueManager instance;

	public CatalogueManager() {
		// Instancier le Data Access Object
		daoArticles = DAOFactory.getArticleDao();
	}

	public static CatalogueManager getInstance() {
		if (instance == null) {
			instance = new CatalogueManager();
		}
		return instance;
	}
	
// Clement
	public List<Article> getCatalogue() throws BLLException {
		List<Article> articles = null;
		try {
			articles = daoArticles.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur rï¿½cupï¿½ration catalogue", e);
		}

		return articles;
	}

	// Judicael
	/**
	 * Ajout d'un article au catalogue
	 * 
	 * @param newArticle
	 * @return index du nouvel article dans le catalogue
	 * @throws BLLException
	 */
	public void addArticle(Article newArticle) throws BLLException {
		if (newArticle.getIdArticle() != null) {
			throw new BLLException("Article deja existant.");
		}
		try {
			validerArticle(newArticle);
			daoArticles.insert(newArticle);
		} catch (DALException e) {
			throw new BLLException("Echec addArticle", e);
		}
	}

	// Elouan
	/**
	 * updateArticle : Modifier un article du catalogue
	 * 
	 * @param article
	 * @throws BLLException
	 */
	public void updateArticle(Article article) throws BLLException {
		try {
			validerArticle(article);
			daoArticles.update(article);

		} catch (DALException e) {
			throw new BLLException("Echec updateArticle-article:" + article, e);
		}
	}

	
	//valentin
	/**
	 * Supprimer un article du catalogue
	 * 
	 * @param index
	 * @throws BLLException
	 */
	public void removeArticle(Article article) throws BLLException {
		try {
			daoArticles.delete(article.getIdArticle());
		} catch (DALException e) {
			throw new BLLException("Echec de la suppression de l'article - ", e);
		}

	}

	
	// amelie
	/**
	 * Valider les donnï¿½es d'un article
	 * 
	 * @param a
	 * @throws BLLException
	 */
	public void validerArticle(Article a) throws BLLException {
		boolean valide = true;
		StringBuffer sb = new StringBuffer();

		if (a == null) {
			throw new BLLException("Article null");
		}
		// Les attributs des articles sont obligatoires
		if (a.getReference() == null || a.getReference().trim().length() == 0) {
			sb.append("La reference article est obligatoire.\n");
			valide = false;
		}
		if (a.getMarque() == null || a.getMarque().trim().length() == 0) {
			sb.append("La marque  est obligatoire.\n");
			valide = false;
		}
		if (a.getDesignation() == null || a.getDesignation().trim().length() == 0) {
			sb.append("La designation  est obligatoire.\n");
			valide = false;
		}
		if (a instanceof Ramette && ((Ramette) a).getGrammage() <= 0) {
			sb.append("Le grammage doit avoir une valeur positive.\n");
			valide = false;
		}
		if (a instanceof Stylo) {
			Stylo s = (Stylo) a;
			if (s.getCouleur() == null || s.getCouleur().trim().length() == 0) {
				sb.append("La couleur pour un stylo  est obligatoire.\n");
				valide = false;
			}
		}

		if (!valide) {
			throw new BLLException(sb.toString());
		}

	}

}
