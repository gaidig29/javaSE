package fr.eni.papeterie.bll;

import java.util.List;


public class CatalogueManager {
	/*
	private ArticleDao daoArticles;

	private static CatalogueManager instance;

	public CatalogueManager() {
		// Instancier le Data Access Object
		daoArticles = DaoFactory.getArticleDao();
	}

	public static CatalogueManager getInstance() {
		if (instance == null) {
			instance = new CatalogueManager();
		}
		return instance;
	}
	
	public List<Article> getCatalogue() throws BLLException {
		List<Article> articles = null;
		try {
			articles = daoArticles.getAll();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur r�cup�ration catalogue", e);
		}

		return articles;
	}


	public void addArticle(Article newArticle) throws BLLException {
		if (newArticle.getIdArticle() != null) {
			throw new BLLException("Article deja existant.");
		}
		try {
			validerArticle(newArticle);
			daoArticles.insertArticle(newArticle);
		} catch (DALException e) {
			throw new BLLException("Echec addArticle", e);
		}
	}


	public void updateArticle(Article article) throws BLLException {
		try {
			validerArticle(article);
			daoArticles.updateArticle(article);

		} catch (DALException e) {
			throw new BLLException("Echec updateArticle-article:" + article, e);
		}
	}

	

	public void removeArticle(Article article) throws BLLException {
		try {
			daoArticles.deleteArticle(article.getIdArticle());
		} catch (DALException e) {
			throw new BLLException("Echec de la suppression de l'article - ", e);
		}

	}

	
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
*/
}
