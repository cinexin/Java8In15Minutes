/**
 * 
 */
package org.migue.java8tuto.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.migue.java8tuto.interfaces.ConverterInterface;

/**
 * @author migue
 *
 */
public class ConverterInterfaceTest {

	@Test
	public void testConvert() {
		
		// we provide a lambda function as an implementation of the "convert" method of the ConverterInterface
		ConverterInterface<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		Integer expected = 123;
		assertEquals(expected, converted);
		
		// referencing methods via "::" 
		// this is another way to provide a simple implementation for the "convert" method
		converter = Integer::valueOf;
		converted = converter.convert("123");
		assertEquals(expected, converted);
	}
	


}
