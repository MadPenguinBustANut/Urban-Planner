package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import centrourbano.CentroUrbano;

public class PannelloVisualizzazione extends JPanel {
	private static final long serialVersionUID = 1L;

	CentroUrbano rifer;
	
	public PannelloVisualizzazione(CentroUrbano e) {
		rifer = e;
		}
	
	
	public int Z = 5;
	
	
	public void paintComponent(Graphics g) {
		Graphics2D u = (Graphics2D) g;
		
		
		
		int P = 3;
		int L = 10;
		
		
		int i, j;
		for(i = 0; i < 15 ;i++ ) {
			for(j = 0; j < 6; j++) {
				u.drawRect(P+(L*i*Z), P+(L*j*Z), L*Z, L*Z);
				switch(rifer.lista[j%2][i%3].lista[j%3][i%5].getTip()) {
				case 1:	paintStrada(u, P+(L*1*Z), P+(L*0*Z), L*Z, i, j);
						break;
				case 2:	paintPub(u,P+(L*1*Z), P+(L*0*Z), L*Z); 
						break;
				case 3: paintPriv(u, P+(L*i*Z), P+(L*j*Z), L*Z); 
						break;
				default: break;
				}
			}
		}
		paintStrada(u, P+(L*1*Z), P+(L*0*Z), L*Z, 1, 2);
		
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
		
		if( (i%5) + 1 < 6) {
			
		}
			
	}
	
}
