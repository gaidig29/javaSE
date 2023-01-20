package fr.eni.demo_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class DEMO_JDBC {

	private static final String sql_insert= "INSERT into Stagiaires(prenom,nom,dateDeNaissance,motDePasse)values(?,?,?,?);";
	private static final String sql_update= "update Stagiaires set prenom=?,nom=?,dateDeNaissance=?,motDePasse=? where noStagiaire=?;";
	private static final String GETALL= "select * from Stagiaires";
	private static final String FINDONE= " select *  from Stagiaires where  noStagiaire=?;";
	private static final String sql_delete= "delete from Stagiaires where noStagiaire=?;";

	public Stagiaire insert (Stagiaire sta) throws ParseException {

		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			DriverManager.registerDriver(new SQLServerDriver());
			String urlConnection = "jdbc:sqlserver://127.0.0.1:1433;databasename=BDD_DEMO";
			con = DriverManager.getConnection(urlConnection, "sa", "Pa$$w0rd");
			System.out.println("Connexion réussie");
			stmt = con.prepareStatement(sql_insert, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, sta.getPrenom());
			stmt.setString(2, sta.getNom());
			stmt.setDate(3, (java.sql.Date) sta.getDateDeNaissance());
			stmt.setString(4, sta.getMotDePasse());
			stmt.executeUpdate();
			ResultSet rsId = stmt.getGeneratedKeys();
			if(rsId.next()) {
				sta.setNoStagiaire(rsId.getInt(1));
			}
			
			return sta;
			
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
	public Stagiaire update (Stagiaire sta) throws ParseException {

		Connection con = null;
		PreparedStatement stmt = null;

		
		try {
			DriverManager.registerDriver(new SQLServerDriver());
			String urlConnection = "jdbc:sqlserver://127.0.0.1:1433;databasename=BDD_DEMO";
			con = DriverManager.getConnection(urlConnection, "sa", "Pa$$w0rd");
			System.out.println("Connexion réussie");
			stmt = con.prepareStatement(sql_update);
			stmt.setString(1, sta.getPrenom());
			stmt.setString(2, sta.getNom());
			stmt.setDate(3,(java.sql.Date) sta.getDateDeNaissance());
			stmt.setString(4, sta.getMotDePasse());
			stmt.setInt(5, sta.getNoStagiaire());

			stmt.executeUpdate();

			return sta;
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
	public void GETALL () {

		Connection con = null;
		PreparedStatement stmt = null;
		List<Stagiaire> stagiaires = new ArrayList<>();
		
		try {
			DriverManager.registerDriver(new SQLServerDriver());
			String urlConnection = "jdbc:sqlserver://127.0.0.1:1433;databasename=BDD_DEMO";
			con = DriverManager.getConnection(urlConnection, "sa", "Pa$$w0rd");
			System.out.println("Connexion réussie");
			ResultSet rs = stmt.executeQuery(GETALL);
			StringBuffer msg;
			
			while(rs.next()) {
				Stagiaire stagiaire = new Stagiaire();
				stagiaire.setNoStagiaire(rs.getInt("noStagiaire"));
				stagiaire.setNom(rs.getString("nom"));
				stagiaire.setPrenom(rs.getString("prenom"));
				stagiaire.setDateDeNaissance(rs.getDate("dateDeNaissance"));
				stagiaire.setMotDePasse(rs.getString("motDePasse"));
				((List<Stagiaire>) stagiaire).add(stagiaire);
			}
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
	}
	public void FINDONE () {

		Connection con = null;
		PreparedStatement stmt = null;

		
		try {
			DriverManager.registerDriver(new SQLServerDriver());
			String urlConnection = "jdbc:sqlserver://127.0.0.1:1433;databasename=BDD_DEMO";
			con = DriverManager.getConnection(urlConnection, "sa", "Pa$$w0rd");
			System.out.println("Connexion réussie");
			stmt = con.prepareStatement(sql_delete);

			stmt.setString(1, "1003");
			ResultSet rs = stmt.executeQuery(FINDONE);
			StringBuffer msg;
			
			while(rs.next()) {
				msg = new StringBuffer();
				msg.append("noStagiaire = ");
				msg.append(rs.getInt("noStagiaire"));
				msg.append(", nom = ");
				msg.append(rs.getString("nom"));
				msg.append(", prenom = ");
				msg.append(rs.getString("prenom"));
				msg.append(", date de naissance = ");
				msg.append(rs.getString("dateDeNaissance"));
				msg.append(", mot de passe = ");
				msg.append(rs.getString("motDePasse"));
				System.out.println(msg.toString());

			stmt.executeUpdate();
			}
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
	}
	public void delete (int i) {

		Connection con = null;
		PreparedStatement stmt = null;

		
		try {
			DriverManager.registerDriver(new SQLServerDriver());
			String urlConnection = "jdbc:sqlserver://127.0.0.1:1433;databasename=BDD_DEMO";
			con = DriverManager.getConnection(urlConnection, "sa", "Pa$$w0rd");
			System.out.println("Connexion réussie");
			stmt = con.prepareStatement(sql_delete);
			stmt.setString(1, "1003");			
			stmt.executeUpdate();
			}
		 catch (SQLException e) {
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
	}
}
