package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ascoltatori.StartFrameListener;

public class StartFrame extends JFrame{

	public StartFrame() {
		super("Urban Planner");
		JPanel io = new JPanel();
		JPanel grid = new JPanel(new GridLayout(2, 1));
		selezione.addActionListener(new StartFrameListener());
		gestione.addActionListener(new StartFrameListener());
		visualizzazione.addActionListener(new StartFrameListener());
		setJMenuBar(addFile());
		io.add(gestione);
		io.add(selezione);
		io.add(visualizzazione);
		
		JPanel due = new JPanel();
		due.add(new JTextArea(5, 30));
		
		due.add(new JTextArea());
		grid.add(io);
		grid.add(due);
		add(grid);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
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
	
	private JButton selezione = new JButton("Selezione");
	private JButton gestione = new JButton("Gestione");
	private JButton visualizzazione = new JButton("Visualizzazione");
}
