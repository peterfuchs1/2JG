/**
 * 
 */
package enumeration;

/**
 * @author uhs374h
 *
 */
public enum Day {
	MONDAY(1),
	TUESDAY(2),
	WEDNESDAY(3),
	THURSDAY(4),
	FRIDAY(5),
	SATURDAY(6),
	SUNDAY(7);
	
	private int value;
	
	private Day(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		switch(this) {
			case FRIDAY:
				return "Friday: " + value;
			case MONDAY:
				return "Monday: " + value;
			case SATURDAY:
				return "Saturday: " + value;
			case SUNDAY:
				return "Sunday: " + value;
			case THURSDAY:
				return "Thursday: " + value;
			case TUESDAY:
				return "Tuesday: " + value;
			case WEDNESDAY:
				return "Wednesday: " + value;
			default:
				return null;
		}
	}
	/**
	 * Isn't this day a working day?
	 * @param day
	 * @return
	 */
	public static boolean isWeekEnd(Day day )
	{
	  return  day == Day.SATURDAY || day == Day.SUNDAY;
	}
	/**
	 * Is it a working day?
	 * @param day
	 * @return
	 */
	public static boolean isWorkingDay(Day day){
		return !Day.isWeekEnd(day);
	}
    private static Day[] vals = values();
    /**
     * which is the next day from today?
     * @return the next day
     */
    public Day next()
    {
        return vals[(this.ordinal()+1) % vals.length];
    }
    /**
     * which is the previous day from today?
     * @return the previous day
     */
    public Day previous()
    {
        return vals[(this.ordinal()+vals.length-1) % vals.length];
    }
}
