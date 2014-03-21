/**
 * 
 */
package org.migue.java8tuto.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.migue.java8tuto.Person;
import org.migue.java8tuto.interfaces.PersonFactory;



/**
 * @author migue
 *
 */
public class PersonFactoryTest {
	
	
	@Test
	public void testPersonFactory() {
	
		// we provide an implementation to the "create" method via the constructor reference "::new"
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("Peter", "Parker");
		assertEquals("Peter",person.getFirstName() );
		assertEquals("Parker",person.getLastName() );
		
	}
}
