/**
 * 
 */
package org.migue.java8tuto.tests;

import static org.junit.Assert.*;

import java.util.function.Function;

import org.junit.Test;

/**
 * @author migue
 *  
 * Chaining functions in Java 8
 */
public class FunctionsChainTest {

	@Test
	public void testFunctionChaining() {
		
		Function<String, Integer> toInteger = Integer::valueOf;
		
		assertEquals(new Integer(32), toInteger.apply("32"));
		
		Function<String, String> toIntegerAndBackToString = toInteger.andThen(String::valueOf);
		assertEquals(new String("32"), toIntegerAndBackToString.apply("32"));
	}

}
