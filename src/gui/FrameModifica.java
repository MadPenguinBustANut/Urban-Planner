package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import centrourbano.CentroUrbano;

public class FrameModifica extends JFrame{
	private static final long serialVersionUID = 1L;
	boolean[] arrayB = new boolean [6];
	private int settX;
	private int settY;
	private CentroUrbano rifer;
	
	public FrameModifica (CentroUrbano e) {
		super("Seleziona settore");
		
		rifer = e;
		
		JPanel io = new JPanel(new BorderLayout());
		PannelloSettore x = new PannelloSettore();
		PannelloPulsanti PPul = new PannelloPulsanti();
		io.add(x, BorderLayout.CENTER);
		io.add(PPul, BorderLayout.EAST);
		PPul.setSize(400, 400);
		add(io);
						
		setTitle("Modifica");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(500, 750);
		setVisible(true);
	}
	
}
