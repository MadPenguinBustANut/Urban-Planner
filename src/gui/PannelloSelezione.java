package gui;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import centrourbano.*;
import seleziona.*;

public class PannelloSelezione extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public PannelloSelezione(CentroUrbano c) {
		super(new BorderLayout());
		
		centro= c;
		cEffButton= new JRadioButton ("Coefficiente Efficienza");
		cInvButton= new JRadioButton ("Coefficiente Invecchiamento");
	    ValoreButton= new JRadioButton ("Valore");
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
	    inversOrdButton= new JRadioButton("Dal più Piccolo al più Grande");
	    normalOrdButton.setSelected(true);
	    
	    ButtonGroup groupOrd= new ButtonGroup();
	    groupOrd.add(normalOrdButton);
	    groupOrd.add(inversOrdButton);
	    
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
	    
	    calButton=new JButton("Effettua Selezione");
	    calButton.addActionListener(listener);
	    
	    textArea= new JTextArea(5,30);
	    textArea.setEditable(false);
	    scrollPanel= new JScrollPane(textArea);
	    
	    add(scrollPanel,BorderLayout.SOUTH);
	    add(calButton,BorderLayout.NORTH);
	    
	    add(panel, BorderLayout.WEST);
	    add(panelG,BorderLayout.EAST);
	    add(panelM,BorderLayout.CENTER);
	    
	}
	
	public class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
		
			double max;
			double min;
			int scelta;
			Seleziona Select;

			
			if(cEffButton.isSelected()) {
				max= Double.parseDouble(maxEff.getText());
				min= Double.parseDouble(minEff.getText());
				scelta=0;
				Select= new Seleziona(centro,max,min,scelta);
				Select.Scelta();
                OrdPrintLista(Select);
			}
			else {
				if(cInvButton.isSelected()) {
				   max= Double.parseDouble(maxInv.getText());
				   min= Double.parseDouble(minInv.getText());
				   scelta=1;
				   Select= new Seleziona(centro,max,min,scelta);
				   Select.Scelta();
                   OrdPrintLista(Select);
				}
				else {
					if(ValoreButton.isSelected()) {
						max= Double.parseDouble(maxVal.getText());
						min= Double.parseDouble(minVal.getText());
						scelta=2;
						Select= new Seleziona(centro,max,min,scelta);
						Select.Scelta();
                        OrdPrintLista(Select);
					}
				}
			
			}
			
		}
			
	}
	
	private void OrdPrintLista(Seleziona Select) {
		
		
		int flag=0;
		Ordinamento Ord;
		
		if(normalOrdButton.isSelected()) {
			flag=0;
		}
		if(inversOrdButton.isSelected()) {
			flag=1;
		}
		Ord= new Ordinamento(flag,Select);
		Ord.sceltaOrd();
		for(int i=0;i<Select.getCount();i++) {
			textArea.append("Lotto :"+i+"\n");
			textArea.append("Coeff Efficienza"+Select.lista[i].getCeff()+"\n");
			textArea.append("Coeff Invecchiamento"+Select.lista[i].getCinv()+"\n");
			textArea.append("Valore"+Select.lista[i].getValore()+"\n");
			textArea.append("\n");
		}
	}

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
    
    private JTextArea textArea;
    
    private JScrollPane scrollPanel;
    
    private ActionListener listener = new ButtonListener();
    
    private CentroUrbano centro;
    
    private static final int FIELD_WIDTH=10;
}

