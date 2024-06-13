package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;


import it.uniroma3.diadia.Partita;

/**
* Nome-classe: ComandoFine
* un comando che fa finire la partita subito
*
* @author 590871 
* @see FabbricaDiComandiFisarmonica
* @version 1.0
*/


public class ComandoFine extends AbstractComando {
	private IO io;
	private static final String NOME = "fine";
	public final static String MESSAGGIO_FINE = "Grazie di aver giocato!";
	
	
	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		io.mostraMessaggio(MESSAGGIO_FINE);
	}

	@Override
	public String getNome() {
		return NOME;
		
	}
	
	@Override
	public void setIO(IO console) {
		this.io=console;
	}

}
