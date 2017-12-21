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


/**
 * Il Pannello Gestione contiene una finestra informativa ed una serie di pulsanti 
 * */
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
			pModifica = new JButton ("Modifica");
			
			pModifica.addActionListener(new ButtonListener());
			
			
			paPulsanti = new JPanel(new GridLayout(3, 1));
			
			paPulsanti.add(pInvecchia = new JButton ("Invecchiamento"));
			paPulsanti.add(pDisastro = new JButton ("Disastro"));
			paPulsanti.add(pModifica);
			
			add(informazioni = new JTextArea(), BorderLayout.CENTER);
			add(paPulsanti, BorderLayout.EAST);
			informazioni.setEditable(false);
		}
		
		
		public class ButtonListener implements ActionListener {

			
			public void actionPerformed(ActionEvent e) {
				JButton rif = (JButton) e.getSource();
				if(rif.getText().equalsIgnoreCase("Modifica")) {
					FrameModifica io = new FrameModifica(centroUrbano);
					io.setSize(950, 310);
					io.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					io.setVisible(true);
				}
					
			}
			
		}
			
	}
