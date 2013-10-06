package test_komplex;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Komplex k=new Komplex(2,5);
		k.divide(3, 7);
		k.multiply(58);
		System.out.println(k.toString());
		System.out.println(k.toPolar());
		System.out.println(k.toTrigonometric());

	}

}
