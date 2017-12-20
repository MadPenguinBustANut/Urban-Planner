package seleziona;

import java.io.*;

import centrourbano.*;

public class Ordinamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Ordinamento contiene i lotti selezionati e in che modo ordinarli(flag=0 ord normal flag=1 ord inverso)
	
	public Ordinamento(int f, Seleziona sel) {
		flag=f;
		select=sel;
	}
	
	//Il metodo sceltaOrd seleziona in base a quale valore effettuare l'ordinamento
	
	public void sceltaOrd(Ordinamento ord) {
		
		switch(select.getScelta()) {
		case 0: ord.coeffEff();
		        break;
		case 1: ord.coeffInv();
		        break;
		case 2: ord.val();
		        break;
		} 
		
	}
	
	//Il metodo coeffEff effettua il bubleSort della lista in base al coeff. di Efficienza
	
	private void coeffEff() {
		for(int i=0;i<select.getCount();i++) {
			boolean f=false;
			for(int j=0;j<select.getCount()-1;j++) {
				if(flag==0) {
					if(select.lista[j].getCeff()>select.lista[j+1].getCeff()) {
						Lotti k=select.lista[j];
						select.lista[j]=select.lista[j+1];
						select.lista[j+1]=k;
						f=true;
					}
				}
				else {
					if(select.lista[j].getCeff()<select.lista[j+1].getCeff()) {
						Lotti k=select.lista[j];
						select.lista[j]=select.lista[j+1];
						select.lista[j+1]=k;
						f=true;
					}
				}
					
			}
			if(!f) break;
		}
		
	}
	
	//Il metodo coeffInv effettua il bubleSort della lista in base al coeff. di Invecchiamento
	
	private void coeffInv() {
		for(int i=0;i<select.getCount();i++) {
			boolean f=false;
			for(int j=0;j<select.getCount()-1;j++) {
			    if(flag==0) {
			    	if(select.lista[j].getCinv()>select.lista[j+1].getCinv()) {
						Lotti k=select.lista[j];
						select.lista[j]=select.lista[j+1];
						select.lista[j+1]=k;
						f=true;
					}
			    }
			    else{
			    	if(select.lista[j].getCinv()<select.lista[j+1].getCinv()) {
						Lotti k=select.lista[j];
						select.lista[j]=select.lista[j+1];
						select.lista[j+1]=k;
						f=true;
					}
			    }
			}
			if(!f) break;
		}
		
	}
	
	
	//Il metodo val effettua il bubleSort della lista in base al Valore
	
	private void val() {
		for(int i=0;i<select.getCount();i++) {
			boolean f=false;
			for(int j=0;j<select.getCount()-1;j++) {
				if(flag==0) {
					if(select.lista[j].getValore()>select.lista[j+1].getValore()) {
						Lotti k=select.lista[j];
						select.lista[j]=select.lista[j+1];
						select.lista[j+1]=k;
						f=true;
					}
				}
				else{
					if(select.lista[j].getValore()<select.lista[j+1].getValore()) {
						Lotti k=select.lista[j];
						select.lista[j]=select.lista[j+1];
						select.lista[j+1]=k;
						f=true;
					}
				}
			}
			if(!f) break;
		}
		
	}
	
	
	
	
	
	private int flag;
	private Seleziona select;
}
