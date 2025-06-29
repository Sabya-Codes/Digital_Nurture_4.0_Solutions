import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Exercise 3: Assertions in JUnit
 * This class demonstrates various JUnit assertions to validate test results
 * Includes the solution code provided in the exercise plus additional examples
 */
public class AssertionsTest {
    
    private DataValidator validator;
    
    @Before
    public void setUp() {
        validator = new DataValidator();
    }
    
    /**
     * Solution code from the exercise - demonstrates basic assertions
     */
    @Test
    public void testAssertions() {
        // Assert equals
        assertEquals(5, 2 + 3);
        
        // Assert true
        assertTrue(5 > 3);
        
        // Assert false
        assertFalse(5 < 3);
        
        // Assert null
        assertNull(null);
        
        // Assert not null
        assertNotNull(new Object());
    }
    
    // Additional comprehensive assertion examples
    
    @Test
    public void testAssertEquals() {
        // Test integer equality
        int result = validator.add(3, 4);
        assertEquals("3 + 4 should equal 7", 7, result);
        
        // Test string equality
        String expected = "hello";
        String actual = "hello";
        assertEquals("Strings should be equal", expected, actual);
        
        // Test with custom message
        assertEquals("Addition should work correctly", 10, validator.add(6, 4));
    }
    
    @Test
    public void testAssertTrue() {
        // Test boolean true conditions
        assertTrue("5 should be positive", validator.isPositive(5));
        assertTrue("100 should be positive", validator.isPositive(100));
        
        // Test with expressions
        assertTrue("String should contain substring", "Hello World".contains("World"));
        assertTrue("List should not be empty", !validator.getStringList().isEmpty());
    }
    
    @Test
    public void testAssertFalse() {
        // Test boolean false conditions
        assertFalse("-5 should not be positive", validator.isPositive(-5));
        assertFalse("0 should not be positive", validator.isPositive(0));
        
        // Test with expressions
        assertFalse("String should not contain substring", "Hello".contains("xyz"));
        assertFalse("Numbers should not be equal", 5 == 3);
    }
    
    @Test
    public void testAssertNull() {
        // Test null values
        assertNull("Method should return null", validator.getNullValue());
        
        String nullString = null;
        assertNull("Null string should be null", nullString);
    }
    
    @Test
    public void testAssertNotNull() {
        // Test non-null values
        assertNotNull("Method should return non-null object", validator.getNonNullValue());
        assertNotNull("String list should not be null", validator.getStringList());
        assertNotNull("Array should not be null", validator.getIntArray());
        
        String nonNullString = "test";
        assertNotNull("String should not be null", nonNullString);
    }
    
    @Test
    public void testAssertSame() {
        // Test object reference equality (same object in memory)
        Object obj = new Object();
        Object sameRef = validator.getSameReference(obj);
        assertSame("Should be the same object reference", obj, sameRef);
        
        String str = "test";
        assertSame("Should be the same string reference", str, validator.getSameReference(str));
    }
    
    @Test
    public void testAssertNotSame() {
        // Test different object references
        String original = "hello";
        String copy = validator.createNewString(original);
        assertNotSame("Should be different object references", original, copy);
        
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertNotSame("Should be different objects", obj1, obj2);
    }
    
    @Test
    public void testAssertArrayEquals() {
        // Test array equality (content comparison)
        int[] expected = {1, 2, 3, 4, 5};
        int[] actual = validator.getIntArray();
        assertArrayEquals("Arrays should have same content", expected, actual);
        
        int[] anotherArray = validator.getEqualIntArray();
        assertArrayEquals("Both arrays should be equal", actual, anotherArray);
    }
    
    @Test
    public void testAssertEqualsWithDelta() {
        // Test floating point equality with delta (tolerance)
        double expected = 3.14159;
        double actual = validator.getDoubleValue();
        assertEquals("Double values should be equal within delta", expected, actual, 0.00001);
        
        // Test division that might have precision issues
        double result = validator.divide(10.0, 3.0);
        assertEquals("10/3 should be approximately 3.333", 3.333, result, 0.001);
        
        // Test with very small delta
        assertEquals("Pi approximation", Math.PI, 3.14159, 0.001);
    }
    
    @Test
    public void testMultipleAssertionsInOneTest() {
        // Demonstrate multiple assertions in a single test method
        int[] array = validator.getIntArray();
        
        assertNotNull("Array should not be null", array);
        assertEquals("Array should have 5 elements", 5, array.length);
        assertEquals("First element should be 1", 1, array[0]);
        assertEquals("Last element should be 5", 5, array[4]);
        assertTrue("Array length should be positive", array.length > 0);
    }
    
    @Test
    public void testStringAssertions() {
        // Various string-related assertions
        String text = "Hello JUnit World";
        
        assertNotNull("String should not be null", text);
        assertTrue("String should contain 'JUnit'", text.contains("JUnit"));
        assertTrue("String should start with 'Hello'", text.startsWith("Hello"));
        assertTrue("String should end with 'World'", text.endsWith("World"));
        assertEquals("String length should be 17", 17, text.length());
        assertFalse("String should not be empty", text.isEmpty());
    }
    
    @Test
    public void testCollectionAssertions() {
        // Test collection-related assertions
        var stringList = validator.getStringList();
        
        assertNotNull("List should not be null", stringList);
        assertEquals("List should have 3 elements", 3, stringList.size());
        assertTrue("List should contain 'apple'", stringList.contains("apple"));
        assertTrue("List should contain 'banana'", stringList.contains("banana"));
        assertFalse("List should not contain 'orange'", stringList.contains("orange"));
        assertFalse("List should not be empty", stringList.isEmpty());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testExceptionAssertion() {
        // Test that a method throws expected exception
        validator.throwException();
    }
    
    @Test
    public void testConditionalException() {
        // Test method that conditionally throws exception
        
        // Should not throw exception
        validator.conditionalException(false);
        
        // Should throw exception
        try {
            validator.conditionalException(true);
            fail("Expected RuntimeException to be thrown");
        } catch (RuntimeException e) {
            assertEquals("Exception message should match", "Conditional exception thrown", e.getMessage());
        }
    }
    
    @Test
    public void testFailAssertion() {
        // Demonstrate explicit test failure
        boolean condition = true;
        
        if (!condition) {
            fail("This test should fail if condition is false");
        }
        
        // This assertion will pass
        assertTrue("Condition should be true", condition);
    }
}
