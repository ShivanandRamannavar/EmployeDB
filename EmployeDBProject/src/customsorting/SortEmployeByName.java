package customsorting;

import java.util.Comparator;

import edbms.Employe;

public class SortEmployeByName implements Comparator<Employe> {

	@Override
	public int compare(Employe e1, Employe e2) {
		String x=e1.getName();
		String y=e2.getName();
		x.compareTo(y);
		
		//e1.getName().compareTo(e2.getName());
		
		return 0;
	}

}
