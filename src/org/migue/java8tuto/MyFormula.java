/**
 * 
 */
package org.migue.java8tuto;

import org.migue.java8tuto.interfaces.Formula;

/**
 * @author migue
 *
 */
public class MyFormula implements Formula {

	/* (non-Javadoc)
	 * @see org.migue.java8tuto.interfaces.Formula#calculate(int)
	 */
	@Override
	public double calculate(int a) {
		
		return sqrt(a*100);
	}

}
