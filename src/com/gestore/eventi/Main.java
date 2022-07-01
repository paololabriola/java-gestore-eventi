package com.gestore.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	/*
	 * ATTENZIONE:
	 * Sono a conoscenza del fatto che questo main sia estremamente lungo e ridondante,
	 * avrei avuto piacere a dichiarare dei metodi/funzioni nel main stesso da richiamare
	 * poi all'interno di quest'ultimo per svolgere l'esercizio in molte meno righe di 
	 * codice per facilitare la correzione e la lettura dell'intero esercizio.
	 * Non avendolo mai fatto in classe con voi ho preferito lasciare
	 * il main lungo con tutte le funzioni in esso come fatto con voi a lezione.
	 * Mi scuso per le 300 e passa righe di codice causate da tutti i controlli 
	 * e casi presi in considerazione per la migliore gestione dell'output.
	 */
	
	public static void main(String[] args) {
		//Scanner per prendere valori in input.
		Scanner scan = new Scanner(System.in);
		//Variabile localDate con la data dell'evento.
		LocalDate dataEvento = null;
		//Oggetti evento, conferenza e oratore inizializzati a null.
		Evento evento1 = null;
		Conferenza conferenza1 = null;
		Oratore oratore1 = null;
		//Variabili flag per ripetizione dei cicli.
		boolean flag = false, chiudiProgramma = false;
		//Variabile opzione per entrare nel primo switch case.
		int opzione1;
			
		do {
			//Prima scelta per la creazione di una conferenza oppure un evento generico.
			System.out.println("Inserisci \n1. Per creare una Conferenza. \n2. Per creare un Evento generico.");
			System.out.print("Scelta: ");
			opzione1 = Integer.parseInt(scan.nextLine());
			//Controllo valore non valido.
			if(opzione1 != 1 && opzione1 != 2)
				System.out.println("Inserire un valore valido.");
		//Ciclo per ripetere l'operazione in input in caso di valore non valido.	
		}while(opzione1 != 1 && opzione1 != 2);
		
		switch(opzione1) {
		//CASO CONFERENZA	
		case 1:
			
			do {
				
				try {
					//Inizializzazione variabili temporanee per la creazione della conferenza.
					System.out.print("Inserisci il titolo della conferenza: ");
					String nome = scan.nextLine();
					System.out.print("Inserisci l'argomento della conferenza: ");
					String argomento = scan.nextLine();
					System.out.print("Inserisci il nome dell'oratore della conferenza: ");
					String nomeOratore = scan.nextLine();
					System.out.print("Inserisci il conome dell'oratore della conferenza: ");
					String cognomeOratore = scan.nextLine();
					System.out.print("Inserisci il titolo dell'oratore della conferenza: ");
					String titoloOratore = scan.nextLine();
					System.out.print("Inserisci la capienza della location della conferenza: ");
					int capienza = Integer.parseInt(scan.nextLine());
					//Valori della data.
					System.out.print("Inserisci il giorno dell'evento: ");
					int giorno = Integer.parseInt(scan.nextLine());
					System.out.print("Inserisci il mese dell'evento: ");
					int mese = Integer.parseInt(scan.nextLine());
					System.out.print("Inserisci l'anno dell'evento: ");
					int anno = Integer.parseInt(scan.nextLine());
					//Controllo validità della data con relativo messaggio di errore.
					try {
					
						dataEvento = LocalDate.of(anno, mese, giorno);
						
					} catch (Exception e) {
						
						System.out.println("Data non valida.");
						
					}
					//Inizializzazione oggetto Presentatore della conferenza.
					oratore1 = new Oratore(nomeOratore, cognomeOratore, titoloOratore);
					//Inizializzazione oggetto conferenza con tutte le componenti precedentemente inizializzate.
					conferenza1 = new Conferenza(nome, dataEvento, capienza, argomento, oratore1);
					System.out.println(conferenza1.toString());
					//Cambio valore flag in caso di corretto inserimento degli oggetti per uscire dal ciclo.
					flag = true;
					
				//Errore in caso di carattere invalido in uno scanner di un numero.
				} catch (NumberFormatException nfe) {
					
					System.out.println("Hai inserito un carattere non valido, il valore deve necessariamente essere un numero.");
					System.out.println(nfe.getMessage());
				//Errore in caso di stringa null o variabile vuota.	
				}catch (NullPointerException npe) {
					
					System.out.println(npe.getMessage());
				//Errore più generico con descrizione nello specifico data dalla classe di creazione dell'oggetto.	
				}  catch (Exception e) {
					
					System.out.println("I dati inseriti per creare la conferenza sono invalidi. Riprova.");
					System.out.println(e.getMessage());
					
				}
			//Ciclo per ripetere l'inserimento dell'oggetto in caso di valori errati.	
			}while(!flag);
			
			do {
				//Secondo switchcase per scegliere quale operazione svolgere tra prenotare, disdire o chiudere il programma.
				int opzione2;
				
				do {
					//Stampa delle opzioni e inizializzazione opzione.
					System.out.println("Inserisci: \n1. se vuoi effettuare delle prenotazioni\n2. se vuoi disdire delle prenotazioni\n3. se vuoi chiudere il programma.");
					System.out.print("Scelta: ");
					opzione2 = Integer.parseInt(scan.nextLine());
					//Controllo valore errato dell'opzione.
					if(opzione2 != 1 && opzione2 != 2 && opzione2 != 3)
						System.out.println("Inserire un valore valido.");
					
				}while(opzione2 != 1 && opzione2 != 2 && opzione2 != 3);
					
				switch(opzione2) {
					//CASO CREAZIONE PRENOTAZIONE.
					case 1: 
						//Dichiarazione e inizializzazione variabili.
						int numeroPrenotazioni = 0;
						flag = false;
						
						do {
							
							try {
								//Inizializzazione numero delle prenotazioni da effettuare.
								System.out.print("Quante prenotazioni vuole effettuare? ");
								numeroPrenotazioni = Integer.parseInt(scan.nextLine());
								//Metodo per prenotare.
								conferenza1.prenota(numeroPrenotazioni);
								flag = true;
							//Errore in caso di carattere invalido in uno scanner di un numero.	
							} catch (NumberFormatException nfe) {
								
								System.out.println("Hai inserito un carattere non valido, il valore deve necessariamente essere un numero.");
								System.out.println(nfe.getMessage());
							//Errore più generico con descrizione nello specifico dato dal metodo dell'oggetto.		
							} catch (Exception e) {
								
								System.out.println(e.getMessage());
								
							}
						//Ciclo per ripetere l'inserimento dell'oggetto in caso di valori errati.	
						}while(!flag);
						//Stampa dei posti disponibili e prenotazioni effettuate fino a quel momento.
						System.out.println("L'evento presenta ancora " + conferenza1.postiDisponibili() + " posti disponibili, e conta " + conferenza1.getPostiPrenotati() + " prenotazioni.");
						//FINE CASO 1
						break;
					//CASO DISDICI PRENOTAZIONE.
					case 2:
						//Dichiarazione e inizializzazione variabili.
						boolean scelta = false;
						String conferma;
						
						do {
							
							do {
								//Domanda se vuole disdire una prenotazione.
								System.out.print("Vuole disdire delle prenotazioni? ");
								conferma = scan.nextLine();
								
								if(!conferma.equalsIgnoreCase("si") && !conferma.equalsIgnoreCase("no"))
									System.out.println("Rispondi solo Si o No.");
							
							}while(!conferma.equalsIgnoreCase("no") && !conferma.equalsIgnoreCase("si"));
							//Se la risposta è si: cambio valore della flag per entrare o meno nel ciclo. Se la risposta è no: esce dal caso.
							if(conferma.equalsIgnoreCase("si")) 
								scelta = true;
							else if(conferma.equalsIgnoreCase("no"))
								break;
								
							try {
									//Inizializzazione numero di prenotazioni disdette.
									System.out.print("Inserisci il numero delle prenotazioni da disdire: ");
									int prenotazioniDisdette = Integer.parseInt(scan.nextLine());
									//Metodo per disdire le prenotazioni della classe Evento ereditato in questo caso dalla conferenza.
									conferenza1.disdici(prenotazioniDisdette);
									//Cambio valore della flag in caso di corretto inserimento dei dati e svolgimento del metodo.
									scelta = false;
							//Errore in caso di carattere invalido in uno scanner di un numero.			
							} catch (NumberFormatException nfe) {
									
								System.out.println("Hai inserito un carattere non valido, il valore deve necessariamente essere un numero.");
								System.out.println(nfe.getMessage());	
							//Errore più generico con descrizione nello specifico data dal metodo dell'oggetto.				
							} catch (Exception e) {
									
								System.out.println(e.getMessage());
								
							}
								
							}while(scelta);
						//Stampa posti ancora disponibili e prenotazioni effettuate.
						System.out.println("L'evento presenta ancora " + conferenza1.postiDisponibili() + " posti disponibili, e conta " + conferenza1.getPostiPrenotati() + " prenotazioni.");
						//FINE CASO 2.
						break;
					//CASO 3 PER CHIUDERE IL PROGRAMMA.
					case 3:
						//Cambio valore della flag per uscire dal programma.
						chiudiProgramma = true;
						//FINE CASO 3.
						break;
						
				}
			//Ciclo per ripetere il codice.
			}while(!chiudiProgramma);
			//FINE CASO 1 DELLA CONFERENZA.
			break;
		//CASO 2 DELL'EVENTO GENERICO.	
		case 2:
			
			do {
				
				try {
					//Inizializzazione variabili temporanee per la creazione dell'evento.
					System.out.print("Inserisci il nome dell'evento: ");
					String nome = scan.nextLine();
					System.out.print("Inserisci la capienza della location dell'evento: ");
					int capienza = Integer.parseInt(scan.nextLine());
					//Valori della data.
					System.out.print("Inserisci il giorno dell'evento: ");
					int giorno = Integer.parseInt(scan.nextLine());
					System.out.print("Inserisci il mese dell'evento: ");
					int mese = Integer.parseInt(scan.nextLine());
					System.out.print("Inserisci l'anno dell'evento: ");
					int anno = Integer.parseInt(scan.nextLine());
					//Controllo validità della data con relativo messaggio di errore.
					try {
					
						dataEvento = LocalDate.of(anno, mese, giorno);
						
					} catch (Exception e) {
						
						System.out.println("Data non valida.");
						
					}
					//Inizializzazione oggetto conferenza con tutte le componenti precedentemente inizializzate.
					evento1 = new Evento(nome, dataEvento, capienza);
					System.out.println(evento1.toString());
					//Cambio valore flag in caso di corretto inserimento degli oggetti per uscire dal ciclo.
					flag = true;
					
				//Errore in caso di carattere invalido in uno scanner di un numero.	
				} catch (NumberFormatException nfe) {
					
					System.out.println("Hai inserito un carattere non valido, il valore deve necessariamente essere un numero.");
					System.out.println(nfe.getMessage());
				//Errore più generico con descrizione nello specifico data dalla classe di creazione dell'oggetto.		
				} catch (Exception e) {
					
					System.out.println("I dati inseriti per creare l'evento sono invalidi. Riprova.");
					System.out.println(e.getMessage());
					
				}
			//Ciclo per ripetere l'inserimento dell'oggetto in caso di valori errati.		
			}while(!flag);
			
			do {
				//Secondo switchcase per scegliere quale operazione svolgere tra prenotare, disdire o chiudere il programma.
				int opzione2;
				
				do {
					//Stampa delle opzioni e inizializzazione opzione.
					System.out.println("Inserisci: \n1. se vuoi effettuare delle prenotazioni\n2. se vuoi disdire delle prenotazioni\n3. se vuoi chiudere il programma.");
					System.out.print("Scelta: ");
					opzione2 = Integer.parseInt(scan.nextLine());
					//Controllo valore errato dell'opzione.
					if(opzione2 != 1 && opzione2 != 2 && opzione2 != 3)
						System.out.println("Inserire un valore valido.");
					
				}while(opzione2 != 1 && opzione2 != 2 && opzione2 != 3);
					
				switch(opzione2) {
					//CASO CREAZIONE PRENOTAZIONE.
					case 1: 
						//Dichiarazione e inizializzazione variabili.
						int numeroPrenotazioni = 0;
						flag = false;
						
						do {
							
							try {
								//Inizializzazione numero delle prenotazioni da effettuare.
								System.out.print("Quante prenotazioni vuole effettuare? ");
								numeroPrenotazioni = Integer.parseInt(scan.nextLine());
								//Metodo per prenotare.
								evento1.prenota(numeroPrenotazioni);
								flag = true;
							//Errore in caso di carattere invalido in uno scanner di un numero.		
							} catch (NumberFormatException nfe) {
								
								System.out.println("Hai inserito un carattere non valido, il valore deve necessariamente essere un numero.");
								System.out.println(nfe.getMessage());
							//Errore più generico con descrizione nello specifico dato dal metodo dell'oggetto.		
							} catch (Exception e) {
								
								System.out.println(e.getMessage());
								
							}
						//Ciclo per ripetere l'inserimento dell'oggetto in caso di valori errati.	
						}while(!flag);
						//Stampa dei posti disponibili e prenotazioni effettuate fino a quel momento.						
						System.out.println("L'evento presenta ancora " + evento1.postiDisponibili() + " posti disponibili, e conta " + evento1.getPostiPrenotati() + " prenotazioni.");
						
						break;
					//CASO DISDICI PRENOTAZIONE.
					case 2:
						//Dichiarazione e inizializzazione variabili.						
						boolean scelta = false;
						String conferma;
						
						do {
							
							do {
								//Domanda per conferma se vuole disdire una prenotazione.
								System.out.print("Vuole disdire delle prenotazioni? ");
								conferma = scan.nextLine();
							
								if(!conferma.equalsIgnoreCase("si") && !conferma.equalsIgnoreCase("no"))
									System.out.println("Rispondi solo Si o No.");
							
							}while(!conferma.equalsIgnoreCase("no") && !conferma.equalsIgnoreCase("si"));
							//Se la risposta è si: cambio valore della flag per entrare o meno nel ciclo. Se la risposta è no: esce dal caso.
							if(conferma.equalsIgnoreCase("si")) 
								scelta = true;
							else if(conferma.equalsIgnoreCase("no"))
								break;
								
								try {
									//Inizializzazione numero di prenotazioni disdette.
									System.out.print("Inserisci il numero delle prenotazioni da disdire: ");
									int prenotazioniDisdette = Integer.parseInt(scan.nextLine());
									//Metodo per disdire le prenotazioni della classe Evento ereditato in questo caso dalla conferenza.
									evento1.disdici(prenotazioniDisdette);
									//Cambio valore della flag in caso di corretto inserimento dei dati e svolgimento del metodo.
									scelta = false;
								//Errore in caso di carattere invalido in uno scanner di un numero.		
								} catch (NumberFormatException nfe) {
									
									System.out.println("Hai inserito un carattere non valido, il valore deve necessariamente essere un numero.");
									System.out.println(nfe.getMessage());	
								//Errore più generico con descrizione nello specifico data dal metodo dell'oggetto.	
								} catch (Exception e) {
									
									System.out.println(e.getMessage());
									
								}
								
							}while(scelta);
						//Stampa posti ancora disponibili e prenotazioni effettuate.
						System.out.println("L'evento presenta ancora " + evento1.postiDisponibili() + " posti disponibili, e conta " + evento1.getPostiPrenotati() + " prenotazioni.");
						//FINE CASO 2.
						break;
						//CASO 3 PER CHIUDERE IL PROGRAMMA.
					case 3:
						//Cambio valore della flag per uscire dal programma.
						chiudiProgramma = true;
						//FINE CASO 3.
						break;
						
				}
			//Ciclo per ripetere il codice.
			}while(!chiudiProgramma);
			//FINE CASO EVENTO GENERICO.
			break;
			
		}
		//Chiusura scanner.
		scan.close();
		
	}

}