package seleziona;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import centrourbano.Lotti;

public class Ordinamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**Ordinamento contiene i lotti selezionati e in che modo ordinarli(flag=0 ord normal flag=1 ord inverso)*/
	
	public Ordinamento(int f, Seleziona sel) {
		flag=f;
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
			if(flag!=0) {
				Collections.sort(select, Collections.reverseOrder(new EfficComparator()));
			}
			else{
				Collections.sort(select, Collections.reverseOrder(new EfficComparator()));
			}
		
		        break;
		       
		case 1: 
			if(flag!=0)Collections.sort(select, Collections.reverseOrder(new InvComparator()));
			else{
				Collections.sort(select, Collections.reverseOrder(new InvComparator()));
			}
		        break;
		case 2: 
			if(flag!=0)Collections.sort(select, Collections.reverseOrder(new ValComparator()));
			else{
				Collections.sort(select, Collections.reverseOrder(new ValComparator()));
			}
		        break;
		} 
		
	}
	
	
	
	
	private int flag;
	private ArrayList<Lotti> select;
	private Seleziona selez ;
	


	
}
