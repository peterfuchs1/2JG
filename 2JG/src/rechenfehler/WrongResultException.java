package rechenfehler;

public class WrongResultException extends Exception {
	public WrongResultException(){
		super();
	}
	public WrongResultException(String s){
		System.err.println(s);
	}
}
