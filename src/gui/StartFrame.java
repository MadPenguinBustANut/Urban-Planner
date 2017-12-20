package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ascoltatori.StartFrameListener;
import centrourbano.CentroUrbano;

public class StartFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	public StartFrame(CentroUrbano c) {
		super("Urban Planner");

		setJMenuBar(addFile());
		
		JPanel grid = new JPanel(new BorderLayout());
		
		JPanel io = new JPanel();
		
		uno = c;
		centro = new DatiPanel(c);
		selezioneB.addActionListener(new ButtonListener(this));
		gestioneB.addActionListener(new ButtonListener(this));
		visualizzazioneB.addActionListener(new ButtonListener(this));
		visualizzazione = new PannelloVisualizzazione(uno);
		selezione = new PannelloSelezione(c);
		gestione = new PannelloGestione(c);
		
		
		io.add(gestioneB);
		io.add(selezioneB);
		io.add(visualizzazioneB);
		

		contenitore = new JPanel(new GridLayout(1,1));
		
		grid.add(contenitore, BorderLayout.CENTER);
		grid.add(centro, BorderLayout.NORTH);
		grid.add(io, BorderLayout.SOUTH);
		
		
		visualizzazione.setVisible(false);
		selezione.setVisible(false);
		gestione.setVisible(false);
		
		add(grid);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		/*setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null,"Credits: \n Alessandro Zolfanelli \n Vito Carmine Lanaro \n Tiziana Correale \n Giuseppe Madonna \n Stefano Nicodemo");
	            System.exit(0);
	        };
	    });
	    */
		setSize(800, 150);
		setVisible(true);
	}
	
	private JMenuBar addFile() {
		JMenuBar due = new JMenuBar();
		JMenu io = new JMenu("File");
		io.add(createItem("Nuovo"));
		io.add(createItem("Salva"));
		io.add(createItem("Carica"));
		io.add(createItem("Esci"));
		due.add(io);
		
		
		
		return due;
	}
	
	
	
	
	
	
	
	private JMenuItem createItem(String a) {
		
		JMenuItem it = new JMenuItem(a);
		it.addActionListener(new StartFrameListener(this));
		return it;
		
	}
		
	public CentroUrbano uno;
	public DatiPanel centro;
	
	private JPanel contenitore;
	private PannelloSelezione selezione;
	private PannelloGestione gestione;
	private PannelloVisualizzazione visualizzazione;
	private JButton selezioneB = new JButton("Selezione");
	private JButton gestioneB = new JButton("Gestione");
	private JButton visualizzazioneB = new JButton("Visualizzazione");
	


public class ButtonListener implements ActionListener{
		StartFrame rifer;
	
		public ButtonListener(StartFrame e) {
			rifer = e;
		}
		
		
		public void actionPerformed(ActionEvent e) {
			JButton io = (JButton) e.getSource();
			
			
			String testo = io.getText();
			if(testo.equalsIgnoreCase("Selezione")){			//Ridimensionamento del frame per
				rifer.setSize(800, 600);						//visualizzare il pannello di selezione
				contenitore.removeAll();
				contenitore.add(selezione);
				selezione.setVisible(true);
				gestione.setVisible(false);
				visualizzazione.setVisible(false);
			}
			else if(testo.equalsIgnoreCase("Gestione")){		//visualizzazione del pannello di gestione
				rifer.setSize(800, 600);
				contenitore.removeAll();
				contenitore.add(gestione);
				selezione.setVisible(false);
				gestione.setVisible(true);
				visualizzazione.setVisible(false);
			}
			else if(testo.equalsIgnoreCase("Visualizzazione")){	//visualizzazione del pannello di visualizzazione
				rifer.setSize(800, 600);	
				contenitore.removeAll();
				contenitore.add(visualizzazione);
				selezione.setVisible(false);
				gestione.setVisible(false);
				visualizzazione.setVisible(true);
			}
			
		}
		
	}
}
