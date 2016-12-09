package abstrakt;
/**
 * Klasse Person 
 * @author Walter Rafeiner-Magor
 * @version 1.2
 */
public abstract class Person implements Printable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1801294918292966838L;
	protected static long ID;
	private long id;
	private String nachName;
	private String vorName;	

	/**
	 * Konstruktor mit einem Parameter
	 * @param nachName
	 */
	public Person(String nachName) {
		this(nachName,"");
	}
	/**
	 * Konstruktor mit 2 Parameter
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
	/**
	 * {@link Printable#print(boolean)}
	 */
	@Override
	public void print(boolean newLine) {
		System.out.print(this.getKlassenName()+this.toString());
		if(newLine)
			System.out.println();
	}

}
