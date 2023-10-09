package edbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customexception.EmployeNotFoundException;
import customexception.InvaliChoiceException;
import customsorting.SortEmployeByAge;
import customsorting.SortEmployeById;
import customsorting.SortEmployeByName;
import customsorting.SortEmployeBySallary;

public class EmployeManagementSystemImpl implements EmployeManagementSystem{

	Scanner scan=new Scanner(System.in);
	Map<String,Employe> db=new LinkedHashMap<String,Employe>(); 

	private static void display(List<Employe> list) {
		for(Employe e:list) {
			System.out.println(e);
		}
	}

	@Override
	public void addEmploye() {
		System.out.println("Enter Employe Name");
		String name=scan.next();
		System.out.println("Enter Age:");
		int age=scan.nextInt();
		System.out.println("Enter Sallary");
		double sallary=scan.nextDouble();

		Employe emp=new Employe(age,name,sallary);
		db.put(emp.getId(), emp);
		System.out.println("Employe added Successfully");
		System.out.println("Employe ID is: "+emp.getId());
	}

	@Override
	public void displayEmploye() {
		System.out.println("Enter Employe Id:");
		String id=scan.next().toUpperCase();
		if(db.containsKey(id)) {
			Employe emp=db.get(id);
			System.out.println("ID: "+emp.getId());
			System.out.println("Age: "+emp.getAge());
			System.out.println("Name: "+emp.getName());
			System.out.println("Sallary: "+emp.getSallary());
		}
		else {
			try {
				String message="Employe with id "+id+" not found";
				throw new EmployeNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void displayAllEmploye() {
		if(db.size()!=0) {
			System.out.println("Employe Details As Follows");
			System.out.println("---------------------------");
			Set<String> keys=db.keySet();
			for(String key: keys) {
				System.out.println(db.get(key));
			}
		}
		else {
			try {
				String message="Record Not Found";
				throw new EmployeNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void rmoveEmploye() {
		System.out.println("ENter EMploye ID: ");
		String id=scan.next().toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("Employe Detils:");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Employe Removed Successfully!!");
		}
		else {
			try {
				String message="Employe Id: "+id+" Not Found";
				throw new EmployeNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeAllEmploye() {
		if(db.size()!=0) {
			System.out.println("Number Of Employe Records: "+db.size());
			db.clear();
			System.out.println("Records Removed Successfully");
			System.out.println("Number Of Emoloye Records "+db.size());
		}
		else {
			try {
				String messege="Employe DB is Empty!!";
				throw new EmployeNotFoundException(messege);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void updateEmploye() {
		System.out.println("Enter Employe Id: ");
		String id=scan.next().toUpperCase();

		if(db.containsKey(id)) {
			Employe emp=db.get(id);

			System.out.println("1.Update Employe Name:\n2.Update Employe Age:\n3.Update Employe Sallary");
			System.out.println("Enter Your Choice");
			int choice=scan.nextInt();


			switch(choice) {
			case 1:
				System.out.println("Enter Name:");
				String name=scan.next();
				emp.setName(name);
				System.out.println("Name Updated Successfully!!");
				break;
			case 2:
				System.out.println("Enter Age: ");
				int age=scan.nextInt();
				emp.setAge(age);
				System.out.println("Age Updated Successfully!!");
				break;
			case 3:
				System.out.println("Enter Sallary: ");
				double sallary=scan.nextDouble();
				emp.setSallary(sallary);
				System.out.println("Sallary Updated Successfully!!");
				break;
			default:
				try {
					String message="Invalid Choice";
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}

		}
		else {
			try {
				String message="Employe Not Found";
				throw new EmployeNotFoundException(message);

			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void countEmploye() {
		System.out.println("Number of Employe: "+db.size());
	}

	@Override
	public void sortEmplye() {
		Set<String> keys=db.keySet();
		List<Employe> list=new ArrayList<Employe>();
		for(String key:keys) {
			list.add(db.get(key));
		}
		System.out.println("1.Sort By Employe Id:\n2.Sort Employe By Age:");
		System.out.println("3.Sort Employe By Name:\n4.Sort Emloye By Sallary");
		System.out.println("Enter Your Choice");

		int choice=scan.nextInt();

		switch(choice) {
		case 1:
			Collections.sort(list, new SortEmployeById());
			display(list);
			break;
		case 2:
			Collections.sort(list, new SortEmployeByAge());
			display(list);
			break;
		case 3:
			Collections.sort(list, new SortEmployeByName());
			display(list);
			break;
		case 4:
			Collections.sort(list,new SortEmployeBySallary());
			display(list);
			break;
		default:
			try {
				String message="Invalid Choice";
				throw new InvaliChoiceException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void getEmployeWithLOwestSallary() {
		Set<String> keys=db.keySet();
		List<Employe> list=new ArrayList<Employe>();
		for(String key:keys) {
			list.add(db.get(keys));
		}
		Collections.sort(list,new SortEmployeBySallary());
		System.out.println(list.get(0));

	}

	@Override
	public void getEmployeWithHighestSallary() {
		Set<String> keys=db.keySet();
		List<Employe> list=new ArrayList<Employe>();
		for(String key:keys) {
			list.add(db.get(keys));
		}
		Collections.sort(list, new SortEmployeBySallary());
		System.out.println(list.size()-1);
	}

}
