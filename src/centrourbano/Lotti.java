package centrourbano;

import java.io.Serializable;
import edifici.*;

public class Lotti implements Serializable{
	private static final long serialVersionUID = 1L;

	public Lotti() {
		edificio = VUOTO;
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
	public void modEdi(Edificabile NuovoEdificio) {
		edificio = NuovoEdificio;
	}

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
		return edificio.getCeff();
	}
	public void setCeff(int ceff) {
		edificio.setCeff(ceff);
	}
	public int getCinv() {
		return edificio.getCinv();
	}
	public void setCinv(int cinv) {
		edificio.setCinv(cinv);
	}


	private Edificabile edificio;
	
	
	private static Edificabile VUOTO = new Edificabile(){
		private static final long serialVersionUID = 1L;

		public int getTipo() {
			return 0;
		}	
	};
}
