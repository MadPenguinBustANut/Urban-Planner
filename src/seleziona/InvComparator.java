package seleziona;

import java.util.Comparator;

import centrourbano.Lotti;

public class InvComparator implements Comparator<Lotti>{
	
	public int compare(Lotti o1, Lotti o2) {
		if (o1== null) {
	        return (o2== null) ? 0 : -1;
	    }
	    if (o2== null) {
	        return 1;
	    }
		return Double.compare(o1.getCinv(),o2.getCinv());
	}
}
