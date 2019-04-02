package test4;
public class QuadratTest {
  public static void main(String[] args) {
	  Quadrat q1 = new Quadrat(1);
	  Quadrat q2 = new Quadrat(2);
	  if (q1.istKleiner(q2))
		  System.out.println(q1.text());
  }
}
