package eccezioni;

import java.io.IOException;

public class Ortogonale extends IOException{

	public Ortogonale() {
		super("La direzione non e' ortogonale");
	}
}
