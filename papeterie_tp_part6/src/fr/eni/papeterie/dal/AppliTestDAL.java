package fr.eni.papeterie.dal;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;


public class AppliTestDAL {

	public static void main(String[] args) {
	
		//DÃ©claration et instanciation de la DAO
		ArticleDAO articleDAO = DAOFactory.getArticleDao();
		
		//Instanciation du jeu d'essai 
		Article a1 = new Stylo( "Bic", "BBOrange","Bic bille Orange", 1.2f, 20, "bleu");
		Article a2 = new Ramette(  "Clairef", "CRA4S", "Ramette A4 Sup", 9f, 20, 80);
		Article a3 = new Stylo( "Stypen", "PlumeS", "Stylo Plume Stypen", 5.5f, 20, "jaune");

		System.out.println("Ajout des articles... ");
		//TODO...
		
		try {
			articleDAO.insert(a1);
			System.out.println("Article ajoutÃ©  : " + a1.toString() );
			articleDAO.insert(a2);
			System.out.println("Article ajoutÃ©  : " + a2.toString() );
			articleDAO.insert(a3);
			System.out.println("Article ajoutÃ©  : " + a3.toString() );

			//SÃ©lection de l'article par id
			Article a = articleDAO.selectById(a2.getIdArticle());
			System.out.println("\nSÃ©lection de l'article par id  : " + a.toString() );
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
