/**
 * 
 */
package it.uniroma3.diadia.giocatore;

/**
 * Giocatore: classe che si occupa di gestire il giocatore e creare la borsa
 * 
 * @author docente di POO 590871 
 * 
 * @see Borsa
 * 
 * @version 1.0
 */
public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa;
	
	/**
	 * Metodo che imposta i cfu e crea la borsa
	 */
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
	public void setBorsa(Borsa borsa) {
		this.borsa=borsa;
	}
	
	public Borsa getBorsa() {
		return borsa;
	}
}
