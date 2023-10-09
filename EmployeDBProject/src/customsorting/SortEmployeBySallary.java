package customsorting;

import java.util.Comparator;

import edbms.Employe;

public class SortEmployeBySallary implements Comparator<Employe> {

	@Override
	public int compare(Employe e1, Employe e2) {
		Double x=e1.getSallary();
		Double y=e2.getSallary();
		
		return x.compareTo(y);
		
		//return e1.getSallary()-e2.getSallary();
	}

}
