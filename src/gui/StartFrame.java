package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import ascoltatori.StartFrameListener;
import centrourbano.CentroUrbano;

public class StartFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	public StartFrame(CentroUrbano c) {
		super("Urban Planner");

		setJMenuBar(addFile());
		
		JPanel grid = new JPanel();
		
		JPanel io = new JPanel();
		
		uno = c;
		centro = new DatiPanel(c);
		selezione.addActionListener(new StartFrameListener());
		gestione.addActionListener(new StartFrameListener());
		visualizzazione.addActionListener(new StartFrameListener());
		
		
		io.add(gestione);
		io.add(selezione);
		io.add(visualizzazione);
		
		
		grid.add(centro);
		grid.add(io);
		
		add(grid);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 100);
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
		it.addActionListener(new StartFrameListener());
		return it;
		
	}
	
	CentroUrbano uno;
	DatiPanel centro;
	private JButton selezione = new JButton("Selezione");
	private JButton gestione = new JButton("Gestione");
	private JButton visualizzazione = new JButton("Visualizzazione");
}
