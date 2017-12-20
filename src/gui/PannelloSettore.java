package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PannelloSettore extends JPanel {
	private static final long serialVersionUID = 1L;
	private int cost = 300;
	private int weight = 300;
	private int height = 100;
	
	public PannelloSettore () {
		super();
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				g2.drawRect(20+(weight*j), 20+(height*i), weight, height);
			}
		}
	}
	
}
