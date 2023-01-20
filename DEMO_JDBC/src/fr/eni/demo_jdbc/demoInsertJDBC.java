package fr.eni.demo_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class demoInsertJDBC {


	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;

		
		try {
			DriverManager.registerDriver(new SQLServerDriver());
			String url = "jdbc:sqlserver://127.0.0.1:1433;databasename=BDD_DEMO";
			con = DriverManager.getConnection(url, "sa", "Pa$$w0rd");
			
			String sql = "INSERT into Stagiaires(prenom,nom,dateDeNaissance,motDePasse)values(?,?,?,?);";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "bob");
			stmt.setString(2, "Leponge");
			stmt.setString(3, "2021-12-21");
			stmt.setString(4, "mdp");
			stmt.executeUpdate();

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

