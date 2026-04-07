package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PartitaTest {
    private Partita partita;

    @Before
    public void setUp() {
        partita = new Partita();
    }

    @Test
    public void testIsFinitaCfuFiniti() {
        partita.getGiocatore().setCfu(0);
        assertTrue(partita.isFinita());
    }

    @Test
    public void testIsFinitaPartitaVinta() {
        partita.setStanzaCorrente(partita.getStanzaVincente());
        assertTrue(partita.isFinita());
    }

    @Test
    public void testVintaFalseInizio() {
        assertFalse(partita.vinta());
    }
}
