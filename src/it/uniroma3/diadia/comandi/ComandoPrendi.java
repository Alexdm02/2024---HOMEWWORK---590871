package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
/**
* Nome-classe: ComandoFine
* un comando che fa prendere un oggetto dalla stanza alla borsa
*
* @author 590871 
* @see FabbricaDiComandiFisarmonica
* @version 1.0
*/
public class ComandoPrendi extends AbstractComando {
	private String nomeAttrezzo;
	private IO io;
	private final String NOME = "prendi";
	

	@Override
	public void esegui(Partita partita) {
			if (partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
				Attrezzo a=partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
				partita.getGiocatore().getBorsa().addAttrezzo(a);
				partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
				io.mostraMessaggio("Hai preso con successo l'attrezzo.\n");
			}
			else
				io.mostraMessaggio("L'attrezzo non è presente nella stanza.\n");	
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
