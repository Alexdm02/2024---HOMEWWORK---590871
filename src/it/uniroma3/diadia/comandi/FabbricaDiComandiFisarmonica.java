package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;
/**
* Nome-classe: FabbricaDiComandiFisarmonica
* in questa classe vengono creati tutti i comandi che il giocatore può eseguire nel gioco
*
* @author 590871 
* @version 1.0
*/
public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi{
	
	private IO io;
	
	public FabbricaDiComandiFisarmonica(IO console) {
		this.io = console;
	}
	
	@Override
	public Comando costruisciComando(String istruzione) {
		Scanner scannerDiParole = new Scanner (istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
	
	
	if (scannerDiParole.hasNext())
		nomeComando = scannerDiParole.next();
	if (scannerDiParole.hasNext())
		parametro = scannerDiParole.next();
	
	
	if (nomeComando == null)
		comando = new ComandoNonValido();
	else if (nomeComando.equals("vai"))
		comando = new ComandoVai();
	else if (nomeComando.equals("prendi"))
		comando = new ComandoPrendi();
	else if (nomeComando.equals("posa"))
		comando = new ComandoPosa();
	else if (nomeComando.equals("aiuto"))
		comando = new ComandoAiuto();
	else if (nomeComando.equals("fine"))
		comando = new ComandoFine();
	else if (nomeComando.equals("guarda"))
		comando = new ComandoGuarda();
	else comando = new ComandoNonValido();
		comando.setParametro(parametro);
		comando.setIO(io);
	return comando;
	
	
		}
}


