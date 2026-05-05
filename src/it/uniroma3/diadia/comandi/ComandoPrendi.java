package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;

public class ComandoPrendi implements Comando {
    private String nomeAttrezzo;
    private IO io;

    @Override
    public void esegui(Partita partita) {
        if (nomeAttrezzo == null) {
            this.io.mostraMessaggio("Cosa vuoi prendere?");
            return;
        }
        Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
        if (attrezzo != null) {
            partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
            partita.getStanzaCorrente().removeAttrezzo(attrezzo);
            this.io.mostraMessaggio("Hai preso: " + nomeAttrezzo);
        } else {
            this.io.mostraMessaggio("Attrezzo non presente nella stanza.");
        }
    }

    @Override
    public void setParametro(String parametro) {
        this.nomeAttrezzo = parametro;
    }

    @Override
    public String getNome() {
        return "prendi";
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
