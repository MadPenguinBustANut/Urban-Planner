package intermezzi;

import java.io.LineNumberInputStream;
import java.util.Random;

import javax.imageio.ImageTypeSpecifier;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import centrourbano.CentroUrbano;
import centrourbano.Lotti;
import centrourbano.Settori;
import edifici.Edificabile;

public class Simulazione {
	
	public Simulazione() {
	}
	
	public void invecchiamento (CentroUrbano centro) {
		for (Settori[]x : centro.lista ) {
			for (Settori a: x) {
				for (Lotti[]c: a.lista) {
					for (Lotti d: c) {
							d.setCeff(d.getCeff()-(d.getCeff()*d.getCinv())/100);
				
				}
			}
		}
	}
	}
	
	public void modificaDisastro (int x, int y, int z, int w) throws IndexOutOfBoundsException{
		
	}
	
	public void disastro (CentroUrbano centro) {
	
	//genero numeri casuali per determinare settore e lotto
		Random random = new Random();
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
		// settando così i valori la catastrofe se avviene al confine subirà due volte le conseguenze. Non riesco a pensare ad un'alternativa utile che non lanci eccezioni
		// dovrei dargli dei luoghi da modificare che non mi servono... o controllo prima di effettuare l'operazione!
		
		
		//modifico ogni elemento circostante
		//per ogni direzione l'operazione cambia
		
		//NORDOVEST
		if ((l1-1) < 0){		
			if ((l2-1) < 0){ 				//se c'è un cambio di settore per RIGA E COLONNA
				if((s1-1) >= 0){ 			//se non esce dal riquadro
					if ((s2-1) >=0) {
					set1 = s1-1;
					set2 = s2-1;
					lot1 = 2;
					lot2 = 4;
					}
				}
			}
			else if ((s1-1) >= 0){ 			//se c'è solo un cambio di settore SOLO PER RIGA
				set1 = s1-1;
				set2 = s2;
				lot1 = 2;
				lot2 = l2;
			}
						 					//se c'è un cambio di settore SOLO PER COLONNA 
		if ((s2-1) > 0)
				set1 = s1;
				set2 = s2-1;
				lot1 = l1;
				lot2 = 4;	
		}  								//se non c'è cambio di settore
		else {
				set1 = s1;
				set2 = s2;
				lot1 = l1-1;
				lot2 = l2-1;
		}	
		
		if((set1!=-1) && (set2!=-1) && (lot1!=-1) && (lot2!=-1))
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
		
		if((set1!=-1) && (set2!=-1) && (lot1!=-1) && (lot2!=-1))
			centro.lista[set1][set2].lista[lot1][lot2].setCeff(centro.lista[set1][set2].lista[lot1][lot2].getCeff()-(d1/3));
	
		//NORDEST
		if ((l1-1) < 0){
			if ((l2 + 1) > 4){			//cambio settore riga e colonna
				if ((s1-1) >= 0){ 		
					if ((s2+1) < 3){ 
						set1 = s1-1;
						set2 = s2+1;
						lot1 = 2;
						lot2 = 0;
					}
			
				}
		
			}	
			else if ((s1-1) >= 0){ 		//cambio settore riga
				
				set1 = s1-1;
				set2 = s2;
				lot1 = 2;
				lot2 = l2+1;
			}
		}
		else if ((l2+1) > 4) {			//cambio settore colonna
			if ((s2+1) < 2) {
				set1 = s1;
				set2 = s2+1;
				lot1 = l1-1;
				lot2 = 0;
			}
		}
		else {							//nessun cambio settore
			set1 = s1;
			set2 = s2;
			lot1 = l1-1;
			lot2 = l2+1;
		}
	
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
			if ((s1-1) >=0) {
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
