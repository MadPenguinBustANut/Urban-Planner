package edifici;

import java.io.Serializable;
import java.util.Random;

public abstract class Edificabile implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public Edificabile() {
		 Random rnd = new Random(System.currentTimeMillis());
		 ceff=rnd.nextInt(100);
		 cinv=rnd.nextInt(100);
	}
	
	
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
