import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;

class TetsaComandoVai {
	Partita p;
	Stanza s1;
	Stanza s2;
	ComandoVai c;
	ComandoVai vuoto;
	IO io;
	

	@BeforeEach
	void setUp() throws Exception {
		p = new Partita();
		s1 = new Stanza("bagno");
		s2 = new Stanza("salone");
		c = new ComandoVai();	
		vuoto = new ComandoVai();
		io = new IOConsole();
		c.setParametro("nord");
		c.setIO(io);
		vuoto.setIO(io);
		
		
	}

	@Test
	void testEseguiNullo() {
		p.getLabirinto().setStanzaCorrente(s1);
		vuoto.esegui(p);
		assertEquals(s1, p.getLabirinto().getStanzaCorrente());
	}
	@Test
	void testEseguiNord() {
		p.getLabirinto().setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("nord", s2);
		c.esegui(p);
		assertEquals(s2, p.getLabirinto().getStanzaCorrente());
	}

}
