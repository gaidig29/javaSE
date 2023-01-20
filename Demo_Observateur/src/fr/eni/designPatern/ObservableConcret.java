package fr.eni.designPatern;

import java.util.ArrayList;
import java.util.List;

public class ObservableConcret implements Observable{

	private List<Observer> observers = new ArrayList();
	private int etat;
	
	
	public List<Observer> getObservers() {
		return observers;
	}

	public void setObservers(List<Observer> observers) {
		this.observers = observers;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObserver() {
		for(Observer o : observers) {
			o.update(this);
		}
	}


}
