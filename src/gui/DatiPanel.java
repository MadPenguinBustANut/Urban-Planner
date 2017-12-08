package gui;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import centrourbano.CentroUrbano;

public class DatiPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	
	
	
	
	
	
	public DatiPanel(CentroUrbano c) {
		super();
		
		
		f1.setEditable(false);
		f2.setEditable(false);
		f3.setEditable(false);
		f4.setEditable(false);
		f5.setEditable(false);
		
		add(t1);
		add(f1);
		add(t2);
		add(f2);
		add(t3);
		add(f3);
		add(t4);
		add(f4);
		add(t5);
		add(f5);
		
		nDati(c);
		
	
}
	
	public void nDati(CentroUrbano c) {
		f1.setText(""+c.numSettori());
		f2.setText(""+c.numLotti());
		f3.setText(""+c.numLottiLiberi());
		f4.setText(""+c.numStrade());
		f5.setText(""+c.numLottiPrivati());
	}
	

	private	JLabel t1 = new JLabel("Numero settori");
	private	JLabel t2 = new JLabel("Numero Lotti");
	private	JLabel t3 = new JLabel("Lotti Liberi");
	private	JLabel t4 = new JLabel("Strade");
	private	JLabel t5 = new JLabel("Lotti privati");
	
	public	JTextField f1 = new JTextField(4);
	public	JTextField f2 = new JTextField(4);
	public	JTextField f3 = new JTextField(4);
	public	JTextField f4 = new JTextField(4);
	public	JTextField f5 = new JTextField(4);
	
	
}