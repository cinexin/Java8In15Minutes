/**
 * 
 */
package org.migue.java8tuto.tests;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;
import org.migue.java8tuto.Person;

/**
 * @author migue
 *
 */
public class ComparatorTest {

	@Test
	public void testComparators() {
		
		Comparator<Person> personComparator = (p1,p2) -> p1.getFirstName().compareTo(p2.getFirstName());
		
		Person p1 = new Person("Mark", "Renton");
		Person p2 = new Person ("Alice", "Wonderland");
		Person p3 = new Person ("Alice", "in Wonderland");
		
	 	assertTrue(personComparator.compare(p1, p2) > 0);
	 	assertTrue(personComparator.reversed().compare(p1, p2) <0);
	 	assertEquals(0, personComparator.compare(p2, p3));
	}

}
