package ascoltatori;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

public class StartFrameListener implements ActionListener{

	File file = new File("Salvataggio.sav");
	
	public void actionPerformed(ActionEvent e) {
		JMenuItem t = (JMenuItem) e.getSource();
		if(t.getText().equalsIgnoreCase("Salva")) {
			
		}
		else if(t.getText().equalsIgnoreCase("Carica")) {
			
			
		}
		else if(t.getText().equalsIgnoreCase("Nuovo")) {
			
		}
		else if(t.getText().equalsIgnoreCase("Esci")) {
			System.exit(0);
		}
	}
	
	private void salva() {
		
	}
	
	private void carica() {
		JFileChooser io = new JFileChooser(file);
	}
	
	private void nuovo() {
		
	}

}
