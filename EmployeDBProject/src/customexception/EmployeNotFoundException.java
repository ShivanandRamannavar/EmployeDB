package customexception;

public class EmployeNotFoundException extends RuntimeException {
private String message;


 public EmployeNotFoundException(String message) {
	 this.message=message;
 }
 
 @Override
 public String getMessage() {
	 return message;
 }




}
