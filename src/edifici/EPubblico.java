package edifici;

public class EPubblico extends Edificabile{
	private static final long serialVersionUID = 1L;

	public int getTipo() {
		return 2;
	}

	
	public short getStato() {
		return stato;
	}
	
	public void addStato() {
		stato++;
	}
	
	private short stato = 0;

}
