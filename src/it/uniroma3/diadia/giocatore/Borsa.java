package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int pesoMax;

	public Borsa() { this(DEFAULT_PESO_MAX_BORSA); }

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<>();
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax()) return false;
		return this.attrezzi.add(attrezzo);
	}

	public int getPesoMax() { return pesoMax; }
	public boolean isEmpty() { return this.attrezzi.isEmpty(); }

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		for (Attrezzo a : this.attrezzi) {
			if (a.getNome().equals(nomeAttrezzo)) return a;
		}
		return null;
	}

	public int getPeso() {
		int peso = 0;
		for (Attrezzo a : this.attrezzi) peso += a.getPeso();
		return peso;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = getAttrezzo(nomeAttrezzo);
		if (a != null) this.attrezzi.remove(a);
		return a;
	}

	public String toString() {
		if (!this.isEmpty()) return "Borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): " + this.attrezzi.toString();
		else return "Borsa vuota";
	}

	// 1. Ordinato per Peso
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> risultato = new ArrayList<>(this.attrezzi);
		Collections.sort(risultato, new Comparator<Attrezzo>() {
			@Override
			public int compare(Attrezzo a1, Attrezzo a2) {
				if (a1.getPeso() - a2.getPeso() == 0) return a1.getNome().compareTo(a2.getNome());
				return a1.getPeso() - a2.getPeso();
			}
		});
		return risultato;
	}

	// 2. Ordinato per Nome
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		return new TreeSet<>(this.attrezzi);
	}

	// 3. Raggruppato per Peso
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Map<Integer, Set<Attrezzo>> risultato = new HashMap<>();
		for (Attrezzo a : this.attrezzi) {
			if (!risultato.containsKey(a.getPeso())) risultato.put(a.getPeso(), new HashSet<>());
			risultato.get(a.getPeso()).add(a);
		}
		return risultato;
	}

	// 4. SortedSet per Peso
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		SortedSet<Attrezzo> risultato = new TreeSet<>(new Comparator<Attrezzo>() {
			@Override
			public int compare(Attrezzo a1, Attrezzo a2) {
				if (a1.getPeso() - a2.getPeso() == 0) return a1.getNome().compareTo(a2.getNome());
				return a1.getPeso() - a2.getPeso();
			}
		});
		risultato.addAll(this.attrezzi);
		return risultato;
	}
}
