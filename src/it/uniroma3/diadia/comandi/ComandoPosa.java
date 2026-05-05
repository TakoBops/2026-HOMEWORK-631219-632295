package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;

public class ComandoPosa implements Comando {
    private String nomeAttrezzo;
    private IO io;

    @Override
    public void esegui(Partita partita) {
        if (nomeAttrezzo == null) {
            this.io.mostraMessaggio("Cosa vuoi posare?");
            return;
        }
        Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
        if (attrezzo != null) {
            partita.getStanzaCorrente().addAttrezzo(attrezzo);
            partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
            this.io.mostraMessaggio("Hai posato: " + nomeAttrezzo);
        } else {
            this.io.mostraMessaggio("Attrezzo non presente nella borsa.");
        }
    }

    @Override
    public void setParametro(String parametro) {
        this.nomeAttrezzo = parametro;
    }

    @Override
    public String getNome() {
        return "posa";
    }

    @Override
    public String getParametro() {
        return this.nomeAttrezzo;
    }

    @Override
    public void setIo(IO io) {
        this.io = io;
    }
}
