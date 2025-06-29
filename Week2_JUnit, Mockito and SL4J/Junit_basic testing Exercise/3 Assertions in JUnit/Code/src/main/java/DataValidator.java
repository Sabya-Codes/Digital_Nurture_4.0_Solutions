import java.util.List;
import java.util.Arrays;

/**
 * DataValidator class for Exercise 3: Assertions in JUnit
 * This class provides various methods that return different types of data
 * to demonstrate different JUnit assertions
 */
public class DataValidator {
    
    /**
     * Simple addition method
     * @param a first number
     * @param b second number
     * @return sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }
    
    /**
     * Checks if a number is positive
     * @param number the number to check
     * @return true if positive, false otherwise
     */
    public boolean isPositive(int number) {
        return number > 0;
    }
    
    /**
     * Returns null for testing null assertions
     * @return null
     */
    public String getNullValue() {
        return null;
    }
    
    /**
     * Returns a non-null object for testing not null assertions
     * @return a new Object instance
     */
    public Object getNonNullValue() {
        return new Object();
    }
    
    /**
     * Returns the same object reference for testing same assertions
     * @param obj the object to return
     * @return the same object reference
     */
    public Object getSameReference(Object obj) {
        return obj;
    }
    
    /**
     * Creates a new string with the same content for testing equals vs same
     * @param content the content for the string
     * @return a new String with the same content
     */
    public String createNewString(String content) {
        return new String(content);
    }
    
    /**
     * Returns an array for testing array assertions
     * @return an integer array
     */
    public int[] getIntArray() {
        return new int[]{1, 2, 3, 4, 5};
    }
    
    /**
     * Returns another array with same content for testing array equality
     * @return an integer array with same content
     */
    public int[] getEqualIntArray() {
        return new int[]{1, 2, 3, 4, 5};
    }
    
    /**
     * Returns a double value for testing floating point assertions
     * @return a double value
     */
    public double getDoubleValue() {
        return 3.14159;
    }
    
    /**
     * Performs division that might result in floating point precision issues
     * @param numerator the numerator
     * @param denominator the denominator
     * @return the division result
     */
    public double divide(double numerator, double denominator) {
        return numerator / denominator;
    }
    
    /**
     * Returns a list for testing collection assertions
     * @return a list of strings
     */
    public List<String> getStringList() {
        return Arrays.asList("apple", "banana", "cherry");
    }
    
    /**
     * Throws an exception for testing exception assertions
     * @throws IllegalArgumentException always throws this exception
     */
    public void throwException() {
        throw new IllegalArgumentException("This is a test exception");
    }
    
    /**
     * Method that might throw an exception based on input
     * @param shouldThrow if true, throws an exception
     * @throws RuntimeException if shouldThrow is true
     */
    public void conditionalException(boolean shouldThrow) {
        if (shouldThrow) {
            throw new RuntimeException("Conditional exception thrown");
        }
    }
}
