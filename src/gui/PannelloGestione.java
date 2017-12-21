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
import intermezzi.Simulazione;


/**
 * Il Pannello Gestione contiene una finestra informativa ed una serie di pulsanti 
 * */
public class PannelloGestione extends JPanel {
	private static final long serialVersionUID = 1L;
		
		private JButton pInvecchia; 
		private JButton pDisastro;
		private JButton pModifica;
		private CentroUrbano centroUrbano;
		private Simulazione sim;
		private JTextArea informazioni;
		
		private JPanel paPulsanti;
		
		
		public PannelloGestione (CentroUrbano c) {
			super(new BorderLayout());
			centroUrbano = c;
			pModifica = new JButton ("Modifica");
			pInvecchia = new JButton ("Invecchiamento");
			pDisastro = new JButton ("Disastro");
			
			pModifica.addActionListener(new ButtonListener());
			pInvecchia.addActionListener(new ButtonListener());
			pDisastro.addActionListener(new ButtonListener());
			
			
			sim = new Simulazione();
			
			paPulsanti = new JPanel(new GridLayout(3, 1));
			
			paPulsanti.add(pInvecchia);
			paPulsanti.add(pDisastro);
			paPulsanti.add(pModifica);
			
			add(informazioni = new JTextArea(), BorderLayout.CENTER);
			add(paPulsanti, BorderLayout.EAST);
			informazioni.setText("Effettuare una selezione con i bottoni a destra. Le informazioni verranno mostrare in questo campo \n");
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
					else if(rif.getText().equalsIgnoreCase("Invecchiamento"))
						sim.invecchiamento(centroUrbano);
				
					else if(rif.getText().equalsIgnoreCase("Disastro"))
						sim.disastro(centroUrbano,informazioni);
					
			}
			
		}
			
	}
