/**
 * 
 */
package org.migue.java8tuto.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.migue.java8tuto.MyFormula;

/**
 * @author migue
 *
 */
public class FormulaTests {

	MyFormula aFormulaToTest = new MyFormula();
	
	
	@Test
	public void testCalculate() {
		double expectedValue = 50;
		int a = 25;
		double actualValue = 0;
		
		actualValue =  aFormulaToTest.calculate(a);
	
		assertEquals(expectedValue, actualValue, (expectedValue/Math.pow(10.0, 6.0)  ) );
	}
	
	
	public void setUp() {
		
	}
	 

}
