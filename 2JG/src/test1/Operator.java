package test1;

public class Operator {

	private char operator;

	public Operator(char o) {
		this.setOperator(o);
	}

	public Operator() {
		this('+');
	}

	public static boolean isOperator(char o) {
		return (o == '+' || o == '*');
	}

	public String auswerten(String s, String z) {
		String ret = "";
		int zahl = -1;
		if (this.operator == '*') {
			try {
				zahl = Integer.parseInt(z);
				for (int i = 0; i < zahl; ++i) {
					ret += s;
				}
			} catch (Exception e) {
			}
		}
		else {
			ret=s+z;
		}
		return ret;
	}
	public String wort() {
		return (this.operator=='+')?
				"Addition":"Multiplikation";
	}
	public String text() {
		return "Operator: "+this.operator+"("+this.wort()+")";
	}
	/**
	 * @return the operator
	 */
	public char getOperator() {
		return operator;
	}
	/**
	 * @param operator the operator to set
	 */
	public void setOperator(char o) {
		if(Operator.isOperator(o))
			this.operator = o;
		else
			this.operator = '+';
	}
	public boolean bindetStaerker(Operator o2) {
		char o=o2.getOperator();
		if(Operator.isOperator(o)) {
			if (this.operator=='*' && o=='+')
					return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Operator o1=new Operator('*');
		System.out.println(o1.text());
		System.out.println(o1.auswerten("*", "4"));
		Operator o2=new Operator('+');
		System.out.println(o2.text());
		System.out.println(o2.auswerten("*", "4"));
		if(o1.bindetStaerker(o2)) {
			System.out.println("Der Operator "+o1.wort()+" bindet staerker "+
						"als "+o2.wort());
		}
	}

}
