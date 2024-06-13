import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {
	Borsa b= new Borsa();
	Attrezzo torcia;
	Attrezzo manubrio;
	Attrezzo libro;
	

	@BeforeEach
	void setUp() throws Exception {
		b = new Borsa(50);
		torcia=new Attrezzo("torcia", 2);
		manubrio=new Attrezzo("manubrio", 2);
		libro=new Attrezzo("libro", 4);
	}
	
	@Test
	void testgetContenutoRaggruppatoPerPeso() {
		b.addAttrezzo(torcia);
		b.addAttrezzo(libro);
		b.addAttrezzo(manubrio);
		Map<Integer, Set<Attrezzo>> mappa = b.getContenutoRaggruppatoPerPeso();
		assertNotEquals(mappa, b.getAttrezzi());
		
	}
	
	@Test
	void testSortedSetOrdinaPerPeso(){
		b.addAttrezzo(torcia);
		b.addAttrezzo(libro);
		b.addAttrezzo(manubrio);
		Collection<Attrezzo> tree = b.getSortedSetOrdinatoPerPeso();
		assertNotEquals(tree, b.getAttrezzi());
	}
	
	@Test
	void testOrdinaPerNome() {
		b.addAttrezzo(torcia);
		b.addAttrezzo(libro);
		b.addAttrezzo(manubrio);
		Collection<Attrezzo> tree = b.getContenutoOrdinatoPerNome();
		assertNotEquals(tree, b.getAttrezzi());
	}
	
	@Test
	void testOrdina() {
		b.addAttrezzo(torcia);
		b.addAttrezzo(libro);
		b.addAttrezzo(manubrio);
		Collection<Attrezzo>lista =b.getContenutoOrdinatoPerPeso();
		assertNotEquals(lista, b.getAttrezzi());
	}

	@Test
	void testAddAttrezzoMinoreDiDieci() {
		assertTrue(b.addAttrezzo(torcia));
	}
	
	@Test
	void testAddAttrezzoMaggioreDiDieci() {
		assertFalse(b.addAttrezzo(manubrio));
	}

	@Test
	void testGetPeso() {
		b.addAttrezzo(torcia);
		assertEquals(torcia.getPeso(), b.getPeso());
	}

	@Test
	void testGetAttrezzo() {
		b.addAttrezzo(torcia);
		assertEquals(torcia, b.getAttrezzo("torcia"));
	}
	
	@Test
	void testRemoveAttrezzo() {
		b.addAttrezzo(torcia);
		b.addAttrezzo(libro);
		assertNotNull(b.removeAttrezzo("libro"));
	}

}
