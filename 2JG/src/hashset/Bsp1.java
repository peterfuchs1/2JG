package hashset;

import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Bsp1 {
	private HashSet<Integer> abc;

	@SuppressWarnings("unused")
	public Bsp1() {
		int zaehler = 0;
		int z = 0;
		abc = new HashSet<Integer>();
		for (int i = 0; i < 20; i++) {
			abc.add(0 + z);
			z += 7;
		}
		String help = JOptionPane
				.showInputDialog("Gib eine Zahl von 0 bis  140 ein");
		int as = Integer.parseInt(help);
		for (int k = 0; k < 5; k++) {
			if (as == abc.hashCode()) {
				abc.remove(as);
			} else {
				zaehler++;

			}
		}
		
	}
	void print(){
		Iterator<Integer> hiho = abc.iterator();
		while (hiho.hasNext()) {
			Integer x = hiho.next();
			System.out.println(x);
		}	
	}
	public static void main(String[] args) {
		Bsp1 bsp=new Bsp1();
		bsp.print();
		
	}
}