/**
 * 
 */
package org.migue.java8tuto.tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * @author migue
 * Test class for giving a first try to some new Map methods in Java 8
 */
public class NewMapMethodsTest {

	private static Map<Integer, String> map = new HashMap<Integer, String>();
	
	@SuppressWarnings("deprecation")
	@Test
	public void testPutIfAbsent() {
		for (int i = 0; i < 10; i++) {
		    map.putIfAbsent(i, "val" + i);
		}
		Map<Integer,String> expectedMap = new HashMap<Integer,String>();
		expectedMap.put(0, "val0");
		expectedMap.put(1, "val1");
		expectedMap.put(2, "val2");
		expectedMap.put(3, "val3");
		expectedMap.put(4, "val4");
		expectedMap.put(5, "val5");
		expectedMap.put(6, "val6");
		expectedMap.put(7, "val7");
		expectedMap.put(8, "val8");
		expectedMap.put(9, "val9");
		
		assertEquals(expectedMap.values().toArray(), map.values().toArray());
	}
	
	@Test
	public void testComputeIfPresent() {
		map.computeIfPresent(3, (num, val) -> val + num);
		assertEquals("val33", map.get(3));
		
		map.computeIfPresent(9, (num, val) -> null);
		assertFalse(map.containsKey(9));
	}
	
	@Test
	public void testComputeIfAbsent() {
		map.computeIfAbsent(23, num -> "val" + num);
		assertTrue( map.containsKey(23));  
		map.remove(23);
		
		map.computeIfAbsent(3, num -> "bam");
		assertEquals("val3", map.get(3)); 
	}
	
	@Test
	public void testGetOrDefault() {
		assertEquals("not found", map.getOrDefault(42, "not found"));  
	}
	
	@Test 
	public void testMergeMethods() {
		map.computeIfPresent(9, (num, val) -> null);
		map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
		assertEquals("val9", map.get(9));   
		
		map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
		assertEquals("val9concat", map.get(9));             
	}
	
	@Before
	public  void setUp() {
		for (int i = 0; i < 10; i++) {
		    map.put(i, "val" + i);
		}
	}

}
