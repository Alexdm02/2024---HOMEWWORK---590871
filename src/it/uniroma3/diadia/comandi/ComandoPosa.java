package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
/**
* Nome-classe: ComandoPosa
* un comando che fa posare un ogetto dalla borsa alla stanza
*
* @author 590871
* @see FabbricaDiComandiFisarmonica
* @version 1.0
*/
public class ComandoPosa implements Comando {
	private IO io;
	private String nomeAttrezzo;
	private final String NOME = "posa";
	

	@Override
	public void esegui(Partita partita) {
		if (partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo));
			io.mostraMessaggio("Hai posato con successo l'attrezzo.\n");
		}else
			io.mostraMessaggio("L'attrezzo non è prensente nella borsa.\n");

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;

	}

	@Override
	public String getNome() {
		return NOME;
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
	@Override
	public void setIO(IO console) {
		this.io=console;
	}

}
