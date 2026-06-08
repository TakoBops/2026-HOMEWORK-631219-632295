package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

public class IOSimulator implements IO {
    private List<String> righeDaLeggere;
    private int indiceRighe;
    private List<String> messaggiProdotti;

    public IOSimulator(List<String> righeDaLeggere) {
        this.righeDaLeggere = righeDaLeggere;
        this.indiceRighe = 0;
        this.messaggiProdotti = new ArrayList<>();
    }

    @Override
    public String leggiRiga() {
        if (this.indiceRighe < this.righeDaLeggere.size()) {
            String riga = this.righeDaLeggere.get(this.indiceRighe);
            this.indiceRighe++;
            return riga;
        } else {
            return null; // Nessun altro comando da leggere
        }
    }

    @Override
    public void mostraMessaggio(String messaggio) {
        this.messaggiProdotti.add(messaggio);
    }

    public List<String> getMessaggiProdotti() {
        return this.messaggiProdotti;
    }
}
