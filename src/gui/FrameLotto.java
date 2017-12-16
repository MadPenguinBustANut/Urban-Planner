package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import centrourbano.CentroUrbano;
import centrourbano.Lotti;

public class FrameLotto extends JFrame {
	private static final long serialVersionUID = 1L;



	/**
	 * Il frame presenta sul lato sinistro dentro tre campi di testo
	 * i valori di:
	 * 	-Valore lotto
	 *  -Coefficente di efficienza
	 *  -Coefficente di invecchiamento
	 *
	 * Sul lato destro abbiamo tre pulsanti radiali con su scritti i nomi dei tipi di edifici costruibili
	 * e un pulsante normale con su scritto "OK", circondati da un bordo
	 * Un pulsante con su scritto "Rimozione"
	 *
	 * @param lotto
	 * @param centrourbano
	 */
	public FrameLotto(Lotti lotto, CentroUrbano centrourbano) {			//Se il bordo attorno alla sezione della modifica e brutto, mettilo pure attorno alla sezione
		super("Lotto");													//di rimozione e poi fallo vedere agli altri
		rifer = lotto;
		centro = centrourbano;
		 s1 = new JLabel("Valore Lotto");
		 p1=new JTextField("");
		 s2= new JLabel("Coefficiente di efficenza");
		 p2=new JTextField("");
		 s3= new JLabel("Coefficiente di invecchiamento");
		 p3=new JTextField("");

		JFrame panel= new JFrame("Lotto");

		add(panel);
		panel.add(s1, BorderLayout.WEST);
		panel.add(p1, BorderLayout.WEST);
		panel.add(s2, BorderLayout.WEST);
		panel.add(p2, BorderLayout.WEST);
		panel.add(s3, BorderLayout.WEST);
		panel.add(p3, BorderLayout.WEST);
		ButtonGroup radio= new ButtonGroup();


	radio.add(radio1,BorderLayout.EAST);
	radio.add(radio2,BorderLayout.EAST);
	radio.add(radio3,BorderLayout.EAST);
	panel.add(removeButton,BorderLayout.EAST);
	panel.add(okButton,BorderLayout.EAST);
//lo chiamo panel perché così mi piace chiamarlo
	panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	panel.setVisible(true);
	}

	public void creaBottoni(){
		radio1= new JRadioButton("Edificio 1");
		radio1.setSelected(true);
		radio2= new JRadioButton("Edificio 2");
		radio3= new JRadioButton("Edificio3");
		okButton= new JButton("OK");
		//ActionListener radio
		class ActionMan implements ActionListener{
			public void actionPerformed(ActionEvent e){
				getInfo(); //stessa questione dei parametri
			}
			ActionListener radioActive= new ActionMan();
			radio1.AddActionListener(radioActive);
			radio2.AddActionListener(radioActive);
			radio3.AddActionListener(radioActive);
		}
	//ActionListener per OK, praticamente fa mostrare i campi a sinistra a seconda dell'edificio scelto. Ho messo getsource ma non ho capito da dove prendere gli edifici so
	class OkButtoner implements ActionListener{
	public void actionPerformed(ActionEvent e){
		costruzione(); //ancora, non so cosa passargli, non sto a capì ao
				}
		ActionListener listenerOk= new OkButtoner();
		okButton.addActionListener(listenerOk);
//ActionListener per remove. chiama il metodo rimozione quando premi il bottone. Come prima non so come prendere l'edificio selezionato da radiobuttons quindi gli passo il nulla per ora
class RemoveButton implements ActionListener{
	public void actionPerformed(ActionEvent e){
		rimozione();
	}
	ActionListener remover= new RemoveButton;
	removeButton.AddActionListener(remover);
}
		}

	}

	/**
	 * Elimina l'edificabile nel lotto attuale sostituendolo con
	 * l'edificabile VUOTO
	 */
	public void rimozione(Edificabile a) {
		a=vuoto;
	}


	/**
	 * La funzione cambia l'Edificabile contenuto all'interno del Lotto con
	 * uno del tipo scelto dall'utente attraverso i pulsanti radiali
	 */
	public void costruzione() {
//non ho capito
	}


	/**
	 * La funzione legge coefficienti e valore del lotto (nel caso sia privato) e li stampa in Campi di testo
	 * alla sinistra del pannello
	 *
	 */
	public void getInfo(Edificabile a) {
		p1=""+a.Lotto();
		p2=""+a.getEfficienza();
		p3=""a.getInvecchiamento();
	}

	private Lotti rifer;
	private CentroUrbano centro;
	private	JLabel s1,s2,s3;
	private JTextField p1,p2,p3;
	private JButton okButton,removeButton,radio2,radio3;
	JRadioButton radio1;
}
