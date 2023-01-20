package fr.eni.vehicule.dal;

import java.lang.reflect.InvocationTargetException;

import fr.eni.vehicule.dal.jdbc.AvionDaoJdbcImpl;


public class DaoFactory {

	public static AvionDao getAvionDao() {
		return new AvionDaoJdbcImpl();
	}
	
	public static VoitureDao getVoitureDao() {
	VoitureDao voiture = null;

		try {
			voiture = (VoitureDao) Class.forName(Settings.getProperty("VoitureDao"))
					.getDeclaredConstructor().newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	  return voiture;
	}
}
