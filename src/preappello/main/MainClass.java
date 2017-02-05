package preappello.main;
import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;

import preappello.aeromobili.Aeroplano;
import preappello.aeromobili.Deposito;
import preappello.aeromobili.Elicottero;
import preappello.gui.DepositoJFrame;
import preappello.tool.FileAeromobile;

public class MainClass { 
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Deposito deposito = new Deposito();
		
		Aeroplano aero1 = new Aeroplano(new GregorianCalendar(2016, 11, 1), 
				new GregorianCalendar(2017,1,2), 20, "AirBus", "ABC12D" , rotta1, 15 );
		Aeroplano aero2 = new Aeroplano(new GregorianCalendar(2013, 9, 4), 
				new GregorianCalendar(2017,1,3), 30, "AirDiego", "DIE60A", rotta2, 10);
		Elicottero eli1 = new Elicottero(new GregorianCalendar(2016, 5, 20), 
				new GregorianCalendar(2017, 1, 10), 2, "T3CCH14", "Napoli");
		Elicottero eli2 = new Elicottero(new GregorianCalendar(2015, 5, 27), 
				new GregorianCalendar(2017, 1, 15), 2, "D4R10", "Roma");
		
		deposito.addAeromobile(aero1);
		deposito.addAeromobile(aero2);
		deposito.addAeromobile(eli1);
		deposito.addAeromobile(eli2);
		
		//File file = new File (PATHNAME_WINDOWS);
		File file = new File (PATHNAME_LINUX);
		
		FileAeromobile.checkFile(file, deposito);
		
		DepositoJFrame frame = new DepositoJFrame("Deposito", file);	
	}
	
	static String [] rotta1 = {"Roma-Parigi", "Parigi-Amsterdam"};
	static String[] rotta2 = {"NewYork-LosAngeles","LosAngeles-Miami"};
	static String[] rotta3 = {"Londra-Barcellona", "Barcellona-Londra"};
	static String PATHNAME_WINDOWS = "C:/Users/anton/Desktop/deposito";
	static String PATHNAME_LINUX = "../../Scrivania/deposito";
}
