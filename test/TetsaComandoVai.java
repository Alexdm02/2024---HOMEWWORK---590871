import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoFine;
import it.uniroma3.diadia.comandi.ComandoVai;



class TetsaComandoVai {
	Partita p;
	Stanza s1;
	Stanza s2;
	ComandoVai c;
	ComandoVai vuoto;
	IO io;
	Labirinto l;
	List<String> righeDaLeggere;
	List<String> righeDaLeggere2;
	

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
	

	@Test
	public void testPartitaConComandoVai() {
		righeDaLeggere.add("vai nord");

		IOSimulator io = Fixture.creaSimulazionePartitaEGiocaEasy(righeDaLeggere);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Biblioteca", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Hai vinto!", io.nextMessaggio());
		
	}
	
	@Test
	public void testPartitaConComandoVaiOvest() {
		righeDaLeggere2.add("vai ovest");
		righeDaLeggere2.add("fine");

		IOSimulator io = Fixture.creaSimulazionePartitaEGiocaHard(righeDaLeggere2);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Studio", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
	}
}
