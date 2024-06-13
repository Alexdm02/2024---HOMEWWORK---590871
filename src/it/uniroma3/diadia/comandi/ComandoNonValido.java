package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
/**
* Nome-classe: ComandoNonValido
* un comando che ritorna una stringa "non valido" se si inserisce un comando inesistente
*
* @author 590871 
* @see FabbricaDiComandiFisarmonica
* @version 1.0
*/
public class ComandoNonValido extends AbstractComando {
	IO io;
	private static final String NOME = "non valido";

	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Comando non valido");
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
