package org.poo.cb;

import java.util.ArrayList;

public class User {
	private final String email;
	private final String nume;
	private final String prenume;
	private final String adresa;
	private final ArrayList<String> listaPrieteni;
	private final ArrayList<Cont> listaConturi;
	private final ArrayList<Actiuni> listaActiuni;

	private User(UserBuilder builder) {
		this.email = builder.email;
		this.nume = builder.nume;
		this.prenume = builder.prenume;
		this.adresa = builder.adresa;
		this.listaPrieteni = builder.listaPrieteni;
		this.listaConturi = builder.listaConturi;
		this.listaActiuni = builder.listaActiuni;
	}

	public String getEmail() {
		return email;
	}

	public String getNume() {
		return nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public String getAdresa() {
		return adresa;
	}

	public ArrayList<String> getListaPrieteni() {
		return listaPrieteni;
	}

	public ArrayList<Cont> getListaConturi() {
		return listaConturi;
	}

	public ArrayList<Actiuni> getListaActiuni() {
		return listaActiuni;
	}

	public static class UserBuilder {
		private final String email;
		private String nume;
		private String prenume;
		private String adresa;
		private ArrayList<String> listaPrieteni;
		private ArrayList<Cont> listaConturi;
		private ArrayList<Actiuni> listaActiuni;

		public UserBuilder(String email) {
			this.email = email;
		}

		public UserBuilder setNume(String nume) {
			this.nume = nume;
			return this;
		}

		public UserBuilder setPrenume(String prenume) {
			this.prenume = prenume;
			return this;
		}

		public UserBuilder setAdresa(String adresa) {
			this.adresa = adresa;
			return this;
		}

		public UserBuilder setListaPrieteni(ArrayList<String> listaPrieteni) {
			this.listaPrieteni = listaPrieteni;
			return this;
		}

		public UserBuilder setListaConturi(ArrayList<Cont> listaConturi) {
			this.listaConturi = listaConturi;
			return this;
		}

		public UserBuilder setListaActiuni(ArrayList<Actiuni> listaActiuni) {
			this.listaActiuni = listaActiuni;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}
}
