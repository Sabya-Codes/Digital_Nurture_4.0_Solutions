import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import static org.junit.Assert.*;

/**
 * JUnit 4 Test class for MathUtils
 * Demonstrates basic JUnit 4 testing concepts and annotations
 */
public class MathUtilsTest {
    
    private MathUtils mathUtils;
    
    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Setting up before all tests in the class");
    }
    
    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Cleaning up after all tests in the class");
    }
    
    @Before
    public void setUp() {
        mathUtils = new MathUtils();
        System.out.println("Setting up before each test");
    }
    
    @After
    public void tearDown() {
        System.out.println("Cleaning up after each test");
    }
    
    @Test
    public void testAdd() {
        // Test addition functionality
        int result = mathUtils.add(5, 3);
        assertEquals("5 + 3 should equal 8", 8, result);
        
        // Test with negative numbers
        result = mathUtils.add(-2, 3);
        assertEquals("-2 + 3 should equal 1", 1, result);
        
        // Test with zero
        result = mathUtils.add(0, 5);
        assertEquals("0 + 5 should equal 5", 5, result);
    }
    
    @Test
    public void testSubtract() {
        // Test subtraction functionality
        int result = mathUtils.subtract(10, 4);
        assertEquals("10 - 4 should equal 6", 6, result);
        
        // Test with negative result
        result = mathUtils.subtract(3, 7);
        assertEquals("3 - 7 should equal -4", -4, result);
    }
    
    @Test
    public void testMultiply() {
        // Test multiplication functionality
        int result = mathUtils.multiply(4, 5);
        assertEquals("4 * 5 should equal 20", 20, result);
        
        // Test with zero
        result = mathUtils.multiply(7, 0);
        assertEquals("7 * 0 should equal 0", 0, result);
        
        // Test with negative numbers
        result = mathUtils.multiply(-3, 4);
        assertEquals("-3 * 4 should equal -12", -12, result);
    }
    
    @Test
    public void testDivide() {
        // Test division functionality
        double result = mathUtils.divide(10, 2);
        assertEquals("10 / 2 should equal 5.0", 5.0, result, 0.001);
        
        // Test with decimal result
        result = mathUtils.divide(7, 2);
        assertEquals("7 / 2 should equal 3.5", 3.5, result, 0.001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        // Test that dividing by zero throws an exception
        mathUtils.divide(5, 0);
    }
    
    @Test
    public void testIsPositive() {
        // Test positive number
        assertTrue("5 should be positive", mathUtils.isPositive(5));
        
        // Test negative number
        assertFalse("-3 should not be positive", mathUtils.isPositive(-3));
        
        // Test zero
        assertFalse("0 should not be positive", mathUtils.isPositive(0));
    }
    
    @Test
    public void testMax() {
        // Test max functionality
        int result = mathUtils.max(5, 3);
        assertEquals("Max of 5 and 3 should be 5", 5, result);
        
        // Test with equal numbers
        result = mathUtils.max(4, 4);
        assertEquals("Max of 4 and 4 should be 4", 4, result);
        
        // Test with negative numbers
        result = mathUtils.max(-2, -5);
        assertEquals("Max of -2 and -5 should be -2", -2, result);
    }
    
    @Test
    public void testAbs() {
        // Test absolute value of positive number
        int result = mathUtils.abs(5);
        assertEquals("Absolute value of 5 should be 5", 5, result);
        
        // Test absolute value of negative number
        result = mathUtils.abs(-7);
        assertEquals("Absolute value of -7 should be 7", 7, result);
        
        // Test absolute value of zero
        result = mathUtils.abs(0);
        assertEquals("Absolute value of 0 should be 0", 0, result);
    }
    
    @Test
    public void testMultipleAssertions() {
        // Demonstrate multiple assertions in one test
        MathUtils utils = new MathUtils();
        
        assertEquals("Addition test", 8, utils.add(5, 3));
        assertEquals("Subtraction test", 2, utils.subtract(5, 3));
        assertEquals("Multiplication test", 15, utils.multiply(5, 3));
        assertTrue("Positive test", utils.isPositive(5));
        assertFalse("Positive test for negative", utils.isPositive(-5));
    }
}
