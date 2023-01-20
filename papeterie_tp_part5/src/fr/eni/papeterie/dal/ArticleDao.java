package fr.eni.papeterie.dal;
import java.util.List;

import fr.eni.papeterie.bo.Article;

public interface ArticleDao {

		public void insertArticle(Article v)throws DALException;
		public List<Article> getAll()throws DALException;
		public Article getById(long id)throws DALException;
		public void updateArticle(Article v)throws DALException;
		public void deleteArticle (long id)throws DALException;
		public List<Article> selectByMarque(String marque)throws DALException;
		public List<Article> selectByMotCle(String motCle)throws DALException;

	}

