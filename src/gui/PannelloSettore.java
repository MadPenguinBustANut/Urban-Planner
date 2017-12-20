package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PannelloSettore extends JPanel {
	private static final long serialVersionUID = 1L;
	private int x = 30;
	private int y = 30;
	private int cost = 30;
	private int weight= 300;
	private int height= 100;
	
	public PannelloSettore () {
		super();
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 30; j < 2; j++) {
				g2.drawRect(x, y, weight*i, height*j);
			}
		}
	}
	
}
