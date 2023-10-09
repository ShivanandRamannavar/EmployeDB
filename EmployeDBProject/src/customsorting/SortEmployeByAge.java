package customsorting;

import java.util.Comparator;

import edbms.Employe;

public class SortEmployeByAge implements Comparator<Employe> {

	@Override
	public int compare(Employe e1, Employe e2) {
		Integer x=e1.getAge();
		Integer y=e2.getAge();
		return x.compareTo(y);
		
		//e1.getAge()-e2.getAge();
	}

}
