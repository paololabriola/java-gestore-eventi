package com.gestore.eventi;

import java.time.LocalDate;

public class Conferenza extends Evento {

	private String argomentoDellaConferenza;
	Oratore oratoreDellaConferenza;
	
	public Conferenza(String titoloEvento, LocalDate dataEvento, int postiTotali, String argomentoDellaConferenza, Oratore oratoreDellaConferenza)
	throws NullPointerException, IllegalArgumentException {
		super(titoloEvento, dataEvento, postiTotali);
		
		this.argomentoDellaConferenza = argomentoDellaConferenza;
		this.oratoreDellaConferenza = new Oratore (oratoreDellaConferenza.getNome(), oratoreDellaConferenza.getCognome(), oratoreDellaConferenza.getTitolo());
		
	}

	public String getArgomentoDellaConferenza() {
		return argomentoDellaConferenza;
	}

	public void setArgomentoDellaConferenza(String argomentoDellaConferenza) {
		validaStringa(argomentoDellaConferenza);
		this.argomentoDellaConferenza = argomentoDellaConferenza;
	}

	private void validaStringa(String stringa) throws NullPointerException {
		
	    if (stringa.isBlank() || stringa==null) 
	      throw new NullPointerException("La stringa deve avere un valore.");
	    
	}

	@Override
	public String toString() {
		
		return super.toString() + "\nTitolo Oratore: " + oratoreDellaConferenza.getTitolo() + "\nNome Oratore: " + oratoreDellaConferenza.stampaNomeCognome() + "\nArgomento: " + getArgomentoDellaConferenza();
		
	}
	
}
