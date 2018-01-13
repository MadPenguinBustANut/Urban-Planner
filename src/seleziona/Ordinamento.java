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
			if(flag!=0)
			Collections.sort(select, new EfficComparator());
			else{
				Collections.sort(select, Collections.reverseOrder(new EfficComparator()));
			}
		
		        break;
		       
		case 1: 
			if(flag!=0)Collections.sort(select, new InvComparator());
			else{
				Collections.sort(select, Collections.reverseOrder(new InvComparator()));
			}
		        break;
		case 2: 
			if(flag!=0)Collections.sort(select, new ValComparator());
			else{
				Collections.sort(select, Collections.reverseOrder(new ValComparator()));
			}
		        break;
		} 
		
	}
	


	//
	/**Il metodo coeffEff effettua il bubleSort della lista in base al coeff. di Efficienza*/
	
	/*private void coeffEff() {
		for(int i=0;i<select.getCount();i++) {
			boolean f=false;
			for(int j=0;j<select.getCount()-1;j++) {
				if(flag==0) {
					if(select.lista[j].getCeff()<select.lista[j+1].getCeff()) {
						Lotti k=select.lista[j];
						select.lista[j]=select.lista[j+1];
						select.lista[j+1]=k;
						String x=select.settLott.get(j);
						select.settLott.set(j, select.settLott.get(j+1));
						select.settLott.set(j+1, x);
						f=true;
					}
				}
				else {
					if(select.lista[j].getCeff()>select.lista[j+1].getCeff()) {
						Lotti k=select.lista[j];
						select.lista[j]=select.lista[j+1];
						select.lista[j+1]=k;
						String x=select.settLott.get(j);
						select.settLott.set(j, select.settLott.get(j+1));
						select.settLott.set(j+1, x);
						f=true;
					}
				}
					
			}
			if(!f) break;
		}
		
	}
	
	Il metodo coeffInv effettua il bubleSort della lista in base al coeff. di Invecchiamento.E' stato scartato e sto provando array.sort
	
	private void coeffInv() {
		for(int i=0;i<select.getCount();i++) {
			boolean f=false;
			for(int j=0;j<select.getCount()-1;j++) {
			    if(flag==0) {
			    	if(select.lista[j].getCinv()<select.lista[j+1].getCinv()) {
						Lotti k=select.lista[j];
						select.lista[j]=select.lista[j+1];
						select.lista[j+1]=k;
						String x=select.settLott.get(j);
						select.settLott.set(j, select.settLott.get(j+1));
						select.settLott.set(j+1, x);
						f=true;
					}
			    }
			    else{
			    	if(select.lista[j].getCinv()>select.lista[j+1].getCinv()) {
						Lotti k=select.lista[j];
						select.lista[j]=select.lista[j+1];
						select.lista[j+1]=k;
						String x=select.settLott.get(j);
						select.settLott.set(j, select.settLott.get(j+1));
						select.settLott.set(j+1, x);
						f=true;
					}
			    }
			}
			if(!f) break;
		}
		
	}
	Il metodo coeffInv effettua il bubleSort della lista in base al coeff. di Invecchiamento.E' stato scartato e sto provando array.sort
	
	Il metodo val effettua il bubbleSort della lista in base al Valore
	
	private void val() {
		for(int i=0;i<select.getCount();i++) {
			boolean f=false;
			for(int j=0;j<select.getCount()-1;j++) {
				if(flag==0) {
					if(select.lista[j].getValore()<select.lista[j+1].getValore()) {
						Lotti k=select.lista[j];
						select.lista[j]=select.lista[j+1];
						select.lista[j+1]=k;
						String x=select.settLott.get(j);
						select.settLott.set(j, select.settLott.get(j+1));
						select.settLott.set(j+1, x);
						f=true;
					}
				}
				else{
					if(select.lista[j].getValore()>select.lista[j+1].getValore()) {
						Lotti k=select.lista[j];
						select.lista[j]=select.lista[j+1];
						select.lista[j+1]=k;
						String x=select.settLott.get(j);
						select.settLott.set(j, select.settLott.get(j+1));
						select.settLott.set(j+1, x);
			
						f=true;
					}
				}
			}
			if(!f) break;
		}
		
	}
*/
	
	
	
	private int flag;
	private ArrayList<Lotti> select;
	private Seleziona selez ;
	


	
}
