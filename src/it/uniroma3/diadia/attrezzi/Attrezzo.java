package it.uniroma3.diadia.attrezzi;

import it.uniroma3.diadia.ambienti.Stanza;
import java.util.Objects; // Necessario per l'hashCode

/**
 * Una semplice classe che modella un attrezzo.
 * Gli attrezzi possono trovarsi all'interno delle stanze
 * del labirinto.
 * Ogni attrezzo ha un nome ed un peso.
 *
 * @author  docente di POO
 * @see Stanza
 * @version homework C
 */
public class Attrezzo implements Comparable<Attrezzo> {

	private String nome;
	private int peso;

	/**
	 * Crea un attrezzo
	 * @param nome il nome che identifica l'attrezzo
	 * @param peso il peso dell'attrezzo
	 */
	public Attrezzo(String nome, int peso) {
		this.peso = peso;
		this.nome = nome;
	}

	/**
	 * Restituisce il nome identificatore dell'attrezzo
	 * @return il nome identificatore dell'attrezzo
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce il peso dell'attrezzo
	 * @return il peso dell'attrezzo
	 */
	public int getPeso() {
		return this.peso;
	}

	/**
	 * Restituisce una rappresentazione stringa di questo attrezzo
	 * @return la rappresentazione stringa
	 */
	@Override
	public String toString() {
		return this.getNome()+" ("+this.getPeso()+"kg)";
	}

	// =========================================================
	// METODI AGGIUNTI PER L'HOMEWORK C (COLLECTIONS & SORTING)
	// =========================================================

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Attrezzo attrezzo = (Attrezzo) o;
		return this.getPeso() == attrezzo.getPeso() && this.getNome().equals(attrezzo.getNome());
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, peso);
	}

	@Override
	public int compareTo(Attrezzo a) {
		// Ordinamento alfabetico di default per gli attrezzi
		return this.getNome().compareTo(a.getNome());
	}
}
