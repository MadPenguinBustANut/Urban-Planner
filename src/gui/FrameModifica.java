package gui;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;


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
	public int settX;
	public int settY;
	private CentroUrbano rifer;
	
	public FrameModifica (CentroUrbano e) {

		rifer = e;
		JPanel io = new JPanel(new BorderLayout());
		JPanel io2 = new JPanel();
		PannelloSettore x = new PannelloSettore(this);
		JPanel PPul = new JPanel(new GridLayout(1,2));
		
		JButton modStrada = new JButton("Crea strada");
		JButton modSettore = new JButton("Modifica settore");
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
		setSize(300, 300);
		setVisible(true);

	}
	
		public void mouseClicked(MouseEvent e) {
			int a = e.getX();
			int b = e.getY();
			
			if(a > 3 & b > 3) {
				if(a <= 3+(5*10*5) & b <= 3+(5*10*3)) {
					
					 settX = a/(10);
					 settY = b/(10);
			}
		}	
		}
		
		public class ButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				
				JButton rif = (JButton) e.getSource();
				if(rif.getText().equalsIgnoreCase("crea strada")) {
					
					Point newP = new Point(settX, settY);				
					
					JFrame nuovoFrame = new JFrame ();
					CreaStrada nuovaS = new CreaStrada (newP, rifer.getLista()[settX][settY], rifer);
					nuovoFrame.add(nuovaS);
					nuovoFrame.setSize(300, 200);
					nuovoFrame.setVisible(true);
					nuovoFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				}
				
				else if(rif.getText().equalsIgnoreCase("modifica settore")) {
					Point newP = new Point(settY, settX);
					JFrame nuovoFrame = new JFrame ();
					PannelloLotto VMod = new PannelloLotto(rifer.getLista()[settX][settY], rifer, newP);
					
					
					
					nuovoFrame.setTitle("Seleziona il lotto");
					nuovoFrame.add(VMod);
					nuovoFrame.setResizable(false);
					nuovoFrame.setLocation(200, 100);
					nuovoFrame.setSize(270,195);
					nuovoFrame.setResizable(false);
					nuovoFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					nuovoFrame.setVisible(true);
				}	
			}
		}

	}
