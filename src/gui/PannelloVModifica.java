package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import centrourbano.CentroUrbano;
import centrourbano.Settori;

public class PannelloVModifica extends JPanel {
	private static final long serialVersionUID = 1L;

	
	int PX = 3;
	int PY = 3;
	int L = 10;
	Settori rifer;
	CentroUrbano centro;
	
	public PannelloVModifica(Settori e, CentroUrbano t) {
		rifer = e;
		centro = t;
		addMouseListener(new VisualListener(this));
		}
	
	
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
	
	private class VisualListener implements MouseInputListener{
		
		PannelloVModifica rifer;

		JFrame io = new JFrame("Lotto");
		
		
		public VisualListener(PannelloVModifica e) {
			rifer = e;
		}
		
		public void mouseClicked(MouseEvent e) {
			Point evento = e.getPoint();
			
			//Se il mouse è all'interno del disegno
			if(evento.getX() > PX & evento.getY() > PY) {
				if(evento.getX()+(Z*L*4) < PX+(Z*L*4) & evento.getY()+(Z*L*2) < PY+(Z*L*2)) {

					if(io.isVisible()) {
						io.setVisible(false);
						io.dispose();
						//Inizializzazione a nuovo Lotto
						io.setSize(300, 500);
						io.setVisible(true);
						io.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
					else {
						//Inizializzazione a Lotto
						io.setSize(300, 500);
						io.setVisible(true);
						io.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
					}
				}
			}
		}

		
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		
		public void mousePressed(MouseEvent e) {
		}

		
		public void mouseReleased(MouseEvent e) {
		}


		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}


		public void mouseMoved(MouseEvent arg0) {
				
		}
		
	}
}
