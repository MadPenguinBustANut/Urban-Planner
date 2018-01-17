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

		
		
		
		
		/**
	 * 
	 */
	private static final long serialVersionUID = -1604129713682110563L;

		public PannelloGestione (CentroUrbano c) {
			super(new BorderLayout());
			centroUrbano = c;
			pModifica = new JButton ("Modifica");
			pInvecchia = new JButton ("Scorri tempo");
			pDisastro = new JButton ("Genera Disastro");
			pClear= new JButton("Pulisci Log");
			
			pModifica.addActionListener(new ButtonListener());
			pInvecchia.addActionListener(new ButtonListener());
			pDisastro.addActionListener(new ButtonListener());
			pClear.addActionListener(new ButtonListener());
			
			
			sim = new Simulazione();
			
			paPulsanti = new JPanel(new GridLayout(4, 1));
			
			paPulsanti.add(pInvecchia);
			paPulsanti.add(pDisastro);
			paPulsanti.add(pModifica);
			paPulsanti.add(pClear);
			
			add(informazioni = new JTextArea(), BorderLayout.CENTER);
			add(paPulsanti, BorderLayout.EAST);
			informazioni.setText("Effettuare una selezione con i bottoni a destra. Le informazioni verranno mostrare in questo campo. \n"
					+ "'Modifica' permette la modifica dei Settori e degli edificabili nei lotti. \n"
					+ "'Scorri tempo' permettere di far passare del tempo, causando l'invecchiamento \n"
					+ "degli edificabili. \n"
					+ "'Genera Disastro' causerà un disastro (terremoti, uragani, ecc), deteriorando un lotto casuale e i suoi dintorni \n"
					+ " 'Pulisci Log' disattiva gli aiuti e pulisce questa schermata dal testo."
					+ " E' possibile salvare, caricare o chiudere \n il programma  dal menu 'File' \n");
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
					else if(rif.getText().equalsIgnoreCase("Scorri tempo"))
						sim.invecchiamento(centroUrbano,informazioni);
				
					else if(rif.getText().equalsIgnoreCase("Genera Disastro"))
						sim.disastro(centroUrbano,informazioni);
					else if(rif.getText().equalsIgnoreCase("Pulisci Log"))
						informazioni.setText("");
			}
			
		}
		private JButton pInvecchia,pDisastro,pModifica,pClear;
		private CentroUrbano centroUrbano;
		private Simulazione sim;
		private JTextArea informazioni;
		
		private JPanel paPulsanti;
	}
