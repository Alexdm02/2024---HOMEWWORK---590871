import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class TestLabirintoBuilder {
	LabirintoBuilder l;
	
	@BeforeEach
	void setUp() throws Exception {
		l = new LabirintoBuilder();
	}

	@Test
	void testGetLabirinto() {
		assertNotNull(l.getLabirinto());
	}

	@Test
	void testAddStanzaIniziale() {
		l.addStanzaIniziale("Salotto");
		assertEquals(l.getLabirinto().getStanzaCorrente(), l.getnomeStanza().get("Salotto"));
	}

	@Test
	void testAddStanzaVincente() {
		l.addStanzaVincente("Salotto");
		assertEquals(l.getLabirinto().getStanzaVincente(), l.getnomeStanza().get("Salotto"));
	}

	@Test
	void testAddAttrezzo() {
		l.addAttrezzo("trapano", 2);
		l.addStanzaIniziale("Salotto");
		assertEquals(l.getLabirinto().getStanzaCorrente().getAttrezzo("trapano"), l.getnomeStanza().get("Salotto").getAttrezzo("trapano"));                                            
	}

	@Test
	void testAddAdiacenza() {
		l.getnomeStanza().put("Salotto", new Stanza("Salotto"));
		l.getnomeStanza().put("Cucina", new Stanza("Cucina"));
		l.addStanzaIniziale("Salone");
		l.addAdiacenza("Salone", "Cucina", "Nord");
		assertEquals(l.getLabirinto().getStanzaCorrente().getStanzaAdiacente("Nord"), l.getnomeStanza().get("Cucina"));
	}

	@Test
	void testAddStanzaMagica() {
		l.addStanzaMagica("Cucina");
		l.addStanzaIniziale("Salone");
		l.addAdiacenza("Salone", "Cucina", "Nord");
		
		assertEquals(l.getLabirinto().getStanzaCorrente().getStanzaAdiacente("Nord"), l.getnomeStanza().get("Cucina"));
	}

	@Test
	void testAddStanzaBuia() {
		l.addStanzaBuia("Cucina", "torcia");
		l.addStanzaIniziale("Salone");
		l.addAdiacenza("Salone", "Cucina", "Nord");
		
		assertEquals(l.getLabirinto().getStanzaCorrente().getStanzaAdiacente("Nord"), l.getnomeStanza().get("Cucina"));
	}

	@Test
	void testAddStanzaBloccata() {
		l.addStanzaBloccata("Cucina", "Sud", "trapano");
		l.addStanzaIniziale("Salone");
		l.addAdiacenza("Salone", "Cucina", "Nord");
		
		assertEquals(l.getLabirinto().getStanzaCorrente().getStanzaAdiacente("Nord"), l.getnomeStanza().get("Cucina"));
	}

}
