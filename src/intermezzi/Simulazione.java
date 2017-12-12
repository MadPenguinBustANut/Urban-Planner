package intermezzi;

import java.awt.List;
import centrourbano.CentroUrbano;
import centrourbano.Lotti;
import centrourbano.Settori;
import edifici.Edificabile;

public class Simulazione {
	
	public Simulazione() {
	}
	
	public void invecchiamento (CentroUrbano centro) {
		for (Settori[]x : centro.lista ) {
			for (Settori a: x) {
				for (Lotti[]c: a.lista) {
					for (Lotti d: c) {
							d.setCeff(d.getCeff()-(d.getCeff()*d.getCinv())/100);
				
				}
			}
		}
	}
	}
}
