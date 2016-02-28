/**
 * 
 */
package enumeration;

/**
 * @author uhs374h
 *
 */
public class TestDay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(Day day: Day.values())
			System.out.println(day.name());
		Day day=Day.MONDAY;
		
//		for(int i=0;i<10;i++, day=day.next())
//			System.out.println(day);
		for(int i=0;i<10;i++, day=day.previous())
			System.out.println(day);
	}
	
}
