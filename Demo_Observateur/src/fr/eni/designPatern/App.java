 package fr.eni.designPatern;

public class App {

	public static void main(String[] args) {
		ObservableConcret sujet = new ObservableConcret();
		ObserverImpl1 obs1 = new ObserverImpl1();
		sujet.addObserver(obs1);
		ObserverImpl2 obs2 = new ObserverImpl2();
		sujet.addObserver(obs2);
		ObserverImpl3 obs3 = new ObserverImpl3();
		sujet.addObserver(obs3);
		
		sujet.setEtat(5);
		
	}

}
