package rechenfehler;

public class WrongResultException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4360152493026262994L;
	public WrongResultException(){
		super();
	}
	public WrongResultException(String s){
		System.err.println(s);
	}
}
