package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;
import java.util.Arrays;
import java.util.List;

public class ComandoAiuto implements Comando {
    // Sostituito l'array con una List
    static final private List<String> elencoComandi = Arrays.asList("vai", "prendi", "posa", "guarda", "aiuto", "fine");
    private IO io;

    @Override
    public void esegui(Partita partita) {
        for (String comando : elencoComandi) {
            this.io.mostraMessaggio(comando + " ");
        }
    }

    @Override
    public void setParametro(String parametro) {}

    @Override
    public String getNome() {
        return "aiuto";
    }

    @Override
    public String getParametro() {
        return null;
    }

    @Override
    public void setIo(IO io) {
        this.io = io;
    }
}
