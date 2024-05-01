package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
/*
import java.util.Scanner;
*/
import it.uniroma3.diadia.Partita;

public interface Comando {
	public void esegui(Partita partita);
	
	public void setParametro(String paramentro);
	
	public String getNome();
	
	public String getParametro();
	
	public void setIO(IO io);
}