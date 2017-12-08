package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
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
		}
	
	
	public int Z = 5;
	
	
	public void paintComponent(Graphics g) {
		Graphics2D u = (Graphics2D) g;
		u.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		
		
		
		int i, j;
		for(i = 0; i < 15 ;i++ ) {
			for(j = 0; j < 6; j++) {
				u.drawRect(PX+(L*i*Z), PY+(L*j*Z), L*Z, L*Z);
				
				switch(rifer.lista[j%2][i%3].lista[j%3][i%5].getTip()) {
				case 1:	paintStrada(u, PX+(L*1*Z), PY+(L*0*Z), L*Z, i, j);
						break;
				case 2:	paintPub(u,PX+(L*1*Z), PY+(L*0*Z), L*Z); 
						break;
				case 3: paintPriv(u, PX+(L*i*Z), PY+(L*j*Z), L*Z); 
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

		int settX, settY, lottX, lottY;
		
		settX = j%2; settY = j%3; lottX = j%3; lottY = i%5;
		
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
	
	private class VisualListener implements MouseInputListener{
		
		Point pos = new Point(0, 0);
		PannelloVisualizzazione rifer;
		
		public VisualListener(PannelloVisualizzazione e) {
			rifer = e;
		}
		
		public void mouseClicked(MouseEvent e) {
			if(e.getPoint() == pos)
				return;
			
			JFrame io = new JFrame("Lotto");
			io.setSize(300, 500);
			io.setVisible(true);
			io.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
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