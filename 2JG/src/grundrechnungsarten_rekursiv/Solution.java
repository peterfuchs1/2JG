package grundrechnungsarten_rekursiv;

import java.util.ArrayList;

public class Solution<T extends Number> {
	private int anzahl;
	private ArrayList<T> val;
	/**
	 * @return the val
	 */
	public T getVal(int index){
		return val.get(index);
	}
	/**
	 * @param val the val to set
	 */
	public void setVal(int index, T element){
		this.val.add(index, element);
	}
	public int length(){
		return anzahl;
	}
	Solution(int anzahl){
		val=new ArrayList<T>(anzahl);
		this.anzahl=anzahl;
	}
	
}
