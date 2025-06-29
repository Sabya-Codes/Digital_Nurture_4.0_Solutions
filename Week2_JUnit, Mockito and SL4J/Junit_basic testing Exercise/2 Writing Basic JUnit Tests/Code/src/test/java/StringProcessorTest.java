import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Exercise 2: Writing Basic JUnit Tests
 * Test class for StringProcessor demonstrating basic JUnit testing techniques
 */
public class StringProcessorTest {
    
    private StringProcessor processor;
    
    @Before
    public void setUp() {
        processor = new StringProcessor();
        System.out.println("Setting up test - creating StringProcessor instance");
    }
    
    @After
    public void tearDown() {
        System.out.println("Cleaning up after test");
    }
    
    // Test 1: Basic string reversal
    @Test
    public void testReverse() {
        String result = processor.reverse("hello");
        assertEquals("String should be reversed", "olleh", result);
    }
    
    // Test 2: Reverse with null input
    @Test
    public void testReverseWithNull() {
        String result = processor.reverse(null);
        assertNull("Null input should return null", result);
    }
    
    // Test 3: Reverse empty string
    @Test
    public void testReverseEmptyString() {
        String result = processor.reverse("");
        assertEquals("Empty string should remain empty", "", result);
    }
    
    // Test 4: Basic uppercase conversion
    @Test
    public void testToUpperCase() {
        String result = processor.toUpperCase("hello world");
        assertEquals("String should be converted to uppercase", "HELLO WORLD", result);
    }
    
    // Test 5: Uppercase with null input
    @Test
    public void testToUpperCaseWithNull() {
        String result = processor.toUpperCase(null);
        assertNull("Null input should return null", result);
    }
    
    // Test 6: Count words in normal sentence
    @Test
    public void testCountWords() {
        int result = processor.countWords("Hello world from JUnit");
        assertEquals("Should count 4 words", 4, result);
    }
    
    // Test 7: Count words with extra spaces
    @Test
    public void testCountWordsWithExtraSpaces() {
        int result = processor.countWords("  Hello   world  ");
        assertEquals("Should count 2 words despite extra spaces", 2, result);
    }
    
    // Test 8: Count words with null input
    @Test
    public void testCountWordsWithNull() {
        int result = processor.countWords(null);
        assertEquals("Null input should return 0", 0, result);
    }
    
    // Test 9: Count words with empty string
    @Test
    public void testCountWordsWithEmptyString() {
        int result = processor.countWords("");
        assertEquals("Empty string should return 0", 0, result);
    }
    
    // Test 10: Palindrome check - positive case
    @Test
    public void testIsPalindromeTrue() {
        boolean result = processor.isPalindrome("racecar");
        assertTrue("'racecar' should be identified as palindrome", result);
    }
    
    // Test 11: Palindrome check - negative case
    @Test
    public void testIsPalindromeFalse() {
        boolean result = processor.isPalindrome("hello");
        assertFalse("'hello' should not be identified as palindrome", result);
    }
    
    // Test 12: Palindrome with spaces
    @Test
    public void testIsPalindromeWithSpaces() {
        boolean result = processor.isPalindrome("race car");
        assertTrue("'race car' should be identified as palindrome", result);
    }
    
    // Test 13: Palindrome with null
    @Test
    public void testIsPalindromeWithNull() {
        boolean result = processor.isPalindrome(null);
        assertFalse("Null should not be identified as palindrome", result);
    }
    
    // Test 14: String concatenation
    @Test
    public void testConcatenate() {
        String result = processor.concatenate("Hello", "World", " ");
        assertEquals("Should concatenate with separator", "Hello World", result);
    }
    
    // Test 15: Concatenation with null values
    @Test
    public void testConcatenateWithNulls() {
        String result = processor.concatenate(null, "World", "-");
        assertEquals("Should handle null first string", "-World", result);
    }
    
    // Test 16: Numeric string check - positive
    @Test
    public void testIsNumericTrue() {
        boolean result = processor.isNumeric("12345");
        assertTrue("'12345' should be identified as numeric", result);
    }
    
    // Test 17: Numeric string check - negative
    @Test
    public void testIsNumericFalse() {
        boolean result = processor.isNumeric("123abc");
        assertFalse("'123abc' should not be identified as numeric", result);
    }
    
    // Test 18: Numeric check with null
    @Test
    public void testIsNumericWithNull() {
        boolean result = processor.isNumeric(null);
        assertFalse("Null should not be identified as numeric", result);
    }
    
    // Test 19: Remove whitespace
    @Test
    public void testRemoveWhitespace() {
        String result = processor.removeWhitespace("Hello World Test");
        assertEquals("Should remove all whitespace", "HelloWorldTest", result);
    }
    
    // Test 20: Remove whitespace with null
    @Test
    public void testRemoveWhitespaceWithNull() {
        String result = processor.removeWhitespace(null);
        assertNull("Null input should return null", result);
    }
    
    // Test 21: Get first N characters
    @Test
    public void testGetFirstNCharacters() {
        String result = processor.getFirstNCharacters("Hello World", 5);
        assertEquals("Should return first 5 characters", "Hello", result);
    }
    
    // Test 22: Get first N characters - N larger than string
    @Test
    public void testGetFirstNCharactersLargerThanString() {
        String result = processor.getFirstNCharacters("Hi", 10);
        assertEquals("Should return whole string if N is larger", "Hi", result);
    }
    
    // Test 23: Get first N characters with negative N
    @Test(expected = IllegalArgumentException.class)
    public void testGetFirstNCharactersNegativeN() {
        processor.getFirstNCharacters("Hello", -1);
    }
    
    // Test 24: Get first N characters with null
    @Test
    public void testGetFirstNCharactersWithNull() {
        String result = processor.getFirstNCharacters(null, 5);
        assertNull("Null input should return null", result);
    }
}
