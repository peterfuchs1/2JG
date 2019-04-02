package nost191;

public class Parameter {

	public static void main(String[] args) {
		int[] zahlen= {2,4,6,8,10};
		aendern(zahlen);
		System.out.println(zahlen[1]);
	}

	private static void aendern(int[] arr) {
		arr[1]=arr[2]*2;		
	}

}
