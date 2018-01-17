package seleziona;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import centrourbano.Lotti;

public class Ordinamento implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6750123478772739079L;
	/**Ordinamento contiene i lotti selezionati e in che modo ordinarli(flag=0 ord normal flag=1 ord inverso)*/
	
	public Ordinamento( Seleziona sel) {
		selez=sel;
		select=new ArrayList<>(Arrays.asList(selez.getLista()));

	}
	public ArrayList<Lotti> getSelect() {
		return select;
	}
	/**Il metodo sceltaOrd seleziona in base a quale valore effettuare l'ordinamento*/
	
	public void sceltaOrd() {
		switch(selez.getScelta()) {
		case 0:

				Collections.sort(select, Collections.reverseOrder(new EfficComparator()));
			
		
		        break;
		       
		case 1: 
			Collections.sort(select, Collections.reverseOrder(new InvComparator()));

		        break;
		case 2: 
			Collections.sort(select, Collections.reverseOrder(new ValComparator()));
		        break;
		} 
		
	}
	
	
	
	
	private ArrayList<Lotti> select;
	private Seleziona selez ;
	


	
}
