package test4;
public class A2 {
	  public static void method(B b) {
		    b = new B();
		    b.set('x');
		  }

  public static void main(String[] args) {
    B obj = new B();
    obj.set('a');
    A2.method(obj);
    System.out.println(obj.get());
  }
}
