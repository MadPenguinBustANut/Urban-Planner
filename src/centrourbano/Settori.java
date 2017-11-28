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
	
	public int vendiEdificio(int X, int Y) {
		Lotti vend = getLotto(X, Y);
		int tot = (vend.getVal() + this.getValore()) * vend.getCeff();
		rmLotto(X, Y);
		return tot;
		
	}
	
	
	
	/**
	 * In base al tipo di lotto il metodo esegue una di 3 azioni
	 * -Edificio pubblico: Incrementa di 1 il valore del settore
	 * -Strada: Trova i lotti adiacenti nelle 8 direzioni e aumenta il loro valore di 1
	 * -Edificio privato: Controlla i lotti adiacenti in cerca di strade e aumenta per ogni strada il valore di 1
	 * @param Nuovo
	 */
	public void addLotto(Lotti Nuovo, int X, int Y) {
		if(Nuovo.getTip() == 1)
			addStrada( Nuovo,X,Y);
		if(Nuovo.getTip() == 2)
			addepub(Nuovo,X,Y);
		if(Nuovo.getTip() == 3)
			addepriv(Nuovo,  X, Y);
	}
	
	
	
	
	/**
	 * Rimuove l'edificio e inverte i cambiamenti che questo influiva sui vicini e sul settore.
	 * -Edificio privato: Semplice rimozione
	 * -Edificio pubblico: Il valore del settore viene ridotto di 1
	 * -Strada: Riduce di 1 il valore dei lotti adiacenti
	 * 
	 * 
	 * Nel caso in cui il lotto sia già libero lancia un eccezione di tipo "LottoLibero"
	 * @param X
	 * @param Y
	 */
	
	public void rmLotto(int X, int Y) {
		if((getLotto(X, Y)).getTip() == 0)
			throw new LottoLibero();
		if((getLotto(X, Y)).getTip() == 1)
			rmStrada(X,Y);
		if((getLotto(X, Y)).getTip() == 2)
			rmepub(X,Y);
		if((getLotto(X, Y)).getTip() == 3)
			rmepriv(X,Y);
		
	}
	
	/**
	 * Cambia l'edificio selezionato con un altro aggiornando gli effetti
	 * @param X
	 * @param Y
	 * @throws LottoLibero
	 */
	
	public void cgEdificio(Lotti nuovo,int X, int Y) {
		rmLotto(X, Y);
		addLotto(nuovo, X , Y);
	}
	
	public Lotti getLotto(int X, int Y) {
		Lotti io = lista[X][Y]; 		
		
		
		return io;
	}
	
	/**
	 * Aggiunge una strada alla posizione indicata da X e Y e aumenta di uno 
	 * il valore di tutti i lotti adiacenti
	 * @param Nuovo
	 * @param X
	 * @param Y
	 */
	private void addStrada(Lotti Nuovo, int X, int Y) {
			lista[X][Y] = Nuovo;
			
			if((Y - 1) >= 0)
				lista[X][Y - 1].setVal(lista[X][Y - 1].getVal() +1);
			if((Y + 1) <= MAX_Y )
				lista[X][Y + 1].setVal(lista[X][Y + 1].getVal() +1);
			if((X - 1) >= 0) {
				lista[X - 1][Y].setVal(lista[X - 1][Y].getVal() +1);
				if((Y-1) >= 0)
					lista[X - 1][Y - 1].setVal(lista[X - 1][Y - 1].getVal() +1);
				if((Y + 1) <= MAX_Y)
					lista[X - 1][Y + 1].setVal(lista[X - 1][Y + 1].getVal() +1);
			}
			if((X + 1) <= MAX_X) {
				lista[X + 1][Y].setVal(lista[X + 1][Y].getVal() +1);
				if((Y-1) >= 0)
					lista[X + 1][Y - 1].setVal(lista[X + 1][Y - 1].getVal() +1);
				if((Y+1) <= MAX_Y)
					lista[X + 1][Y + 1].setVal(lista[X + 1][Y + 1].getVal() +1); 
			}
		}
	
	/**
	 * Aggiunge un edificio pubblico e aumenta il valore del settore di 1
	 * @param Nuovo
	 * @param X
	 * @param Y
	 */
	private void addepub(Lotti Nuovo, int X, int Y) {
		lista[X][Y] = Nuovo;
		this.setValore(this.getValore() + 1);
	}
	
	private void addepriv(Lotti Nuovo, int X, int Y) {
		lista[X][Y] = Nuovo;
	}
	
	/**
	 * Rimuovi la strada ed elimina il bonus agli edifici adiacenti
	 * @param X
	 * @param Y
	 */
	private void rmStrada(int X, int Y) {
		lista[X][Y].setVal(0);
		lista[X][Y].setTip(0);
		/*
		lista[X][Y - 1].setVal(lista[X][Y - 1].getVal() -1);
		lista[X][Y + 1].setVal(lista[X][Y + 1].getVal() -1);
		lista[X - 1][Y].setVal(lista[X - 1][Y].getVal() -1);
		lista[X - 1][Y - 1].setVal(lista[X - 1][Y - 1].getVal() -1);
		lista[X - 1][Y + 1].setVal(lista[X - 1][Y + 1].getVal() -1);
		lista[X + 1][Y].setVal(lista[X + 1][Y].getVal() -1);
		lista[X + 1][Y - 1].setVal(lista[X + 1][Y - 1].getVal() -1);
		lista[X + 1][Y + 1].setVal(lista[X + 1][Y + 1].getVal() -1); */
	}
	
	/**
	 * Rimuovi l'edificio pubblico e rimuove il +1 bonus
	 * @param X
	 * @param Y
	 */
	
	private void rmepub(int X,int Y) {
		lista[X][Y].setTip(0);
		lista[X][Y].setVal(0);
		this.setValore(this.getValore() - 1);
	
	}
	
	
	private void rmepriv(int X,int Y) {
		lista[X][Y].setTip(0);
		lista[X][Y].setVal(0);
	}
	
	public int calcolaLotti() {
		int totale = 0;
		totale+=calcolaLottiLiberi();
		totale+=calcolaLottiPrivati();
		totale+=calcolaLottiPubblici();
		totale+=calcolaStrade();
		return totale;
	}
	
	public int calcolaLottiLiberi() {
		int lottiLiberi = 0;
		for(int i = 0; i <= MAX_X ; i++ ) {
			for(int j=0;j <= MAX_Y; j++) {
				if(lista[i][j].getTip() == 0)
					lottiLiberi++;
			}
				
		}
		
		return lottiLiberi;
	}
	
	public int calcolaStrade() {
		int strade = 0;
		for(int i = 0; i <= MAX_X ; i++ ) {
			for(int j=0;j <= MAX_Y; j++) {
				if(lista[i][j].getTip() == 1)
					strade++;
			}
				
		}
		
		return strade;
	}
	
	
	public int calcolaLottiPubblici() {
		int lottiPubblici = 0;
		for(int i = 0; i <= MAX_X ; i++ ) {
			for(int j=0;j <= MAX_Y; j++) {
				if(lista[i][j].getTip() == 2)
					lottiPubblici++;
			}
				
		}
		
		return lottiPubblici;
	}
	

	public int calcolaLottiPrivati() {
		int lottiPrivati = 0;
		for(int i = 0; i <= MAX_X ; i++ ) {
			for(int j=0;j <= MAX_Y; j++) {
				if(lista[i][j].getTip() == 3)
					lottiPrivati++;
			}
				
		}
		
		return lottiPrivati;
	}
	
	public void addOne(int X,int Y) {
		lista[X][Y].setVal(lista[X][Y].getVal() + 1);
	}
	
	public void subOne(int X,int Y) {
		lista[X][Y].setVal(lista[X][Y].getVal() - 1);
	}
	
	public int getValore() {
		return valore;
	}
	public void setValore(int valore) {
		this.valore = valore;
	}



	private static final int MAX_X = 2;
	private static final int MAX_Y = 4;
	private int valore;

	
	
	public Lotti[][] lista;
}
