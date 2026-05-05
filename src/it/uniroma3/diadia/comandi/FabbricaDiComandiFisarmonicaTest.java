package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonicaTest {
    private FabbricaDiComandiFisarmonica factory;
    private IO io;

    @Before
    public void setUp() {
        io = new IOConsole();
        factory = new FabbricaDiComandiFisarmonica(io);
    }

    @Test
    public void testComandoVai() {
        Comando comando = factory.costruisciComando("vai nord");
        assertEquals("vai", comando.getNome());
        assertEquals("nord", comando.getParametro());
    }

    @Test
    public void testComandoPrendi() {
        Comando comando = factory.costruisciComando("prendi osso");
        assertEquals("prendi", comando.getNome());
        assertEquals("osso", comando.getParametro());
    }

    @Test
    public void testComandoNonValido() {
        Comando comando = factory.costruisciComando("vola in_alto");
        assertEquals("non valido", comando.getNome());
    }
}
