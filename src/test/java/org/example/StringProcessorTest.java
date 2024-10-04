package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringProcessorTest {

    private final StringProcessor processor = new StringProcessor(); // Create an instance of StringProcessor

    @Test
    public void testIsStrongPassword() {
        // Test strong password
        Assertions.assertTrue(processor.isStrongPassword("Strong1@"));
        // Test weak password
        Assertions.assertFalse(processor.isStrongPassword("weakpass"));
    }

    @Test
    public void testCalculateDigits() {
        // Test digits count
        Assertions.assertEquals(3, processor.calculateDigits("Hello 123!"));
        Assertions.assertEquals(0, processor.calculateDigits("No digits here."));
    }

    @Test
    public void testCalculateWords() {
        String input = "This is a sample input."; // Sample input
        int expectedWordCount = 5; // Expected word count
        int actualWordCount = processor.calculateWords(input); // Get actual word count
        Assertions.assertEquals(expectedWordCount, actualWordCount); // Check if they match
    }

    @Test
    public void testCalculateExpression() {
        // Test mathematical expressions
        Assertions.assertEquals(5.0, processor.calculateExpression("2 + 3"));
        Assertions.assertEquals(8.0, processor.calculateExpression("(1 + 2) * 3 - 1"));
    }
}
