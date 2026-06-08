package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

public class Partita {
    private Labirinto labirinto;
    private Giocatore giocatore;
    private Stanza stanzaCorrente;
    private boolean finita;

    public Partita(Labirinto labirinto) {
        this.labirinto = labirinto;
        this.giocatore = new Giocatore();
        this.stanzaCorrente = labirinto.getStanzaIniziale();
        this.finita = false;
    }

    public Partita() {
        this.labirinto = Labirinto.newBuilder()
                .addStanzaIniziale("Atrio")
                .addStanzaVincente("Biblioteca")
                .addStanza("Aula N11")
                .addStanza("Laboratorio Campus")
                .addStanza("Aula N10")
                .addAttrezzo("lanterna", 3) 
                .addAdiacenza("Atrio", "Biblioteca", "nord")
                .addAdiacenza("Atrio", "Aula N11", "est")
                .addAdiacenza("Atrio", "Aula N10", "sud")
                .addAdiacenza("Atrio", "Laboratorio Campus", "ovest")
                .addAdiacenza("Aula N11", "Laboratorio Campus", "est")
                .addAdiacenza("Aula N11", "Atrio", "ovest")
                .addAdiacenza("Aula N10", "Atrio", "nord")
                .addAdiacenza("Aula N10", "Aula N11", "est")
                .addAdiacenza("Aula N10", "Laboratorio Campus", "ovest")
                .addAdiacenza("Laboratorio Campus", "Atrio", "est")
                .addAdiacenza("Laboratorio Campus", "Aula N11", "ovest")
                .addAdiacenza("Biblioteca", "Atrio", "sud")
                .getLabirinto();
        
        this.giocatore = new Giocatore();
        this.labirinto.getStanzaIniziale().addAttrezzo(new Attrezzo("osso", 1));
        this.stanzaCorrente = this.labirinto.getStanzaIniziale();
        this.finita = false;
    }

    public Stanza getStanzaCorrente() { return this.stanzaCorrente; }
    public void setStanzaCorrente(Stanza stanzaCorrente) { this.stanzaCorrente = stanzaCorrente; }
    public Stanza getStanzaVincente() { return this.labirinto.getStanzaVincente(); }
    public Giocatore getGiocatore() { return this.giocatore; }
    
    public boolean vinta() {
        return this.stanzaCorrente == this.labirinto.getStanzaVincente();
    }
    
    public boolean isFinita() {
        return finita || vinta() || (giocatore.getCfu() == 0);
    }
    
    public void setFinita() { this.finita = true; }
}
