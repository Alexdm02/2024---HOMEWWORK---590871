package it.uniroma3.diadia;

import java.util.Scanner;

/**
 * IOConsole: classe che gestisce le stampe e le letture di istruzioni
 * 
 * @author docente di POO
 * 
 * @version
 */

public class IOConsole implements IO{
	
	Scanner scannerDiLinea;
	
	public IOConsole(Scanner scanner) {
		this.scannerDiLinea = scanner;
	}
	
	/**
	 * Metodo che stampa messaggi
	 * @param msg
	 */
	@Override
    public void mostraMessaggio(String msg) {
    	System.out.println(msg);
    }
   
    /**
     * Metodo per leggere istruzioni
     * @return restituisce una stringa
     */
	
	@Override
    public String leggiRiga() {
    	String riga = scannerDiLinea.nextLine();
    	return riga;

    }
}
