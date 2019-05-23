package test4;
public class A {
  public static void method(B b) {
    b.set('x');
  }
  public static void main(String[] args) {
    B obj = new B();
    obj.set('a');
    A.method(obj);
    
    System.out.println(obj.get());
  }
}
