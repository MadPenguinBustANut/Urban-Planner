package eccezioni;

public class LottoLibero extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public LottoLibero() {
		super("Il lotto è vuoto");
	}

}
