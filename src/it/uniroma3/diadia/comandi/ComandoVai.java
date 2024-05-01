package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
/**
* Nome-classe: ComandoFine
* un comando che fa muovere il giocatore
*
* @author 590871
* @see FabbricaDiComandiFisarmonica
* @version 1.0
*/
public class ComandoVai implements Comando {
	private String direzione;
	private IO console;
	private static final String NOME = "vai";

	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;
		
		if(direzione==null) {
			console.mostraMessaggio("Dove vuoi andare? Devi inserire una direzione.");
			return ;		
		}
		
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza==null) {
			console.mostraMessaggio("Direzione inseistente");
			return;
		}
		
		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		console.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}

	@Override
	public String getNome() {
		return NOME;
	}

	@Override
	public String getParametro() {
		return this.direzione;
	}
	@Override
	public void setIO(IO io) {
		this.console=io;
	}
	
}
