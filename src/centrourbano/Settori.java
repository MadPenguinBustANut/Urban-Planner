package centrourbano;

import java.awt.Dimension;
import java.io.Serializable;
import java.util.ArrayList;

public class Settori implements Serializable{
	private static final long serialVersionUID = 1L;

	public Settori() {
		setValore(0);
		setDimensione(new Dimension(0, 0));
	}
	/**
	 * 
	 * Costruttore per decidere le dimensioni di un settore
	 * 
	 * @param altezza righe
	 * @param larghezza colonne
	 * 
	 */
	public Settori(int altezza, int larghezza) {
		setValore(0);
		setDimensione(new Dimension(altezza, larghezza));
	}
	
	
	
	
	
	
	
	public void addLotto(Lotti Nuovo) {
		//TODO
	}
	
	public Lotti getLotto(int riga, int colonna) {
		Lotti io = lista.get((riga)*(colonna)); //TODO il metodo è errato per il calcolo
												//Dobbiamo vedere come calcolare correttamente
												//la posizione dell'elemento in lista
		return io;
	}
	
	
	
	public int getValore() {
		return valore;
	}
	public void setValore(int valore) {
		this.valore = valore;
	}





	public Dimension getDimensione() {
		return dimensione;
	}
	public void setDimensione(Dimension dimensione) {
		this.dimensione = dimensione;
	}





	private Dimension dimensione;
	private int valore;
	
	public ArrayList<Lotti> lista = new ArrayList<Lotti>();
}
