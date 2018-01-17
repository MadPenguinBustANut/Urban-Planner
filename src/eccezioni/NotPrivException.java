package eccezioni;

import java.io.IOException;

public class NotPrivException extends IOException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6454436569771712595L;

	/**
	 * 
	 */

	public NotPrivException() {
		super("Il lotto non è Privato");
	}

}
