package edbms;

public class Employe {
 private String id;
 private int age;
 private String name;
 private double sallary;
 private static int count=101;
 
 public Employe(int age, String name, double sallary) {
	 this.id="JSP"+count;
	 this.age=age;
	 this.name=name;
	 this.sallary=sallary;
	 count++;
 }

public String getId() {
	return id;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getSallary() {
	return sallary;
}

public void setSallary(double sallary) {
	this.sallary = sallary;
}

public static int getCount() {
	return count;
}

public static void setCount(int count) {
	Employe.count = count;
}

@Override
public String toString() {
	return "Employe ID:"+id+" Emp Name: "+name+" Emp Age: "+age+" Emp Sallary: "+sallary;
}
 
}
