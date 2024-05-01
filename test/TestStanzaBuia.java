import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class TestStanzaBuia {
	Stanza s1;
	Attrezzo a;
	
	@BeforeEach
	void setUp() throws Exception {
		s1 = new StanzaBuia("salone", "lampada");
		a = new Attrezzo("lampada", 2);
	    s1.addAttrezzo(a);
	}

	@Test
	void testGetDescrizione() {
		assertNotEquals(s1.getDescrizione(), "Qui c'è buio pesto");
	}

}
