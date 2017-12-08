package centrourbano;

import java.io.Serializable;

import edifici.*;

public class Lotti implements Serializable{
	private static final long serialVersionUID = 1L;

	public Lotti() {
		edificio = null;
	}
	

	public Lotti(Edificabile NuovoEdificio) {
		edificio = NuovoEdificio;
	}
	
	/**
	 * La funzione verrà usata per modificare il tipo di edificio
	 * sostituendolo con il nuovo edificio
	 * 
	 * @param NuovoEdificio
	 */
	public void setEdificio(Edificabile NuovoEdificio) {
		edificio = NuovoEdificio;
	}
	
	/**
	 * Il valore del lotto viene cambiato al nuovo valore
	 * @param NuovoValore
	 */
	public void setValore(int NuovoValore) {
		((EPrivato) edificio).setValore(NuovoValore);
	}
	
	
	
	public int getValore() {
		return ((EPrivato) edificio).getValore();
	}
	
	
	public int getTip() {
		return edificio.getTipo();
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



	private Edificabile edificio;
	
	
	//Li randomizziamo?
	private int ceff;
	private int cinv;
}
