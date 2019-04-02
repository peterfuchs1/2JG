package test4;

public interface IstSteuerbar {
	public void erhoehen(int wert) throws NegativeValueException;
	public void verringern(int wert) throws NegativeValueException;
}
