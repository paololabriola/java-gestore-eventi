package com.gestore.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		LocalDate dataEvento = null, dataOdierna = null;
		Evento evento1 = null;
		boolean flag = false;
		
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
		
		int numeroPrenotazioni = 0;
		flag = false;
		
		do {
			
			try {
				
				System.out.print("Quante prenotazioni vuole effettuare? ");
				numeroPrenotazioni = Integer.parseInt(scan.nextLine());
				
				System.out.println("Inserire la data di oggi.");
				
				System.out.print("Inserisci il giorno: ");
				int giorno = Integer.parseInt(scan.nextLine());
				System.out.print("Inserisci il mese: ");
				int mese = Integer.parseInt(scan.nextLine());
				System.out.print("Inserisci l'anno: ");
				int anno = Integer.parseInt(scan.nextLine());
				
				try {
				
					dataOdierna = LocalDate.of(anno, mese, giorno);
					
				} catch (Exception e) {
					
					System.out.println("Data non valida.");
					
				}
				
				flag = true;
				
			} catch (NumberFormatException nfe) {
				
				System.out.println("Hai inserito un carattere non valido, il valore deve necessariamente essere un numero.");
				System.out.println(nfe.getMessage());
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
				
			}
			
		}while(!flag);
		
		
		for(int i = 0; i < numeroPrenotazioni; i++) {
			
			try {
				
				evento1.prenota(dataOdierna);
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
				
			}
			
			
		}
		
		System.out.println("L'evento presenta ancora " + evento1.postiDisponibili() + " posti disponibili, e conta " + evento1.getPostiPrenotati() + " prenotazioni.");
		
		boolean scelta = false;
		int prenotazioniDisdette = 0;
		String conferma;
		
		do {
			
			System.out.print("Vuole disdire delle prenotazioni? ");
			conferma = scan.nextLine();
		
			if(!conferma.equalsIgnoreCase("si") && !conferma.equalsIgnoreCase("no"))
				System.out.println("Rispondi solo Si o No.");
		
		}while(!conferma.equalsIgnoreCase("no") && !conferma.equalsIgnoreCase("si"));
		
		if(conferma.equalsIgnoreCase("si"))
			scelta = true;
		
		if(scelta) {
			
			try {
				
				System.out.println("Inserisci il numero delle prenotazioni da disdire: ");
				prenotazioniDisdette = Integer.parseInt(scan.nextLine());
				
			} catch (NumberFormatException nfe) {
				
				System.out.println("Hai inserito un carattere non valido, il valore deve necessariamente essere un numero.");
				System.out.println(nfe.getMessage());		
			}
			
			for(int i = 0; i < prenotazioniDisdette; i++) {
				
				try {
					
					evento1.disdici(dataOdierna);
					
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
					
				}
				
			}
			
		}
		
		System.out.println("L'evento presenta ancora " + evento1.postiDisponibili() + " posti disponibili, e conta " + evento1.getPostiPrenotati() + " prenotazioni.");
		
		scan.close();
		
	}

}
