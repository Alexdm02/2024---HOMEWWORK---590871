package it.uniroma3.diadia.ambienti;
import java.util.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/

public class Stanza {
	//NON MODIFICABILE
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
	private String nome;
	
	private Map<String, Attrezzo> nome_attrezzi;
	private int numeroAttrezzi;
	private Map<Direzioni, Stanza> direzioni_stanzeAdiacenti;
	private int numeroStanzeAdiacenti;
	private AbstractPersonaggio personaggio;
	
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.nome_attrezzi = new HashMap<>(NUMERO_MASSIMO_ATTREZZI);
        this.direzioni_stanzeAdiacenti = new HashMap<>(NUMERO_MASSIMO_DIREZIONI);
        this.numeroAttrezzi = 0;
        this.numeroStanzeAdiacenti = 0;
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(Direzioni direzione, Stanza stanza) {
        boolean aggiornato = false;
        if(this.direzioni_stanzeAdiacenti.containsKey(direzione)) {
    	this.direzioni_stanzeAdiacenti.put(direzione, stanza);
    	aggiornato = true;
        }
        if(!aggiornato) {
        	if(this.numeroStanzeAdiacenti< NUMERO_MASSIMO_DIREZIONI) {
        		this.direzioni_stanzeAdiacenti.put(direzione, stanza);
        		this.numeroStanzeAdiacenti++;
        	}
        }
    }
    

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(Direzioni direzione) {
		return this.direzioni_stanzeAdiacenti.get(direzione);
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public Collection<Attrezzo> getAttrezzi() {
        return this.nome_attrezzi.values();
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
    	boolean verificato = false;
    	if(numeroAttrezzi<NUMERO_MASSIMO_ATTREZZI&&attrezzo!=null) {
    		this.nome_attrezzi.put(attrezzo.getNome(), attrezzo);
    		verificato = true;
    		numeroAttrezzi++;
    	}
    	return verificato;	
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	risultato.append("\nUscite: ");
    	risultato.append(this.getDirezioni().toString());
    	risultato.append("\nAttrezzi nella stanza:");
    	risultato.append(this.getAttrezzi().toString());
    	return risultato.toString();
    }
  
    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.nome_attrezzi.containsKey(nomeAttrezzo);
	}
	
	public List<Stanza> getStanzeAdiacenti() {
		List<Stanza> stanzeAdiacenti = new ArrayList<>();
		
		for(Stanza s: direzioni_stanzeAdiacenti.values()) {
			stanzeAdiacenti.add(s);
		}
		
		return stanzeAdiacenti;		
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		if(this.nome_attrezzi.containsKey(nomeAttrezzo)) {
			attrezzoCercato = this.nome_attrezzi.get(nomeAttrezzo);
		}
		return attrezzoCercato;
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param attrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(attrezzo!=null&&this.hasAttrezzo(attrezzo.getNome())) {
			this.nome_attrezzi.remove(attrezzo.getNome(), attrezzo);
			return true;
		}
		return false;
	}
	

	/**
	 * Metodo che restituisce le direzioni
	 * @return  Direzioni
	 */
	public Set<Direzioni> getDirezioni() {
		return this.direzioni_stanzeAdiacenti.keySet();
    }
	
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
	
	@Override
	public boolean equals(Object o) {
		Stanza that = (Stanza) o;
		
		return this.getNome().equals(that.getNome());
	}
	
	public void setPersonaggio(AbstractPersonaggio personaggio) {
		this.personaggio = personaggio;
		}
	
	
	public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
		}
	
	public int numeroAttrezzi() {
		return this.numeroAttrezzi;
	}

}