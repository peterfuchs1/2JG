package scanner;

import java.util.Scanner;

public class Einlesen {

	public static void main(String[] args) {
		java.util.Scanner sc = new Scanner(System.in);
		String name = sc.next();  // It will not leave until the user enters data.
		int number = sc.nextInt(); // We can read specific data.
		System.out.println("Name " + name + "\t number " + number);
		number= sc.nextInt(); // We can read specific data.
		System.out.println("Name " + name + "\t number " + number);
		boolean bool= sc.nextBoolean();
		System.out.println("Name " + name + "\t bool " + bool);
		double d=sc.nextDouble(); 
		System.out.println("Name " + name + "\t double " + d);
		
	}

}
