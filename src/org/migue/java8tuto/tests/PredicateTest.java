/**
 * 
 */
package org.migue.java8tuto.tests;

import static org.junit.Assert.*;

import java.util.Objects;
import java.util.function.Predicate;

import org.junit.Test;

/**
 * @author migue
 * Testing predicates in Java 8
 */
public class PredicateTest {

	@Test
	public void testPredicates() {
		
		Predicate<String> predicate = (s) -> s.length() > 0;
		
		assertEquals(Boolean.TRUE, predicate.test("foo")); 
		
		assertEquals(Boolean.FALSE, predicate.negate().test("foo"));
		
		Predicate<Boolean> nonNull = Objects::nonNull;
		assertEquals(Boolean.TRUE, nonNull.test(Boolean.TRUE));
		
		Predicate<Boolean> isNull = Objects::isNull;
		Boolean nullBool = null;
		assertEquals(Boolean.TRUE, isNull.test(nullBool));
		
		Predicate<String> isEmpty = String::isEmpty;
		assertEquals(Boolean.TRUE, isEmpty.test(new String()) );
		
		Predicate<String> isNotEmpty = isEmpty.negate();
		assertEquals(Boolean.TRUE, isNotEmpty.test(new String("Mike")) );

	}

}
