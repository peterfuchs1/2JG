package test4;
public class Licht {
	private String name;
	private boolean eingeschaltet;
	/**
	 * @param name
	 * @param eingeschaltet
	 */
	public Licht(String name, boolean eingeschaltet) {
		super();
		this.name = name;
		this.eingeschaltet = eingeschaltet;
	}
	/**
	 * 
	 */
	public Licht() {
		this("Licht", true);
	}
	/**
	 * @return the eingeschaltet
	 */
	public boolean isEingeschaltet() {
		return eingeschaltet;
	}
	public void ausschalten() {
		this.eingeschaltet = false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (eingeschaltet ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Licht other = (Licht) obj;
		if (eingeschaltet != other.eingeschaltet)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public void einschalten() {
		this.eingeschaltet = true;
	}
	/**
	 * @return the name
	 */
	public String beschreibung() {
		String status=(this.eingeschaltet)?"An":"Aus";
		return "Licht: "+this.name+" - "+status;
	}

}
