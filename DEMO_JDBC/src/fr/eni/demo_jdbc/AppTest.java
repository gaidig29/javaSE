package fr.eni.demo_jdbc;

import java.text.ParseException;

public class AppTest {
	public static void main(String[] args) throws ParseException {
		DEMO_JDBC demoJdbc = new DEMO_JDBC() ;
			 demoJdbc.insert(null);
			 demoJdbc.update(null);
			 demoJdbc.GETALL();
			 demoJdbc.FINDONE();
			 demoJdbc.delete(4);
	}
}
