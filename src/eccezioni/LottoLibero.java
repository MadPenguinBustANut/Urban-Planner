package eccezioni;

public class LottoLibero extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4228013978269762512L;

	public LottoLibero() {
		super("Il lotto è vuoto:");
	}

}
