package fr.eni.random.bll;

import java.util.List;
import java.util.Random;

import fr.eni.random.bo.Personne;
import fr.eni.random.dal.Idao;
import fr.eni.random.dal.PersonneDaoJdbcImpl;

public class PersonneManager implements Imetier {

	Idao dao = new PersonneDaoJdbcImpl();
	
	@Override
	public List<Personne> recupToutLeMonde() {
		return dao.getAll();
	}

	@Override
	public boolean enregistrerUnePersonneEnBase(Personne p) {
		return dao.save(p);
	}

	@Override
	public void supprimerUnePersonneEnBase(Long Id) {
		dao.deleteById(Id);
	}

	@Override
	public Personne tirageAuSort(List<Personne> liste) {
		Random random_method = new Random();
			int index = random_method.nextInt(liste.size());
			System.out.println("Random Element is :"+liste.get(index));
		return liste.get(index);
	}

	
}
