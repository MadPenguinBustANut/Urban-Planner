package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
		JPanel io2 = new JPanel();
		PannelloSettore x = new PannelloSettore();
		JPanel PPul = new JPanel(new GridLayout(1,2));
		
		JButton modStrada = new JButton("crea strada");
		JButton modSettore = new JButton("modifica settore");
		PPul.add(modStrada);
		PPul.add(modSettore);
		
		modStrada.addActionListener(new ButtonListener());
		modSettore.addActionListener(new ButtonListener());
		
		io.add(x, BorderLayout.CENTER);
		io2.add(PPul);
		add(io, BorderLayout.CENTER);
		add(io2, BorderLayout.SOUTH);
		
		
		
		setTitle("Modifica");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(500, 750);
		setVisible(true);
	}
	
	public class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton rif = (JButton) e.getSource();
			if(rif.getText().equalsIgnoreCase("crea strada")) {
				JFrame nuovoFrame = new JFrame ();
				CreaStrada nuovaS = new CreaStrada ();

				nuovoFrame.add(nuovaS);
				setVisible(true);
				setSize(720, 560);
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
			else if(rif.getText().equalsIgnoreCase("modifica settore")) {
				FrameModificaLotto unLotto = new FrameModificaLotto();
			}
		}
			
			
				
		}
		
	
}
