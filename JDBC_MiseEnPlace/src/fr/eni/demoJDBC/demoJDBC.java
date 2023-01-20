package fr.eni.demoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class demoJDBC {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		
		try {
			DriverManager.registerDriver(new SQLServerDriver());
			String url = "jdbc:sqlserver://127.0.0.1:1433;databasename=BDD_DEMO";
			con = DriverManager.getConnection(url, "sa", "Pa$$w0rd");
			stmt = con.createStatement();
			String sql = "select * from Stagiaires;";
			ResultSet rs = stmt.executeQuery(sql);
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
	}

