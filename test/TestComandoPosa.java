import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.giocatore.Borsa;

class TestComandoPosa {
	Partita p;
	ComandoPosa c;
	Attrezzo a;
	Borsa b;
	IO io;
	

	@BeforeEach
	void setUp() throws Exception {
		p = new Partita();
		b = new Borsa();
		io = new IOConsole();
		c = new ComandoPosa();
		a = new Attrezzo("lampada", 2);
		p.getGiocatore().getBorsa().addAttrezzo(a);
		c.setIO(io);
	}

	@Test
	void testEsegui() {
		c.setParametro(a.getNome());
		c.esegui(p);
		assertFalse(p.getGiocatore().getBorsa().hasAttrezzo(a.getNome()));
		
	}

}
