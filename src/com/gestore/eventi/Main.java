package com.gestore.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		LocalDate dataEvento = null;
		Evento evento1 = null;
		Conferenza conferenza1 = null;
		Oratore oratore1 = null;
		boolean flag = false, chiudiProgramma = false;
		int opzione1;
			
		do {
			
			System.out.println("Inserisci \n1. Per creare una Conferenza. \n2. Per creare un Evento.");
			System.out.print("Scelta: ");
			opzione1 = Integer.parseInt(scan.nextLine());
			
			if(opzione1 != 1 && opzione1 != 2)
				System.out.println("Inserire un valore valido.");
				
		}while(opzione1 != 1 && opzione1 != 2);
		
		switch(opzione1) {
			
		case 1:
			
			do {
				
				try {
					
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
					
					System.out.print("Inserisci il giorno dell'evento: ");
					int giorno = Integer.parseInt(scan.nextLine());
					System.out.print("Inserisci il mese dell'evento: ");
					int mese = Integer.parseInt(scan.nextLine());
					System.out.print("Inserisci l'anno dell'evento: ");
					int anno = Integer.parseInt(scan.nextLine());
					
					try {
					
						dataEvento = LocalDate.of(anno, mese, giorno);
						
					} catch (Exception e) {
						
						System.out.println("Data non valida.");
						
					}
					
					oratore1 = new Oratore(nomeOratore, cognomeOratore, titoloOratore);
					
					conferenza1 = new Conferenza(nome, dataEvento, capienza, argomento, oratore1);
					System.out.println(conferenza1.toString());
					
					flag = true;
					
					
				} catch (NumberFormatException nfe) {
					
					System.out.println("Hai inserito un carattere non valido, il valore deve necessariamente essere un numero.");
					System.out.println(nfe.getMessage());
					
				}catch (NullPointerException npe) {
					
					System.out.println(npe.getMessage());
					
				}  catch (Exception e) {
					
					System.out.println("I dati inseriti per creare la conferenza sono invalidi. Riprova.");
					System.out.println(e.getMessage());
					
				}
				
			}while(!flag);
			
			do {
				
				int opzione2;
				
				do {
				
					System.out.println("Inserisci: \n1. se vuoi effettuare delle prenotazioni\n2. se vuoi disdire delle prenotazioni\n3. se vuoi chiudere il programma.");
					System.out.print("Scelta: ");
					opzione2 = Integer.parseInt(scan.nextLine());
				
					if(opzione2 != 1 && opzione2 != 2 && opzione2 != 3)
						System.out.println("Inserire un valore valido.");
					
				}while(opzione2 != 1 && opzione2 != 2 && opzione2 != 3);
					
				switch(opzione2) {
				
					case 1: 
						
						int numeroPrenotazioni = 0;
						flag = false;
						
						do {
							
							try {
								
								System.out.print("Quante prenotazioni vuole effettuare? ");
								numeroPrenotazioni = Integer.parseInt(scan.nextLine());
								
								conferenza1.prenota(numeroPrenotazioni);
								flag = true;
								
							} catch (NumberFormatException nfe) {
								
								System.out.println("Hai inserito un carattere non valido, il valore deve necessariamente essere un numero.");
								System.out.println(nfe.getMessage());
								
							} catch (Exception e) {
								
								System.out.println(e.getMessage());
								
							}
							
						}while(!flag);
						
						System.out.println("L'evento presenta ancora " + conferenza1.postiDisponibili() + " posti disponibili, e conta " + conferenza1.getPostiPrenotati() + " prenotazioni.");
						
						break;
						
					case 2:
						
						boolean scelta = false;
						String conferma;
						
						do {
							
							do {
								
								System.out.print("Vuole disdire delle prenotazioni? ");
								conferma = scan.nextLine();
							
								if(!conferma.equalsIgnoreCase("si") && !conferma.equalsIgnoreCase("no"))
									System.out.println("Rispondi solo Si o No.");
							
							}while(!conferma.equalsIgnoreCase("no") && !conferma.equalsIgnoreCase("si"));
							
							if(conferma.equalsIgnoreCase("si")) 
								scelta = true;
							else if(conferma.equalsIgnoreCase("no"))
								break;
								
								try {
									
									System.out.print("Inserisci il numero delle prenotazioni da disdire: ");
									int prenotazioniDisdette = Integer.parseInt(scan.nextLine());
									
									conferenza1.disdici(prenotazioniDisdette);
									scelta = false;
									
								} catch (NumberFormatException nfe) {
									
									System.out.println("Hai inserito un carattere non valido, il valore deve necessariamente essere un numero.");
									System.out.println(nfe.getMessage());	
									
								} catch (Exception e) {
									
									System.out.println(e.getMessage());
									
								}
								
							}while(scelta);
						
						System.out.println("L'evento presenta ancora " + conferenza1.postiDisponibili() + " posti disponibili, e conta " + conferenza1.getPostiPrenotati() + " prenotazioni.");
						
						break;
						
					case 3:
						
						chiudiProgramma = true;
						break;
						
				}
				
			}while(!chiudiProgramma);
			
			break;
			
		case 2:
			
			do {
				
				try {
					
					System.out.print("Inserisci il nome dell'evento: ");
					String nome = scan.nextLine();
					System.out.print("Inserisci la capienza della location dell'evento: ");
					int capienza = Integer.parseInt(scan.nextLine());
					
					System.out.print("Inserisci il giorno dell'evento: ");
					int giorno = Integer.parseInt(scan.nextLine());
					System.out.print("Inserisci il mese dell'evento: ");
					int mese = Integer.parseInt(scan.nextLine());
					System.out.print("Inserisci l'anno dell'evento: ");
					int anno = Integer.parseInt(scan.nextLine());
					
					try {
					
						dataEvento = LocalDate.of(anno, mese, giorno);
						
					} catch (Exception e) {
						
						System.out.println("Data non valida.");
						
					}
					
					evento1 = new Evento(nome, dataEvento, capienza);
					System.out.println(evento1.toString());
					
					flag = true;
					
					
				} catch (NumberFormatException nfe) {
					
					System.out.println("Hai inserito un carattere non valido, il valore deve necessariamente essere un numero.");
					System.out.println(nfe.getMessage());
					
				} catch (Exception e) {
					
					System.out.println("I dati inseriti per creare l'evento sono invalidi. Riprova.");
					System.out.println(e.getMessage());
					
				}
				
			}while(!flag);
			
			do {
				
				int opzione2;
				
				do {
				
					System.out.println("Inserisci: \n1. se vuoi effettuare delle prenotazioni\n2. se vuoi disdire delle prenotazioni\n3. se vuoi chiudere il programma.");
					System.out.print("Scelta: ");
					opzione2 = Integer.parseInt(scan.nextLine());
				
					if(opzione2 != 1 && opzione2 != 2 && opzione2 != 3)
						System.out.println("Inserire un valore valido.");
					
				}while(opzione2 != 1 && opzione2 != 2 && opzione2 != 3);
					
				switch(opzione2) {
				
					case 1: 
						
						int numeroPrenotazioni = 0;
						flag = false;
						
						do {
							
							try {
								
								System.out.print("Quante prenotazioni vuole effettuare? ");
								numeroPrenotazioni = Integer.parseInt(scan.nextLine());
								
								evento1.prenota(numeroPrenotazioni);
								flag = true;
								
							} catch (NumberFormatException nfe) {
								
								System.out.println("Hai inserito un carattere non valido, il valore deve necessariamente essere un numero.");
								System.out.println(nfe.getMessage());
								
							} catch (Exception e) {
								
								System.out.println(e.getMessage());
								
							}
							
						}while(!flag);
						
						System.out.println("L'evento presenta ancora " + evento1.postiDisponibili() + " posti disponibili, e conta " + evento1.getPostiPrenotati() + " prenotazioni.");
						
						break;
						
					case 2:
						
						boolean scelta = false;
						String conferma;
						
						do {
							
							do {
								
								System.out.print("Vuole disdire delle prenotazioni? ");
								conferma = scan.nextLine();
							
								if(!conferma.equalsIgnoreCase("si") && !conferma.equalsIgnoreCase("no"))
									System.out.println("Rispondi solo Si o No.");
							
							}while(!conferma.equalsIgnoreCase("no") && !conferma.equalsIgnoreCase("si"));
							
							if(conferma.equalsIgnoreCase("si")) 
								scelta = true;
							else if(conferma.equalsIgnoreCase("no"))
								break;
								
								try {
									
									System.out.print("Inserisci il numero delle prenotazioni da disdire: ");
									int prenotazioniDisdette = Integer.parseInt(scan.nextLine());
									
									evento1.disdici(prenotazioniDisdette);
									scelta = false;
									
								} catch (NumberFormatException nfe) {
									
									System.out.println("Hai inserito un carattere non valido, il valore deve necessariamente essere un numero.");
									System.out.println(nfe.getMessage());	
									
								} catch (Exception e) {
									
									System.out.println(e.getMessage());
									
								}
								
							}while(scelta);
						
						System.out.println("L'evento presenta ancora " + evento1.postiDisponibili() + " posti disponibili, e conta " + evento1.getPostiPrenotati() + " prenotazioni.");
						
						break;
						
					case 3:
						
						chiudiProgramma = true;
						break;
						
				}
				
			}while(!chiudiProgramma);
			
			break;
			
		}
		
		scan.close();
		
	}

}