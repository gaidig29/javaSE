package fr.eni.papeterie.dal;

import fr.eni.papeterie.dal.jdbc.ArticleDAOJdbcImpl;

public class DAOFactory {

	public static ArticleDAO getArticleDao() {
		return new ArticleDAOJdbcImpl();
	}
}
