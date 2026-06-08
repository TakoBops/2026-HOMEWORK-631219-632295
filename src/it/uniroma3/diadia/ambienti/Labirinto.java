package it.uniroma3.diadia.ambienti;

public class Labirinto {
	
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;

	/**
	 * Costruttore vuoto. 
	 * Ora la creazione delle stanze è delegata al LabirintoBuilder!
	 */
	public Labirinto() {
		// Niente più creaStanze() qui dentro!
	}

	/**
	 * Metodo statico per richiamare comodamente il costruttore (Builder)
	 */
	public static LabirintoBuilder newBuilder() {
		return new LabirintoBuilder();
	}

	public Stanza getStanzaIniziale() {
		return stanzaIniziale;
	}

	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale;
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}
}
