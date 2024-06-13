package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;


/**
* Nome-classe: ComandoAiuto
* la classe è un comando per il gioco DiaDia che se selezionato stampa tutti i comandi disponibili
* per il gioco aiutando il giocatore su cosa deve fare
*
* @author 590871 
* @see FabbricaDiComandiFisarmonica
* @version 1.0
*/


public class ComandoAiuto extends AbstractComando {
	
	public static final String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};
	static final private String NOME = "aiuto";
	private IO io;
	
	
	public void esegui(Partita partita) {
	for(int i=0; i< elencoComandi.length; i++) 
		io.mostraMessaggio(elencoComandi[i]+" ");
	io.mostraMessaggio("");
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
