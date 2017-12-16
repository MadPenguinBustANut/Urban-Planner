package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//import centrourbano.CentroUrbano;
//import centrourbano.Lotti;
//import edifici.Edificabile;

public class FrameLotto extends JFrame {
	private static final long serialVersionUID = 1L;

	/**
	 * Il frame presenta sul lato sinistro dentro tre campi di testo i valori di:
	 * -Valore lotto -Coefficente di efficienza -Coefficente di invecchiamento
	 *
	 * Sul lato destro abbiamo tre pulsanti radiali con su scritti i nomi dei tipi
	 * di edifici costruibili e un pulsante normale con su scritto "OK", circondati
	 * da un bordo Un pulsante con su scritto "Rimozione"
	 *
	 * @param lotto
	 * @param centrourbano
	 */
	public FrameLotto(/*Lotti lotto, CentroUrbano centrourbano*/) {		// Se il bordo attorno alla sezione della modifica e
																		// brutto, mettilo pure attorno alla sezione
		/*super("Lotto"); 												// di rimozione e poi fallo vedere agli altri
		rifer = lotto;
		centro = centrourbano;
		*/
		createTesti();
		createBottoni();
		createPanel();
		setSize(400,200); //qua mi devi dire tu
	}
	public void createTesti() {
		s1 = new JLabel("Valore Lotto");
		p1 = new JTextField(TEXTLARGO);
		p1.setText(" ");
		s2 = new JLabel("Coefficiente di efficenza");
		p2 = new JTextField(TEXTLARGO);
		p2.setText(" ");
		s3 = new JLabel("Coefficiente di invecchiamento");
		p3 = new JTextField(TEXTLARGO);
		p3.setText(" ");
	}
	

	public void createBottoni(){
		radio1= new JRadioButton("Edificio 1");
		radio1.setSelected(true);
		radio2= new JRadioButton("Edificio 2");
		radio3= new JRadioButton("Edificio3");
		okButton= new JButton("OK");
		removeButton= new JButton("Rimuovi");
		
		//ActionListener radio
		class ActionMan implements ActionListener{
			public void actionPerformed(ActionEvent e){
				//getInfo(); //stessa questione dei parametri
				p3.setText("prova radio ok");
			}
		}
			ActionListener radioActive= new ActionMan();
			radio1.addActionListener(radioActive);
			radio2.addActionListener(radioActive);
			radio3.addActionListener(radioActive);
		
	class OkButtoner implements ActionListener{
	public void actionPerformed(ActionEvent e){
		//costruzione(); 
		p1.setText("Ok button ok");
				}
	}
		ActionListener listenerOk= new OkButtoner();
		okButton.addActionListener(listenerOk);
		
		
class RemoveButton implements ActionListener{
	public void actionPerformed(ActionEvent e){
		//rimozione();
		p2.setText("bottone rimuovi ok");
	}
}
	ActionListener remover= new RemoveButton();
	removeButton.addActionListener(remover);

		

	}
	public void createPanel() {
		ButtonGroup radio = new ButtonGroup();
		radio.add(radio1);
		radio.add(radio2);
		radio.add(radio3);
		
		JPanel panel = new JPanel(new GridLayout(6,2));

		add(panel);
		panel.add(s1);
		panel.add(radio1);
		panel.add(p1);
		panel.add(radio2);
		panel.add(s2);
		panel.add(radio3);
		panel.add(p2);
		panel.add(removeButton);
		panel.add(s3);
		panel.add(okButton);
		panel.add(p3);
		
		
		
		
		
		
		
		
		

		panel.setVisible(true);
		add(panel);
	}
	
	/**
	 * Elimina l'edificabile nel lotto attuale sostituendolo con l'edificabile VUOTO
	 */
	public void rimozione() {
		//a = vuoto;
	}

	/**
	 * La funzione cambia l'Edificabile contenuto all'interno del Lotto con uno del
	 * tipo scelto dall'utente attraverso i pulsanti radiali
	 */
	public void costruzione() {
		// non ho capito
	}

	/**
	 * La funzione legge coefficienti e valore del lotto (nel caso sia privato) e li stampa in Campi di testo
	 * alla sinistra del pannello
	 *
	 */
	public void getInfo() {
		//p1.setText(""+getTipo());
		//p2.setText(""+getCeff());
		//p3.setText(""+getCinv());
	}

	//private Lotti rifer;
	//private CentroUrbano centro;
	private JLabel s1, s2, s3;
	private JTextField p1, p2, p3;
	private JButton okButton, removeButton;
	private JRadioButton radio1, radio2, radio3;
	final int TEXTLARGO=10;
}
