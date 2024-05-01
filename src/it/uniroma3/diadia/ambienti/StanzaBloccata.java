package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

/**
* Nome-classe: StanzaBloccata
* creo una stanza che se ha un determinato oggetto sblocca una direzione, altrimenti la direzione è 
* bloccata
*
* @author 590871
* @see Stanza
* @version 1.0
*/
public class StanzaBloccata extends Stanza {
	private String direzioneB;
	private String nomeAttrezzo;
	
	public StanzaBloccata(String nome, String direzioneB, String nomeAttrezzo) {
		super (nome);
		this.direzioneB = direzioneB;
		this.nomeAttrezzo = nomeAttrezzo;
	}
	 @Override
	 public Stanza getStanzaAdiacente(String direzione) {
	        if(direzioneB.equals(direzione)&&!this.hasAttrezzo(nomeAttrezzo))
	        	return (this);
	        
	        return super.getStanzaAdiacente(direzione);
		}
	 
	 @Override
	 public String getDescrizione() {
		 String bloccata = new String();
		 bloccata = "la stanza è bloccata devi aggiungere l'attrezzo:"+nomeAttrezzo;
		 if(!this.hasAttrezzo(nomeAttrezzo))
			 return bloccata;
		 
		 return super.getDescrizione();
	 }
	
}
