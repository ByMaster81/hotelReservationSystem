package hotelreservation;

import java.util.Comparator;
public class CostComparator implements Comparator<services>{



	@Override
	public int compare(services o1, services o2) {
		if(o1.getCost() == o2.getCost()) {
			return 0;
		}
		else if(o1.getCost()<o2.getCost()) {
			return 1;
		}
		else {
			return -1;
		}
	}

}
