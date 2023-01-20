package fr.eni.vehicule.bll;

import fr.eni.vehicule.bo.Voiture;
import fr.eni.vehicule.dal.jdbc.VoitureDaoJdbcImpl;

public class VoitureManager {

	VoitureDaoJdbcImpl voitureDao = new VoitureDaoJdbcImpl();
	public void AjouterVoitureALaFouriere(Voiture v) {
		voitureDao.insertVoiture(v);
	}
}
