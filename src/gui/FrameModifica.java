package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameModifica extends JFrame{
	private static final long serialVersionUID = 1L;
	boolean[] arrayB = new boolean [6];
	private int x;
	private int y;
	private int weight;
	private int height;
	
	public FrameModifica () {
		super();
		
		JPanel unPannello = new JPanel();
		PannelloSettore x = new PannelloSettore();
		
		unPannello.add(x);
		add(unPannello);	
		
		setTitle("Modifica");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(500, 750);
		setVisible(true);
	}
	
}
