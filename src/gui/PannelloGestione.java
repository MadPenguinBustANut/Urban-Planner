package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import centrourbano.CentroUrbano;

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
			pModifica = new JButton ("modifica");
			
			pModifica.addActionListener(new ButtonListener());
			
			
			paPulsanti = new JPanel(new GridLayout(3, 1));
			
			paPulsanti.add(pInvecchia = new JButton ("invecchiamento"));
			paPulsanti.add(pDisastro = new JButton ("disastro"));
			paPulsanti.add(pModifica);
			
			add(informazioni = new JTextArea("PROVA"), BorderLayout.CENTER);
			
			ButtonListener bInv = new ButtonListener();
			add(paPulsanti, BorderLayout.EAST);
		}
		
		
		public class ButtonListener implements ActionListener {

			
			public void actionPerformed(ActionEvent e) {
				JButton rif = (JButton) e.getSource();
				if(rif.getText().equalsIgnoreCase("Modifica")) {
					JFrame io = new JFrame();
					io.add(new PannelloVModifica(centroUrbano.lista[0][0], centroUrbano));
					io.setSize(800, 600);
					io.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					io.setVisible(true);
				}
					
			}
			
		}
		
}
