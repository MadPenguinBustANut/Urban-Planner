package seleziona;

import java.io.Serializable;
import java.util.ArrayList;

import centrourbano.*;

public class Seleziona implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**Seleziona contiene il settore selezionato, il massimo e il minimo ammissibili nella selezione, 
	* il tipi di selezione scelta e un array che conterra tutti i lotti scelti
	*/
	
	public Seleziona(CentroUrbano centr,double ma,double mi,int scelt) {
        lista= new Lotti[DIM_LIST];
        settLott= new ArrayList<String>();
		centro=centr;
		max=ma;
		min=mi;
		scelta=scelt;
		
	}
	
	/**
	 *Seleziona il metodo di selezione
	 * */
	
	public void Scelta() {
		switch(scelta) {
		case 0:coeffEff();
		       break;
		case 1:coeffInv();
		       break;
		case 2:val();
		       break;
		default: System.out.println("Selezione Errata\n");
		}
		
	}
	
	/**Seleziona i lotti presenti nel settore selezionato che rispettano 
	*le condizioni di max e min di coeff. di Efficienza dei lotti
	*/ 
	
	private void coeffEff() {
		
		for(int l=0;l<MAX_XSETTORE;l++)
			for(int k=0;k<MAX_YSETTORE;k++)
				for(int i=0;i<MAX_XLOTTO;i++)
					for(int y=0;y<MAX_YLOTTO;y++) {
						if(centro.lista[l][k].getLotto(i, y).getTip()!=0) {
						if(centro.lista[l][k].lista[i][y].getCeff()>min && centro.lista[l][k].lista[i][y].getCeff()<max) {
							addLista(l,k,i,y);
						}
						}
					}
	}
	
	/**Seleziona i lotti presenti nel settore selezionato che rispettano 
	*le condizioni di max e min di coeff. di Invecchiamento dei lotti
	*/
	
	private void coeffInv() {
		
		for(int l=0;l<MAX_XSETTORE;l++)
			for(int k=0;k<MAX_YSETTORE;k++)
				for(int i=0;i<MAX_XLOTTO;i++)
					for(int y=0;y<MAX_YLOTTO;y++) {	
						if(centro.lista[l][k].getLotto(i, y).getTip()!=0)
							if(centro.lista[l][k].getLotto(i, y).getCinv()>min && centro.lista[l][k].getLotto(i, y).getCinv()<max) {
								addLista(l,k,i,y);
							}
					}
	}
	
	/**Seleziona i lotti presenti nel settore selezionato che rispettano 
    *le condizioni di max e min di Valore dei lotti */
	
	
	private void val() {
		
		for(int l=0;l<MAX_XSETTORE;l++)
			for(int k=0;k<MAX_YSETTORE;k++)	
				for(int i=0;i<MAX_XLOTTO;i++)
					for(int y=0;y<MAX_YLOTTO;y++)
						if(centro.lista[l][k].lista[i][y].getTip()==3 && centro.lista[l][k].getLotto(i, y).getTip()!=0)
							if(centro.lista[l][k].getLotto(i, y).getValore()>min && centro.lista[l][k].getLotto(i, y).getValore()<max) {
								addLista(l,k,i,y);
						}
							
	}
	
	
	/**Ritorna il Conto di quanti elementi ci sono in lista */
	
	public int getCount() {
		return count;
	}
	
	public void setCount() {
		count++;
	}
	
	/**Ritorna il tipo di selezione effettuata */
	
	public int getScelta() {
		return scelta;
	}
	
	private void addLista(int l,int k,int i, int y) {
		lista[count]=centro.lista[l][k].getLotto(i, y);
		settLott.add(count, "Settore: "+l+":"+k+"\nLotto: "+i+":"+y);
		setCount();
	}

    private CentroUrbano centro;
    private double max;
    private double min;
    private int scelta;
    private int count=0;
    
    
    //Array di Stringhe contenenti il numero di settore e di lotto dei lotti memorizzati
    public ArrayList<String> settLott;
    
    private int x=0;
    private static final int MAX_XSETTORE= 2;
    private static final int MAX_YSETTORE= 3;
    private static final int MAX_XLOTTO = 3;
	private static final int MAX_YLOTTO = 5;
    private final static int DIM_LIST=90;
    
    
    public Lotti lista[];
}
