package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	private Labirinto labirinto;
	private Map<String, Stanza> nome2stanza;
	private Stanza ultimaStanzaAggiunta;

	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.nome2stanza = new HashMap<>();
	}

	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
		Stanza s = new Stanza(nomeStanza);
		this.labirinto.setStanzaIniziale(s);
		this.aggiungiStanzaValida(s);
		return this;
	}

	public LabirintoBuilder addStanzaVincente(String nomeStanza) {
		Stanza s = new Stanza(nomeStanza);
		this.labirinto.setStanzaVincente(s);
		this.aggiungiStanzaValida(s);
		return this;
	}

	public LabirintoBuilder addStanza(String nomeStanza) {
		Stanza s = new Stanza(nomeStanza);
		this.aggiungiStanzaValida(s);
		return this;
	}

	public LabirintoBuilder addAttrezzo(String nome, int peso) {
		if (this.ultimaStanzaAggiunta != null) {
			this.ultimaStanzaAggiunta.addAttrezzo(new Attrezzo(nome, peso));
		}
		return this;
	}

	public LabirintoBuilder addAdiacenza(String stanzaPartenza, String stanzaArrivo, String direzione) {
		Stanza s1 = this.nome2stanza.get(stanzaPartenza);
		Stanza s2 = this.nome2stanza.get(stanzaArrivo);
		if (s1 != null && s2 != null) {
			s1.impostaStanzaAdiacente(direzione, s2);
		}
		return this;
	}

	public Labirinto getLabirinto() {
		return this.labirinto;
	}

	private void aggiungiStanzaValida(Stanza stanza) {
		this.ultimaStanzaAggiunta = stanza;
		this.nome2stanza.put(stanza.getNome(), stanza);
	}
}
