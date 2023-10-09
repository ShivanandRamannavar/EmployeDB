package edbms;

import java.util.Scanner;

import customexception.EmployeNotFoundException;

public class Solution {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		EmployeManagementSystem ems=new EmployeManagementSystemImpl();
		
		System.out.println("Welcome To Employe DB Management System");
		System.out.println("====================================");
		while(true) {
			System.out.println("1.Add Employe Details:\n2.Display Emplye:\n3.Display All Emplye:\n4.Remov Emplye");
			System.out.println("5.Remove All Employe:\n6.Update Employe:\n7.Count Employe:\n8.Sort Emplye:");
			System.out.println("9.Get EMploye With Lowest Sallary:\n10.Get Employe With Highest Sallary\n11.EXIT..");
			System.out.println("Enter Your Choice");

			int choice=scan.nextInt();
			switch(choice) {
			case 1:
				ems.addEmploye();
				break;
			case 2:
				ems.displayEmploye();
				break;
			case 3:
				ems.displayAllEmploye();
				break;
			case 4:
				ems.rmoveEmploye();
				break;
			case 5:
				ems.removeAllEmploye();
				break;
			case 6:
				ems.updateEmploye();
			case 7:
				ems.countEmploye();
				break;
			case 8:
				ems.sortEmplye();
				break;
			case 9:
				ems.getEmployeWithLOwestSallary();
				break;
			case 10:
				ems.getEmployeWithHighestSallary();
				break;
			case 11:
				System.out.println("Thank You!!");
				System.exit(0);
			default:
				try {
					String message="Invalid Choice, Enter Valid Choice";
					throw new EmployeNotFoundException(message);

				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}

System.out.println("========================");

		}

	}

}
