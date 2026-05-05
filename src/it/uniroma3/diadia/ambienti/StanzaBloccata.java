package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
    private String direzioneBloccata;
    private String attrezzoSbloccante;

    public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
        super(nome);
        this.direzioneBloccata = direzioneBloccata;
        this.attrezzoSbloccante = attrezzoSbloccante;
    }

    @Override
    public Stanza getStanzaAdiacente(String dir) {
        if (dir.equals(direzioneBloccata) && !this.hasAttrezzo(attrezzoSbloccante)) {
            return this; // Ritorna se stessa se è bloccata e manca l'attrezzo
        }
        return super.getStanzaAdiacente(dir);
    }

    @Override
    public String getDescrizione() {
        return super.getDescrizione() + "\nDirezione bloccata: " + direzioneBloccata;
    }
}
