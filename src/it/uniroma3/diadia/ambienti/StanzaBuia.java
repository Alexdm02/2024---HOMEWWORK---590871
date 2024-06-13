package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
/**
* Nome-classe: StanzaBuia
* creo una stanza che se ha un determinato oggetto si illumina, altrimenti stampa un messaggio
* "Qui c'è buio pesto".
*
* @author 590871
* @see Stanza
* @version 1.0
*/
public class StanzaBuia extends Stanza{
	private String nomeAttrezzo;
	
	
	public StanzaBuia(String nome, String nomeAttrezzo) {
		super (nome);
		this.nomeAttrezzo = nomeAttrezzo;
	}
	
	@Override
	public String getDescrizione() {
		String buio = new String();
		buio = "Qui c'è buio pesto";
		if(!this.hasAttrezzo(nomeAttrezzo)) {
			return buio;
		}
		return super.getDescrizione();
	}
}
	
