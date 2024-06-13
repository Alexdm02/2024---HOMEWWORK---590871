import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;


class AbstractComandoTest {
	
	FakeComando cc;
	Partita p;
	
	@Before
	public void setUp() throws Exception {
		cc = new FakeComando();
		p = new Partita(Labirinto.newBuilder("labirinto.txt").getLabirinto());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConcreteComandoGetNome() {
		 assertNotEquals("AbstractComando", cc.getNome());
		 assertEquals("ConcreteComando", cc.getNome());
	}
	
	@Test
	public void testConcreteComandoEsegui() {
		cc.esegui(p);
		 assertTrue(p.isFinita());
	}

	@Test
	public void testConcreteComandoGetIO() {
		cc.setIO(new IOConsole(new Scanner(System.in)));
		 assertNotNull(cc.getIO());
	}
	
	@Test
	public void testConcreteComandoParametro() {
		cc.setParametro("pippo");
		 assertNotNull(cc.getParametro());
	}

}
