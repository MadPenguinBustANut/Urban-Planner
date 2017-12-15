package gui;

import javax.swing.JFrame;

import centrourbano.CentroUrbano;
import centrourbano.Lotti;

public class FrameLotto extends JFrame {
	private static final long serialVersionUID = 1L;

	private Lotti rifer;
	private CentroUrbano centro;
	
	
	public FrameLotto(Lotti e, CentroUrbano u) {
		super("Lotto");
		rifer = e;	
		centro = u;
	}
	
	
	/**
	 * Elimina il Lotto attuale, chiamando
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
