package fr.eni.random.ihm;

import java.awt.GridLayout;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import fr.eni.random.bll.Imetier;
import fr.eni.random.bll.PersonneManager;
import fr.eni.random.bo.Personne;

public class JPanel2 extends JPanel{
	Imetier pmger = new PersonneManager();
	JList list1;
	List list2 = new List();
	java.util.List<Personne> listP = new ArrayList<>();
	DefaultListModel<Personne> listModel = new DefaultListModel<>();
	public JPanel2() {
		super();
		listP = pmger.recupToutLeMonde();
		for (Personne p : listP) {
			listModel.addElement(p);
		}
		list1 = new JList(listModel);
		

		this.add(list1);
		this.add(list2);
	}

}
