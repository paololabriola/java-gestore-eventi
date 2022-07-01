package com.gestore.eventi;

import java.time.LocalDate;

public class Conferenza extends Evento {
	//ATTRIBUTI della classe Conferenza.
	private String argomentoDellaConferenza;
	Oratore oratoreDellaConferenza;
	//COSTRUTTORE della classe Conferenza.
	public Conferenza(String titoloEvento, LocalDate dataEvento, int postiTotali, String argomentoDellaConferenza, Oratore oratoreDellaConferenza)
	throws NullPointerException, IllegalArgumentException {
		super(titoloEvento, dataEvento, postiTotali);
		
		validaStringa(argomentoDellaConferenza);
		
		this.argomentoDellaConferenza = argomentoDellaConferenza;
		this.oratoreDellaConferenza = new Oratore (oratoreDellaConferenza.getNome(), oratoreDellaConferenza.getCognome(), oratoreDellaConferenza.getTitolo());
		
	}
	//GETTERS & SETTERS della classe Conferenza.
	public String getArgomentoDellaConferenza() {
		return argomentoDellaConferenza;
	}
	
	public void setArgomentoDellaConferenza(String argomentoDellaConferenza) {
		validaStringa(argomentoDellaConferenza);
		this.argomentoDellaConferenza = argomentoDellaConferenza;
	}
	//Metodo di controllo della stringa in caso di valore nullo.
	private void validaStringa(String stringa) throws NullPointerException {
		
	    if (stringa.isBlank() || stringa==null) 
	      throw new NullPointerException("La stringa deve avere un valore.");
	    
	}
	//Sovrascrittura della classe Evento con dei valori in aggiunta.
	@Override
	public String toString() {
		
		return super.toString() + "\nTitolo Oratore: " + oratoreDellaConferenza.getTitolo() + "\nNome Oratore: " + oratoreDellaConferenza.stampaNomeCognome() + "\nArgomento: " + getArgomentoDellaConferenza();
		
	}
	
}
