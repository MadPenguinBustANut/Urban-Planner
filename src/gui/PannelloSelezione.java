package gui;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import centrourbano.*;

public class PannelloSelezione extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public PannelloSelezione(CentroUrbano c) {
		super(new BorderLayout());
		centro=c;
		
		cEffButton= new JRadioButton ("Coefficiente Efficienza");
		cEffButton.addActionListener(listener);
		cInvButton= new JRadioButton ("Coefficiente Invecchiamento");
		cInvButton.addActionListener(listener);
	    ValoreButton= new JRadioButton ("Valore");
	    ValoreButton.addActionListener(listener);
		cEffButton.setSelected(true);
	    
		ButtonGroup group= new ButtonGroup();
	    group.add(cEffButton);
	    group.add(cInvButton);
	    group.add(ValoreButton);
	    
	    panel= new JPanel(new GridLayout(3,1));
	    panel.add(cEffButton);
	    panel.add(cInvButton);
	    panel.add(ValoreButton);
	    
	    panel.setBorder(new TitledBorder(new EtchedBorder(),"Metodi di Selezione in base a:"));
	    
	    normalOrdButton= new JRadioButton("Dal più Grande al più Piccolo");
	    normalOrdButton.addActionListener(listenerOrd);
	    inversOrdButton= new JRadioButton("Dal più Piccolo al più Grande");
	    inversOrdButton.addActionListener(listenerOrd);
	    normalOrdButton.setSelected(true);
	    
	    ButtonGroup groupOrd= new ButtonGroup();
	    group.add(normalOrdButton);
	    group.add(inversOrdButton);
	    
	    panelG= new JPanel(new GridLayout(2,1));
	    panelG.add(normalOrdButton);
	    panelG.add(inversOrdButton);
	    
	    panelG.setBorder(new TitledBorder(new EtchedBorder(),"Metodi di ordinamento:"));
	    
	    maxEff= new JTextField(FIELD_WIDTH);
	    maxEff.setText(""+100);
	    minEff= new JTextField(FIELD_WIDTH);
	    minEff.setText(""+0);
	    maxInv= new JTextField(FIELD_WIDTH);
	    maxInv.setText(""+100);
	    minInv= new JTextField(FIELD_WIDTH);
	    minInv.setText(""+0);
	    maxVal= new JTextField(FIELD_WIDTH);
	    maxVal.setText(""+100);
	    minVal= new JTextField(FIELD_WIDTH);
	    minVal.setText(""+0);
	    
	    panelM= new JPanel(new GridLayout(3,2));
	    panelM.add(maxEff);
	    panelM.add(minEff);
	    panelM.add(maxInv);
	    panelM.add(minInv);
	    panelM.add(maxVal);
	    panelM.add(minVal);
	    
	    panelM.setBorder(new TitledBorder(new EtchedBorder(),"Massimo   -   Minimo"));
	    
	    calButton=new JButton("Effetua Selezione");
	    
	    JTextArea textArea= new JTextArea(10,30);
	    textArea.setEditable(false);
	    JScrollPane scrollPanel= new JScrollPane(textArea);
	    
	    add(scrollPanel,BorderLayout.SOUTH);
	    add(calButton,BorderLayout.NORTH);
	    
	    add(panel, BorderLayout.WEST);
	    add(panelG,BorderLayout.EAST);
	    add(panelM,BorderLayout.CENTER);
	    
	}
	
	public class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
	

    private CentroUrbano centro;
    
    private JRadioButton cEffButton;
    private JTextField maxEff;
    private JTextField minEff;
    private JRadioButton cInvButton;
    private JTextField maxInv;
    private JTextField minInv;
    private JRadioButton ValoreButton;
    private JTextField maxVal;
    private JTextField minVal;
    
    private JButton calButton;
    
    private JRadioButton normalOrdButton;
    private JRadioButton inversOrdButton;
    
    
    private JPanel panel;
    private JPanel panelG;
    private JPanel panelM;
    
    private ActionListener listener = new ButtonListener();
    private ActionListener listenerOrd;
    
    private static final int FIELD_WIDTH=10;
}
