import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.giocatore.Borsa;

class TestStanzaBloccata {
	Stanza s1;
	Stanza s2;
	Attrezzo a;
	String nomeAttrezzo;
	

	@BeforeEach
	void setUp() throws Exception {
		s1 = new StanzaBloccata("salone","nord", "chiave");
		s2 = new Stanza("bagno");
		a = new Attrezzo("chiave", 2);
		s1.impostaStanzaAdiacente("nord", s2);
		s1.addAttrezzo(a);
		nomeAttrezzo = new String("chiave");
		
	}

	@Test
	void testGetStanzaAdiacenteSiAttrezzo() {
		assertEquals(s1.getStanzaAdiacente("nord"), s2);
	}
	
	@Test
	void testGetStanzaAdiacenteNoAttrezzo() {
		s1.removeAttrezzo(a);
		assertEquals(s1.getStanzaAdiacente("nord"), s1);
	}

	@Test
	void testGetDescrizioneSiAttrezzo() {
		assertEquals(s1.getDescrizione(), s1.toString());
	}
	
	@Test
	void testGetDescrizioneNoAttrezzo() {
		s1.removeAttrezzo(a);
		assertEquals(s1.getDescrizione(), "la stanza è bloccata devi aggiungere l'attrezzo:" +nomeAttrezzo);
	}

}
