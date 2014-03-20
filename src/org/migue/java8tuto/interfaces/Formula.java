/**
 * 
 */
package org.migue.java8tuto.interfaces;

/**
 * @author migue
 *
 */
public interface Formula {

    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
