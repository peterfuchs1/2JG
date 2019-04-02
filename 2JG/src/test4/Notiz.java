package test4;

import java.time.LocalDate;

public class Notiz {
	private long idNummer;
	private LocalDate datum;
	private String inhalt;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		result = prime * result + (int) (idNummer ^ (idNummer >>> 32));
		result = prime * result + ((inhalt == null) ? 0 : inhalt.hashCode());
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
		Notiz other = (Notiz) obj;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (idNummer != other.idNummer)
			return false;
		if (inhalt == null) {
			if (other.inhalt != null)
				return false;
		} else if (!inhalt.equals(other.inhalt))
			return false;
		return true;
	}

	

	/**
	 * @param idNummer
	 * @param datum
	 * @param inhalt
	 */
	public Notiz(long idNummer, LocalDate datum, String inhalt) {
		super();
		this.idNummer = idNummer;
		this.datum = datum;
		this.inhalt = inhalt;
	}



	/**
	 * @return the idNummer
	 */
	public long getIdNummer() {
		return idNummer;
	}

	/**
	 * @param idNummer the idNummer to set
	 */
	public void setIdNummer(long idNummer) {
		this.idNummer = idNummer;
	}

	/**
	 * @return the datum
	 */
	public LocalDate getDatum() {
		return datum;
	}

	/**
	 * @param datum the datum to set
	 */
	public void setDatum(LocalDate datum) {
		datum = datum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
