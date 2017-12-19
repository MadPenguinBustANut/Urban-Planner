package seleziona;

import java.io.Serializable;

import centrourbano.*;

public class Seleziona implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Seleziona contiene il settore selezionato, il massimo e il minimo ammissibili nella selezione, 
	//il tipi di selezione scelta e un array che conterra tutti i lotti scelti
	
	public Seleziona(Settori sett) {
        lista= new Lotti[DIM_LIST];
		settore = sett;
		max=90;
		min=10;
		scelta=0;
		
	}
	
	//Il metodo scelta selezione il metodo di selezione
	
	public void Scelta(Seleziona select) {
		switch(scelta) {
		case 0:select.coeffEff();
		       break;
		case 1:select.coeffInv();
		       break;
		case 2:select.coeffDann();
		       break;
		case 3:select.val();
		       break;
		default: System.out.println("Selezione Errata\n");
		}
		
	}
	
	//Il metodo coeffEff selezione i lotti presenti nel settore selezionato che rispettano 
	//le condizioni di max e min di coeff. di Efficienza dei lotti
	
	private void coeffEff() {
		int j=0;
		for(int i=0;i<MAX_X;i++)
			for(int y=0;y<MAX_Y;y++) {
				if(settore.getLotto(i, y).getCeff()>min && settore.getLotto(i, y).getCeff()<max) {
					lista[j]=settore.getLotto(i, y);
				}
			}
		this.setCount(j);
	}
	
	//Il metodo coeffInv seleziona i lotti presenti nel settore selezionato che rispettano 
	//le condizioni di max e min di coeff. di Invecchiamento dei lotti
	
	private void coeffInv() {
		int j=0;
		for(int i=0;i<MAX_X;i++)
			for(int y=0;y<MAX_Y;y++) {
				if(settore.getLotto(i, y).getCinv()>min && settore.getLotto(i, y).getCinv()<max)
					lista[j]=settore.getLotto(i, y);
			}
		this.setCount(j);
	}
	
	//Il metodo coeffDan seleziona i lotti presenti nel settore selezionato che rispettano 
	//le condizioni di max e min di coeff di Danno dei lotti
	
	private void coeffDann() {
		
	}
	
	//Il metodo val seleziona i lotti presenti nel settore selezionato che rispettano 
    //le condizioni di max e min di Valore dei lotti
	
	
	private void val() {
		int j=0;
		for(int i=0;i<MAX_X;i++)
			for(int y=0;y<MAX_Y;y++)
			    if(settore.getLotto(i, y).getValore()>min && settore.getLotto(i, y).getValore()<max)
			    	lista[j]=settore.getLotto(i, y);
		this.setCount(j);
	}
	
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int c) {
		count+=c;
	}
	
	public int getScelta() {
		return scelta;
	}
	

    private Settori settore;
    private double max;
    private double min;
    private int scelta;
    private int count=0;
    
    
    private static final int MAX_X = 2;
	private static final int MAX_Y = 4;
    private final static int DIM_LIST=90;
    
    public Lotti lista[];
}
