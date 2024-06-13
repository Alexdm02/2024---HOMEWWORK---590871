package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala extends AbstractComando {

	private IO io;
	private String nomeAttrezzo;
	private final static String NOME = "regala";
	
	
	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if(personaggio!=null) {
			if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
				personaggio.riceviRegalo(partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo), partita);
				io.mostraMessaggio("Hai regalato con successo l'attrezzo");
			}
			else {
				io.mostraMessaggio("Non hai l'attrezzo nella borsa.");
		}
		
		}
		else {
			io.mostraMessaggio("Non c'è nessun personaggio in questa stanza.");
		}
	}
	
	@Override
	public void setIO(IO io) {
		this.io = io;
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	

	@Override
	public String getParametro() {
		return nomeAttrezzo;
	}
	
	@Override 
	public String getNome() {
		return NOME;
	}
	

}
