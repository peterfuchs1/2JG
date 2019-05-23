package test4;


public class Akku extends Batterie implements IstAufladbar {

	@Override
	public void aufladen(double prozent) {
		this.setKapazitaet(prozent);
		
	}

}
