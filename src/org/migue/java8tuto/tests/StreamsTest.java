/**
 * 
 */
package org.migue.java8tuto.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.BeforeClass;
import org.junit.Test;
import org.migue.java8tuto.StringCollection;

/**
 * @author migue
 * Introduction explanation extracted from the source tutorial:
 * 
 *  A java.util.Stream represents a sequence of elements on which one or more operations can be performed. 
 *  Stream operations are either intermediate or terminal. 
 *  While terminal operations return a result of a certain type, intermediate operations return the stream itself,
 *  so you can chain multiple method calls in a row. 
 *  Streams are created on a source, e.g. a java.util.Collection like lists or sets (maps are not supported). 
 *  Stream operations can either be executed sequential or parallel.
 */


public class StreamsTest {

	private static StringCollection stringColl;
	
	@Test
	public void testFilters() {
		
		// if you want a deeper debug...
		/* stringColl.stringsCollection
	    .stream()
	    .filter((s) -> s.startsWith("a"))
	    .forEach(System.out::println); */
		
		 Stream<String> stringStream = (Stream<String>) stringColl.stringsCollection
		.stream()
		.filter((s) -> s.startsWith("a"));
		assertEquals(2, stringStream.count());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSort() {
		Stream<String> stringStream = (Stream<String>) stringColl.stringsCollection
										.stream()
										.sorted()
										.filter((s) -> s.startsWith("a"));
		Stream<String> expectedStream = (Stream<String>) (new ArrayList<String>( Arrays.asList("aaa1", "aaa2"))).stream();
		assertEquals(expectedStream.toArray(), stringStream.toArray());
	}
	
	@Test
	public void testAnyMatch() {
		Stream<String> stringStream = (Stream<String>) stringColl.stringsCollection.stream();
		assertTrue(stringStream.anyMatch((s) -> s.startsWith("a")));
	}
	
	@Test
	public void testAllMatch() {
		Stream<String> stringStream = (Stream<String>) stringColl.stringsCollection.stream();
		assertFalse(stringStream.allMatch((s)->s.startsWith("s")));
	}
	
	@Test 
	public void testNoneMatch() {
		Stream<String> stringStream = (Stream<String>) stringColl.stringsCollection.stream();
		assertTrue(stringStream.noneMatch((s) -> s.startsWith("z")));
	}
	
	// note that "count()" is a TERMINAL operation, that is, you can't chain another operation after it
	@Test
	public void testCount() {
		Stream<String> stringStream = (Stream<String>) stringColl.stringsCollection.stream();
		long numberOfStringsStartingWithB = stringStream.filter((s) -> s.startsWith("b")).count();
		assertEquals(3, numberOfStringsStartingWithB);
	}
	
	@Test
	public void testReduce() {
		Stream<String> stringStream = (Stream<String>) stringColl.stringsCollection.stream();
		Optional<String> reducedString =  stringStream.sorted().reduce((s1,s2)->s1 + "," + s2);
		Optional<String> expectedString = Optional.of( "aaa1,aaa2,bbb1,bbb2,bbb3,ccc,ddd1,ddd2");
		reducedString.ifPresent(System.out::println);
		assertEquals(expectedString, reducedString);
	}
	
	@BeforeClass
	public static void setUp() {
		stringColl = new StringCollection();
	}
	
	
}
