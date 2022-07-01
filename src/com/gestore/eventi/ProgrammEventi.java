package com.gestore.eventi;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgrammEventi extends CompareTo{

	public  static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		boolean flag = false;
		String conferma;
		LocalDate dataEvento = null;
		List<Evento> listaEventi = new ArrayList<Evento>();
		
		do {
			
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
			
			Evento nuovoEvento = new Evento(nome, dataEvento, capienza);
			
			listaEventi.add(nuovoEvento);
			
			System.out.println("La lista ora contiene " + listaEventi.size() + " Eventi.");
			
			
			do {
					
				System.out.print("Vuoi inserire un nuovo Evento? ");
				conferma = scan.nextLine();
				
				if(!conferma.equalsIgnoreCase("si") && !conferma.equalsIgnoreCase("no"))
					System.out.println("Rispondi solo Si o No.");
				
			}while(!conferma.equalsIgnoreCase("no") && !conferma.equalsIgnoreCase("si"));
				
			if(conferma.equalsIgnoreCase("no"))
				flag = true;
		
		}while(!flag);
		
		listaEventi.sort(new CompareTo());
		
		System.out.println("La tua lista di Eventi ordinata è: ");
		System.out.println(listaEventi);
		
		List<Evento> listaEventiProssimi = new ArrayList<Evento>();
		List<Evento> listaEventiFuturi = new ArrayList<Evento>();
		
	    for(int i = 0; i < listaEventi.size(); i++) {
	    		
			int giorni = (int) LocalDate.now().until(listaEventi.get(i).getDataEvento(), ChronoUnit.DAYS);

			if (giorni < 30)
					listaEventiProssimi.add(listaEventi.get(i));
			else
					listaEventiFuturi.add(listaEventi.get(i));
	    }
		
	    System.out.println("Eventi nel prossimo mese:");
	    System.out.println(listaEventiProssimi);
	    System.out.println("Eventi futuri:");
	    System.out.println(listaEventiFuturi);
	    
		scan.close();

	}

}
