package fr.eni.papeterie.ihm;

import java.util.List;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Article;

public class ArticleController {
	
	private EcranArticle ecrArticle;
	
	//Attributs
	private int indexCatalogue;
	private CatalogueManager mger;
	private List<Article> catalogue;
	private static ArticleController instance;
	
	//Constructeur
	
	public ArticleController() {
		
		
		//Initialisation du catalogue en mémoire
		try {
			mger = new CatalogueManager();
			catalogue = mger.getCatalogue();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Méthodes
		public static synchronized ArticleController get(){
			if(instance == null){
				instance = new ArticleController();
			}
			return instance;
		}
		
		public void startApp(){
			ecrArticle = new EcranArticle();
			
			afficherPremierArticle();
			ecrArticle.setVisible(true);
		}

	
	public void afficherPremierArticle(){
			//todo
		// 1 - on regarde la taille du catalogue
		// 2 - si la taille du catalogue est supérieur à zéro
		//     :--> alors on affiche le premier article avec indexCatalogue = 0
		// 3 - si le catalogue est vide
		//     :--> affiche une vue pour créer un nouvelle article (afficherNouveau())
		
		if  ( catalogue.size()>0) {
			indexCatalogue = 0;
			ecrArticle.afficherArticle(catalogue.get(indexCatalogue));
		} else {
			indexCatalogue = -1;
			ecrArticle.afficherNouveau();
		}
	}
		
	public void precedent(){
		// 1 - on décrémente indexCatalogue et on affiche l'article via l'ID décrémenté
		if (indexCatalogue > 0) {
			indexCatalogue--;
			ecrArticle.afficherArticle(catalogue.get(indexCatalogue));
		}
	}
	

	public void suivant() {
		// 1 - on incrémente indexCatalogue et on affiche l'article via l'ID incrémenté
		if (indexCatalogue < catalogue.size()-1) {
			indexCatalogue++;
			ecrArticle.afficherArticle(catalogue.get(indexCatalogue));
		}
	}

	public void nouveau() {
		//1 - indexCatalogue est égale à la taille du catalogue et on utilise afficherNouveau()
		indexCatalogue = catalogue.size();
		ecrArticle.afficherNouveau();
	}
	
	public void enregistrer() {
		Article articleAffiche = ecrArticle.getArticle();
		
		
			try {
				if (articleAffiche.getIdArticle() == null) {
				mger.addArticle(articleAffiche);
				System.out.println("article: " + articleAffiche);
				catalogue.add(articleAffiche);
				ecrArticle.afficherArticle(articleAffiche);
				} 
				else {
				mger.updateArticle(articleAffiche);
				catalogue.set(indexCatalogue, articleAffiche);
				}
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public void supprimer() {
		try {
			mger.removeArticle(catalogue.get(indexCatalogue));
			catalogue.remove(indexCatalogue);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (indexCatalogue < catalogue.size()) {
			ecrArticle.afficherArticle(catalogue.get(indexCatalogue));
		} else if (indexCatalogue > 0) {
			indexCatalogue--;
			ecrArticle.afficherArticle(catalogue.get(indexCatalogue));
		} else {
			ecrArticle.afficherNouveau();
		}
		
		
		
		
		
		
		
	}
}
