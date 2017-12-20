package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import centrourbano.CentroUrbano;

/**
 * Frame che compare al premere del pulsante "Modifica" del Pannello Gestione. 
 * In esso deve essere possibile scegliere tra la costruzione di una strada e la modifica di un settore. 
 * RICEVE: @param centroUrbano
 * GENERA: 	un Frame con un pannello "CreaStrada" o "PannelloVModifica"  
 * */

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
				
				Point newP = new Point(settX, settY);				
				
				JFrame nuovoFrame = new JFrame ();
				CreaStrada nuovaS = new CreaStrada (newP, rifer.lista[settX][settY], rifer);
				nuovoFrame.add(nuovaS);
				nuovoFrame.setSize(400, 400);
				nuovoFrame.setVisible(true);
				nuovoFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
			}
			
			else if(rif.getText().equalsIgnoreCase("modifica settore")) {
				Point newP = new Point(settX, settY);
				JFrame nuovoFrame = new JFrame ();
				PannelloVModifica VMod = new PannelloVModifica(rifer.lista[settX][settY], rifer, newP);
				
				
				nuovoFrame.add(VMod);
				nuovoFrame.setVisible(true);
				nuovoFrame.setSize(400,400);
				nuovoFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		}
			
	}
		
}
