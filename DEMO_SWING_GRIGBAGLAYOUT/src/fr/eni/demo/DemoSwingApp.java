package fr.eni.demo;

import javax.swing.SwingUtilities;

public class DemoSwingApp {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				EcranStagiaire frame = new EcranStagiaire();
				frame.setVisible(true);
			}
			
		});
	}
}
