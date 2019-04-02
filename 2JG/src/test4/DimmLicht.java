package test4;

public class DimmLicht extends Licht implements IstSteuerbar {
	private int wert;

	public DimmLicht(String name, boolean eingeschaltet, int wert) 
			throws NegativeValueException {
		super(name, eingeschaltet);
		this.setWert(wert);
	}

	@Override
	public void erhoehen(int wert) throws NegativeValueException{
		this.checkValue(wert);
		this.setWert(wert+this.wert);
		if (this.wert>100) this.wert=100;
	}

	private void checkValue(int wert) throws NegativeValueException {
		if (wert<0) throw new NegativeValueException();
	}
	
	/**
	 * @return the wert
	 */
	public int getWert() {
		return wert;
	}

	/**
	 * @param wert the wert to set
	 * @throws NegativeValueException 
	 */
	public void setWert(int wert) throws NegativeValueException {
		checkValue(wert);
		this.wert = wert;
	}

	@Override
	public void verringern(int wert)  throws NegativeValueException{
		this.checkValue(wert);
		if (this.wert-wert<0) 
			this.wert=0;
		else
			this.wert -= wert;
	}

	@Override
	public String beschreibung() {
		return super.beschreibung()+"("+this.wert+")";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 3;
		result = prime * result + wert;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) return false;
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		DimmLicht other = (DimmLicht) obj;
		if (wert != other.wert) return false;
		return true;
	}

}
