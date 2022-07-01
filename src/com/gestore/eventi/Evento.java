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
			throw new IllegalArgumentException("Il numero inserito non può essere minore o uguale a 0.");
		
	}
	//Metodo di validazione di una stringa con lancio di errore in caso di valore null.
	private void validaStringa(String stringa) throws NullPointerException {
		
		    if (stringa.isBlank() || stringa==null) 
		      throw new NullPointerException("La stringa deve avere un valore.");
		    
	}
	//Metodo di validazione di una data con lancio di un errore in caso di data null o precedente alla data corrente.
	private void validaData(LocalDate data) throws NullPointerException, IllegalArgumentException {
		
	    if (data == null)
	      throw new NullPointerException("La data deve essere necessariamente definita.");
	    
	    if (data.isBefore(LocalDate.now())) 
	      throw new IllegalArgumentException("La data non può essere passata.");
	    
	  }
	//Metodo di formattazione di una data con formato giorno/mese/anno.
	public String formattaData (LocalDate data) {  

		DateTimeFormatter formattazione = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		
		return data.format(formattazione);
		
	}
	//Metodo di prenotazione di un biglietto per l'evento in una certa data.
	public void prenota(int prenotazioni) throws IllegalArgumentException {
		//Controllo affinché la data di creazione del biglietto non sia una data successiva all'evento.
		if((LocalDate.now()).isAfter(dataEvento))
			throw new IllegalArgumentException("L'evento è già passato, non è possibile prenotare un posto per questo evento.");
		//Controllo disponibilità di posti prenotabili.
		if(prenotazioni > postiDisponibili()) 
			throw new IllegalArgumentException("Non ci sono abbastanza posti per questo evento, i posti disponibili sono solo " + postiDisponibili());
		else {
			//Stampa in caso di prenotazione riuscita con successo e incremento della variabile che tiene il conto dei posti prenotati.
			System.out.println("Prenotazioni avvenute con successo.");
			postiPrenotati += prenotazioni; 
			
		}
		
	}
	//Metodo di disdetta di un biglietto per l'evento in una certa data.
	public void disdici(int prenotazioniDisdette) throws IllegalArgumentException {
		//Controllo affinché la data in cui dsdici il biglietto non sia una data successiva all'evento.
		if((LocalDate.now()).isAfter(dataEvento))
			throw new IllegalArgumentException("L'evento è già passato, non è possibile prenotare un posto per questo evento.");
		//Controllo nel caso in cui non ci fossero prenotazioni da disdire.
		if(postiPrenotati == 0) 
			throw new IllegalArgumentException("Non sono state ancora effettuate prenotazioni per questo evento, non è possibile disdirne alcuna.");
		//Controllo qualora le prenotazioni disdette siano maggiori delle prenotazioni effettuate con relativo messaggio di errore.
		else if(prenotazioniDisdette > postiPrenotati) 
			throw new IllegalArgumentException("Non ci sono abbastanza prenotazioni per questo evento, le prenotazioni disdicibili sono solo " + postiPrenotati);
		else {
			//Stampa in caso di disdetta riuscita  con successo e decremento della variabile che tiene il conto dei posti prenotati.
			System.out.println("Biglietti disdetti con successo.");
			postiPrenotati -= prenotazioniDisdette; 
			
		}
		
	}
	//Calcolo posti disponibili.
	public int postiDisponibili() {
		
		return postiTotali - postiPrenotati;
		
	}
	
	//Sovrascrittura del metodo toString della classe Oggetto di Java specifico della classe Evento.
	@Override
	public String toString() {
		
		return "\nNome Evento: " + getTitoloEvento() + " Data Evento: " + formattaData(getDataEvento()) ;
		
	}
	
}
