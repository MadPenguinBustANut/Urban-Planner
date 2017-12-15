package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.lang.reflect.Array;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.JFrame;

public class FrameModifica extends JFrame{
	boolean[] arrayB = new boolean [6];
	private int x;
	private int y;
	private int weight;
	private int height;
	
	public FrameModifica () {
		super();
		
		
		
		setTitle("Modifica");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 750);
		setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2= (Graphics2D) g;
		
		
			
	}
	
}
