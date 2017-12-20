package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import centrourbano.CentroUrbano;
import centrourbano.Settori;

public class CreaStrada extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	boolean inizio;
	int primoX,primoY;
	int secondoX,secondoY;
	int PX = 3;
	int PY = 3;
	int L = 10;
	Settori rifer;
	CentroUrbano centro;
	public int Z = 5;
	
	public void paintComponent(Graphics g) {
		Graphics2D u = (Graphics2D) g;
		u.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		int i, j;
		for(i = 0; i < 5 ;i++ ) {
			for(j = 0; j < 3; j++) {
				u.drawRect(PX+(L*i*Z), PY+(L*j*Z), L*Z, L*Z);
				
				//Controllo il tipo del lotto
				switch(rifer.lista[j][i].getTip()) {
				case 1:	paintStrada(u, PX+(L*1*Z), PY+(L*0*Z), L*Z, i, j);	//STRADA
						break;
				case 2:	paintPub(u,PX+(L*1*Z), PY+(L*0*Z), L*Z);			//PUBBLICO
						break;
				case 3: paintPriv(u, PX+(L*i*Z), PY+(L*j*Z), L*Z); 			//PRIVATO
						break;
				default: break;
				}
			}
		}
		
	}
	
	
	private void paintPriv(Graphics2D e, int x, int y, int L) {
		e.drawLine(x+(L/2), y+(L/10), x+(L/10), y+(L/2));
		e.drawLine(x+(L/10), y+(L/2), x+L-(L/10), y+(L/2));
		e.drawLine(x+L-(L/10), y+(L/2), x+(L/2), y+(L/10));
	}
	
	private void paintPub(Graphics2D e, int x, int y, int L) {
		e.drawRect(x+(L/10), y+(L/10), L-(L/5), L-(L/5));
	}
	
	private void paintStrada(Graphics2D e, int x, int y, int L, int i, int j) {
		e.drawLine(x+(L/2), y, x+(L/2), y+L-(L/2));

		//Controllo se i lotti adiacenti hanno una strada
		
		//Destra
		if( (y) == 4 ) {
		}
		else if(rifer.lista[x][y+1].getTip() == 1)
			e.drawLine(x+(L/2), y+(L/2), x+L, y+(L/2));
		
		
		//Basso
		if( (x) == 2) {
		}
		else if(rifer.lista[x+1][y].getTip() == 1)
			e.drawLine(x+(L/2), y+(L/2), x+(L/2), y+L);
		
		
		//Sinistra
		if( (y) == 0 ) {
		}
		else if(rifer.lista[x][y-1].getTip() == 1)
			e.drawLine(x+(L/2), y+(L/2), x, y+(L/2));
		
		
		//Sopra
		if( (x) == 0) {
		}
		else if(rifer.lista[x-1][y].getTip() == 1)
			e.drawLine(x+(L/2), y+(L/2), x+(L/2), y+L);
		
	}
	
	public void mouseClicked(MouseEvent e) {
		if(inizio == true) {
			Point evento = e.getPoint();
			primoX= e.getX();		//FARE IN MODO CHE SI PRENDA LA VERA POSIZIONE
			primoY= e.getY();		//FARE IN MODO CHE SI PRENDA LA VERA POSIZIONE
			inizio = false;
		}
		if(inizio == false) {
			Point evento = e.getPoint();
			secondoX= e.getX();		//FARE IN MODO CHE SI PRENDA LA VERA POSIZIONE
			secondoY= e.getY();		//FARE IN MODO CHE SI PRENDA LA VERA POSIZIONE
			if(controllaPercorso()== true)
				costruisciPercorso();
			inizio = false;
		}
	
	}
	
	private boolean controllaPercorso() {  //DA FINIRE
		if (primoX == secondoX) {
			int diff = primoY - secondoY;
			if(diff < 0) {
				check(primoY,diff);
				}
			if(diff > 0) {
				check(secondoY,diff);
				
			}
		}
		
		if (primoY == secondoY) {
			
		}
		//LANCIA ECCEZZIONE
		return false;
	}
	
	private boolean check(int inizio, int diff) {
		for(int i=inizio;i<diff;i++) {
			//FAI COSA
		}
	}
	
	private void costruisciPercorso() {  //DA FINIRE
		
	}
	
}
