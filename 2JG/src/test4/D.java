package test4;

public class D extends C {
	@Override
	public void method() {
		super.method();
		System.out.println("Ich bin in Klasse D");
	}
	public static void main(String[] args) {
		D myD=new D();
		myD.method();
	}

}
