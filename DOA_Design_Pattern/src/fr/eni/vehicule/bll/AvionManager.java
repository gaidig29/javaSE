package fr.eni.vehicule.bll;

import java.util.List;

import fr.eni.vehicule.bo.Avion;
import fr.eni.vehicule.dal.jdbc.AvionDaoJdbcImpl;

public class AvionManager {

	AvionDaoJdbcImpl avionDao = new AvionDaoJdbcImpl();
	
	public void AjoterAvionAuParc(Avion a) {
		avionDao.insertAvion(a);
	}
	
	public List<Avion> RecupereAvionsDuParc(){
		List<Avion> listesAvion = avionDao.getAll();
		return listesAvion;
	}
	
	public Avion RecupererAvionParId (long id) {
		Avion avion = avionDao.getById(id);
		return avion;
	}
	
	public void mettreJourInfoAvion (Avion a) {
		avionDao.updateAvion(a);
	}
	
	public void supprimervionDuParc (long id) {
		avionDao.deleteAvion(id);
	}
}
