package edifici;

import java.util.Random;

public class EPrivato extends Edificabile{
	private static final long serialVersionUID = 1L;
	
	public EPrivato() {
		 Random rnd = new Random(System.currentTimeMillis());
		 valore=rnd.nextInt(100);
	}

	int valore;
	
	public int getValore() {
		return valore;
	}
	
	public void setValore(int nuovovalore) {
		valore= nuovovalore;
	}
	
	public int getTipo() {
		return 3;
	}
}
