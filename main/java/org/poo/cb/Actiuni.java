package org.poo.cb;

public class Actiuni {
	private final String numeCompanie;
	private int numarActiuni;

	public Actiuni(String numeCompanie, int numarActiuni) {
		this.numeCompanie = numeCompanie;
		this.numarActiuni = numarActiuni;
	}

	public String getNumeCompanie() {
		return numeCompanie;
	}

	public int getNumarActiuni() {
		return numarActiuni;
	}

	public void setNumarActiuni(int numarActiuni) {
		this.numarActiuni = numarActiuni;
	}

	public void adaugaActiuni(int numarActiuni) {
		this.numarActiuni += numarActiuni;
	}
}
