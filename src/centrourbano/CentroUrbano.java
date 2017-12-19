package centrourbano;

import java.io.Serializable;

import edifici.Strada;

public class CentroUrbano implements Serializable{
	private static final long serialVersionUID = 1L;

	// Calcolare Numero di settori, lotti, lotti liberi, strade, lotti privati
	
	public CentroUrbano() {
		lista = new Settori[2][3];
		for(int x = 0; x < 2; x++)
			for(int i = 0; i < 3; i++)
				lista[x][i] = new Settori();
		
	}
	
	/** 
	 * Calcola il numero di settori
	 * @return I settori saranno sempre 6, abbiamo deciso di rendere il numero fisso
	 */
	public int numSettori() {
		return 6;
	}
	
	/**
	 * Calcola il numero di Lotti presenti in tutti i settori, compresi i lotti liberi e le strade
	 * scorre ogni settore e usa il loro metodo per calcolare i lotti
	 */
	
	public int numLotti() {
		int totale = 0;
		for(int i = 0; i < MAX_MASTER_X ; i++ ) {
			for(int j=0;j < MAX_MASTER_Y; j++)
				totale = totale + lista[i][j].calcolaLotti();
		}
		
		return totale;
	}
	
	/**
	 * Calcola il numero di lotti liberi presenti in tutti i settori,
	 * scorre ogni settore e usa i loro metodi per calcolare i lotti liberi
	 */
	
	public int numLottiLiberi() {
		int totale = 0;
		for(int i = 0; i < MAX_MASTER_X ; i++ ) {
			for(int j=0;j < MAX_MASTER_Y; j++)
				totale = totale +lista[i][j].calcolaLottiLiberi();
		}
		
		return totale;
	}
	
	/**
	 * Calcola il numero di lotti pubblici presenti in tutti i settori,
	 * scorre ogni settore e usa i loro metodi per calcolare i lotti pubblici
	 */
	
	public int numLottiPubblici() {
		int totale = 0;
		for(int i = 0; i < MAX_MASTER_X ; i++ ) {
			for(int j=0;j < MAX_MASTER_Y; j++)
				totale = totale +lista[i][j].calcolaLottiPubblici();
		}
		
		return totale;
	}
	
	/**
	 * Calcola il numero di lotti privati presenti in tutti i settori,
	 * scorre ogni settore e usa i loro metodi per calcolare i lotti privati
	 */
	
	public int numLottiPrivati() {
		int totale = 0;
		for(int i = 0; i < MAX_MASTER_X ; i++ ) {
			for(int j=0;j < MAX_MASTER_Y; j++)
				totale = totale +lista[i][j].calcolaLottiPrivati();
		}
		
		return totale;
	}
	
	/**
	 * Calcola il numero di strade presenti in tutti i settori,
	 * scorre ogni settore e usa i loro metodi per calcolare il numero di strade
	 */
	
	public int numStrade() {
		int totale = 0;
		for(int i = 0; i < MAX_MASTER_X ; i++ ) {
			for(int j=0;j < MAX_MASTER_Y; j++)
				totale = totale +lista[i][j].calcolaStrade();
		}
		
		return totale;
	}
	
	/**
	 * Aggiunge una strada al settore indicato con MasterX e MasterY nelle coordinate indicate
	 * dopo averla aggiunta dovranno anche applicarsi gli effetti speciali della strada,
	 * ovvero aumentare di 1 il valore degli edifici adiacenti
	 * @param Nuovi Lotto da inserire
	 * @param MasterX Coordinata X del settore, insieme a MasterY indica il settore scelto
	 * @param MasterY Coordinata Y del settore, insieme a MasterX indica il settore scelto
	 * @param X Coordinata X del lotto, insieme a Y indica dove verra posizionato il lotto
	 * @param Y Coordinata Y del lotto, insieme a X indica dove verra posizionato il lotto
	 */
	public void addStrada(int MasterX, int MasterY,int X ,int Y) {
	
		if(X==MAX_X && Y < MAX_Y) {
			if((MasterX + 1) < MAX_MASTER_X)
				lista[MasterX + 1][MasterY].addOne(0, Y);
		}
		
		if(X < MAX_X && Y == MAX_Y) {
			if((MasterY + 1) < MAX_MASTER_Y)
				lista[MasterX][MasterY + 1].addOne(X, 0);
		}
		
		if(X==MAX_X && Y == MAX_Y) {
			if((MasterX + 1) < MAX_MASTER_X)
				lista[MasterX + 1][MasterY].addOne(0, Y);

			if((MasterY + 1) < MAX_MASTER_Y)
				lista[MasterX][MasterY + 1].addOne(X, 0);
			
			if(((MasterX + 1) < MAX_MASTER_X) && ((MasterY + 1) < MAX_MASTER_Y))
				lista[MasterX + 1][MasterY + 1].addOne(0, 0);
			
			return;
		}
		
		if(X==MAX_X && Y == 0) {
			lista[MasterX + 1][MasterY - 1].addOne(0, MAX_Y);
		}
		
		if(X==0 && Y == MAX_Y) {
			lista[MasterX -1][MasterY + 1].addOne(MAX_X, 0);
		}
		
		if(X==0 && Y >0) {
			if((MasterX - 1) >-1)
				lista[MasterX - 1][MasterY].addOne(MAX_X, Y);
		}
		
		if(X>0 && Y ==0) {
			if((MasterY - 1) >-1)
				lista[MasterX][MasterY - 1].addOne(X, MAX_Y);
		}
		
		if(X==0 && Y ==0) {
			if((MasterY - 1) >-1)
				lista[MasterX][MasterY - 1].addOne(X, MAX_Y);
			
			if((MasterX - 1) >-1)
				lista[MasterX - 1][MasterY].addOne(MAX_X, Y);
			
			if(((MasterX - 1) >-1) && ((MasterY - 1) >-1))
				lista[MasterX - 1][MasterY].addOne(MAX_X, MAX_Y);
			
			return;

		}
		
		lista[MasterX][MasterY].addLotto(new Strada(), X, Y);
			
	}
	

