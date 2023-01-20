package fr.eni.papeterie.dal;

import java.util.List;

import fr.eni.papeterie.bo.Article;

public class DAO {
	

	public void insert(Article art) throws DALException;
	public Article selectById(int id) throws DALException ;
	public List<Article> selectAll() throws DALException;
	public void update(Article data) throws DALException;
	public void delete(int idArticle) throws DALException;

}
