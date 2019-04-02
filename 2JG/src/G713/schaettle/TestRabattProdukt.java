/**
 * 
 */
package G713.schaettle;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author wrafeiner
 *
 */
public class TestRabattProdukt {
	private Long id=999L;
	private String beschreibung="Beschreibung";
	private String bezeichnung="Bezeichnung";
	private double preis=9.90D;
	private int rabatt=10;
	private RabattProdukt rp;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		rp=new RabattProdukt(id, bezeichnung, beschreibung, preis, rabatt);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		rp=null;
	}

	/**
	 * Test method for {@link G713.schaettle.RabattProdukt#RabattProdukt(long, java.lang.String, java.lang.String, double, int)}.
	 */
	@Test
	public void testRabattProduktLongStringStringDoubleInt() {
		RabattProdukt rp2=new RabattProdukt(id, bezeichnung, beschreibung, preis, rabatt);
		assertEquals(rp2.getClass(),rp.getClass());
	}


	/**
	 * Test method for {@link G713.schaettle.RabattProdukt#getRabatt()}.
	 */
	@Test
	public void testGetRabatt() {
		int expected = rabatt;
		int actual = rp.getRabatt();
		assertEquals(expected,actual);
	}

	/**
	 * Test method for {@link G713.schaettle.RabattProdukt#setRabatt(int)}.
	 */
	@Test
	public void testSetRabatt() {
		int expected=99;
		rp.setProduktID(expected);
		long actual=rp.getProduktID();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link G713.schaettle.RabattProdukt#ermaessigterPreis()}.
	 */
	@Test
	public void testErmaessigterPreis() {
		double expected=preis*(1.0-rabatt/100.0);
		double actual=rp.ermaessigterPreis();
		assertEquals(expected, actual,0.01);
	}

	/**
	 * Test method for {@link G713.schaettle.RabattProdukt#equals(G713.schaettle.RabattProdukt)}.
	 */
	@Test
	public void testEqualsRabattProdukt() {
		RabattProdukt rp2=new RabattProdukt(id, bezeichnung, beschreibung, preis, rabatt);
		assertEquals(rp2,rp);
	}

}
