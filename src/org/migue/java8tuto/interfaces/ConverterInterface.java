/**
 * 
 */
package org.migue.java8tuto.interfaces;

/**
 * @author migue
 *
 * This is an example of a functional interface. 
 * This means that we can give an implementation to the abstract method we declare by using lambdas
 * A functional interface CAN ONLY have ONE ABSTRACT method  (and it must have one)
 */

@FunctionalInterface
public interface ConverterInterface<F,T> {

	T convert (F from);
}
