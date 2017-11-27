package centrourbano;

import java.io.Serializable;

import eccezioni.LottoLibero;

public class Settori implements Serializable{
	private static final long serialVersionUID = 1L;

	public Settori() {
		setValore(0);
		lista = new Lotti[3][5];
	}
	/**
	 * 
	 * Costruttore per decidere le dimensioni di un settore
	 * 
	 * @param altezza righe
	 * @param larghezza colonne
	 * 
	 */
	
	
	/**
	 * Calcola il prezzo del lotto
	 * @param settore
	 */
	
	public void vendiEdificio(int settore) {
		// (Valore settore + valore lotto) * coeff. eff.
	}
	
	
	
	/**
	 * In base al tipo di lotto il metodo esegue una di 3 azioni
	 * -Edificio pubblico: Incrementa di 1 il valore del settore
	 * -Strada: Trova i lotti adiacenti nelle 8 direzioni e aumenta il loro valore di 1
	 * -Edificio privato: Controlla i lotti adiacenti in cerca di strade e aumenta per ogni strada il valore di 1
	 * @param Nuovo
	 */
	public void addLotto(Lotti Nuovo) {
		//TODO
	}
	
	
	
	
	/**
	 * Rimuove l'edificio e invere i cambiamenti che questo influiva sui vicini e sul settore.
	 * -Edificio privato: Semplice rimozione
	 * -Edificio pubblico: Il valore del settore viene ridotto di 1
	 * -Strada: Riduce di 1 il valore dei lotti adiacenti
	 * 
	 * 
	 * Nel caso in cui il lotto sia già libero lancia un eccezione di tipo "LottoLibero"
	 * @param riga
	 * @param colonna
	 */
	
	public void rmEdificio(int riga, int colonna) throws LottoLibero{
		//TODO
	}
	
	public Lotti getLotto(int riga, int colonna) {
		Lotti io = lista[riga][colonna]; 		
		
		
		return io;
	}
	
	
	
	public int getValore() {
		return valore;
	}
	public void setValore(int valore) {
		this.valore = valore;
	}




	private int valore;
	
	public Lotti[][] lista;
}
