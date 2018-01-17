package eccezioni;

import java.io.IOException;

public class NotPrivException extends IOException{

	/**
	 * 
	 */

	public NotPrivException() {
		super("Il lotto non è Privato");
	}

}
