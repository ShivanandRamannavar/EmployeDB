package customsorting;

import java.util.Comparator;

import edbms.Employe;

public class SortEmployeById implements Comparator<Employe>{

	@Override
	public int compare(Employe e1, Employe e2) {
		String x=e1.getId();
		String y=e2.getId();
		return x.compareTo(y);
		//return e1.getId().compareTo(e2.getId());
	}

}
//e1->Object To be insterted
//e2-> already existing object