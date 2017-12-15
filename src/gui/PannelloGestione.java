package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import centrourbano.CentroUrbano;
import intermezzi.Simulazione;

public class PannelloGestione extends JPanel {
	private static final long serialVersionUID = 1L;
		
		private JButton pInvecchia; 
		private JButton pDisastro;
		private JButton pModifica;
		private CentroUrbano centroUrbano;
		
		private JTextArea informazioni;
		
		private JPanel paPulsanti;
		
		
		public PannelloGestione (CentroUrbano c) {
			super(new BorderLayout());
			centroUrbano = c;
						
			paPulsanti = new JPanel(new GridLayout(3, 1));
			
			paPulsanti.add(pInvecchia = new JButton ("invecchiamento"));
			paPulsanti.add(pDisastro = new JButton ("disastro"));
			paPulsanti.add(pModifica = new JButton ("modifica"));
			
			add(informazioni = new JTextArea("PROVA"), BorderLayout.CENTER);
			
			ButtonListener bInv = new ButtonListener();
			
			pInvecchia.addActionListener(bInv);
			add(paPulsanti, BorderLayout.EAST);
		}
		
		
		public class ButtonListener implements ActionListener {

			
			public void actionPerformed(ActionEvent e) {
				Simulazione sim= new Simulazione();
				sim.invecchiamento(centroUrbano);
				informazioni.setText("coefficiente di efficienza aggiornato");
			}
			
		}
			
	}
