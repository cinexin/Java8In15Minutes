/**
 * 
 */
package org.migue.java8tuto.interfaces;

/**
 * @author migue
 *
 * Example of default methods for interfaces
 */
public interface Formula {

    double calculate(int a);

    /* we provide an implementation directly in the interface!! */
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
