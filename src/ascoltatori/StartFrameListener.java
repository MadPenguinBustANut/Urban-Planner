package ascoltatori;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import centrourbano.CentroUrbano;
import gui.StartFrame;

public class StartFrameListener implements ActionListener{

	StartFrame rifer;
	File file = new File("Salvataggio.sav");
	
	public StartFrameListener(StartFrame e) {
		rifer = e;
	}
	
	public void actionPerformed(ActionEvent e) {
		JMenuItem t = (JMenuItem) e.getSource();
		if(t.getText().equalsIgnoreCase("Salva")) {
			salva();
		}
		else if(t.getText().equalsIgnoreCase("Carica")) {
			carica();
			
		}
		else if(t.getText().equalsIgnoreCase("Nuovo")) {
			nuovo();
			
		}
		else if(t.getText().equalsIgnoreCase("Esci")) {
			rifer.setEnabled(false);
			JFrame temp= new JFrame("Chiusura");
			temp.add(new JLabel("Made by Alessandro Zolfanelli, Tiziana Correale, Stefano Nicodemo, Vito Carmine Lanaro e Giuseppe Madonna."));
			temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			temp.setSize(300,110);
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
		finally{JFrame temp= new JFrame("Salvataggio");
		temp.add(new JLabel("Salvato nella cartella corrente in Salvataggio.sav"));
		temp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		temp.setSize(500,110);
		temp.setResizable(false);
		temp.setVisible(true);
		}
	}
	
	private void carica() {
		JFileChooser io = new JFileChooser();
		JFrame nuovo = new JFrame("File");
		io.addActionListener(new Filechooserlistener(nuovo));
		nuovo.add(io);
		nuovo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		nuovo.setSize(600,  300);
		nuovo.setVisible(true);
		
	}
	
	private void nuovo() {
		rifer.setVisible(false);
		StartFrame io = new StartFrame(new CentroUrbano());
		io.setLocation(rifer.getX(), rifer.getY());
		JFrame temp= new JFrame("Avviso");
		temp.add(new JLabel("Simulazione riavviata."));
		temp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		temp.setSize(500,110);
		temp.setVisible(true);
		temp.setResizable(false);
		rifer.dispose();
		
	}

	
	
	private class Filechooserlistener implements ActionListener{

		JFrame rife;
		
		public Filechooserlistener(JFrame nuovo) {
			rife = nuovo;
		}
		
		
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = (JFileChooser) e.getSource();
			if(JFileChooser.APPROVE_SELECTION.equalsIgnoreCase(e.getActionCommand())) {
				file = chooser.getSelectedFile();
				
				FileInputStream reader = null;
				try {
					reader = new FileInputStream(file);
				} catch (FileNotFoundException e1) {
				}
				ObjectInputStream in = null;
				try {
					in = new ObjectInputStream(reader);
					rifer.uno = (CentroUrbano) in.readObject();
				} catch (ClassNotFoundException e1) {
				} catch (IOException e1) {
				}
				rifer.centro.nDati(rifer.uno);
			}
			else if(JFileChooser.CANCEL_SELECTION.equalsIgnoreCase(e.getActionCommand())) {
				rife.dispose();
			}
		}
		
	}
	
}
