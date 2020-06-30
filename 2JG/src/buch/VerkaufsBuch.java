/**
 * 
 */
package buch;


/**
 * @author uhs374h
 *
 */
public class VerkaufsBuch extends Buch implements Verkaufbar {
	private double preis;
	
	/**
	 * @param name
	 * @param autor
	 * @param seitenzahl
	 * @param preis
	 */
	public VerkaufsBuch(String name, String autor, int seitenzahl, double preis) {
		super(name, autor, seitenzahl);
		this.preis = preis;
	}
	
	/**
	 * @return the preis
	 */
	public double getPreis() {
		return preis;
	}

	/**
	 * @param preis the preis to set
	 */
	public void setPreis(double preis) {
		this.preis = preis;
	}

	@Override
	public String buchDaten() {
		// TODO Auto-generated method stub
		return super.buchDaten()+" - "+this.preisInfo();
	}
	

	@Override
	public String preisInfo() {
		return String.format("%3.2f", this.preis)+" EUR";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VerkaufsBuch vb=new VerkaufsBuch("Mein Buch", "Max Mustermann", 112, 35.90);
		System.out.println(vb.preis);
		System.out.println(vb.preisInfo());
		System.out.println(vb.buchDaten());
	}

}
