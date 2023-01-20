package demoInterfaces.fr.eni.demoInterfaces;

public class ZooApp {
	public static void main(String[] args) {
		//Chat c = new Chat();
		//c.communiquer();
		
		ChauveSouris cs = new ChauveSouris();
		cs.voler();
		
		Volant cs2 = cs;
		cs2.voler();
		
		PoissonVolant ps = new PoissonVolant();
		ps.nager();
		ps.voler();
		
	}
	
}
