package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PannelloSettore extends JPanel {
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private int weight;
	private int height;
	
	public PannelloSettore () {
		super();
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		for (x = 0; x < 3; x++) {
			for (y = 30; y < 2; y++) {
				g2.drawRect(x, y, weight, height);
			}
		}
	}
	
}
