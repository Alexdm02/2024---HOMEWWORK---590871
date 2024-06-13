package it.uniroma3.diadia.personaggi;

import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{
	
	private static final String MESSAGGIO_SALUTO = "Grazie per avermi salutato,"+
    "ti meriti di essere spostato in un posto migliore.";
	
	private static final String MESSAGGIO_NON_SALUTO = "Non mi hai neanche salutato,"+
	"ora ti sposto in un brutto posto!";
	
	public Strega(String nome, String presentazione) {
		super (nome, presentazione);
	}
	
	@Override
	public String agisci(Partita partita) {
		String msg;
		List<Stanza> stanzeAdiacenti = partita.getLabirinto().getStanzaCorrente().getStanzeAdiacenti();
		Stanza maxAttrezzi=stanzeAdiacenti.get(0);
		Stanza minAttrezzi=stanzeAdiacenti.get(0);
		
		for(Stanza s: stanzeAdiacenti) {
			if(s!=null) {
				if(s.numeroAttrezzi() > maxAttrezzi.numeroAttrezzi())
					maxAttrezzi = s;
			}
			if(s.numeroAttrezzi() < minAttrezzi.numeroAttrezzi())
				minAttrezzi = s;
		}
		
		
		if(this.haSalutato()) {
			partita.getLabirinto().setStanzaCorrente(maxAttrezzi);
			msg = MESSAGGIO_SALUTO;
			
		}
		
		else {
			partita.getLabirinto().setStanzaCorrente(minAttrezzi);
			msg = MESSAGGIO_NON_SALUTO;
		}
		
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String msg = "HIHIHIHIHI ora lo tengo io l'attrezzo!!!";
		return msg;
	}
	
	
}
