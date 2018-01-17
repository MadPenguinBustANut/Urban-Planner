package gui;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import centrourbano.CentroUrbano;
import centrourbano.Lotti;
import eccezioni.LottoLibero;
import eccezioni.NotPrivException;
import edifici.EPrivato;
import edifici.EPubblico;

public class FrameLotto extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5810793527231372492L;
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
		SettX= 	(int) Settore.getX(); 
		SettY= 	(int) Settore.getY();
		LX= 	(int) Lotto.getX();
		LY=		(int) Lotto.getY();
		this.lotto = lotto;
		this.centroUrbano = centroUrbano;
		this.setLocation(320, 0);
		createTesti();
		createBottoni();
		createPanel();
		getInfo();
		setSize(700, 700);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public FrameLotto() {

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
		success= new JLabel();
		p3.setEditable(false);
	}

	public void createBottoni() {
		radio1 = new JRadioButton("Strada");
		radio2 = new JRadioButton("Pubblico");
		radio3 = new JRadioButton("Privato");
		okButton = new JButton("Costruire");
		vendiButton = new JButton("Vendi");
		restauroButton= new JButton("Restaura");

		removeButton = new JButton("Demolisci");
		if (lotto.getTip()==0) removeButton.setEnabled(false);

		class RestauraButtoner implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				restaura();
				getInfo();
			}
		}
		class OkButtoner implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				// costruisci
				costruzione();
				dispose();
				
			}
		}

		class RemoveButton implements ActionListener {
			public void actionPerformed(ActionEvent e) {
			 rimozione();
			 
			}
		}
		class VendiListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				vendita();
			}
		}
		ActionListener vendi= new VendiListener();
		vendiButton.addActionListener(vendi);
		ActionListener remover = new RemoveButton();
		removeButton.addActionListener(remover);
		ActionListener listenerOk = new OkButtoner();
		okButton.addActionListener(listenerOk);
		ActionListener restaura= new RestauraButtoner();
		restauroButton.addActionListener(restaura);
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
		dx.add(vendiButton);
		dx.add(restauroButton);
		sx.add(s3);
		dx.add(success);
		sx.add(p3);
		sx.add(removeButton);

		panel.setVisible(true);
		add(panel);
	}
//vendi edificabile privato
	public void vendita() {
		
		try {
	
		centroUrbano.getLista()[SettY][SettX].vendiEdificio(LY, LX);
		vendiButton.setEnabled(false);
		removeButton.setEnabled(false);
		success.setText("Vendita effettuata");
		}
		catch(NotPrivException e) {
			JFrame temp= new JFrame("Errore");
			temp.add(new JLabel("Il lotto non è vendibile"));
			temp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			temp.setSize(400,110);
			temp.setResizable(false);
			temp.setVisible(true);
		}
		
	}
	
	public void restaura() throws LottoLibero {
		if(lotto.getCeff()==100) restauroButton.setEnabled(false);
		if(lotto.getTip()==0) {
			JFrame temporaneo= new JFrame("Errore");
			temporaneo.add(new JLabel("Il lotto è vuoto."));
			temporaneo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			temporaneo.setSize(400,110);
			temporaneo.setResizable(false);
			temporaneo.setVisible(true);
			throw new LottoLibero();
			
		}
		int temp=lotto.getCeff();
		lotto.setCeff(temp+10);
		success.setText("Restauro effettuato");
	}
	public void rimozione() {
		removeButton.setEnabled(false);
		
		if(lotto.getTip() == 1) centroUrbano.rmStrada(SettY, SettX, LY, LX);
		
		else if(lotto.getTip() == 2) {
			EPubblico x = (EPubblico) centroUrbano.getLista()[SettY][SettX].lista[LY][LX].edificio;
			if(x.getStato() > 0) {
		
				JFrame temp= new JFrame();
				temp.add(new JLabel("Rimozione gia' in corso. Verrà eliminato con lo scorrere del tempo."));
				temp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				temp.setSize(400,110);
				temp.setResizable(false);
				temp.setVisible(true);

			}
			else x.addStato();
		}
		else centroUrbano.getLista()[SettY][SettX].rmLotto(LY, LX);
		success.setText("Demolizione avvenuta.");
	}

	/**
	 * La funzione cambia l'Edificabile contenuto all'interno del Lotto con uno del
	 * tipo scelto dall'utente attraverso i pulsanti radiali
	 */
	public void costruzione() {
		if(removeButton.isEnabled()) {
			JFrame temp= new JFrame("Errore");
			temp.add(new JLabel("Demolisci prima di costruire."));
			temp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			temp.setSize(200,110);
			temp.setVisible(true);
			return;
		}
		if(radio1.isSelected()) centroUrbano.addStrada(SettY, SettX, LY, LX);
		if(radio2.isSelected()) {
			centroUrbano.getLista()[SettY][SettX].addLotto(new EPubblico(), LY, LX);
			success.setText("Costruzione avvenuta.");
		}
		if(radio3.isSelected()) { centroUrbano.getLista()[SettY][SettX].addLotto(new EPrivato(), LY, LX);
			success.setText("Costruzione avvenuta.");
		}
		
	}

	/**
	 * La funzione legge coefficienti e valore del lotto (nel caso sia privato) e li
	 * stampa in Campi di testo alla sinistra del pannello
	 *
	 */
	public void getInfo() {
		
		if(lotto.getTip() == 3) p1.setText("" + lotto.getValore());
		else p1.setText("N/A");
		p2.setText("" + lotto.getCeff());
		p3.setText("" + lotto.getCinv());
	}

	private Lotti lotto;
	private int SettX, SettY, LX,LY;
	private CentroUrbano centroUrbano;
	private JLabel s1, s2, s3,success;
	private JTextArea p1, p2, p3;
	private JButton okButton, removeButton, vendiButton, restauroButton;
	private JRadioButton radio1, radio2, radio3;
	final int TEXTLARGO = 10;
}
