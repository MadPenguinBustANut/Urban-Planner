package centrourbano;

import java.io.Serializable;

public class Lotti implements Serializable{
	private static final long serialVersionUID = 1L;

	public Lotti() {
		tipo = 0;
		valore = 0;
	}
	
	/**
	 * La funzione verrà usata per modificare il tipo di edificio
	 * sostituendolo con il nuovo edificio
	 * 
	 * @param NuovoEdificio
	 */
	
	public void cambiaTipo(int NuovoEdificio) {
	}
	
	/**
	 * Il valore del lotto viene cambiato al nuovo valore
	 * @param NuovoValore
	 */
	public void cambiaValore(int NuovoValore) {
		
	}
	
	public int getVal() {
		return valore;
	}
	
	public int getTip() {
		return tipo;
	}
	
	
	
	private int tipo;
	private int valore;
	
	
	//Li randomizziamo?
	private int ceff;
	private int cinv;
	
	static private int LIBERO = 0;
	static private int STRADA = 1;
	static private int EPUB = 2;
	static private int EPRIV = 3;
}
