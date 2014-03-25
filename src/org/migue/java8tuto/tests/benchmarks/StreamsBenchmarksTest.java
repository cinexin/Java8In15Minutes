/**
 * 
 */
package org.migue.java8tuto.tests.benchmarks;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.BeforeClass;
import org.perf4j.LoggingStopWatch;
import org.perf4j.StopWatch;



/**
 * @author migue
 * We're going to test the performance of some operations with Streams
 *  I used the "perf4j" library  
 */

public class StreamsBenchmarksTest {

	int max = 5000000;
	List<String> values = new ArrayList<>(max);
	
	
	public void testSequentialSortPerformance() {
		StopWatch stopWatch = new LoggingStopWatch();
		values.stream().sorted().count();
		stopWatch.stop("Sequential Sort", "");
	}
	
	public void testParallelSortPerformance() {
		StopWatch stopWatch = new LoggingStopWatch();
		values.parallelStream().sorted().count();
		stopWatch.stop("Parallel Sort", "");
	}
	
	@BeforeClass
	public void setUp() {
		for (int i = 0; i < max; i++) {
		    UUID uuid = UUID.randomUUID();
		    values.add(uuid.toString());
		}
		
	}
	
	public static void main(String args[]) {
		StreamsBenchmarksTest perfTest =   new StreamsBenchmarksTest();
		perfTest.setUp();
		perfTest.testSequentialSortPerformance();
		perfTest.testParallelSortPerformance();
	}

}
