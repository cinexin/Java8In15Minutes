/**
 * 
 */
package org.migue.java8tuto.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.migue.java8tuto.interfaces.ConverterInterface;

/**
 * @author migue
 *
 */
public class ConverterInterfaceTest {

	@Test
	public void testConvert() {
		
		// we provide a lambda function as an implementation of the "convert" method of the ConverterInterface
		ConverterInterface<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		Integer expected = 123;
		assertEquals(expected, converted);
		
		// referencing methods via "::" 
		// this is another way to provide a simple implementation for the "convert" method
		converter = Integer::valueOf;
		converted = converter.convert("123");
		assertEquals(expected, converted);
	}
	
	@Test
	public void anotherTestConvert() {

		int num = 1;
		// we can access local variables in a lambda function, must be final but not explicitly
		/* for example, this code works OK... */
		ConverterInterface<Integer, String> converter  =  (from) -> String.valueOf(from + num);
		
		String actualResult =  converter.convert(2);
		String expectedResult = "3";
		
		assertEquals(expectedResult, actualResult);
		
		/* but this code wouldn't work...*/
		/*int num = 1;
		Converter<Integer, String> stringConverter =
		        (from) -> String.valueOf(from + num);
		num = 3; => see? you can't change a "final" variable!!
		*/
		
		// notice writing the "num" variable within the lambda expression is also prohibited
	}
	
    static int outerStaticNum = 72;
    int outerNum = 23;
	
	@Test
	public void testLambdaScopes() {


        ConverterInterface<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        
        };
            ConverterInterface<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
        
        String convertedOuterNum =  stringConverter1.convert(outerNum);
        String convertedOuterStaticNum = stringConverter2.convert(outerStaticNum);
        
        assertEquals("23", convertedOuterNum);
        assertEquals("72", convertedOuterStaticNum);

	}


}
