package fr.eni.demoJtable.ihm;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import fr.eni.demoJtable.bo.Contact;

public class EcranPrincipal extends JFrame {
	
	private ContactTable tblContact;
	private List<Contact> contacts;	
	
	
	public EcranPrincipal() {
		setTitle("Demo JTable");
		setSize(400,500);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initGui();
	}
	
	private void initGui() {
		JPanel panel = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane(getTblContact());
		panel.add(scrollPane);
		
		setContentPane(panel);
	}


	public ContactTable getTblContact() {
	if (tblContact == null) {
		tblContact = new ContactTable(getContacts());
	}	
		
		return tblContact;
	}


	public List<Contact> getContacts(){
		contacts = new ArrayList<>();
		contacts.add(new Contact("Duck","Donald"));
	return 	contacts;
	}

	public static void main(String[] args) {
	
		SwingUtilities.invokeLater( new Runnable() {
			
			@Override
			public void run() {
				
				EcranPrincipal ecr = new EcranPrincipal();
				ecr.setVisible(true);
			}
		});

	}

}
