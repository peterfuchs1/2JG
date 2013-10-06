package grundrechnungsarten_neu2;

import java.util.TreeMap;

public class Possibility {
	private TreeMap<Integer, Boolean> p;
	private int min,max, inkrement;
	/**
	 * Allgemeiner Konstruktor
	 * @param min
	 * @param max
	 */
	public Possibility(int min, int max, int inkrement) {
		this.min = min;
		this.max = max;
		this.inkrement=inkrement;
		p=new TreeMap<Integer,Boolean>();
	}
	public void initiate(){
		for(int d =min;d<=max;d+=inkrement){
			p.put(d, true);
		}
	}
	public void setValue (int key, boolean value ){
		p.put(key, value);
	}
	public boolean getValue (int key){
		return p.get(key).booleanValue();
	}
	/**
	 * @return the min
	 */
	public int getMin() {
		return min;
	}
	/**
	 * @param min the min to set
	 */
	public void setMin(int min) {
		this.min = min;
	}
	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}
	/**
	 * @param max the max to set
	 */
	public void setMax(int max) {
		this.max = max;
	}
	
	
}
