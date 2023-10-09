package customexception;

public class InvaliChoiceException extends Exception {
	
	 private String message;
	 
	 public InvaliChoiceException(String message){
		 this.message=message;
	 }
	 
	@Override
	public String getMessage() {
		return message;
	}

}
