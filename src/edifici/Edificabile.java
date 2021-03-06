package edifici;

import java.io.Serializable;
import java.util.Random;

public abstract class Edificabile implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4469409375632492047L;

	public Edificabile() {
		 Random rnd = new Random(System.currentTimeMillis());
		 ceff=rnd.nextInt(100);
		 cinv=rnd.nextInt(10);
	}
	
	
	public abstract int getTipo();
	
	
	public int getCeff() {
		return ceff;
	}
	public void setCeff(int nuovo) {
		ceff = nuovo;
		if(ceff>100) ceff=100;
		if(ceff<0) ceff= 0;
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
