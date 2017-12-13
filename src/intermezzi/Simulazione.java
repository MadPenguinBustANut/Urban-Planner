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
		
		
		//modifico ogni elemento circostante
		//per ogni direzione l'operazione cambia
		
		//NORDOVEST
		if ((l1-1)<0){		
			if ((l2-1) < 0){ 	//se c'è un cambio di settore anche per RIGA E COLONNA
				if((s1-1) >= 0){ //se non esce dal riquadro
					set1 = s1-1;
					set2 = s2-1;
					lot1 = 2;
					lot2 = 4;
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
		if ((l1-1) < 0){
			if((s1-1) >= 0){
				set1 = s1-1;
				set2 = s2;
				lot1 = 2;
				lot2 = l2;
			}
		//e se esce dall'array che fa? Lancia un'eccezione?
		}
		else {
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
						lot1 = l1-1;
						lot2 = l2+1;
					}
					else throw new IndexOutOfBoundsException();	
				}
				else throw new IndexOutOfBoundsException();
			}	
			else { //fuori dalla RIGA ma non dalla colonna
				set1 = s1-1;
				set2 = s2;
				lot1 = l1-1;
				lot2 = l2+1;
			}
		}
		else {
			set1 = s1;
			set2 = s2;
			lot1 = l1-1;
			lot2 = l2+1;
		}
	}
	
	
	//EST
	
	//SUDEST
	
	//SUD
	
	//SUDOVEST
	
	//OVEST
	
}

