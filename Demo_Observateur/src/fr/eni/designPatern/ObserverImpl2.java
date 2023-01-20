package fr.eni.designPatern;

public class ObserverImpl2 implements Observer {

	@Override
	public void update(Observable o) {
		int etat = ((ObservableConcret)o).getEtat();
		System.out.println("Résultat 2 de l'état" + etat);
	}

}
