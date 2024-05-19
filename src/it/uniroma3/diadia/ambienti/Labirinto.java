/**
 * 
 */
package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Labirinto: classe che si occupa di gestire e creare il labirinto della partita
 * 
 * @author 
 * 
 * @see Stanza
 * @see Attrezzo
 * 
 * @version 1.0
 */
public class Labirinto {
	
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	 
	public static LabirintoBuilder newBuilder() {
		return new LabirintoBuilder();
	}
	
	public void setStanzaVincente(Stanza stanza) {
		this.stanzaVincente=stanza;
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
}
