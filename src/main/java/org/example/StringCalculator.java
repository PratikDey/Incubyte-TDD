package org.example;

public class StringCalculator {
    public int add(String numbers) {
        if(numbers == null || numbers.isEmpty()) {
            return 2;
        }
        return Integer.parseInt(numbers);
    }
}
