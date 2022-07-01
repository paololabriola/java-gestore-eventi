package com.gestore.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	//Attributi della classe Evento.
	private String titoloEvento;
	private LocalDate dataEvento;
	private int postiTotali, postiPrenotati;
	//Costruttore con annesse Eccezioni.
	public Evento(String titoloEvento, LocalDate dataEvento, int postiTotali) throws NullPointerException, IllegalArgumentException {
		
		super();
		//Metodi di validazione delle variabili con lancio degli eventuali errori.
		validaStringa(titoloEvento);
		validaData(dataEvento);
		validaNumero(postiTotali);
		//Assegnazioni dei valori degli attributi.
		this.titoloEvento = titoloEvento;
		this.dataEvento = dataEvento;
		this.postiTotali = postiTotali;
		//Inizializzazione dei posti prenotati a 0 per l'evento corrente.
		postiPrenotati = 0;
		
	}
	//GETTERS & SETTERS
	public String getTitoloEvento() {
		
		return titoloEvento;
		
	}


	//Setter del titolo con eventuale controllo di valore null.
	public void setTitoloEvento(String titoloEvento) throws NullPointerException {
		
		validaStringa(titoloEvento);
		this.titoloEvento = titoloEvento;
		
	}

	

	public LocalDate getDataEvento() {
		
		return dataEvento;
		
	}


	//Setter della data con eventuale errore in caso di data null o precedente a data corrente.
	public void setDataEvento(LocalDate dataEvento) throws NullPointerException, IllegalArgumentException {
		
		validaData(dataEvento);
		this.dataEvento = dataEvento;
		
	}



	public int getPostiTotali() {
		
		return postiTotali;
		
	}



	public int getPostiPrenotati() {
		
		return postiPrenotati;
		
	}


	//Metodo di validazione di un numero necessariamente maggiore di zero (come ad esempio la capienza della sede dell'evento).
	private void validaNumero(int numero) throws IllegalArgumentException {
		
		if(numero <= 0)
			throw new IllegalArgumentException("Il numero inserito non pu� essere minore o uguale a 0.");
		
	}
	//Metodo di validazione di una stringa con lancio di errore in caso di valore null.
	private void validaStringa(String stringa) throws NullPointerException {
		
		    if (stringa == null) 
		      throw new NullPointerException("Il valore non pu� essere null");
		    
		  }
	//Metodo di validazione di una data con lancio di un errore in caso di data null o precedente alla data corrente.
	private void validaData(LocalDate data) throws NullPointerException, IllegalArgumentException {
		
	    if (data == null)
	      throw new NullPointerException("La data deve essere necessariamente definita.");
	    
	    if (data.isBefore(LocalDate.now())) 
	      throw new IllegalArgumentException("La data non pu� essere passata.");
	    
	  }
	//Metodo di formattazione di una data con formato giorno/mese/anno.
	public String formattaData (LocalDate data) {  

		DateTimeFormatter formattazione = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		
		return data.format(formattazione);
		
	}
	//Metodo di prenotazione di un biglietto per l'evento in una certa data.
	public void prenota(LocalDate data) throws IllegalArgumentException {
		//Controllo della data qualora fosse una data null o passata.
		validaData(data);
		//Controllo della data affinch� non sia una data successiva all'evento.
		if(data.isAfter(dataEvento))
			throw new IllegalArgumentException("L'evento � gi� passato, non � possibile prenotare un posto per questo evento.");
		//Controllo disponibilit� di posti prenotabili.
		if(postiPrenotati == postiTotali) 
			throw new IllegalArgumentException("Non ci sono pi� posti disponibili per questo evento.");
		else {
			//Stampa in caso di prenotazione riuscita con successo e incremento della variabile che tiene il conto dei posti prenotati.
			System.out.println("Prenotazione avvenuta con successo.");
			postiPrenotati++; 
			
		}
		
	}
	//Metodo di disdetta di un biglietto per l'evento in una certa data.
	public void disdici(LocalDate data) throws IllegalArgumentException {
		//Controllo della data qualora fosse una data null o passata.
		validaData(data);
		//Controllo della data affinch� non sia una data successiva all'evento.
		if(data.isAfter(dataEvento))
			throw new IllegalArgumentException("L'evento � gi� passato, non � possibile prenotare un posto per questo evento.");
		//Controllo nel caso in cui non ci fossero prenotazioni da disdire.
		if(postiPrenotati == 0) 
			throw new IllegalArgumentException("Non sono state ancora effettuate prenotazioni per questo evento, non � possibile disdirne alcuna.");
		else {
			//Stampa in caso di disdetta riuscita  con successo e decremento della variabile che tiene il conto dei posti prenotati.
			System.out.println("Biglietto disdetto con successo.");
			postiPrenotati--; 
			
		}
		
	}
	
	public int postiDisponibili() {
		
		return postiTotali - postiPrenotati;
		
	}
	
	//Sovrascrittura del metodo toString della classe Oggetto di Java specifico della classe Evento.
	@Override
	public String toString() {
		
		return "Nome Evento: " + getTitoloEvento() + "\nData Evento: " + formattaData(getDataEvento()) ;
		
	}
	
}
