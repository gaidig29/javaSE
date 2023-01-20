package fr.eni.vehicule.dal;
import java.util.List;

import fr.eni.vehicule.bo.Avion;

public interface AvionDao {

	public void insertAvion(Avion v);
		public List<Avion> getAll();
		public Avion getById(long id);
		public void updateAvion(Avion v);
		public void deleteAvion (long id);
	}

