/**
 * 
 */
package org.migue.java8tuto.tests;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

/**
 * @author migue
 *
 * Basic example of non-functional optional interfaces
 */
public class OptionalInterfacesTest {

	@Test
	public void testOptionalInterfaces() {
		
		Optional<String> optional = Optional.of("bam");
		
		// isPresent() will return true if the function we have passed an argument to the function...
		assertEquals(Boolean.TRUE, optional.isPresent());
		
		// the get() method will return us the actual value of the parameter passed to the function...
		assertEquals("bam", optional.get());
		
		// if we passed no args, the "orElse()" function will return us a "fallback" default value...
		// in this case, as we passed "bam", we don't "fall inside the fallback"
		assertEquals ("bam", optional.orElse("fallback"));
		
		optional.ifPresent((s) ->  System.out.println( s.charAt(0)));
		
		
		
	}

}
