package fr.eni.random.ihm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.eni.random.bll.Imetier;
import fr.eni.random.bll.PersonneManager;
import fr.eni.random.bo.Personne;

public class MaFenetre extends JFrame {
//implements ActionListener 

//	Imetier pmger = new PersonneManager();

//	JLabel jl1 = new JLabel("Nom : ");
//	JTextField jt1 = new JTextField(20);
//	JButton jb1 = new JButton("Ajouter");
//	JButton jb2 = new JButton("Supprimer");
//	JButton jb3 = new JButton("Tirage au sort");
//	JList list1;
//	List list2 = new List();
//	java.util.List<Personne> listP = new ArrayList<>();
//	DefaultListModel<Personne> listModel = new DefaultListModel<>();

	MaFenetre() {
//		listP = pmger.recupToutLeMonde();
//		for (Personne p : listP) {
//			listModel.addElement(p);
//		}
//		list1 = new JList(listModel);

		this.setVisible(true);
		this.setBounds(10, 10, 1000, 1000);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());

		JPanel jp1 = new JPanel1();
		this.add(jp1, BorderLayout.NORTH);
		JPanel jp2 = new JPanel2();
		this.add(jp2, BorderLayout.CENTER);

		jp1.setLayout(new FlowLayout());
//		jp1.add(jl1);
//		jp1.add(jt1);
//		jp1.add(jb1);
//		jp1.add(jb2);
//		jp1.add(jb3);

		jp2.setLayout(new GridLayout());
//		jp2.add(list1);
//		jp2.add(list2);

//		jb1.addActionListener((ActionListener) this);
//		jb2.addActionListener((ActionListener) this);

//		jb1.addActionListener( new ActionJb1(jt1, list1));

//		jb1.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String s = jt1.getText();
//				Personne personneAEnregistrer = new Personne();
//				personneAEnregistrer.setNom(s);
//				pmger.enregistrerUnePersonneEnBase(personneAEnregistrer);
//				listP = pmger.recupToutLeMonde();
//				listModel.clear();
//				for (Personne p : listP) {
//					listModel.addElement(p);
//				}
//				list1.updateUI();
//
//				jt1.setText("");
//				jt1.requestFocus();
//
//			}
//		});
//
//		jb2.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// index dans la liste afficher
//				if (list1.getSelectedIndex() != -1) {
//					int num = list1.getSelectedIndex();
//					pmger.supprimerUnePersonneEnBase(listModel.get(num).getId());
//					listP = pmger.recupToutLeMonde();
//					listModel.clear();
//					for (Personne p : listP) {
//						listModel.addElement(p);
//					}
//					list1.updateUI();
//				}
//
//			}
//		});
//		
//		
//		jb3.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				listP = pmger.recupToutLeMonde();
//				Personne p = pmger.tirageAuSort(listP);
//				list2.add(p.getNom());
//				
//			}
//		});
//		
		
		
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == jb1) {
//			String s = jt1.getText();
//			list1.add(s);
//			jt1.setText("");
//			jt1.requestFocus();
//		} else if (e.getSource() == jb2) {
//
//			int num = list1.getSelectedIndex();
//			if (num != -1) {
//				list1.remove(num);
//			}
//		}
//
//	}

//	public static void main(String[] args) {
		// JFrame maFenetre = new JFrame();
//		new MaFenetre();
//	}

}
