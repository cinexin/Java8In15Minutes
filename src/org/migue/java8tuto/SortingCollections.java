/**
 * 
 */
package org.migue.java8tuto;

import java.util.Collections;
import java.util.List;

/**
 * @author migue
 *
 * Example of lambda functions
 */
public class SortingCollections {



	
		
	public List<String> sortNames(List<String> nombres) {
		
		/* Typically we would do this:
		 * 
		 *  Collections.sort(names, new Comparator<String>() {
			    @Override
			    public int compare(String a, String b) {
			        return b.compareTo(a);
    			}
			});
		 */
		
		/* we can translate the above code using lambdas in just one line of code! */
		
		Collections.sort(nombres, (String a, String b) -> a.compareTo(b)); 
		return nombres;
	}
	
	
	
	
}
