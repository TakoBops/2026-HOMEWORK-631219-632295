package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	private Stanza stanzaVuota;
	private Stanza stanzaConAttrezzo;
	private Attrezzo osso;
	private Attrezzo lanterna;

	@Before
	public void setUp() {
		this.stanzaVuota = new Stanza("Stanza Vuota");
		this.stanzaConAttrezzo = new Stanza("Stanza Con Attrezzo");
		
		this.osso = new Attrezzo("osso", 1);
		this.lanterna = new Attrezzo("lanterna", 3);
		
		this.stanzaConAttrezzo.addAttrezzo(this.lanterna);
	}

	// --- ATTREZZI ---

	@Test
	public void testAddAttrezzo() {
		assertTrue(this.stanzaVuota.addAttrezzo(this.osso));
		assertTrue(this.stanzaVuota.hasAttrezzo("osso"));
	}

	@Test
	public void testHasAttrezzo_Trovato() {
		assertTrue(this.stanzaConAttrezzo.hasAttrezzo("lanterna"));
	}

	@Test
	public void testHasAttrezzo_NonTrovato() {
		assertFalse(this.stanzaVuota.hasAttrezzo("lanterna"));
	}

	@Test
	public void testGetAttrezzo_Trovato() {
		assertEquals(this.lanterna, this.stanzaConAttrezzo.getAttrezzo("lanterna"));
	}

	@Test
	public void testGetAttrezzo_NonTrovato() {
		assertNull(this.stanzaVuota.getAttrezzo("lanterna"));
	}

	@Test
	public void testRemoveAttrezzo_Presente() {
		assertTrue(this.stanzaConAttrezzo.removeAttrezzo(this.lanterna));
		assertFalse(this.stanzaConAttrezzo.hasAttrezzo("lanterna"));
	}

	@Test
	public void testRemoveAttrezzo_NonPresente() {
		assertFalse(this.stanzaVuota.removeAttrezzo(this.osso));
	}
	
	@Test
	public void testRemoveAttrezzo_Null() {
		assertFalse(this.stanzaConAttrezzo.removeAttrezzo(null));
	}

	// --- DIREZIONI ---
	
	@Test
	public void testImpostaStanzaAdiacente() {
		this.stanzaVuota.impostaStanzaAdiacente("nord", this.stanzaConAttrezzo);
		assertEquals(this.stanzaConAttrezzo, this.stanzaVuota.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacente_DirezioneSbagliata() {
		this.stanzaVuota.impostaStanzaAdiacente("sud", this.stanzaConAttrezzo);
		assertNull(this.stanzaVuota.getStanzaAdiacente("nord"));
	}
}