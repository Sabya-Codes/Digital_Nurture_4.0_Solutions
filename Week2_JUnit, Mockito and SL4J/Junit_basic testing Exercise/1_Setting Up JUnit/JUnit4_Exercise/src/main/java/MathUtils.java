/**
 * A simple utility class for mathematical operations
 * This class will be used to demonstrate JUnit 4 testing
 */
public class MathUtils {
    
    /**
     * Adds two integers
     * @param a first number
     * @param b second number
     * @return sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }
    
    /**
     * Subtracts second number from first
     * @param a first number
     * @param b second number
     * @return difference of a and b
     */
    public int subtract(int a, int b) {
        return a - b;
    }
    
    /**
     * Multiplies two integers
     * @param a first number
     * @param b second number
     * @return product of a and b
     */
    public int multiply(int a, int b) {
        return a * b;
    }
    
    /**
     * Divides first number by second
     * @param a dividend
     * @param b divisor
     * @return quotient of a divided by b
     * @throws IllegalArgumentException if divisor is zero
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return (double) a / b;
    }
    
    /**
     * Checks if a number is positive
     * @param number the number to check
     * @return true if number is positive, false otherwise
     */
    public boolean isPositive(int number) {
        return number > 0;
    }
    
    /**
     * Finds the maximum of two numbers
     * @param a first number
     * @param b second number
     * @return the larger of the two numbers
     */
    public int max(int a, int b) {
        return Math.max(a, b);
    }
    
    /**
     * Calculates the absolute value of a number
     * @param number the number
     * @return absolute value of the number
     */
    public int abs(int number) {
        return Math.abs(number);
    }
}
