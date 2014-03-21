/**
 * 
 */
package org.migue.java8tuto.interfaces;

import org.migue.java8tuto.Person;

/**
 * @author migue
 *
 */
public interface PersonFactory <P extends Person> {
	
	P create(String firstName, String lastName);
}
