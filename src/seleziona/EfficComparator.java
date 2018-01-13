package seleziona;

import java.util.Comparator;

import centrourbano.Lotti;

public class EfficComparator implements Comparator<Lotti>{
	
	public int compare(Lotti o1, Lotti o2) {
		if (o1== null) {
	        return (o2== null) ? 0 : -1;
	    }
	    if (o2== null) {
	        return 1;
	    }
		return Integer.compare(o1.getCeff(),o2.getCeff());
	}
}