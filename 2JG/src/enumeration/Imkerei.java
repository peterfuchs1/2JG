/**
 * 
 */
package enumeration;

/**
 * @author uhs374h
 *
 */
public enum Imkerei {
	HONIG(500) {
		@Override
		public float preis() {
			return 7.0F;
		}
	},
	LIPPENBALSAM(10) {
		@Override
		public float preis() {
			return 1;
		}
	},
	PROPOLIS(30) {
		@Override
		public float preis() {
			return 9;
		}
	};
	private int menge;
	public abstract float preis();
	private Imkerei(int menge){
		this.setMenge(menge);
	}
	/**
	 * @return the menge
	 */
	public int getMenge() {
		return menge;
	}
	/**
	 * @param menge the menge to set
	 */
	public void setMenge(int menge) {
		this.menge = menge;
	}
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		String einheit=(this!=PROPOLIS)?"g":"ml";
		return ""+this.menge+einheit+" "+this.name()+" kosten "+this.preis()+"€";
	}
	
}
