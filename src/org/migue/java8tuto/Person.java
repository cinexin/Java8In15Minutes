/**
 * 
 */
package org.migue.java8tuto;

/**
 * @author migue
 *
 */
public class Person {
	
	String firstName;
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	String lastName;
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Person() {}
	
}
