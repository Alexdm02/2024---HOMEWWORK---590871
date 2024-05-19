package it.uniroma3.diadia.ambienti;

import java.util.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;
/*
 * Questa classe ci permette di creare un labirinto a nostro piacere senza dover pre impostare 
 * una partita classica
 */
public class LabirintoBuilder {
	private Labirinto labirinto;
	private Stanza ultimaStanzaAggiunta;
	private Map<String, Stanza> nomeStanza;
	
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.nomeStanza = new HashMap<>();
	}
	
	public Map<String, Stanza> getnomeStanza(){
		return this.nomeStanza;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public LabirintoBuilder addStanza(String stanza) {
		Stanza s = new Stanza(stanza);
		this.ultimaAggiuntaAggiornata(s);
		
		return this;
	}
	
	public void ultimaAggiuntaAggiornata(Stanza stanza) {
		this.ultimaStanzaAggiunta = stanza;
		this.nomeStanza.put(ultimaStanzaAggiunta.getNome(), ultimaStanzaAggiunta);
	}
	
	public LabirintoBuilder addStanzaIniziale(String stanza) {
		Stanza stanzaIniziale = new Stanza(stanza);
		
		this.labirinto.setStanzaCorrente(stanzaIniziale);
		this.ultimaAggiuntaAggiornata(stanzaIniziale);
		
		return this;
	}
	
	public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
		Stanza stanza = new Stanza(stanzaVincente);
		this.labirinto.setStanzaVincente(stanza);
		this.ultimaAggiuntaAggiornata(stanza);
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
		Attrezzo a = new Attrezzo(nomeAttrezzo, peso);
		
		if(this.ultimaStanzaAggiunta==null) 
			return this;
		
		this.ultimaStanzaAggiunta.addAttrezzo(a);
		
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String stanza, String stanzaAdiacente, String direzione){
		Stanza s = this.nomeStanza.get(stanza);
		Stanza adiacente = this.nomeStanza.get(stanzaAdiacente);
		
		s.impostaStanzaAdiacente(direzione, adiacente);
		
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String stanza) {
		Stanza s = new StanzaMagica(stanza);
		this.ultimaAggiuntaAggiornata(s);
		
		return this;	
	}
	
	public LabirintoBuilder addStanzaBuia(String stanza, String attrezzo) {
		Stanza s = new StanzaBuia(stanza, attrezzo);
		this.ultimaAggiuntaAggiornata(s);
		
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String stanza, String direzione, String attrezzo) {
		Stanza s = new StanzaBloccata(stanza, direzione, attrezzo);
		this.ultimaAggiuntaAggiornata(s);
		
		return this;
	}
	
	
	
	
}
