package fr.eni.vehicule.dal.jdbc;

import fr.eni.vehicule.dal.Settings;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 

public class JdbcTools {

private static String urldb;
private static String userdb;
private static String passworddb;
	
	static {
		try {
			Class.forName(Settings.getProperty("driverdb"));
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
				urldb = Settings.getProperty(urldb);
				userdb = Settings.getProperty(userdb);
				passworddb = Settings.getProperty(passworddb);
				System.out.println("urldb :"+ urldb);
				System.out.println("userdb :"+ userdb);
				System.out.println("passworddb :"+ passworddb);
		}
		
		 
	
	public static Connection getConnection() throws SQLException {
	
		Connection connection = DriverManager.getConnection(urldb, userdb, passworddb);
		return connection;
	
		}
	
	}