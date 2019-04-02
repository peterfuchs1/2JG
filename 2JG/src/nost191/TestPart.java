package nost191;

public class TestPart {

	public static void main(String[] args) {
		Part p1=new Part("L102", "Servo-Motor");
		Part p2=new Part("L105", "IR-Sensor");
		p1.setStueckzahl(10);
		p2.setStueckzahl(-1);
		p2.setStueckzahl(2);
		System.out.println(""+p2.entnehmen(3));
		System.out.println(""+p2.entnehmen(2));
		System.out.println(""+p2.istLeer());
		System.out.println(""+p1.istMehr(p2));
		System.out.println(p1.partInfo());
		System.out.println(p2.partInfo());
	}

}
