/**
 * 
 */
package org.migue.java8tuto.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.migue.java8tuto.SortingCollections;

/**
 * @author migue
 *
 */
public class SortingListsTest {

	List<String> names = (List<String>) Arrays.asList("peter", "anna", "mike", "xenia");
	
	@Test
	public void test() {
		List<String> expectedList = new ArrayList<String>();
		expectedList.add(0,"anna");
		expectedList.add(1,"mike");
		expectedList.add(2,"peter");
		expectedList.add(3,"xenia");
		
		SortingCollections mySortingClass = new SortingCollections();
		mySortingClass.sortNames(names);
		
		assertArrayEquals(expectedList.toArray(), names.toArray());
		
	}

}
