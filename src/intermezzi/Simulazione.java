package intermezzi;

import java.util.Random;

import centrourbano.CentroUrbano;
import centrourbano.Lotti;
import centrourbano.Settori;
import edifici.EPubblico;
import edifici.Edificabile;
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
	public void disastro (CentroUrbano centro) {
	
	//genero numeri casuali per determinare settore e lotto
		Random random = new Random(System.currentTimeMillis());
		int s1 = random.nextInt(2);
		int s2 = random.nextInt(3);
		int l1= random.nextInt(3);
		int l2= random.nextInt(5);
		int d1= random.nextInt(100); //coefficiente di efficenza può essere anche azzerato;
		
		//seleziono il lotto casuale usando i numeri generati prima
		centro.lista[s1][s2].lista[l1][l2].setCeff(centro.lista[s1][s2].lista[l1][l2].getCeff()-d1);
	
	
		int set1 = -1;
		int set2 = -1;
		int lot1 = -1;
		int lot2 = -1;
				
		//NORDOVEST
		if ((l1-1) < 0){		  //quando la x del lotto e' uguale a 0
			if ((l2-1) < 0){ 		//quando la y del lotto e' 0		//se c'e' un cambio di settore per RIGA E COLONNA
				if((s1-1) > -1){ 			//se non esce dal riquadro
					if ((s2-1) > -1) {
						set1 = s1-1;
						set2 = s2-1;
						lot1 = 2;
						lot2 = 4;
					}
				}
			}
			else { 			//se c'è solo un cambio di settore SOLO PER RIGA
			set1 = s1-1;
			set2 = s2;
			lot1 = 2;
			lot2 = l2;
			}
		}
			else if ((l2-1)<0){ //se c'è un cambio di settore SOLO PER COLONNA 
			if ((s2-1)>0)
			set1 = s1;
			set2 = s2-1;
			lot1 = l1;
			lot2 = 4;	
			}   
			else {
			set1 = s1;
			set2 = s2;
			lot1 = l1-1;
			lot2 = l2-1;
		}
		
		centro.lista[set1][set2].lista[lot1][lot2].setCeff(centro.lista[set1][set2].lista[lot1][lot2].getCeff()-(d1/3));	
	
	//NORD
		if ((l1-1) < 0){				//cambio settore per riga
			if((s1-1) >= 0){			//se non esce
				set1 = s1-1;
				set2 = s2;
				lot1 = 2;
				lot2 = l2;
			}
		}
		else {							//se non cambia settore
			set1 = s1;
			set2 = s2;
			lot1 = l1-1;
			lot2 = l2;
		}
	
		//NORDEST
		if ((l1-1) < 0){
			if ((l2 + 1) > 4){
				if ((s1-1) >= 0){ // fuori da RIGA E COLONNA
					if ((s2+1) < 3){ 
						set1 = s1-1;
						set2 = s2+1;
						lot1 = 2;
						lot2 = 0;
					}
				}
				else throw new IndexOutOfBoundsException();
			}	
			else { //fuori dalla RIGA ma non dalla colonna
				set1 = s1-1;
				set2 = s2;
				lot1 = 2;
				lot2 = l2+1;
			}
		}
		else {

		if((set1!=-1) && (set2!=-1) && (lot1!=-1) && (lot2!=-1))
			centro.lista[set1][set2].lista[lot1][lot2].setCeff(centro.lista[set1][set2].lista[lot1][lot2].getCeff()-(d1/3));
			
	
		//EST
		if ((l2+1) > 4) {					//cambio settore per riga
			if((s2+1) < 2) {
				set1 = s1;
				set2 = s2+1;
				lot1 = l1;
				lot2 = 0;
			}

		}
		else {								//nessun cambio settore
			set1 = s1;
			set2 = s2;
			lot1 = l1;
			lot2 = l2+1;
		}
	
		if((set1!=-1) && (set2!=-1) && (lot1!=-1) && (lot2!=-1))
			centro.lista[set1][set2].lista[lot1][lot2].setCeff(centro.lista[set1][set2].lista[lot1][lot2].getCeff()-(d1/3));
	
		//SUDEST
		if((l1+1) > 2) {
			if ((l2+1) > 2) {
				if((s1+1) < 2) {
					if ((s2+1) < 3) {		//cambio settore per riga e colonna
						set1 = s1+1;
						set2 = s2+1;
						lot1 = 0;
						lot2 = 0;
					}
				}
			}
			else if ((s1+1) < 3){			//cambio settore per riga
				set1 = s1+1;
				set2 = s2;
				lot1 = 0;
				lot2 = l2+1;
			}
		}
		else if ((l2 + 1) > 2){ 			//cambio di settore per colonna
			if ((s2+1) < 2) {	
				set1 = s1;
				set2 = s2+1;
				lot1 = l1+1;
				lot2 = 0;
			}
		}	
		else {								//nessun cambio di settore
			set1 = s1;
			set2 = s2;
			lot1 = l1+1;
			lot2 = l2+1;
		}
	
		if((set1!=-1) && (set2!=-1) && (lot1!=-1) && (lot2!=-1))
			centro.lista[set1][set2].lista[lot1][lot2].setCeff(centro.lista[set1][set2].lista[lot1][lot2].getCeff()-(d1/3));
		
		//SUD
		if ((l1+1) > 2) {					//cambio di settore per riga
			if((s1+1) < 2) {
				set1 = s1+1;
				set2 = s2;
				lot1 = 0;
				lot2 = l2;
			}
		}
		else {								//nessun cambio di settore
			set1 = s1;
			set2 = s2;
			lot1 = l1+1;
			lot2 = l2;
		}
	
		if((set1!=-1) && (set2!=-1) && (lot1!=-1) && (lot2!=-1))
			centro.lista[set1][set2].lista[lot1][lot2].setCeff(centro.lista[set1][set2].lista[lot1][lot2].getCeff()-(d1/3));
		
		//SUDOVEST							
		if((l1+1) < 0) {
			if((l2-1) < 0) {
				if((s1+1) < 2) {			//cambio di settore per riga e colonna
					if((s2-1) >= 0) {
						set1 = s1+1;
						set2 = s2-1;
						lot1 = 0;
						lot2 = 4;
					}
				}
			}
			else if ((s1+1) < 2) {							//cambio di settore per riga
				set1 = s1+1;
				set2 = s2;
				lot1 = 4;
				lot2 = l2-1;
			}
		}
		else if ((l2-1) < 0) {								//cambio di seettore per colonna
			if ((s2-1) >= 0) {
				set1 = s1;
				set2 = s2-1;
				lot1 = l1+1;
				lot2 = 4;
			}
		}
		else {												//nessun cambio di settore
			set1 = s1;
			set2 = s2; 
			lot1 = l1-1;
			lot2 = l2+1;
		}
	
	if((set1!=-1) && (set2!=-1) && (lot1!=-1) && (lot2!=-1))
		centro.lista[set1][set2].lista[lot1][lot2].setCeff(centro.lista[set1][set2].lista[lot1][lot2].getCeff()-(d1/3));
	
	//OVEST
		if((l1-1) < 0) {
			if ((s1-1) >=0){
				set1 = s1-1;
				set2 = s2;
				lot1 = 4;
				lot2 = l2;
			}
		}
		else {
			set1 = s1;
			set2 = s2;
			lot1 = l1-1;
			lot2 = l2;
		}
		
		if((set1!=-1) && (set2!=-1) && (lot1!=-1) && (lot2!=-1))
			centro.lista[set1][set2].lista[lot1][lot2].setCeff(centro.lista[set1][set2].lista[lot1][lot2].getCeff()-(d1/3));
	}
}
}