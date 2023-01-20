package fr.eni.demoJtable.ihm;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.eni.demoJtable.bo.Contact;

public class TableContactModel extends AbstractTableModel {
	
	private List<Contact> contacts;
	
	

	public TableContactModel(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	private String[] columnNames = {"Prénom","Nom"};

	@Override
	public int getRowCount() {
	
		return contacts.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object val = null;
		switch(columnIndex) {
			case ContactTable.COL_PRENOM:
				val = contacts.get(rowIndex).getPrenom();
				break;
			case ContactTable.COL_NOM:
				val = contacts.get(rowIndex).getNom();
				break;
		}
		return val;
	}

}
