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
	 * Aggiunge una strada al settore indicato con settX e settY nelle coordinate indicate
	 * dopo averla aggiunta dovranno anche applicarsi gli effetti speciali della strada,
	 * ovvero aumentare di 1 il valore degli edifici adiacenti
	 * @param Nuovi Lotto da inserire
	 * @param settX Coordinata X del settore, insieme a settY indica il settore scelto
	 * @param settY Coordinata Y del settore, insieme a settX indica il settore scelto
	 * @param X Coordinata X del lotto, insieme a Y indica dove verra posizionato il lotto
	 * @param Y Coordinata Y del lotto, insieme a X indica dove verra posizionato il lotto
	 */
	public void addStrada(int settX, int settY,int LX ,int LY) {
	
		if(LX==MAX_X && LY < MAX_Y) {
			if((settX + 1) < MAX_MASTER_X)
				lista[(int) (settX + 1)][(int) settY].addOne(0, LY);
		}
		
		if(LX < MAX_X && LY == MAX_Y) {
			if((settY + 1) < MAX_MASTER_Y)
				 lista[settX][(settY + 1)].addOne(LX, 0);
		}
		
		if(LX==MAX_X && LY == MAX_Y) {
			if((settX + 1) < MAX_MASTER_X && (settY - 1) >-1)
				lista[(int) (settX + 1)][(int) (settY - 1)].addOne(0, MAX_Y);			
	
		}
		
		if(LX==MAX_X && LY == 0) {
			if((settX + 1) < MAX_MASTER_X)
				lista[(int) (settX + 1)][(int) settY].addOne(0, LY);

			if((settY - 1) > -1)
				lista[(int) settX][(int) (settY - 1)].addOne(LX, 0);
			
			if(((settX + 1) < MAX_MASTER_X) && ((settY - 1) < MAX_MASTER_Y))
				lista[(int) (settX + 1)][(int) (settY - 1)].addOne(0, 0);
			
			return;
		}
		
		if(LX==0 && LY == MAX_Y) {
			
			if((settY + 1) < MAX_MASTER_Y)
				lista[(int) settX][(int) (settY + 1)].addOne(LX, 0);
			
			if((settX - 1) >-1)
				lista[(int) (settX - 1)][(int) settY].addOne(MAX_X, LY);
			
			if(((settX - 1) >-1) && ((settY + 1) < MAX_MASTER_Y))
				lista[(int) (settX - 1)][(int) settY + 1].addOne(MAX_X, 0);
			
			return;
		}
		
		if(LX==0 && LY >0) {
			if((settX - 1) >-1)
				lista[(int) (settX - 1)][(int) settY].addOne(MAX_X, LY);
		}
		
		if(LX>0 && LY ==0) {
			if((settY - 1) > -1)
				lista[(int) settX][(int) (settY - 1)].addOne(LX, MAX_Y);
		}
		
		if(LX==0 && LY ==0) {
			
			if((settX - 1) >-1 && (settY + 1) < MAX_MASTER_Y)
				lista[(int) (settX -1)][(int) (settY + 1)].addOne(MAX_X, 0);

		}
		
		lista[(int) settX][(int) settY].addLotto(new Strada(), LX, LY);
			
	}
	

	/**
	 * Rimuove la strada dal settore indicato con settX e settY nelle coordinate indicate
	 * dopo averla rimossa dovranno anche togliersi gli effetti speciali della strada,
	 * ovvero aumentare di 1 il valore degli edifici adiacenti
	 * @param settX Coordinata X del settore, insieme a settY indica il settore scelto
	 * @param settY Coordinata Y del settore, insieme a settX indica il settore scelto
	 * @param lX Coordinata X del lotto, insieme a Y indica dove verra posizionato il lotto
	 * @param lY Coordinata Y del lotto, insieme a X indica dove verra posizionato il lotto
	 */
	
	public void rmStrada(int settX, int settY,int LX ,int LY) {
		

		if(LX==MAX_X && LY < MAX_Y) {
			if((settX + 1) < MAX_MASTER_X)
				lista[(int) (settX + 1)][(int) settY].subOne(0, LY);
		}
		
		if(LX < MAX_X && LY == MAX_Y) {
			if((settY - 1) > -1)
				 lista[settX][(settY - 1)].subOne(LX, 0);
		}
		
		if(LX==MAX_X && LY == MAX_Y) {
			if((settX + 1) < MAX_MASTER_X && (settY - 1) >-1)
				lista[(int) (settX + 1)][(int) (settY - 1)].subOne(0, MAX_Y);			
	
		}
		
		if(LX==MAX_X && LY == 0) {
			if((settX + 1) < MAX_MASTER_X)
				lista[(int) (settX + 1)][(int) settY].subOne(0, LY);

			if((settY - 1) > -1)
				lista[(int) settX][(int) (settY - 1)].subOne(LX, 0);
			
			if(((settX + 1) < MAX_MASTER_X) && ((settY - 1) < MAX_MASTER_Y))
				lista[(int) (settX + 1)][(int) (settY - 1)].subOne(0, 0);
			
			return;
		}
		
		if(LX==0 && LY == MAX_Y) {
			
			if((settY + 1) < MAX_MASTER_Y)
				lista[(int) settX][(int) (settY + 1)].subOne(LX, 0);
			
			if((settX - 1) >-1)
				lista[(int) (settX - 1)][(int) settY].subOne(MAX_X, LY);
			
			if(((settX - 1) >-1) && ((settY + 1) < MAX_MASTER_Y))
				lista[(int) (settX - 1)][(int) settY + 1].subOne(MAX_X, 0);
			
			return;
		}
		
		if(LX==0 && LY >0) {
			if((settX - 1) >-1)
				lista[(int) (settX - 1)][(int) settY].subOne(MAX_X, LY);
		}
		
		if(LX>0 && LY ==0) {
			if((settY - 1) > -1)
				lista[(int) settX][(int) (settY - 1)].subOne(LX, MAX_Y);
		}
		
		if(LX==0 && LY ==0) {
			
			if((settX - 1) >-1 && (settY + 1) < MAX_MASTER_Y)
				lista[(int) (settX -1)][(int) (settY + 1)].subOne(MAX_X, 0);

		}
		
		lista[(int) settX][(int) settY].addLotto(new Strada(), LX, LY);
			
		
		lista[(int) settX][(int) settY].rmLotto(LX, LY);
			
	}

	//Ho associato delle MACRO ai limiti del settore in modo da rendere piu leggibile il codice
	private static final int MAX_X = 2;
	private static final int MAX_Y = 4;
	

	//Ho associato delle MACRO ai limiti del centrourbano in modo da rendere piu leggibile il codice
	private static final int MAX_MASTER_X = 2;
	private static final int MAX_MASTER_Y = 3;
	public Settori[][] lista;
}
