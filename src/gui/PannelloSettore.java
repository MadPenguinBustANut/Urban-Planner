package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PannelloSettore extends JPanel {
	private static final long serialVersionUID = 1L;

	private int x = 30;
	private int y = 60;

	private int weight = 300;
	private int height = 100;
	private int settX = 0;
	private int settY = 0;
	private FrameModifica rifer;
	boolean[][] arrayB = new boolean[2][3];
	boolean tr = false;
	
	
	public PannelloSettore (FrameModifica e) {
		super();
		addMouseListener(new Posizione());
		rifer = e;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				g2.drawRect(20+(weight*j), 20+(height*i), weight, height);
				if(arrayB[j][i] == true) {
					g2.setColor(Color.YELLOW);
					g2.fillRect(21+(weight*j), 21+(height*i), weight-2, height-2);
					g2.setColor(Color.BLACK);
			}
		}	
	}
}
	
	class Posizione implements MouseListener{

		public void mouseClicked(MouseEvent e) {

			if(tr) {
				tr = false;
			}
			else tr = true;
			
			int a = e.getX();
			int b = e.getY();
			
			if (a > 20 && a < 20 +(weight*2) && b > 20 && b < 20+(height*3)) {
				settX = a/weight;
				settY = b/height;
				for(int i = 0; i < 2; i++) {
					for(int j = 0; i < 3; i++) {
						arrayB[j][i] = false;
					}
				}
				
				arrayB[settX][settY] = true;
				repaint();
				}
			}
		

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

		



