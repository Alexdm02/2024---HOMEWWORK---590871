import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.AbstractComando;

public class FakeComando extends AbstractComando{
	
	private static final String NOME = "FakeComando";
	public final static String MESSAGGIO_FINE = "Grazie di aver giocato!";

	@Override
	public void esegui(Partita partita) {
		partita.setFinita();	
	}
	
	@Override
	public String getNome() {
		return NOME;
	}
	

}
