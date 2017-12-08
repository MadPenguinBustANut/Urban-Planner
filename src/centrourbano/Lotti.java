package centrourbano;

import java.io.Serializable;

import edifici.Edificabile;

public class Lotti implements Serializable{
	private static final long serialVersionUID = 1L;

	public Lotti() {
		edi = VUOTO;
	}
	
	/**
	 * La funzione verrà usata per modificare il tipo di edificio
	 * sostituendolo con il nuovo edificio
	 * 
	 * @param NuovoEdificio
	 */
	public void modEdi(Edificabile NuovoEdificio) {
		edi = NuovoEdificio;
	}
	
	
	
	public int getVal() {
		if(edi.getTipo() == 3);
			//TODO
		
		return 0;
	}

	public int getTip() {
		return edi.getTipo();
		
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

	Edificabile edi;
	
	
	//Li randomizziamo?
	private int ceff;
	private int cinv;
	
	private static Edificabile VUOTO = new Edificabile(){
		private static final long serialVersionUID = 1L;

		public int getTipo() {
			return 0;
		}
		
		
	};
	
	private static int LIBERO = 0;
	private static int STRADA = 1;
	private static int EPUB = 2;
	private static int EPRIV = 3;

	
	//DA FARE
	public void setVal(int i) {
		
	}

	public void setTip(int i) {
		// TODO Auto-generated method stub
		
	}

	
}
