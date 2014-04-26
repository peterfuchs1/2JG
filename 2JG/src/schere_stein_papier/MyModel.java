/**
 * 
 */
package schere_stein_papier;

/**
 * Klasse zum Regeln des Spielverlaufs
 * 
 * @author Daniel May
 * @version 1.0
 * 
 */
public class MyModel {

	private Wahl pczug;
	private Wahl menschzug;

	private int pccounter;
	private int menschcounter;
	private int[] stat;// Siege, Unentschieden, Niederlagen
	private String aktuellerText;
	private int aktuellesSpiel; // 0 unentschieden <0 verloren >0 gewonnen

	/**
	 * Standard konstruktor
	 */
	public MyModel() {
		this.stat = new int[3];
		reset();
	}

	/**
	 * @return the aktuellesSpiel
	 */
	public int getAktuellesSpiel() {
		return aktuellesSpiel;
	}

	/**
	 * @return the pczug
	 */
	public Wahl getPczug() {
		return pczug;
	}

	/**
	 * @return the pccounter
	 */
	public int getPccounter() {
		return pccounter;
	}

	/**
	 * @param pccounter
	 *            the pccounter to set
	 */
	public void setPccounter(int pccounter) {
		this.pccounter = pccounter;
	}

	/**
	 * @return the menschcounter
	 */
	public int getMenschcounter() {
		return menschcounter;
	}

	/**
	 * @param menschcounter
	 *            the menschcounter to set
	 */
	public void setMenschcounter(int menschcounter) {
		this.menschcounter = menschcounter;
	}

	/**
	 * @return the stat
	 */
	public int[] getStat() {
		return stat;
	}

	/**
	 * @param stat
	 *            the stat to set
	 */
	public void setStat(int[] stat) {
		this.stat = stat;
	}

	/**
	 * @return the aktuellerText
	 */
	public String getAktuellerText() {
		return aktuellerText;
	}

	/**
	 * @param aktuellerText
	 *            the aktuellerText to set
	 */
	public void setAktuellerText(String aktuellerText) {
		this.aktuellerText = aktuellerText;
	}

	/**
	 * Methode zum ueberpruefen des gewinners
	 * 
	 * @param menschzug
	 *            Zug des Spielers
	 * @return Auswertung des Zuges 0=unentscheiden, <0 verloren, >0 gewonnen
	 */
	public int check() {
		if (menschzug == pczug) {

			aktuellesSpiel = 0;
			aktuellerText = "Unentschieden!";
			menschcounter++;
			pccounter++;
			stat[1]++;
		} else if ((menschzug == Wahl.SCHERE && pczug == Wahl.STEIN)
				|| (menschzug == Wahl.PAPIER && pczug == Wahl.SCHERE)
				|| (menschzug == Wahl.STEIN && pczug == Wahl.PAPIER)) {
			aktuellesSpiel = -1;
			aktuellerText = "Niederlage!";
			pccounter += 2;
			stat[2]++;
		} else

		// if ((menschzug==Wahl.STEIN && pczug==Wahl.SCHERE) ||
		// (menschzug==Wahl.SCHERE && pczug == Wahl.PAPIER) ||
		// (menschzug==Wahl.PAPIER && pczug == Wahl.STEIN))
		{
			aktuellesSpiel = 1;
			aktuellerText = "Sieg!";
			menschcounter += 2;
			stat[0]++;
		}
		return aktuellesSpiel;
	}

	/**
	 * @return the menschzug
	 */
	public Wahl getMenschzug() {
		if (menschzug != null)
			return menschzug;
		else
			return null;
	}

	/**
	 * @param menschzug
	 *            the menschzug to set
	 */
	public void setMenschzug(Wahl menschzug) {
		this.menschzug = menschzug;
	}

	/**
	 * Laesst den PC zufaellig Schere, Stein oder Papier waehlen
	 */
	public Wahl pczug() {
		int value = (int) (Math.random() * 3);
		switch (value) {
		case 1:
			pczug = Wahl.STEIN;
			break;
		case 2:
			pczug = Wahl.PAPIER;
			break;
		default:
			pczug = Wahl.SCHERE;
		}
		return pczug;
	}

	/**
	 * ruecksetzen der statistik
	 */
	public void reset() {
		this.aktuellesSpiel = 0;
		this.pczug = Wahl.SCHERE;
		this.pccounter = 0;
		this.menschcounter = 0;

		for (int i = 0; i < stat.length; i++) {
			stat[i] = 0;
		}
	}

}
