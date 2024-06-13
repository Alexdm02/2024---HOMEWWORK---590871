package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
	
	private Attrezzo attrezzo;
	private static final String MESSAGGIO_CANE = "Hahaha ti ho morso, maledetto!!";
	private static final String NOME_ATTREZZO = "Osso";
	
	public Cane (String nome, String presentazione, Attrezzo attrezzo) {
		super (nome, presentazione);
		this.attrezzo=attrezzo;
	}
	
	
	@Override
	public String agisci(Partita partita) {
		String msg = MESSAGGIO_CANE;
		
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		
		return msg;
	}


	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(attrezzo.getNome().equals(NOME_ATTREZZO)) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo=attrezzo;
			return "BAU <3";
		}
		else {
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
			return "GRRRR!";
		}
	}

}
