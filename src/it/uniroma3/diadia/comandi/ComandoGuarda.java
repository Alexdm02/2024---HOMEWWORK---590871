package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
/**
* Nome-classe: ComadoGuarda
* un comando che permette al giocatore di guardare, ovvero sapere le informazioni della stanza,
* e le informazioni dello stato del gocatore nel gioco
*
* @author 590871 
* @see FabbricaDiComandiFisarmonica
* @version 1.0
*/
public class ComandoGuarda implements Comando {
	private IO io;
	private static final String NOME = "guarda";


	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("Borsa");
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		io.mostraMessaggio("I CFU rimasti sono:");
		io.mostraMessaggio(partita.getGiocatore().getCfu()+ "");
		
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
