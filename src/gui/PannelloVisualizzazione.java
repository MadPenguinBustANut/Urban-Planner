package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import centrourbano.CentroUrbano;

public class PannelloVisualizzazione extends JPanel {
	private static final long serialVersionUID = 1L;

	
	int PX = 3;
	int PY = 3;
	int L = 10;
	CentroUrbano rifer;
	
	public PannelloVisualizzazione(CentroUrbano e) {
		rifer = e;
		addMouseListener(new VisualListener(this));
		addMouseWheelListener(new Zoomlistener());
		}
	
	
	public int Z = 5;
	
	
	public void paintComponent(Graphics g) {
		Graphics2D u = (Graphics2D) g;
		u.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		
		
		
		int i, j;
		for(i = 0; i < 6 ;i++ ) {
			for(j = 0; j < 15; j++) {
				u.drawRect(PX+(L*i*Z), PY+(L*j*Z), L*Z, L*Z);
				u.drawString(""+ i%2+"-"+ j%3+"", x, y);
//				switch(rifer.lista[i%2][j%3].lista[i%3][j%5].getTip()) {
//				case 1:	paintStrada(u, PX+(L*i*Z), PY+(L*j*Z), L*Z, i, j);
//						break;
//				case 2:	paintPub(u,PX+(L*i*Z), PY+(L*j*Z), L*Z); 
//						break;
//				case 3: paintPriv(u, PX+(L*i*Z), PY+(L*j*Z), L*Z); 
//						break;
//				default: break;
//				}
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
		e.drawLine(x+(L/2), y, x+(L/2), y+(L/2));

		int settX, settY, lottX, lottY;
		
		settX = i%2; settY = j%3; lottX = i%3; lottY = j%5;
		
		//Destra
		if( (lottY) == 4 ) {
			if((settY) != 2) {
				if(rifer.lista[settX][settY+1].lista[lottX][0].getTip() == 1)
					e.drawLine(x+(L/2), y+(L/2), x+L, y+(L/2));
				}
		}
		else if(rifer.lista[settX][settY].lista[lottX][lottY+1].getTip() == 1)
			e.drawLine(x+(L/2), y+(L/2), x+L, y+(L/2));
		
		
		//Basso
		if( (lottX) == 2) {
			if((settX) != 1) {
				if(rifer.lista[settX+1][settY].lista[0][lottY].getTip() == 1)
					e.drawLine(x+(L/2), y+(L/2), x+(L/2), y+L);
				}
		}
		else if(rifer.lista[settX][settY].lista[lottX+1][lottY].getTip() == 1)
			e.drawLine(x+(L/2), y+(L/2), x+(L/2), y+L);
		
		
		//Sinistra
		if( (lottY) == 0 ) {
			if((settY) != 0) {
				if(rifer.lista[settX][settY-1].lista[lottX][4].getTip() == 1)
					e.drawLine(x+(L/2), y+(L/2), x, y+(L/2));
				}
		}
		else if(rifer.lista[settX][settY].lista[lottX][lottY-1].getTip() == 1)
			e.drawLine(x+(L/2), y+(L/2), x, y+(L/2));
		
		
		//Sopra
		if( (lottX) == 0) {
			if((settX) != 0) {
				if(rifer.lista[settX+1][settY].lista[2][lottY].getTip() == 1)
					e.drawLine(x+(L/2), y+(L/2), x+(L/2), y+L);
				}
		}
		else if(rifer.lista[settX][settY].lista[lottX-1][lottY].getTip() == 1)
			e.drawLine(x+(L/2), y+(L/2), x+(L/2), y+L);
		
	}
	
	private class Zoomlistener implements MouseWheelListener{

		
		public void mouseWheelMoved(MouseWheelEvent e) {
			Z -= e.getWheelRotation();
			if(Z > 10) Z = 10;
			if(Z < 1) Z = 1;
			
			repaint();
			
		}
		
	}
	
	private class VisualListener implements MouseInputListener{
		
		Point pos = new Point(0, 0);
		PannelloVisualizzazione rifer;
		
		
		public VisualListener(PannelloVisualizzazione e) {
			rifer = e;
		}
		
		public void mouseClicked(MouseEvent e) {			
		}

		
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		
		public void mousePressed(MouseEvent e) {
			pos = e.getPoint();
		}

		
		public void mouseReleased(MouseEvent e) {
			PX += e.getX()-pos.getX();
			PY += e.getY()-pos.getY();
			rifer.repaint();
		}


		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}


		public void mouseMoved(MouseEvent arg0) {
				
		}
		
	}
}
