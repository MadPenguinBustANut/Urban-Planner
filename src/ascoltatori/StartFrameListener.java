package ascoltatori;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

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
			System.exit(0);
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
		JFileChooser io = new JFileChooser();
		io.addActionListener(new Filechooserlistener());
		JFrame nuovo = new JFrame("File");
		nuovo.add(io);
		nuovo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		nuovo.setSize(600,  300);
		nuovo.setVisible(true);
		
	}
	
	private void nuovo() {
		rifer.uno = new CentroUrbano();
		rifer.centro.nDati(rifer.uno);
	}

	
	
	private class Filechooserlistener implements ActionListener{

		
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
			}
		}
		
	}
	
}
