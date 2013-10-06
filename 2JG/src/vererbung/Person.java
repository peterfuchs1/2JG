package vererbung;

public class Person {
	private String name;
	public Person() {
		this("");
	}
	public Person(String string) {
		this.name=string;
	}
	public String toString() {
		return "Name: name";
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
