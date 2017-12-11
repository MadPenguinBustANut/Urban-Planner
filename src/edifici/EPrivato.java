package edifici;

public class EPrivato extends Edificabile{
	private static final long serialVersionUID = 1L;

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
