package test2;
public class Test {
  public static void main(String[] args) {
    int[] arr = new int[1];
    int x = 7;
    arr[0] = 3;
    Test.methode(x);
    System.out.println(x);
  }
  public static void methode(int a) {
    a = a * 2;
  }
}
