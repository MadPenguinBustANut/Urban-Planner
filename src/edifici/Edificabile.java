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
	
	
	public int ceff;
	public int cinv;
	
	private static final int	LIBERO = 0;
	private static final int	STRADA = 1;
	private static final int	PUBBLICO = 2;
	private static final int	PRIVATO = 3;
}
