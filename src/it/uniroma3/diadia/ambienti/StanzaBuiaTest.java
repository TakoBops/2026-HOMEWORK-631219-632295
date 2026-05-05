package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
    private StanzaBuia stanzaBuia;
    private Attrezzo lanterna;

    @Before
    public void setUp() {
        stanzaBuia = new StanzaBuia("Cantina", "lanterna");
        lanterna = new Attrezzo("lanterna", 1);
    }

    @Test
    public void testGetDescrizioneSenzaAttrezzo() {
        assertEquals("qui c'è un buio pesto", stanzaBuia.getDescrizione());
    }

    @Test
    public void testGetDescrizioneConAttrezzo() {
        stanzaBuia.addAttrezzo(lanterna);
        assertNotEquals("qui c'è un buio pesto", stanzaBuia.getDescrizione());
    }
}
