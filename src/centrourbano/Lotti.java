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
	public void setTip(int NuovoEdificio) {
		tipo = NuovoEdificio;
	}
	
	/**
	 * Il valore del lotto viene cambiato al nuovo valore
	 * @param NuovoValore
	 */
	public void setVal(int NuovoValore) {
		valore = NuovoValore;
	}
	
	
	
	public int getVal() {
		return valore;
	}
	
	
	public int getTip() {
		return tipo;
	}
	public int getCeff() {
		return ceff;
	}
	public void setCeff(int ceff) {
		this.ceff = ceff;
	}
	public int getCinv() {
		return cinv;
	}
	public void setCinv(int cinv) {
		this.cinv = cinv;
	}



	private int tipo;
	private int valore;
	
	
	//Li randomizziamo?
	private int ceff;
	private int cinv;
	
	private final static int LIBERO = 0;
	private final static int STRADA = 1;
	private final static int EPUB = 2;
	private final static int EPRIV = 3;
}
