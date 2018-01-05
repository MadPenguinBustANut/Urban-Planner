package seleziona;

import java.util.Comparator;

import centrourbano.Lotti;

public class InvComparator implements Comparator<Lotti>{
	
	public int compare(Lotti o1, Lotti o2) {
		
		return Double.compare(o1.getCinv(),o2.getCinv());
	}
}
