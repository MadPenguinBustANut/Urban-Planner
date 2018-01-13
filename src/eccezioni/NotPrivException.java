package eccezioni;

import java.io.IOException;

public class NotPrivException extends IOException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotPrivException() {
		super("Il lotto non è Privato");
	}

}
