package fr.eni.designPatern;

public class ObserverImpl3 implements Observer {

	@Override
	public void update(Observable o) {
		int etat = ((ObservableConcret)o).getEtat();
		System.out.println("Résultat 3 de l'état" + etat);
	}

}
