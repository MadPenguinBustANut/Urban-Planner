package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;

import centrourbano.CentroUrbano;
import centrourbano.Settori;
import gui.DatiPanel.MioRicevitore;

public class PannelloVModifica extends JPanel {
	private static final long serialVersionUID = 1L;

	
	int PX = 3;
	int PY = 3;
	int L = 10;
	Settori rifer;
	CentroUrbano centro;
	Point coordinate;
	
	public PannelloVModifica(Settori e, CentroUrbano t, Point a) {
		rifer = e;
		centro = t;
		addMouseListener(new VisualListener(this));
		coordinate = a;
		ActionListener listener = new MioRicevitore();
		Timer timer = new Timer(1000, listener);
		timer.start();
		}
	
	
	public int Z = 5;
	
	class MioRicevitore implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
			
		}
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D u = (Graphics2D) g;
		u.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		int i, j;
		for(i = 0; i < 3 ;i++ ) {
			for(j = 0; j < 5; j++) {
				u.drawRect(PX+(L*j*Z), PY+(L*i*Z), L*Z, L*Z);
				
				//Controllo il tipo del lotto
				switch(rifer.lista[i][j].getTip()) {
				case 1:	paintStrada(u, PX+(L*j*Z), PY+(L*i*Z), L*Z, i, j);	//STRADA
						break;
				case 2:	paintPub(u,PX+(L*j*Z), PY+(L*i*Z), L*Z);			//PUBBLICO
						break;
				case 3: paintPriv(u, PX+(L*j*Z), PY+(L*i*Z), L*Z); 			//PRIVATO
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
		if( (j) == 4 ) {
		}
		else if(rifer.lista[i][j+1].getTip() == 1)
			e.drawLine(x+(L/2), y+(L/2), x+L, y+(L/2));
		
		
		//Basso
		if( (i) == 2) {
		}
		else if(rifer.lista[i+1][j].getTip() == 1)
			e.drawLine(x+(L/2), y+(L/2), x+(L/2), y+L);
		
		
		//Sinistra
		if( (j) == 0 ) {
		}
		else if(rifer.lista[i][j-1].getTip() == 1)
			e.drawLine(x+(L/2), y+(L/2), x, y+(L/2));
		
		
		//Sopra
		if( (i) == 0) {
		}
		else if(rifer.lista[i-1][j].getTip() == 1)
			e.drawLine(x+(L/2), y+(L/2), x+(L/2), y+L);
		
	}
	
	private class VisualListener implements MouseInputListener{
		
		PannelloVModifica rifer;

		FrameLotto io = new FrameLotto();
		
		
		public VisualListener(PannelloVModifica e) {
			rifer = e;
			io.setVisible(false);
		}
		
		public void mouseClicked(MouseEvent e) {
			Point evento = e.getPoint();
			
			//Se il mouse e' all'interno del disegno
			if(evento.getX() > PX & evento.getY() > PY) {
				if(evento.getX() <= PX+(Z*L*5) & evento.getY() <= PY+(Z*L*3)) {
					
					int lx = e.getX()/(L*Z);
					int ly = e.getY()/(L*Z);
					
					
					
					
					Point Lotto = new Point(lx, ly);
					
					

					if(io.isVisible()) {
						io.setVisible(false);
						io.dispose();
						io = new FrameLotto(centro.lista[coordinate.y][coordinate.x].lista[Lotto.y][Lotto.x], centro, coordinate, Lotto);
						io.setSize(300, 500);
						io.setVisible(true);
						io.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
					else {
						io = new FrameLotto(centro.lista[coordinate.y][coordinate.x].lista[Lotto.y][Lotto.x], centro, coordinate, Lotto);
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
