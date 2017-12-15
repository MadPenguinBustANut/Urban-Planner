package gui;

import javax.swing.JFrame;

import centrourbano.CentroUrbano;
import centrourbano.Lotti;

public class FrameLotto extends JFrame {
	private static final long serialVersionUID = 1L;

	private Lotti rifer;
	private CentroUrbano centro;
	
	/**
	 * Il frame presenta sul lato sinistro dentro tre campi di testo 
	 * i valori di:
	 * 	-Valore lotto
	 *  -Coefficente di efficenza
	 *  -Coefficente di invecchiamento
	 * 
	 * Sul lato destro abbiamo tre pulsanti radiali con su scritti i nomi dei tipi di edifici costruibili
	 * e un pulsante normale con su scritto "OK", circondati da un bordo
	 * Un pulsante con su scritto "Rimozione"
	 * 
	 * @param lotto
	 * @param centrourbano
	 */
	public FrameLotto(Lotti lotto, CentroUrbano centrourbano) {			//Se il bordo attorno alla sezione della modifica è brutto, mettilo pure attorno alla sezione
		super("Lotto");													//di rimozione e poi fallo vedere agli altri
		rifer = lotto;	
		centro = centrourbano;
	}
	
	
	/**
	 * Elimina l'edificabile nel lotto attuale sostituendolo con 
	 * l'edificabile VUOTO
	 */
	public void rimozione() {
	}
	
	
	/**
	 * La funzione cambia l'Edificabile contenuto all'interno del Lotto con 
	 * uno del tipo scelto dall'utente attraverso i pulsanti radiali
	 */
	public void costruzione() {
	}
	
	
	/**
	 * La funzione legge coefficienti e valore del lotto (nel caso sia privato) e li stampa in Campi di testo
	 * alla sinistra del pannello
	 * 
	 */
	public void getInfo() {
		
	}
	
}
