/**
 * JUNIT Tests inkl. 100% Coverage
 */
package test_komplex;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author uhs374h
 * @version 05.10.2013
 */
public class TestKomplex {
	private Komplex k;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		k = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		k = null;
	}

	/**
	 * Test method for {@link test_komplex.Komplex#Komplex(double, double, boolean)}.
	 */
	@Test
	public final void testKomplexDoubleDoubleBooleanTrue() {
		double betrag=4;
		double phi=2;
		k = new Komplex(betrag, phi,true);
		assertEquals(betrag,k.betrag(),0.001);
		assertEquals(phi,k.phi(),0.001);
	}
	/**
	 * Test method for {@link test_komplex.Komplex#Komplex(double, double, boolean)}.
	 */
	@Test
	public final void testKomplexDoubleDoubleBooleanFalse() {
		double r=4;
		double i=2;
		k = new Komplex(r, i,false);
		assertEquals(r,k.getR(),0.001);
		assertEquals(i,k.getI(),0.001);
	}

	/**
	 * Test method for {@link test_komplex.Komplex#Komplex(double, double)}.
	 */
	@Test
	public final void testKomplexDoubleDouble() {
		k = new Komplex(4, 2);
		assertTrue(k.equals(new Komplex(4, 2)));
	}

	/**
	 * Test method for {@link test_komplex.Komplex#Komplex(double)}.
	 */
	@Test
	public final void testKomplexDouble() {
		k = new Komplex(4);
		assertTrue(k.equals(new Komplex(4)));
	}

	/**
	 * Test method for {@link test_komplex.Komplex#Komplex()}.
	 */
	@Test
	public final void testKomplex() {
		k = new Komplex();
		assertTrue(k.equals(new Komplex(0, 0)));
	}

	/**
	 * Test method for {@link test_komplex.Komplex#getR()}.
	 */
	@Test
	public final void testGetR() {
		k = new Komplex(4.1, -2.5);
		double expected = 4.1;
		double actual = k.getR();
		assertEquals(expected, actual, 0.001);
	}

	/**
	 * Test method for {@link test_komplex.Komplex#setR(double)}.
	 */
	@Test
	public final void testSetR() {
		k = new Komplex(4.1, -2.5);
		double expected = 4.2;
		k.setR(expected);
		double actual = k.getR();
		assertEquals(expected, actual, 0.001);
	}

	/**
	 * Test method for {@link test_komplex.Komplex#getI()}.
	 */
	@Test
	public final void testGetI() {
		k = new Komplex(4.1, -2.5);
		double expected = -2.5;
		double actual = k.getI();
		assertEquals(expected, actual, 0.001);

	}

	/**
	 * Test method for {@link test_komplex.Komplex#setI(double)}.
	 */
	@Test
	public final void testSetI() {
		k = new Komplex(4.1, -2.5);
		double expected = -2.5;
		k.setI(expected);
		double actual = k.getI();
		assertEquals(expected, actual, 0.001);

	}

	/**
	 * Test method for {@link test_komplex.Komplex#minus(test_komplex.Komplex)}.
	 */
	@Test
	public final void testMinusKomplex() {
		k = new Komplex(4.1, -2.5);
		Komplex k2 = new Komplex(3, 1.5);
		double a = k.getR() - k2.getR();
		double b = k.getI() - k2.getI();
		Komplex expected = new Komplex(a, b);
		assertTrue(expected.equals(k.minus(k2)));
	}

	/**
	 * Test method for {@link test_komplex.Komplex#plus(test_komplex.Komplex)}.
	 */
	@Test
	public final void testPlusKomplex() {
		k = new Komplex(4.1, -2.5);
		Komplex k2 = new Komplex(3, 1.5);
		double a = k.getR() + k2.getR();
		double b = k.getI() + k2.getI();
		Komplex expected = new Komplex(a, b);
		assertTrue(expected.equals(k.plus(k2)));

	}

	/**
	 * Test method for {@link test_komplex.Komplex#minus(double)}.
	 */
	@Test
	public final void testMinusDouble() {
		k = new Komplex(4.1, -2.5);
		double k2 = 3;
		double a = k.getR() - k2;
		double b = k.getI();
		Komplex expected = new Komplex(a, b);
		assertTrue(expected.equals(k.minus(k2)));

	}

	/**
	 * Test method for {@link test_komplex.Komplex#plus(double)}.
	 */
	@Test
	public final void testPlusDouble() {
		k = new Komplex(4.1, -2.5);
		double k2 = 3;
		double a = k.getR() + k2;
		double b = k.getI();
		Komplex expected = new Komplex(a, b);
		assertTrue(expected.equals(k.plus(k2)));

	}

	/**
	 * Test method for {@link test_komplex.Komplex#minus(double, double)}.
	 */
	@Test
	public final void testMinusDoubleDouble() {
		k = new Komplex(4.1, -2.5);
		double r = 3;
		double i = -1;
		double a = k.getR() - r;
		double b = k.getI() - i;
		Komplex expected = new Komplex(a, b);
		assertTrue(expected.equals(k.minus(r, i)));
	}

	/**
	 * Test method for {@link test_komplex.Komplex#plus(double, double)}.
	 */
	@Test
	public final void testPlusDoubleDouble() {
		k = new Komplex(4.1, -2.5);
		double r = 3;
		double i = -1;
		double a = k.getR() + r;
		double b = k.getI() + i;
		Komplex expected = new Komplex(a, b);
		assertTrue(expected.equals(k.plus(r, i)));

	}

	/**
	 * Test method for
	 * {@link test_komplex.Komplex#plus(test_komplex.Komplex, test_komplex.Komplex)}
	 * .
	 */
	@Test
	public final void testPlusKomplexKomplex() {
		k = new Komplex(4.1, -2.5);
		double r = 3;
		double i = -1;
		Komplex k2 = new Komplex(r, i);
		double a = k.getR() + r;
		double b = k.getI() + i;
		Komplex expected = new Komplex(a, b);
		assertTrue(expected.equals(Komplex.plus(k, k2)));

	}

	/**
	 * Test method for
	 * {@link test_komplex.Komplex#minus(test_komplex.Komplex, test_komplex.Komplex)}
	 * .
	 */
	@Test
	public final void testMinusKomplexKomplex() {
		k = new Komplex(4.1, -2.5);
		double r = 3;
		double i = -1;
		Komplex k2 = new Komplex(r, i);
		double a = k.getR() - r;
		double b = k.getI() - i;
		Komplex expected = new Komplex(a, b);
		assertTrue(expected.equals(Komplex.minus(k, k2)));

	}

	/**
	 * Test method for {@link test_komplex.Komplex#multiply(double)}.
	 */
	@Test
	public final void testMultiplyDouble() {
		k = new Komplex(4.1, -2.5);
		double d = 3;
		double a = k.getR() * d;
		double b = k.getI() * d;
		Komplex expected = new Komplex(a, b);
		assertTrue(expected.equals(k.multiply(d)));

	}

	/**
	 * Test method for {@link test_komplex.Komplex#multiply(double, double)}.
	 */
	@Test
	public final void testMultiplyDoubleDouble() {
		k = new Komplex(4.1, -2.5);
		double c = 1.5;
		double d = 3;
		double a = k.getR();
		double b = k.getI();
		double real = a * c - b * d;
		double imag = a * d + b * c;
		Komplex expected = new Komplex(real, imag);
		assertTrue(expected.equals(k.multiply(c, d)));

	}

	/**
	 * Test method for
	 * {@link test_komplex.Komplex#multiply(test_komplex.Komplex)}.
	 */
	@Test
	public final void testMultiplyKomplex() {
		k = new Komplex(4.1, -2.5);
		double c = 1.5;
		double d = 3;
		Komplex k2 = new Komplex(c, d);
		double a = k.getR();
		double b = k.getI();
		double real = a * c - b * d;
		double imag = a * d + b * c;
		Komplex expected = new Komplex(real, imag);
		assertTrue(expected.equals(k.multiply(k2)));

	}

	/**
	 * Test method for
	 * {@link test_komplex.Komplex#multiply(test_komplex.Komplex, test_komplex.Komplex)}
	 * .
	 */
	@Test
	public final void testMultiplyKomplexKomplex() {
		k = new Komplex(4.1, -2.5);
		double c = 1.5;
		double d = 3;
		Komplex k2 = new Komplex(c, d);
		double a = k.getR();
		double b = k.getI();
		double real = a * c - b * d;
		double imag = a * d + b * c;
		Komplex expected = new Komplex(real, imag);
		assertTrue(expected.equals(Komplex.multiply(k, k2)));

	}

	/**
	 * Test method for {@link test_komplex.Komplex#divide(double)}.
	 */
	@Test
	public final void testDivideDouble() {
		k = new Komplex(4.1, -2.5);
		double d = 3;
		double a = k.getR() / d;
		double b = k.getI() / d;
		Komplex expected = new Komplex(a, b);
		assertTrue(expected.equals(k.divide(d)));

	}

	/**
	 * Test method for {@link test_komplex.Komplex#divide(double)} throw
	 * ArithmeticException.
	 */
	@Test(expected = ArithmeticException.class)
	public final void testDivideDoubleE() {
		k = new Komplex(4.1, -2.5);
		double d = 0;
		k.divide(d);
		fail();

	}

	/**
	 * Test method for {@link test_komplex.Komplex#divide(test_komplex.Komplex)}
	 * .
	 */
	@Test
	public final void testDivideKomplex() {
		k = new Komplex(4.1, -2.5);
		double d = 3;
		double c = 1.5;
		Komplex k2 = new Komplex(c, d);
		double nenner = c * c + d * d;
		double a = k.getR();
		double b = k.getI();
		double real = (a * c + b * d) / nenner;
		double imag = (b * c - a * d) / nenner;
		Komplex expected = new Komplex(real, imag);
		assertTrue(expected.equals(k.divide(k2)));

	}

	/**
	 * Test method for {@link test_komplex.Komplex#divide(test_komplex.Komplex)}
	 * throws ArithmeticException.
	 */
	@Test(expected = ArithmeticException.class)
	public final void testDivideKomplexE() {
		k = new Komplex(4.1, -2.5);
		double d = 0;
		double c = 0;
		Komplex k2 = new Komplex(c, d);
		k.divide(k2);
		fail();
	}

	/**
	 * Test method for {@link test_komplex.Komplex#isNull()}.
	 */
	@Test
	public final void testIsNull() {
		k = new Komplex(4.1, -2.5);
		assertFalse(k.isNull());
	}

	/**
	 * Test method for {@link test_komplex.Komplex#isNull()}.
	 */
	@Test
	public final void testIsNullA0() {
		k = new Komplex(0.0, -2.5);
		assertFalse(k.isNull());
	}

	/**
	 * Test method for {@link test_komplex.Komplex#isNull()}.
	 */
	@Test
	public final void testIsNullTrue() {
		k = new Komplex(0.0, 0.0);
		assertTrue(k.isNull());
	}

	/**
	 * Test method for {@link test_komplex.Komplex#equals(Object)}.
	 */
	@Test
	public final void testEqualsObject() {
		k = new Komplex(0.0, 0.0);
		assertFalse(k.equals(new Object()));
	}
	
	/**
	 * Test method for {@link test_komplex.Komplex#equals(Object)}.
	 */
	@Test
	public final void testEqualsKomplexFalse() {
		k = new Komplex(0.0, 0.0);
		Komplex k2=new Komplex(1.0,0.0);
		assertFalse(k.equals(k2));
	}

	/**
	 * Test method for {@link test_komplex.Komplex#equals(Object)}.
	 */
	@Test
	public final void testEqualsKomplexTrue() {
		k = new Komplex(1.0, 0.0);
		Komplex k2=new Komplex(1.0,0.0);
		assertTrue(k.equals(k2));
	}


	/**
	 * Test method for {@link test_komplex.Komplex#compareTo(Komplex)}.
	 */
	@Test
	public final void testCompareToLower() {
		k = new Komplex(1.0, 0.0);
		Komplex k2=new Komplex(1.0,1.0);
		assertEquals(k.compareTo(k2),-1);
	}
	

	/**
	 * Test method for {@link test_komplex.Komplex#compareTo(Komplex)}.
	 */
	@Test
	public final void testCompareToGreather() {
		k = new Komplex(1.0, 2.0);
		Komplex k2=new Komplex(1.0,1.0);
		assertEquals(k.compareTo(k2),1);
	}

	/**
	 * Test method for {@link test_komplex.Komplex#compareTo(Komplex)}.
	 */
	@Test
	public final void testCompareToGreatherReal() {
		k = new Komplex(2.0, 2.0);
		Komplex k2=new Komplex(1.0,1.0);
		assertEquals(k.compareTo(k2),1);
	}
	
	/**
	 * Test method for {@link test_komplex.Komplex#divide(double, double)}.
	 */
	@Test
	public final void testDivideDoubleDoubleD0() {
		k = new Komplex(4.1, -2.5);
		double d = 0;
		double c = 1.5;
		double nenner = c * c + d * d;
		double a = k.getR();
		double b = k.getI();
		double real = (a * c + b * d) / nenner;
		double imag = (b * c - a * d) / nenner;
		Komplex expected = new Komplex(real, imag);
		assertTrue(expected.equals(k.divide(c, d)));

	}

	/**
	 * Test method for {@link test_komplex.Komplex#divide(double, double)}.
	 */
	@Test
	public final void testDivideDoubleDoubleC0() {
		k = new Komplex(4.1, -2.5);
		double d = 3.0;
		double c = 0.0;
		double nenner = c * c + d * d;
		double a = k.getR();
		double b = k.getI();
		double real = (a * c + b * d) / nenner;
		double imag = (b * c - a * d) / nenner;
		Komplex expected = new Komplex(real, imag);
		assertTrue(expected.equals(k.divide(c, d)));

	}
	
	
	/**
	 * Test method for {@link test_komplex.Komplex#divide(double, double)}.
	 */
	@Test
	public final void testDivideDoubleDouble() {
		k = new Komplex(4.1, -2.5);
		double d = 3;
		double c = 1.5;
		double nenner = c * c + d * d;
		double a = k.getR();
		double b = k.getI();
		double real = (a * c + b * d) / nenner;
		double imag = (b * c - a * d) / nenner;
		Komplex expected = new Komplex(real, imag);
		assertTrue(expected.equals(k.divide(c, d)));

	}

	/**
	 * Test method for {@link test_komplex.Komplex#divide(double, double)}.
	 */
	@Test(expected = ArithmeticException.class)
	public final void testDivideDoubleDoubleE() {
		k = new Komplex(4.1, -2.5);
		double d = 0;
		double c = 0;
		k.divide(c, d);
		fail();

	}

	/**
	 * Test method for
	 * {@link test_komplex.Komplex#divide(test_komplex.Komplex, test_komplex.Komplex)}
	 * .
	 */
	@Test
	public final void testDivideKomplexKomplex() {
			k=new Komplex(4.1,-2.5);
			double d=3;
			double c=1.5;
			Komplex k2=new Komplex(c,d);
			double nenner=c*c+d*d;
			double a=k.getR();
			double b=k.getI();
			double real=(a*c+b*d)/nenner;
			double imag=(b*c-a*d)/nenner;
			Komplex expected=new Komplex(real,imag);
			assertTrue(expected.equals(Komplex.divide(k,k2)));
	}

	/**
	 * Test method for
	 * {@link test_komplex.Komplex#divide(test_komplex.Komplex, test_komplex.Komplex)} throws ArithmeticException
	 * .
	 */
	@Test(expected=ArithmeticException.class)
	public final void testDivideKomplexKomplexE() {
			k=new Komplex(4.1,-2.5);
			double d=0;
			double c=0;
			Komplex k2=new Komplex(c,d);
			Komplex.divide(k,k2);
			fail();
	}

	/**
	 * Test method for {@link test_komplex.Komplex#betrag()}.
	 */
	@Test
	public final void testBetrag() {
		k=new Komplex(4.1,-2.5);
		double a=k.getR();
		double b=k.getI();
		double expected=Math.sqrt(a*a+b*b);
		assertEquals(expected,k.betrag(),0.001);
	}
	/**
	 * Test method for {@link test_komplex.Komplex#betrag()}.
	 */
	@Test
	public final void testBetrag0() {
		k=new Komplex(0.0,0.0);
		double expected=0.0;
		assertEquals(expected,k.betrag(),0.001);
	}

	/**
	 * Test method for {@link test_komplex.Komplex#phi()}.
	 */
	@Test
	public final void testPhiBNegativ() {
			k=new Komplex(4.1,-2.5);
			double r=k.betrag();
			double a=k.getR();
			double expected=-Math.acos(a/r);
			assertEquals(expected,k.phi(),0.001);

	}
	/**
	 * Test method for {@link test_komplex.Komplex#phi()}.
	 */
	@Test
	public final void testPhiBPositiv() {
			k=new Komplex(4.1,+2.5);
			double r=k.betrag();
			double a=k.getR();
			double expected=Math.acos(a/r);
			assertEquals(expected,k.phi(),0.001);

	}
	/**
	 * Test method for {@link test_komplex.Komplex#phi()}.
	 */
	@Test
	public final void testPhiBuA0() {
			k=new Komplex(0,0);
			double expected=0;
			assertEquals(expected,k.phi(),0.001);
	}

	/**
	 * Test method for {@link test_komplex.Komplex#konjugation()}.
	 */
	@Test
	public final void testKonjugation() {
		double a=4.1,b=2.5;
		k=new Komplex(a,b);
		double c=a,d=-b;
		Komplex expected=new Komplex(c,d);
		assertTrue(expected.equals(k.konjugation()));
	}

	/**
	 * Test method for
	 * {@link test_komplex.Komplex#konjugation(test_komplex.Komplex)}.
	 */
	@Test
	public final void testKonjugationKomplex() {
		double a=4.1,b=2.5;
		k=new Komplex(a,b);
		double c=a,d=-b;
		Komplex expected=new Komplex(c,d);
		assertTrue(expected.equals(Komplex.konjugation(k)));

	}

	/**
	 * Test method for {@link test_komplex.Komplex#toString()}.
	 */
	@Test
	public final void testToString() {
		double a=4.1,b=2.5;
		k=new Komplex(a,b);
		String expected="4.1+2.5i";
		assertTrue(expected.equals(k.toString()));
	}
	/**
	 * Test method for {@link test_komplex.Komplex#toString()}.
	 */
	@Test
	public final void testToString0() {
		double a=0.0,b=0.0;
		k=new Komplex(a,b);
		String expected="0.0";
		assertTrue(expected.equals(k.toString()));
	}
	/**
	 * Test method for {@link test_komplex.Komplex#toString()}.
	 */
	@Test
	public final void testToStringINegativ() {
		double a=0.0,b=-2.2;
		k=new Komplex(a,b);
		String expected="0.0-2.2i";
		assertTrue(expected.equals(k.toString()));
	}

	/**
	 * Test method for {@link test_komplex.Komplex#toPolar()}.
	 */
	@Test
	public final void testToPolar() {
		double a=2.5,b=2.5;
		k=new Komplex(a,b);
		double r=k.betrag();
		double phi=k.phi();
		String expected=r+"^ei*"+phi;
		assertTrue(expected.equals(k.toPolar()));

	}
	/**
	 * Test method for {@link test_komplex.Komplex#toString()}.
	 */
	@Test
	public final void testToPolar0() {
		double a=0.0,b=0.0;
		k=new Komplex(a,b);
		String expected="0.0";
		assertTrue(expected.equals(k.toPolar()));
	}

	/**
	 * Test method for {@link test_komplex.Komplex#toTrigonometric()}.
	 */
	@Test
	public final void testToTrigonometric0() {
			double a=0.0,b=0.0;
			k=new Komplex(a,b);
			String expected="0.0";
			assertTrue(expected.equals(k.toTrigonometric()));
		
	}

	/**
	 * Test method for {@link test_komplex.Komplex#toTrigonometric()}.
	 */
	@Test
	public final void testToTrigonometricPositiv() {
			double a=2.5,b=2.5;
			k=new Komplex(a,b);
			double r=k.betrag();
			double phi=k.phi();
			String expected=r+"*("+Math.cos(phi)+"+"+Math.sin(phi)+"i)";
			assertTrue(expected.equals(k.toTrigonometric()));
		
	}


	/**
	 * Test method for {@link test_komplex.Komplex#toTrigonometric()}.
	 */
	@Test
	public final void testToTrigonometricNegativ() {
			double a=-2.5,b=-2.5;
			k=new Komplex(a,b);
			double r=k.betrag();
			double phi=k.phi();
			String expected=r+"*("+Math.cos(phi)+Math.sin(phi)+"i)";
			assertTrue(expected.equals(k.toTrigonometric()));
		
	}

}
