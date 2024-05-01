import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoAiuto;
import it.uniroma3.diadia.comandi.ComandoFine;
import it.uniroma3.diadia.comandi.ComandoGuarda;
import it.uniroma3.diadia.comandi.ComandoNonValido;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

class TestFabbricaDiComandiFisarmonica {
	
	FabbricaDiComandi f;
	Comando comando;
	IO io;

	@BeforeEach
	void setUp() throws Exception {
		io = new IOConsole();
		f = new FabbricaDiComandiFisarmonica(io);	
	}

	@Test
	void testCostruisciComandoAiuto() {
		comando=f.costruisciComando("aiuto");
		assertEquals(new ComandoAiuto().getNome(), comando.getNome());
	}
	@Test
	void testCostruisciComandoVai() {
		comando=f.costruisciComando("vai");
		assertEquals(new ComandoVai().getNome(), comando.getNome());
	}
	@Test
	void testCostruisciComandoPrendi() {
		comando=f.costruisciComando("prendi");
		assertEquals(new ComandoPrendi().getNome(), comando.getNome());
	}
	@Test
	void testCostruisciComandoPosa() {
		comando=f.costruisciComando("posa");
		assertEquals(new ComandoPosa().getNome(), comando.getNome());
	}
	@Test
	void testCostruisciComandoNonValido() {
		comando=f.costruisciComando("non valido");
		assertEquals(new ComandoNonValido().getNome(), comando.getNome());
	}
	@Test
	void testCostruisciComandoGuarda() {
		comando=f.costruisciComando("guarda");
		assertEquals(new ComandoGuarda().getNome(), comando.getNome());
	}
	@Test
	void testCostruisciComandoFine() {
		comando=f.costruisciComando("fine");
		assertEquals(new ComandoFine().getNome(), comando.getNome());
	}

}