	/**
	 * Rimuove la strada dal settore indicato con MasterX e MasterY nelle coordinate indicate
	 * dopo averla rimossa dovranno anche togliersi gli effetti speciali della strada,
	 * ovvero aumentare di 1 il valore degli edifici adiacenti
	 * @param MasterX Coordinata X del settore, insieme a MasterY indica il settore scelto
	 * @param MasterY Coordinata Y del settore, insieme a MasterX indica il settore scelto
	 * @param X Coordinata X del lotto, insieme a Y indica dove verra posizionato il lotto
	 * @param Y Coordinata Y del lotto, insieme a X indica dove verra posizionato il lotto
	 */
	
	public void rmStrada(int MasterX, int MasterY,int X ,int Y) {
		
		if(X==MAX_X && Y < MAX_Y) {
			if((MasterX + 1) < MAX_MASTER_X)
				lista[MasterX + 1][MasterY].subOne(0, Y);
		}
		
		if(X < MAX_X && Y == MAX_Y) {
			if((MasterY + 1) < MAX_MASTER_Y)
				lista[MasterX][MasterY + 1].subOne(X, 0);
		}
		
		if(X==MAX_X && Y == MAX_Y) {
			if((MasterX + 1) < MAX_MASTER_X)
				lista[MasterX + 1][MasterY].subOne(0, Y);

			if((MasterY + 1) < MAX_MASTER_Y)
				lista[MasterX][MasterY + 1].subOne(X, 0);
			
			if(((MasterX + 1) < MAX_MASTER_X) && ((MasterY + 1) < MAX_MASTER_Y))
				lista[MasterX + 1][MasterY + 1].subOne(0, 0);
			
			return;
		}
		
		if(X==MAX_X && Y == 0) {
			lista[MasterX + 1][MasterY - 1].subOne(0, MAX_Y);
		}
		
		if(X==0 && Y == MAX_Y) {
			lista[MasterX -1][MasterY + 1].subOne(MAX_X, 0);
		}
		
		if(X==0 && Y >0) {
			if((MasterX - 1) >-1)
				lista[MasterX - 1][MasterY].subOne(MAX_X, Y);
		}
		
		if(X>0 && Y ==0) {
			if((MasterY - 1) >-1)
				lista[MasterX][MasterY - 1].subOne(X, MAX_Y);
		}
		
		if(X==0 && Y ==0) {
			if((MasterY - 1) >-1)
				lista[MasterX][MasterY - 1].subOne(X, MAX_Y);
			
			if((MasterX - 1) >-1)
				lista[MasterX - 1][MasterY].subOne(MAX_X, Y);
			
			if(((MasterX - 1) >-1) && ((MasterY - 1) >-1))
				lista[MasterX - 1][MasterY].subOne(MAX_X, MAX_Y);
			
			return;

		}
		
		
		lista[MasterX][MasterY].rmLotto(X, Y);
			
	}

	//Ho associato delle MACRO ai limiti del settore in modo da rendere piu leggibile il codice
	private static final int MAX_X = 2;
	private static final int MAX_Y = 4;
	

	//Ho associato delle MACRO ai limiti del centrourbano in modo da rendere piu leggibile il codice
	private static final int MAX_MASTER_X = 2;
	private static final int MAX_MASTER_Y = 3;
	public Settori[][] lista;
}
