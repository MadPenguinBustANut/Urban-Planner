package intermezzi;

import java.util.Random;

import javax.swing.JTextArea;

import centrourbano.CentroUrbano;
import centrourbano.Lotti;
import edifici.EPubblico;
/**
 * In questa classe si simulano l'invecchiamento del Centro Urbano e la gestione di un disastro. 
 * L'invecchiamento fa diminuire il coefficiente di efficienza. In caso di secondo invecchiamento di un edificio pubblico, questo viene distrutto.
 * Il disastro viene generato in un lotto determinato casualmente. Esso apporta una modifica sostanziosa (un numero casuale da 1 a 100) 
 * del coefficiente di efficienza del lotto colpito dal disastro e una modifica ridotta (quel numero casuale /3), a tutti settori circostanti. 
 * 
 * */
public class Simulazione {
	
	public Simulazione() {
	}
	
	
	/**
	 * RICEVE: @param CentroUrbano e ne modifica il coefficiente di efficienza di ogni lotto in ogni settore 
	 * moltiplicandolo per il suo coefficiente di invecchiamento /100
	 * */
	public void invecchiamento (CentroUrbano centro) {
		for(int a = 0; a < 2; a++) {
			for(int b = 0; b < 3; b++) {
				for(int c = 0; c < 3; c++) {
					for(int d = 0; d< 5; d++) {
						Lotti k = centro.lista[a][b].lista[c][d];
						k.setCeff(k.getCeff()-(k.getCeff()*k.getCinv())/100);
						if(k.getTip() == 2) {
							EPubblico u = (EPubblico) k.edificio;
							System.out.println("Stato="+u.getStato());
							if(u.getStato() > 1)
								centro.lista[a][b].rmLotto(c, d);
							else if(u.getStato() == 1)  u.addStato();
						}
					}
				}
			}
		}
	}
	
	/**
	 * RICEVE: @param CentroUrbano
	 * seleziona un lotto causale, ne modifica il coefficiente di efficienza sottraendo ad esso un numero causale da 1 a 100)
	 * poi modifica tutti i lotti circostanti sottraendo al loro coefficiente di efficienza un terzo di quel numero casuale
	 * */
	public void disastro (CentroUrbano centro,JTextArea informazioni) {
	
	//genero numeri casuali per determinare settore e lotto
		Random random = new Random(System.currentTimeMillis());
		int settX = random.nextInt(2);
		int settY = random.nextInt(3);
		int LY= random.nextInt(5);
		int LX= random.nextInt(3);
		int d1= random.nextInt(100); //coefficiente di efficenza può essere anche azzerato;
		
		//seleziono il lotto casuale usando i numeri generati prima
		centro.lista[settX][settY].lista[LX][LY].setCeff(centro.lista[settX][settY].lista[LX][LY].getCeff()-d1);
		informazioni.append("Il disastro e' avvenuto nel settore " + settY + " " + settX + " al lotto " +LX + " " + LY  + "\n");
		

		if(LX==MAX_X && LY < MAX_Y) {
			if((settX + 1) < MAX_MASTER_X)
				centro.lista[(int) (settX + 1)][(int) settY].subCeff(d1,0, LY);
		}
		
		if(LX < MAX_X && LY == MAX_Y) {
			if((settY + 1) < MAX_MASTER_Y)
				 centro.lista[settX][(settY + 1)].subCeff(d1,LX, 0);
		}
		
		if(LX==MAX_X && LY == MAX_Y) {
			if((settX + 1) < MAX_MASTER_X && (settY + 1) <MAX_MASTER_Y)
				centro.lista[(int) (settX + 1)][(int) (settY + 1)].subCeff(d1,0, MAX_Y);			
	
		}
		
		if(LX==MAX_X && LY == 0) {
			if((settX + 1) < MAX_MASTER_X)
				centro.lista[(int) (settX + 1)][(int) settY].subCeff(d1,0, LY);

			if((settY - 1) > -1)
				centro.lista[(int) settX][(int) (settY - 1)].subCeff(d1,LX, 0);
			
			if(((settX + 1) < MAX_MASTER_X) && ((settY - 1) > -1))
				centro.lista[(int) (settX + 1)][(int) (settY - 1)].subCeff(d1,0, 0);
			
			return;
		}
		
		if(LX==0 && LY == MAX_Y) {
			
			if((settY + 1) < MAX_MASTER_Y)
				centro.lista[(int) settX][(int) (settY + 1)].subCeff(d1,LX, 0);
			
			if((settX - 1) >-1)
				centro.lista[(int) (settX - 1)][(int) settY].subCeff(d1,MAX_X, LY);
			
			if(((settX - 1) >-1) && ((settY + 1) < MAX_MASTER_Y))
				centro.lista[(int) (settX - 1)][(int) settY + 1].subCeff(d1,MAX_X, 0);
			
			return;
		}
		
		if(LX==0 && LY >0) {
			if((settX - 1) >-1)
				centro.lista[(int) (settX - 1)][(int) settY].subCeff(d1,MAX_X, LY);
		}
		
		if(LX>0 && LY ==0) {
			if((settY - 1) > -1)
				centro.lista[(int) settX][(int) (settY - 1)].subCeff(d1,LX, MAX_Y);
		}
		
		if(LX==0 && LY ==0) {
			
			if((settX - 1) >-1 && (settY + 1) < MAX_MASTER_Y)
				centro.lista[(int) (settX -1)][(int) (settY + 1)].subCeff(d1,MAX_X, 0);

		}
	
	}
	
	//Ho associato delle MACRO ai limiti del settore in modo da rendere piu leggibile il codice
	private static final int MAX_X = 2;
	private static final int MAX_Y = 4;
	

	//Ho associato delle MACRO ai limiti del centrourbano in modo da rendere piu leggibile il codice
	private static final int MAX_MASTER_X = 2;
	private static final int MAX_MASTER_Y = 3;
}