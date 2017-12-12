package edifici;

import java.io.Serializable;

public abstract class Edificabile implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	public abstract int getTipo();
	
	
	public int getCeff() {
		return ceff;
	}
	public void setCeff(int nuovo) {
		ceff = nuovo;
	}

	public int getCinv() {
		return cinv;
	}
	
	public void setCinv(int nuovo) {
		cinv = nuovo;
	}
	
	
	private int ceff;
	private int cinv;
	
	public static final int	LIBERO = 0;
	public static final int	STRADA = 1;
	public static final int	PUBBLICO = 2;
	public static final int	PRIVATO = 3;
}
