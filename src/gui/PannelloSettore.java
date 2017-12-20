package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class PannelloSettore extends JPanel {
	private static final long serialVersionUID = 1L;

	private int x = 30;
	private int y = 60;

	private int weight = 300;
	private int height = 100;
	private int settX = 0;
	private int settY = 0;
	
	public PannelloSettore () {
		super();
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				g2.drawRect(x+(weight*i), y+(height*j), weight*i, height*j);

		g2.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		for ( i = 0; i < 3; i++) {
			for ( j = 0; j < 2; j++) {
				g2.drawRect(20+(weight*j), 20+(height*i), weight, height);

			}
		}
		
	}
	
	class Posizione implements MouseListener{

		public void mouseClicked(MouseEvent e) {

			int a = e.getX();
			int b = e.getY();
			
			if (a > 20 && a < 20 +(weight*2) && b > 20 && b < 20+(height*3)) {
				int SettX = a/weight;
				int SettY = b/height;
				
				Graphics2D g3 = null;
				Color colore = new Color (200,200, 200);
				for (int i = 0; i < weight; i++) {
					for (int j=0; j<height;j++) {
						g3.setColor(colore);
						g3.drawLine(SettX,  SettY, weight*SettX, height*SettY);
					}
				repaint();
				}
		}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
		
}
}
