package com.gestore.eventi;

import java.util.Comparator;

public class CompareTo implements Comparator<Evento> {

  @Override
  public int compare(Evento a, Evento b) {
	  
    if(a.getDataEvento().isBefore(b.getDataEvento()))
    	return -1;
    else if(a.getDataEvento().isAfter(b.getDataEvento()))
    	return 1;
    else {
    	
	    	if(a.getTitoloEvento().compareTo(b.getTitoloEvento()) == 1)
	    	return 1;
	    else if(a.getTitoloEvento().compareTo(b.getTitoloEvento()) == -1)
	    	return -1;
	    else
	    	return 0;
	    	
    }
    
  }

}