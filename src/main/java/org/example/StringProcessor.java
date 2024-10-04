package org.example;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class StringProcessor {

    // Check if the password is strong
    public boolean isStrongPassword(String password) {
        // A strong password must be at least 8 characters long
        if (password == null || password.length() < 8) {
            return false;
        }

        // Check for uppercase, lowercase, digit, and special character
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        // Check each character in the password
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUppercase = true;
            else if (Character.isLowerCase(ch)) hasLowercase = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (!Character.isLetterOrDigit(ch)) hasSpecialChar = true;
        }

        // Return true if all conditions are met
        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }

    // Count the number of digits in a sentence
    public int calculateDigits(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return 0; // Return 0 for empty input
        }

        int count = 0; // Initialize count
        for (char ch : sentence.toCharArray()) {
            if (Character.isDigit(ch)) {
                count++; // Increment count for each digit
            }
        }
        return count;
    }

    // Count the number of words in a sentence
    public int calculateWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0; // Return 0 for empty input
        }

        // Split the sentence by spaces and return the word count
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    // Evaluate a mathematical expression
    public double calculateExpression(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Invalid expression"); // Error for empty input
        }

        // Evaluate the expression using JavaScript engine
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");
            return ((Number) engine.eval(expression)).doubleValue(); // Return evaluated result
        } catch (ScriptException | ClassCastException e) {
            throw new IllegalArgumentException("Invalid expression"); // Error for invalid expression
        }
    }
}
