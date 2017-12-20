package gui;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import centrourbano.CentroUrbano;
import centrourbano.Lotti;
import centrourbano.Settori;
import edifici.EPrivato;
import edifici.EPubblico;

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
	public FrameLotto(Lotti lotto, CentroUrbano centroUrbano, Point Settore, Point Lotto) {
		SettX=Settore.getX();
		SettY=Settore.getY();
		LX=Lotto.getX();
		LY=Lotto.getY();
		this.lotto = lotto;
		this.centroUrbano = centroUrbano;
		createTesti();
		createBottoni();
		createPanel();
		setSize(530, 200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void createTesti() {
		s1 = new JLabel("Valore Lotto");
		p1 = new JTextArea(1, 4);
		p1.setEditable(false);
		s2 = new JLabel("Coefficiente di efficienza");
		p2 = new JTextArea(1, 4);
		p2.setEditable(false);
		s3 = new JLabel("Coefficiente di invecchiamento");
		p3 = new JTextArea(1, 4);
		p3.setEditable(false);
	}

	public void createBottoni() {
		radio1 = new JRadioButton("Strada");
		radio2 = new JRadioButton("Pubblico");
		radio3 = new JRadioButton("Privato");
		okButton = new JButton("Costruire");
		removeButton = new JButton("Demolisci");
		if (lotto.getTip()==0) removeButton.setEnabled(false);

		// ActionListener radio
		class ActionMan implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				getInfo();
			}
		}
		ActionListener radioActive = new ActionMan();
		radio1.addActionListener(radioActive);
		radio2.addActionListener(radioActive);
		radio3.addActionListener(radioActive);

		class OkButtoner implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				// costruisci
				costruzione();
			}
		}
		ActionListener listenerOk = new OkButtoner();
		okButton.addActionListener(listenerOk);

		class RemoveButton implements ActionListener {
			public void actionPerformed(ActionEvent e) {
			 rimozione();
			}
		}
		ActionListener remover = new RemoveButton();
		removeButton.addActionListener(remover);

	}

	public void createPanel() {
		ButtonGroup radio = new ButtonGroup();
		radio.add(radio1);
		radio.add(radio2);
		radio.add(radio3);

		JPanel panel = new JPanel(new GridLayout(1, 2));
		JPanel sx = new JPanel(new GridLayout(7, 1));
		JPanel dx = new JPanel();
		panel.add(sx);
		panel.add(dx);

		add(panel);
		sx.add(s1);
		dx.add(radio1);
		sx.add(p1);
		dx.add(radio2);
		sx.add(s2);
		dx.add(radio3);
		sx.add(p2);
		dx.add(okButton);
		sx.add(s3);
		sx.add(p3);
		sx.add(removeButton);

		panel.setVisible(true);
		add(panel);
	}

	/**
	 * Elimina l'edificabile nel lotto attuale sostituendolo con l'edificabile VUOTO
	 */
	public void rimozione() {
		if(flag==false) {
		if(Epubblico.getStato()==0) .addStato(); VITO VEDI TU NUN O SACC FA
		if(radio1.isSelected()) centroUrbano.rmStrada(SettX, SettY,LX, LY); //coordinate provvisorie
		else if ((radio2.isSelected()) || (radio3.isSelected())) centroUrbano.lista[(int) SettX][(int) SettY].rmLotto(LX,LY);
		flag=true;
		}
		else{
			removeButton.setEnabled(false);
			JFrame erroreDemolizione= new JFrame();
			JPanel nuovoErrore= new JPanel();
			JLabel errore= new JLabel("Demolizione già effettuata");
			nuovoErrore.add(errore);
			erroreDemolizione.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			erroreDemolizione.setSize(200,100);
			erroreDemolizione.setVisible(true);
		}
	}

	/**
	 * La funzione cambia l'Edificabile contenuto all'interno del Lotto con uno del
	 * tipo scelto dall'utente attraverso i pulsanti radiali
	 */
	public void costruzione() {
		if(radio1.isSelected()) centroUrbano.addStrada(1,1,1,1); //coordinate provvisorie
		if(radio2.isSelected()) centroUrbano.lista[(int) SettX][(int) SettY].addLotto(new EPubblico(), LX, LY);
		if(radio3.isSelected()) centroUrbano.lista[(int) SettX][(int) SettY].addLotto(new EPrivato(), LX, LY);
	}

	/**
	 * La funzione legge coefficienti e valore del lotto (nel caso sia privato) e li
	 * stampa in Campi di testo alla sinistra del pannello
	 *
	 */
	public void getInfo() {
		p1.setText("" + lotto.getValore());
		p2.setText("" + lotto.getCeff());
		p3.setText("" + lotto.getCinv());
	}

	private Lotti lotto;
	private double SettX, SettY, LX,LY;
	private CentroUrbano centroUrbano;
	private JLabel s1, s2, s3;
	private JTextArea p1, p2, p3;
	private JButton okButton, removeButton;
	private JRadioButton radio1, radio2, radio3;
	final int TEXTLARGO = 10;
	private boolean flag=false;
}
