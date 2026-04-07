package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class StanzaTest {
    private Stanza vuota;
    private Stanza conAttrezzo;
    private Attrezzo osso;

    @Before
    public void setUp() {
        vuota = new Stanza("Vuota");
        conAttrezzo = new Stanza("ConAttrezzo");
        osso = new Attrezzo("osso", 1);
        conAttrezzo.addAttrezzo(osso);
    }

    @Test
    public void testAddAttrezzo() {
        assertTrue(vuota.addAttrezzo(new Attrezzo("lanterna", 3)));
    }

    @Test
    public void testGetAttrezzoEsistente() {
        assertEquals(osso, conAttrezzo.getAttrezzo("osso"));
    }

    @Test
    public void testGetAttrezzoInesistente() {
        assertNull(vuota.getAttrezzo("osso"));
    }

    @Test
    public void testHasAttrezzoEsistente() {
        assertTrue(conAttrezzo.hasAttrezzo("osso"));
    }

    @Test
    public void testImpostaEGetStanzaAdiacente() {
        Stanza adiacente = new Stanza("Adiacente");
        vuota.impostaStanzaAdiacente("nord", adiacente);
        assertEquals(adiacente, vuota.getStanzaAdiacente("nord"));
    }
}