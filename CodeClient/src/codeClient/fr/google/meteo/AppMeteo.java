package codeClient.fr.google.meteo;

public class AppMeteo {
public static void main(String[] args) {
	System.out.println("Tcapteur = " + getTFromCapteur());
	System.out.println("TBDD = " + getTFromBDD());
	System.out.println("Moy = " + calcMoy(getTFromCapteur(),getTFromBDD()));
	}

	
	public static double getTFromCapteur() {
		return 180.23;
	}
	public static double getTFromBDD() {
		return 200.00;
	}
	public static double calcMoy(double a,double b) {
		a = getTFromBDD()+10;
		return(a+b)/2;
	}
}
