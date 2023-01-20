package demoInterfaces.fr.eni.demoInterfaces;

public class PoissonVolant implements Volant,Nageant {

		public void nager() {
			System.out.println("Poissons volant qui nage");
			
		}
		@Override
		public void voler() {
			System.out.println("Poisson volant qui vole");
		}
}
