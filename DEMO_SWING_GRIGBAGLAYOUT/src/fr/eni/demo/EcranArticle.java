package fr.eni.demo;

import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class EcranArticle extends JFrame {

	private JTextField txtReference,txtDesignation,txtMarque,txtStock;
	private JRadioButton radioRamette, radioStyle;
	private JPanel panelType, panelGrammage ;
	private JCheckBox chk80,chk100;
	private JComboBox<String>cboCouleur;
	
	private JPanel panelBoutons;
	private JButton btnPrecedent;
	private JButton btnNouveau;
	private JButton btnEnregistrer;
	private JButton btnSupprimer;
	private JButton btnSuivant;
	
	
	public EcranArticle() throws HeadlessException {
		super();
		initIHM();
	}
	
	private void initIHM() {
	
	}
	
	
	public JTextField getTxtReference() {
		return txtReference;
	}

	public void setTxtReference(JTextField txtReference) {
		this.txtReference = txtReference;
	}

	public JTextField getTxtDesignation() {
		return txtDesignation;
	}

	public void setTxtDesignation(JTextField txtDesignation) {
		this.txtDesignation = txtDesignation;
	}

	public JTextField getTxtMarque() {
		return txtMarque;
	}

	public void setTxtMarque(JTextField txtMarque) {
		this.txtMarque = txtMarque;
	}

	public JTextField getTxtStock() {
		return txtStock;
	}

	public void setTxtStock(JTextField txtStock) {
		this.txtStock = txtStock;
	}

	public JRadioButton getRadioRamette() {
		return radioRamette;
	}

	public void setRadioRamette(JRadioButton radioRamette) {
		this.radioRamette = radioRamette;
	}

	public JRadioButton getRadioStyle() {
		return radioStyle;
	}

	public void setRadioStyle(JRadioButton radioStyle) {
		this.radioStyle = radioStyle;
	}

	public JPanel getPanelType() {
		return panelType;
	}

	public void setPanelType(JPanel panelType) {
		this.panelType = panelType;
	}

	public JPanel getPanelGrammage() {
		return panelGrammage;
	}

	public void setPanelGrammage(JPanel panelGrammage) {
		this.panelGrammage = panelGrammage;
	}

	public JCheckBox getChk80() {
		return chk80;
	}

	public void setChk80(JCheckBox chk80) {
		this.chk80 = chk80;
	}

	public JCheckBox getChk100() {
		return chk100;
	}

	public void setChk100(JCheckBox chk100) {
		this.chk100 = chk100;
	}

	public JComboBox<String> getCboCouleur() {
		return cboCouleur;
	}

	public void setCboCouleur(JComboBox<String> cboCouleur) {
		this.cboCouleur = cboCouleur;
	}

	public JPanel getPanelBoutons() {
		return panelBoutons;
	}

	public void setPanelBoutons(JPanel panelBoutons) {
		this.panelBoutons = panelBoutons;
	}

	public JButton getBtnPrecedent() {
		return btnPrecedent;
	}

	public void setBtnPrecedent(JButton btnPrecedent) {
		this.btnPrecedent = btnPrecedent;
	}

	public JButton getBtnNouveau() {
		return btnNouveau;
	}

	public void setBtnNouveau(JButton btnNouveau) {
		this.btnNouveau = btnNouveau;
	}

	public JButton getBtnEnregistrer() {
		return btnEnregistrer;
	}

	public void setBtnEnregistrer(JButton btnEnregistrer) {
		this.btnEnregistrer = btnEnregistrer;
	}

	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}

	public void setBtnSupprimer(JButton btnSupprimer) {
		this.btnSupprimer = btnSupprimer;
	}

	public JButton getBtnSuivant() {
		if(btnSuivant == null) {
			btnSuivant = new JButton();
			ImageIcon image = new ImageIcon(this.getClass()
					.getResource("resources/Forward24.gif"));
			btnSuivant.setIcon(image);
		}
		return btnSuivant;
	}
	
	public void setBtnSuivant(JButton btnSuivant) {
		this.btnSuivant = btnSuivant;
	}
	
	

	
}
