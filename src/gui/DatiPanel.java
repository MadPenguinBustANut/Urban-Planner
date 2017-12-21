package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.JTextField;

import centrourbano.CentroUrbano;

public class DatiPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	CentroUrbano centro;
	
	
	
	
	
	public DatiPanel(CentroUrbano c) {
		super();
		centro=c;
		
		f1.setEditable(false);
		f2.setEditable(false);
		f3.setEditable(false);
		f4.setEditable(false);
		f5.setEditable(false);
		f6.setEditable(false);
		
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

		add(t6);
		add(f6);
		
		nDati(centro);
		
		ActionListener listener = new MioRicevitore();
		Timer t = new Timer(3000, listener);
		t.start();
		
	
}
	
	public void nDati(CentroUrbano c) {
		f1.setText(""+c.numSettori());
		f2.setText(""+c.numLotti());
		f3.setText(""+c.numLottiLiberi());
		f4.setText(""+c.numStrade());
		f5.setText(""+c.numLottiPrivati());
		f6.setText(""+c.numLottiPubblici());
	}
	
	class MioRicevitore implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			nDati(centro);
			
		}
	}


	private	JLabel t1 = new JLabel("Numero settori");
	private	JLabel t2 = new JLabel("Numero Lotti");
	private	JLabel t3 = new JLabel("Lotti Liberi");
	private	JLabel t4 = new JLabel("Strade");
	private	JLabel t5 = new JLabel("Lotti privati");
	private	JLabel t6 = new JLabel("Lotti pubblici");
	
	public	JTextField f1 = new JTextField(4);
	public	JTextField f2 = new JTextField(4);
	public	JTextField f3 = new JTextField(4);
	public	JTextField f4 = new JTextField(4);
	public	JTextField f5 = new JTextField(4);
	public	JTextField f6 = new JTextField(4);
	
}
