package devEnCouche.fr.eni.couches.Bll;

import java.util.List;

import devEnCouche.fr.eni.couches.Bo.Employe;
import devEnCouche.fr.eni.couches.Dal.EmployeDaoImpl;
import devEnCouche.fr.eni.couches.Dal.IDao;

public class EmployeManager implements IMetierEmploye{
	
	public IDao employeDao = new EmployeDaoImpl();


		@Override
		public void payerEmployer() {
			// TODO Auto-generated method stub
			 List<Employe>employes =   employeDao.getAll();
			 
			 for(Employe e : employes) {
				 System.out.println("l'employé a été payé");
			 }
		}

		@Override
		public void licencierEmployer() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void augmentationEmployer() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void extensionPeriodeEssai() {
			// TODO Auto-generated method stub
			
		}
		

}
