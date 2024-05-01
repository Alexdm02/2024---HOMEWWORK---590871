package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

/**
* Nome-classe: ComandoFine
* un comando che fa finire la partita subito
*
* @author 590871 
* @see FabbricaDiComandiFisarmonica
* @version 1.0
*/


public class ComandoFine implements Comando {
	private IO io;
	private static final String NOME = "fine";
	
	

	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		io.mostraMessaggio("Grazie di aver giocato!");
	}

	@Override
	public void setParametro(String paramentro) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String getNome() {
		return NOME;
		
	}


	@Override
	public String getParametro() {
		return null;
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setIO(IO console) {
		this.io=console;
	}

}
