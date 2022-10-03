package de.hs_mannheim.informatik.bank.domain;

import java.util.Collection;
import java.util.HashMap;

public class Bank {
	private String name;
	private HashMap<Integer, Konto> konten = new HashMap<>();
	
	public Bank(String name) {
		this.name = name;
	}
	
	public void addKonto(Konto k) {
		konten.put(k.getKontonummer(), k);
	}
	
	public String getName() {
		return name;
	}
	
	public Collection<Konto> getKontenliste() {
		return konten.values();
	}
	
}
