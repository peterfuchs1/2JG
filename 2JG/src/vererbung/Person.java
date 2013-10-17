package vererbung;
/**
 * Klasse Person 
 * @author uhs374h
 * @version 1.1
 */
	
public class Person {
	private static long ID;
	private long id;
	private String nachName;
	private String vorName;

	
	/**
	 * 
	 */
	public Person() {
		this("");
	}
	/**
	 * @param nachName
	 */
	public Person(String nachName) {
		this(nachName,"");
	}
	/**
	 * @param nachName
	 * @param vorName
	 */
	public Person(String nachName, String vorName) {
		this.nachName = nachName;
		this.vorName = vorName;
		this.id=Person.ID++;
	}
	/**
	 * {@link java.lang.Object#toString()}
	 */
	@Override 
	public String toString() {
		return "id: "+id+", Name: "+nachName+", Vorname: "+vorName;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return nachName;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.nachName = name;
	}
	/**
	 * @return the nachName
	 */
	public String getNachName() {
		return nachName;
	}
	/**
	 * @param nachName the nachName to set
	 */
	public void setNachName(String nachName) {
		this.nachName = nachName;
	}
	/**
	 * @return the vorName
	 */
	public String getVorName() {
		return vorName;
	}
	/**
	 * @param vorName the vorName to set
	 */
	public void setVorName(String vorName) {
		this.vorName = vorName;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the iD
	 */
	public static long getLastID() {
		return Person.ID;
	}
	
}
