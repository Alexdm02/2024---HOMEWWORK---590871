import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;

class TestComandoPrendi {
	Labirinto l;
	Partita p;
	ComandoPrendi c;
	Attrezzo a;
	IO io;

	@BeforeEach
	void setUp() throws Exception {
		l = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.addAdiacenza("Biblioteca", "Atrio", "sud")
				.getLabirinto();
		p = new Partita(l);
		io = new IOConsole();
		c = new ComandoPrendi();
		a = new Attrezzo("Martello", 4);
		p.getLabirinto().getStanzaCorrente().addAttrezzo(a);
		c.setIO(io);
	}

	@Test
	void testEsegui() {
		c.setParametro(a.getNome());
		c.esegui(p);
		assertTrue(p.getGiocatore().getBorsa().hasAttrezzo(a.getNome()));
	}

}
