public Partita(Labirinto labirinto) {
    this.labirinto = labirinto;
    this.giocatore = new Giocatore();
    this.finita = false;
}

// METODO UTILE PER GIOCARE NORMALMENTE SENZA PASSARE IL LABIRINTO (usa il labirinto di default di DiaDia)
public Partita() {
    this.labirinto = Labirinto.newBuilder()
            .addStanzaIniziale("Atrio")
            .addStanzaVincente("Biblioteca")
            .addStanza("Aula N11")
            .addStanza("Laboratorio Campus")
            .addStanza("Aula N10")
            .addAttrezzo("osso", 1) // Aggiunge all'ultima stanza (Aula N10)
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
    // Aggiungi subito l'attrezzo iniziale (lanterna) nella stanza di partenza
    this.labirinto.getStanzaIniziale().addAttrezzo(new Attrezzo("lanterna", 3));
}
