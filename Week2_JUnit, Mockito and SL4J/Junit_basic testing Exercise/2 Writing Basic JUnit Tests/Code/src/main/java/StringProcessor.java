/**
 * StringProcessor class for Exercise 2: Writing Basic JUnit Tests
 * This class contains various string processing methods to demonstrate basic JUnit testing
 */
public class StringProcessor {
    
    /**
     * Reverses a string
     * @param input the string to reverse
     * @return reversed string, or null if input is null
     */
    public String reverse(String input) {
        if (input == null) {
            return null;
        }
        return new StringBuilder(input).reverse().toString();
    }
    
    /**
     * Converts string to uppercase
     * @param input the string to convert
     * @return uppercase string, or null if input is null
     */
    public String toUpperCase(String input) {
        if (input == null) {
            return null;
        }
        return input.toUpperCase();
    }
    
    /**
     * Counts the number of words in a string
     * @param input the string to count words in
     * @return number of words, or 0 if input is null or empty
     */
    public int countWords(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }
        return input.trim().split("\\s+").length;
    }
    
    /**
     * Checks if a string is a palindrome (ignoring case and spaces)
     * @param input the string to check
     * @return true if palindrome, false otherwise
     */
    public boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }
    
    /**
     * Concatenates two strings with a separator
     * @param first first string
     * @param second second string
     * @param separator separator to use
     * @return concatenated string
     */
    public String concatenate(String first, String second, String separator) {
        if (first == null) first = "";
        if (second == null) second = "";
        if (separator == null) separator = "";
        
        return first + separator + second;
    }
    
    /**
     * Checks if string contains only digits
     * @param input string to check
     * @return true if contains only digits, false otherwise
     */
    public boolean isNumeric(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        return input.matches("\\d+");
    }
    
    /**
     * Removes all whitespace from a string
     * @param input string to process
     * @return string without whitespace, or null if input is null
     */
    public String removeWhitespace(String input) {
        if (input == null) {
            return null;
        }
        return input.replaceAll("\\s", "");
    }
    
    /**
     * Gets the first n characters of a string
     * @param input the input string
     * @param n number of characters to get
     * @return first n characters, or the whole string if shorter than n
     * @throws IllegalArgumentException if n is negative
     */
    public String getFirstNCharacters(String input, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n cannot be negative");
        }
        if (input == null) {
            return null;
        }
        if (n >= input.length()) {
            return input;
        }
        return input.substring(0, n);
    }
}
