package it.uniroma3.diadia.giocatore;
import java.util.*;

import it.uniroma3.diadia.attrezzi.*;

/**
 * Borsa: classe che si occupa di gestire la borsa del giocatore
 * 
 * @author docente di POO 590871
 * 
 * @see Attrezzo
 * 
 * @version 1.0 
 */

public class Borsa{
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;

	private int pesoMax;
	private Map<String , Attrezzo> nome_attrezzi;
	private int numeroAttrezzi;
	private int pesoAttuale;
	
	/**
	 * Metodo che imposta il peso della borsa con il peso default
	 */
	public Borsa() {
	    this(DEFAULT_PESO_MAX_BORSA);
	}
	
	/**
	 * Metodo che imposta il peso massimo della borsa
	 * @param pesoMax
	 */
	public Borsa(int pesoMax) {
	    this.pesoMax = pesoMax;
	    nome_attrezzi = new TreeMap<>();
	    this.numeroAttrezzi = 0;
	    this.pesoAttuale = 0;
	}
	
	/**
	 * Metodo che inserisce un attrezzo della borsa verificando le condizioni e 
	 * aggiorna se inserisce il numero degli attrezzi presenti nella borsa
	 * @param attrezzo
	 * @return false se non ha inserito l'attrezzo, true altrimenti 
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		
	    if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
	        return false;
	    
	    this.nome_attrezzi.put(attrezzo.getNome(), attrezzo);
	    this.numeroAttrezzi++;
	    this.pesoAttuale =+ attrezzo.getPeso();
	    return true;
	}
	
	public int getPesoMax() {
	    return pesoMax;
	}
	
	/**
	 * Metodo che restituisce un attrezzo se ha lo stesso nome 
	 * @param nomeAttrezzo
	 * @return un attrezzo
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
	    Attrezzo a = null;
	    
	    if(this.nome_attrezzi.containsKey(nomeAttrezzo))
	    	a = this.nome_attrezzi.get(nomeAttrezzo);
	    
	    return a;
	}
	
	/**
	 * Metodo che somma il peso di tutti gli attrezzi presenti nella borsa,
	 * e ne restituisce il peso totale
	 * @return peso
	 */
	public int getPeso() {
		return this.pesoAttuale;
	}
	
	/**
	 * Metodo che verifica se ci sono attrezzi nella borsa
	 * @return true se non ci sono attrezzi, false altrimenti
	 */
	public boolean isEmpty() {
		return this.numeroAttrezzi==0;
	}
		
	/**
	 * Metodo che verifica se è presente l'attrezzo dal nome uguale alla stringa
	 * @param nomeAttrezzo
	 * @return vero se esiste, falso altrimenti
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	/**
	 * Metodo che rimuove un attrezzo dalla borsa e restituisce l'attrezzo rimosso
	 * @param nomeAttrezzo
	 * @return attrezzo rimosso
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a=null;
		if(this.hasAttrezzo(nomeAttrezzo)) {
			a = this.nome_attrezzi.get(nomeAttrezzo);
			this.nome_attrezzi.remove(nomeAttrezzo);
			this.numeroAttrezzi--;	
		}
		return a;
	}
	
	 public Collection<Attrezzo> getAttrezzi() {
	        return this.nome_attrezzi.values();
	    }
	
	/**
	 * Metodo che restituisce le informazioni riguardo il contenuto della borsa
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		 if (!this.isEmpty()) {
			 
		     s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
		     s.append("\nGli attrezzi:");
		     s.append(this.getAttrezzi().toString());
		 }
		 else
		 s.append("Borsa vuota");
		 
		 return s.toString();
		}
	
	/*
	 * Serie di metodi che ordinano gli attrezzi
	 */
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> lista = new TreeSet<>(new ComparatoreAttrezziPerPeso());
		lista.addAll(this.nome_attrezzi.values());
		return lista;
	}
	/*
	 * Questo metodo ordina gli oggetti per peso, e in caso di peso uguale
	 * per nome.
	 */
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> lista = new ArrayList<>();
		lista.addAll(this.nome_attrezzi.values());
		Collections.sort(lista, new ComparatoreAttrezziPerPeso());
		return lista;
	}
	
	/*
	 * Questo metodo ordina gli attrezzi per nome
	 */
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		return new TreeSet<Attrezzo>(this.nome_attrezzi.values());
	}
	
	/*
	 * Questo metodo raggruppa gli oggetti con lo stesso peso e li stampa come un gruppo
	 */
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer,Set<Attrezzo>> mappa = new TreeMap<>();
		Collection<Attrezzo> keys= this.nome_attrezzi.values();
		for(Attrezzo a: keys) {
			if(mappa.containsKey(a.getPeso())) {
				mappa.get(a.getPeso()).add(a);
			}
			else {
				Set<Attrezzo> att = new HashSet<>();
				mappa.put(a.getPeso(), att);
				att.add(a);
			}
		}
		
		return mappa;
		
	}


}
