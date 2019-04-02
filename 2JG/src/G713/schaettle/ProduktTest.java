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
public class ProduktTest {
	private Produkt p;
	private long id=10815L;
	private String bezeichnung= "First";
	private String beschreibung = "Better";
	private double value = 9.9D;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		p =new Produkt(id,bezeichnung,beschreibung,value);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link G713.schaettle.Produkt#Produkt()}.
	 */
	@Test
	public void testProdukt() {
		Produkt p2 = new Produkt();
		assertTrue(p2.getClass()==p.getClass());
	}

	/**
	 * Test method for {@link G713.schaettle.Produkt#Produkt(long, java.lang.String, java.lang.String, double)}.
	 */
	@Test
	public void testProduktLongStringStringDouble() {
		Produkt p2 = new Produkt(98000L,"Simpel","Extended",9.8);
		assertTrue(p2.getClass()==p.getClass());	}

	/**
	 * Test method for {@link G713.schaettle.Produkt#getProduktID()}.
	 */
	@Test
	public void testGetProduktID() {
		assertEquals(id, p.getProduktID());
	}

	/**
	 * Test method for {@link G713.schaettle.Produkt#setProduktID(long)}.
	 */
	@Test
	public void testSetProduktID() {
		long expected=9999L;
		p.setProduktID(expected);
		long actual=p.getProduktID();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link G713.schaettle.Produkt#getBezeichnung()}.
	 */
	@Test
	public void testGetBezeichnung() {
		assertEquals(bezeichnung, p.getBezeichnung());
	}

	/**
	 * Test method for {@link G713.schaettle.Produkt#setBezeichnung(java.lang.String)}.
	 */
	@Test
	public void testSetBezeichnung() {
		String expected="Neue Bez";
		p.setBezeichnung(expected);
		String actual=p.getBezeichnung();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link G713.schaettle.Produkt#getBeschreibung()}.
	 */
	@Test
	public void testGetBeschreibung() {
		assertEquals(beschreibung, p.getBeschreibung());
	}

	/**
	 * Test method for {@link G713.schaettle.Produkt#setBeschreibung(java.lang.String)}.
	 */
	@Test
	public void testSetBeschreibung() {
		String expected="Neue Beschreibung";
		p.setBeschreibung(expected);
		String actual=p.getBeschreibung();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link G713.schaettle.Produkt#getPreis()}.
	 */
	@Test
	public void testGetPreis() {
		assertEquals(value, p.getPreis(),0.01);
	}

	/**
	 * Test method for {@link G713.schaettle.Produkt#setPreis(double)}.
	 */
	@Test
	public void testSetPreis() {
		double expected=4.44D;
		p.setPreis(expected);
		double actual=p.getPreis();
		assertEquals(expected, actual,0.01);
	}

	/**
	 * Test method for {@link G713.schaettle.Produkt#equals(G713.schaettle.Produkt)}.
	 */
	@Test
	public void testEqualsProdukt() {
		Produkt p2=new Produkt(id,bezeichnung,beschreibung,value);
		assertEquals(p,p2);
	}

}
