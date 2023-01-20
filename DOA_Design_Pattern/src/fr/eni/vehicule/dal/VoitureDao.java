package fr.eni.vehicule.dal;
import java.util.List;
import fr.eni.vehicule.bo.Voiture;

public interface VoitureDao {

		public void insertVoiture(Voiture v);
		public List<Voiture> getAll();
		public Voiture getById(long id);
		public void updateVoiture(Voiture v);
		public void deleteVoiture (long id);
	}

