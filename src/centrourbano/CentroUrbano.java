package centrourbano;

import java.io.Serializable;

public class CentroUrbano implements Serializable{
	private static final long serialVersionUID = 1L;

	// Calcolare Numero di settori, lotti, lotti liberi, strade, lotti privati
	
	public CentroUrbano() {
		lista = new Settori[2][3];
	}
	
	
	
	
	/**
	 * Restituisce il Lotto selezionato (?)
	 * 
	 */
	public Lotti seleLotto(int X, int Y) {
		
		return null;
	}
	
	
	public void addstrada(Lotti Nuovi,int MasterX, int MasterY,int X ,int Y) {
	
		if(X==MAX_X && Y < MAX_Y) {
			if((MasterX + 1) <= MAX_MASTER_X)
				lista[MasterX + 1][MasterY].addOne(0, Y);
		}
		
		if(X < MAX_X && Y == MAX_Y) {
			if((MasterY + 1) <= MAX_MASTER_Y)
				lista[MasterX][MasterY + 1].addOne(X, 0);
		}
		
		if(X==MAX_X && Y == MAX_Y) {
			if(((MasterX + 1) <= MAX_MASTER_X) && ((MasterY + 1) <= MAX_MASTER_Y))
				lista[MasterX + 1][MasterY + 1].addOne(0, 0);
		}
		
		
		if(X==0 && Y >0) {
			if((MasterX - 1) >=0)
				lista[MasterX - 1][MasterY].addOne(MAX_X, Y);
		}
		
		if(X>0 && Y ==0) {
			if((MasterY - 1) >=0)
				lista[MasterX][MasterY - 1].addOne(X, MAX_Y);
		}
		
		if(X==0 && Y ==0) {
			if(((MasterX - 1) >=0) && ((MasterY - 1) >=0))
				lista[MasterX - 1][MasterY].addOne(MAX_X, MAX_Y);

		}
		
		lista[MasterX][MasterY].addLotto(Nuovi, X, Y);
			
	}
	
	public void rmstrada(int MasterX, int MasterY,int X ,int Y) {
		
		if(X==MAX_X && Y < MAX_Y) {
			if((MasterX + 1) <= MAX_MASTER_X)
				lista[MasterX + 1][MasterY].subOne(0, Y);
		}
		
		if(X < MAX_X && Y == MAX_Y) {
			if((MasterY + 1) <= MAX_MASTER_Y)
				lista[MasterX][MasterY + 1].subOne(X, 0);
		}
		
		if(X==MAX_X && Y == MAX_Y) {
			if(((MasterX + 1) <= MAX_MASTER_X) && ((MasterY + 1) <= MAX_MASTER_Y))
				lista[MasterX + 1][MasterY + 1].subOne(0, 0);
		}
		
		
		if(X==0 && Y >0) {
			if((MasterX - 1) >=0)
				lista[MasterX - 1][MasterY].subOne(MAX_X, Y);
		}
		
		if(X>0 && Y ==0) {
			if((MasterY - 1) >=0)
				lista[MasterX][MasterY - 1].subOne(X, MAX_Y);
		}
		
		if(X==0 && Y ==0) {
			if(((MasterX - 1) >=0) && ((MasterY - 1) >=0))
				lista[MasterX - 1][MasterY].subOne(MAX_X, MAX_Y);

		}
		
		lista[MasterX][MasterY].rmLotto(X, Y);
			
	}
	
	private static final int MAX_X = 2;
	private static final int MAX_Y = 4;
	private static final int MAX_MASTER_X = 1;
	private static final int MAX_MASTER_Y = 2;
	public Settori[][] lista;
}
