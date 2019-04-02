/**
 * 
 */
package test4;

/**
 * @author wrafeiner
 *
 */
public class BuchstabeMitErsatz extends Buchstabe 
	implements IstUmwandelbar {
	private String ersatzBuchstaben; 
	/* (non-Javadoc)
	 * @see test4.IstUmwandelbar#umwandeln(java.lang.String)
	 */

	@Override
	public String umwandeln(String text) {
		if(text == null || text.length()<1)
			throw new UngueltigeLaengeException(
					"kein brauchbarer Ersatzbuchstabe angeben!");
		else 
			return text.replace(""+this.getBuchstabe(),
					this.ersatzBuchstaben);
	}

	/**
	 * @param ersatzBuchstaben
	 */
	public BuchstabeMitErsatz(char b, String ersatzBuchstaben) {
		super(b);
		this.setErsatzBuchstaben(ersatzBuchstaben);
	}

	/**
	 * @param ersatzBuchstaben
	 */
	public BuchstabeMitErsatz(String ersatzBuchstaben) {
		this(' ',ersatzBuchstaben);
	}

	/**
	 * @return the ersatzBuchstaben
	 */
	public String getErsatzBuchstaben() {
		return ersatzBuchstaben;
	}

	/**
	 * @param ersatzBuchstaben the ersatzBuchstaben to set
	 */
	public void setErsatzBuchstaben(String eb)
	{
		if(eb == null || eb.length()<1)
			throw new UngueltigeLaengeException(
					"kein brauchbarer Ersatzbuchstabe angeben!");
		else 
			this.ersatzBuchstaben = ersatzBuchstaben;
	}
	
	/* (non-Javadoc)
	 * @see test4.Buchstabe#buchstabenText()
	 */
	@Override
	public String buchstabenText() {
		return super.buchstabenText()+
				"("+this.ersatzBuchstaben+")";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
