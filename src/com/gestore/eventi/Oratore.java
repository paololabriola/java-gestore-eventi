package com.gestore.eventi;

public class Oratore {
	//ATTRIBUTI della classe Oratore.
	String nome, cognome, titolo;
	//COSTRUTTORE della classe Oratore.
	public Oratore(String nome, String cognome, String titolo) throws NullPointerException {
		
		super();
		
		validaStringa(nome);
		validaStringa(cognome);
		validaStringa(titolo);
		
		this.nome = nome;
		this.cognome = cognome;
		this.titolo = titolo;
		
	}
	//GETTERS & SETTERS della classe Oratore.
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		validaStringa(nome);
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		validaStringa(cognome);
		this.cognome = cognome;
	}


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		validaStringa(titolo);
		this.titolo = titolo;
	}
	//Metodo di controllo in caso di stringa vuota.
	private void validaStringa(String stringa) throws NullPointerException{
		
		if(stringa.isBlank() || stringa==null)
			throw new NullPointerException("La stringa deve avere un valore.");
		
	}
	//Metodo di stampa di nome e cognome dell'Oratore.
	public String stampaNomeCognome() {
		
		return nome + " " + cognome;
		
	}

}
