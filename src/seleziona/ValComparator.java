package seleziona;

import java.util.Comparator;

import centrourbano.Lotti;

public class ValComparator implements Comparator<Lotti>{
	
	public int compare(Lotti o1, Lotti o2) {
		
		if (o1== null) {
	        return (o2== null) ? 0 : -1;
	    }
	    if (o2== null) {
	        return 1;
	    }
	    if(o1.getTip()!=3) return 0;
		return Integer.compare(o1.getValore(),o2.getValore());
	}
}
