package G614;

import java.util.Random;

public class Zahlenarray {
	private int[] zahlen;
	public Zahlenarray() {
		this(5);
	}
	
	public Zahlenarray(int stellen) {
		this.zufallsArray(stellen);
	}

	public void zufallsArray(int stellen) {
		Random r=new Random();
		zahlen= r.ints(stellen, 0, stellen*2+1).toArray();
	}
	public String arrayToText() {
		StringBuilder s=new StringBuilder();
		for (int i=0;i<zahlen.length;++i) {
			s.append(zahlen[i]);
			if(i<zahlen.length-1)
				s.append(" ,");
		}
		return s.toString();
	}
	public void umdrehen() {
		int temp;
		int j=zahlen.length/2;
		int max=zahlen.length-1;
		for (int i=0;i<j;++i) {
			temp=zahlen[i];
			zahlen[i]=zahlen[max-i];
			zahlen[max-i]=temp;
		}
	}
}
