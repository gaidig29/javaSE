package fr.eni.papeterie.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.DALException;



public class ArticleDAOJdbcImpl {

	private static final String TYPE_STYLO="STYLO";
	private static final String TYPE_RAMETTE="RAMETTE";
	private static final String sql_insert= "INSERT into dbo.Articles(reference,marque,designation,prixUnitaire,qteStock,grammage,couleur,type)values(?,?,?,?,?,?,?,?);";
	private static final String sql_update= "update dbo.Articles set reference=?,marque=?,designation=?,prixUnitaire=?,qteStock=?,grammage=?,couleur=?,type=? where idArticle=?;";
	private static final String selectId= "select * from dbo.Articles where idArticle=?";
	private static final String select= "select * from dbo.Articles";
	private static final String sql_delete= "delete from dbo.Articles where idArticle=?";


	public Article insert (Article art) throws DALException {

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			DriverManager.registerDriver(new SQLServerDriver());
			String urlConnection = "jdbc:sqlserver://127.0.0.1:1433;databasename=PAPETERIE_DB";
			con = DriverManager.getConnection(urlConnection, "sa", "Pa$$w0rd");
			stmt = con.prepareStatement(sql_insert, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, art.getReference());
			stmt.setString(2, art.getMarque());
			stmt.setString(3, art.getDesignation());
			stmt.setLong(4, (long) art.getPrixUnitaire());
			stmt.setFloat(5, (long) art.getQteStock());

			if(art instanceof Ramette) {
				Ramette r =(Ramette)art;
				stmt.setInt(6, r.getGrammage());
				stmt.setNull(7, Types.VARCHAR);
				stmt.setString(8, TYPE_RAMETTE);

			}
			if(art instanceof Stylo) {
				Stylo s =(Stylo)art;
				stmt.setNull(6, Types.INTEGER);
				stmt.setString(7, s.getCouleur() );
				stmt.setString(8, TYPE_STYLO);

			}

			stmt.executeUpdate();
			ResultSet rsId = stmt.getGeneratedKeys();
			if(rsId.next()) {
				art.setIdArticle(rsId.getInt(1));
			}

			return art;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null) {
					stmt.close();
				}
				if(con !=null) {
					stmt.close();	
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return null;

	}

	public void update (Article data) throws DALException {

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			DriverManager.registerDriver(new SQLServerDriver());
			String urlConnection = "jdbc:sqlserver://127.0.0.1:1433;databasename=PAPETERIE_DB";
			con = DriverManager.getConnection(urlConnection, "sa", "Pa$$w0rd");
			PreparedStatement rqt = con.prepareStatement(sql_update);
			rqt.setString(1, data.getReference());
			rqt.setString(2, data.getMarque());
			rqt.setString(3, data.getDesignation());
			rqt.setFloat(4, data.getPrixUnitaire());
			rqt.setInt(5, data.getQteStock());
			rqt.setInt(8, data.getIdArticle());
			
			if (data instanceof Ramette) {
				Ramette r = (Ramette) data;
				rqt.setInt(6, r.getGrammage());
				rqt.setNull(7, Types.VARCHAR);
			}
			if (data instanceof Stylo) {
				//autre possibilité : 
				//if(data.getClass().getSimpleName().equals(Stylo.class.getSimpleName())	
				Stylo s = (Stylo) data;
				rqt.setNull(6, Types.INTEGER);
				rqt.setString(7, s.getCouleur());
			}
			
		} catch (SQLException e) {

			throw new DALException("Update article failed - " + data, e);
		}
	}
	 

	public Article selectById(Integer id) throws DALException {
		Connection con = null;
		ResultSet rs = null;
		Article art = null;
		

		try {

			DriverManager.registerDriver(new SQLServerDriver());
			String url ="jdbc:sqlserver://127.0.0.1:1433;databasename=PAPETERIE_DB";
			con = DriverManager.getConnection(url, "sa", "Pa$$w0rd");
			PreparedStatement rqt = con.prepareStatement(selectId); 
			{
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			
			if(rs.next()) {
				if(TYPE_STYLO.equalsIgnoreCase(rs.getString("type").trim())) {
					art = new Stylo(
							rs.getInt("idArticle"),
							rs.getString("marque"),
							rs.getString("reference").trim(),
							rs.getString("designation"),
							rs.getFloat("prixUnitaire"),
							rs.getInt("qteStock"),
							rs.getString("couleur")
							);
	
				}
				if(TYPE_RAMETTE.equalsIgnoreCase(rs.getString("type").trim())) {
					art = new Ramette(
							rs.getInt("idArticle"),
							rs.getString("marque"),
							rs.getString("reference").trim(),
							rs.getString("designation"),
							rs.getFloat("prixUnitaire"),
							rs.getInt("qteStock"),
							rs.getInt("grammage")
							);
				}
			}

		}
		}catch (SQLException e) {
			throw new DALException("selectById failed - id = " +id, e);
		}

		return art;
	}
	public List<Article> selectAll() throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		List<Article> liste = new ArrayList<Article>();

		try {

			DriverManager.registerDriver(new SQLServerDriver());
			String url ="jdbc:sqlserver://127.0.0.1:1433;databasename=PAPETERIE_DB";
			cnx = DriverManager.getConnection(url, "sa", "Pa$$w0rd");

			
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(select);
			Article art = null;

			while (rs.next()) {
				if (TYPE_STYLO.equalsIgnoreCase(rs.getString("type").trim())) {

					art = new Stylo(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference").trim(),
							rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
							rs.getString("couleur"));
				}
				if (TYPE_RAMETTE.equalsIgnoreCase(rs.getString("type").trim())) {
					art = new Ramette(rs.getInt("idArticle"), rs.getString("marque"), rs.getString("reference").trim(),
							rs.getString("designation"), rs.getFloat("prixUnitaire"), rs.getInt("qteStock"),
							rs.getInt("grammage"));
				}
				liste.add(art);
			}

		} catch (SQLException e) {

			throw new DALException("selectAll failed - ", e);
		}
		return liste;
	}

	public void delete(int idArticle) throws DALException {
		Connection cnx = null;

		try {
				
			DriverManager.registerDriver(new SQLServerDriver());
			String url ="jdbc:sqlserver://127.0.0.1:1433;databasename=PAPETERIE_DB";
			cnx = DriverManager.getConnection(url, "sa", "Pa$$w0rd");				
			PreparedStatement rqt = cnx.prepareStatement(sql_delete);

			
			// l'intégrité référentielle s'occupe d'invalider la suppression
			// si l'article est référencé dans une ligne de commande
			rqt.setInt(1, idArticle);
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Delete article failed - id=" + idArticle, e);
		} 
	}

}



