package ascoltatori;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import centrourbano.CentroUrbano;
import gui.StartFrame;

public class StartFrameListener implements ActionListener,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3796252926992624304L;
	private StartFrame rifer;
	private File file = new File("Salvataggio.sav");
	
	public StartFrameListener(StartFrame e) {
		rifer = e;
	}
	
	public void actionPerformed(ActionEvent e) {
		JMenuItem t = (JMenuItem) e.getSource();
		if(t.getText().equalsIgnoreCase("Salva")) {
			salva();
			JFrame temp= new JFrame("Avviso");
			temp.add(new JLabel("Salvataggio effettuato."));
			temp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			temp.setSize(500,110);
			temp.setVisible(true);
			temp.setResizable(false);
		}
		else if(t.getText().equalsIgnoreCase("Carica")) {
			carica();
			
		}
		else if(t.getText().equalsIgnoreCase("Nuovo")) {
			nuovo(new CentroUrbano());
			JFrame temp= new JFrame("Avviso");
			temp.add(new JLabel("Simulazione riavviata."));
			temp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			temp.setSize(500,110);
			temp.setVisible(true);
			temp.setResizable(false);
			
		}
		else if(t.getText().equalsIgnoreCase("Esci")) {
			rifer.setEnabled(false);
			JFrame temp= new JFrame("Chiusura");
			temp.add(new JLabel("In uscita."));
			temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			temp.setSize(700,110);
			temp.setResizable(false);
			temp.setVisible(true);
			
		}
	}
	
	private void salva() {
		FileOutputStream writer= null;
		try {
			writer = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
		}
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(writer);
			out.writeObject(rifer.uno);
		} catch (IOException e) {
		}
		
		
		}
	
	private void carica() {
		FileInputStream reader = null;
		ObjectInputStream in = null;
		try {
			reader = new FileInputStream(file);
			in = new ObjectInputStream(reader);
			nuovo((CentroUrbano)in.readObject());
			JFrame temp= new JFrame("Avviso");
			temp.add(new JLabel("File caricato."));
			temp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			temp.setSize(500,110);
			temp.setVisible(true);
			temp.setResizable(false);
		} catch (IOException | ClassNotFoundException e) {
			JFrame tempFrame= new JFrame("Errore");
			JPanel temp= new JPanel();
			temp.add(new JLabel("Errore nel caricare. Riprovare?"),BorderLayout.NORTH);
			JButton riprova= new JButton("Riprova");
			riprova.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tempFrame.dispose();
					carica();
				}
			});
			temp.add(riprova, BorderLayout.SOUTH);
			tempFrame.add(temp);
			tempFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			tempFrame.setSize(500,110);
			tempFrame.setVisible(true);
			tempFrame.setResizable(false);
		}

		
	}
	
	private void nuovo(CentroUrbano c) {
		rifer.setVisible(false);
		StartFrame io = new StartFrame(c);
		io.setLocation(rifer.getX(), rifer.getY());
		
		rifer.dispose();
		
	}


}


