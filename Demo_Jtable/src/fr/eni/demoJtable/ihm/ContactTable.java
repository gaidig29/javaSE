package fr.eni.demoJtable.ihm;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import fr.eni.demoJtable.bo.Contact;

public class ContactTable extends JTable{
	
	public static final int COL_PRENOM = 0;
	public static final int COL_NOM = 1;
	
	public ContactTable(List<Contact> contacts) {
		this.setModel(new TableContactModel(contacts));
		setPreferredScrollableViewportSize(new Dimension(300,400));
		setFillsViewportHeight(true);
		this.getColumnModel().getColumn(COL_PRENOM).setPreferredWidth(100);
		this.getColumnModel().getColumn(COL_NOM).setPreferredWidth(100);
		
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	}

}
