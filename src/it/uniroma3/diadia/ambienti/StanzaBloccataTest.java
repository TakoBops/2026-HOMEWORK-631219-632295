package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
    private StanzaBloccata stanzaBloccata;
    private Stanza stanzaAdiacente;
    private Attrezzo chiave;

    @Before
    public void setUp() {
        stanzaBloccata = new StanzaBloccata("Prigione", "nord", "chiave");
        stanzaAdiacente = new Stanza("Uscita");
        stanzaBloccata.impostaStanzaAdiacente("nord", stanzaAdiacente);
        chiave = new Attrezzo("chiave", 1);
    }

    @Test
    public void testGetStanzaAdiacenteBloccataSenzaAttrezzo() {
        // Se non ho la chiave e vado a nord, resto nella stanza bloccata
        assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente("nord"));
    }

    @Test
    public void testGetStanzaAdiacenteSbloccataConAttrezzo() {
        // Se ho la chiave e vado a nord, passo alla stanza adiacente
        stanzaBloccata.addAttrezzo(chiave);
        assertEquals(stanzaAdiacente, stanzaBloccata.getStanzaAdiacente("nord"));
    }
}
