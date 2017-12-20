package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PannelloPulsanti extends JPanel{
	
	public PannelloPulsanti () {
		super(new GridLayout(1, 2));

		JButton modStrada = new JButton("crea strada");
		JButton modLotto = new JButton("modifica lotto");
		
		add(modStrada);
		add(modLotto);
	}
	
	
}
