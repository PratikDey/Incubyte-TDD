package org.example;

import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        if(numbers == null || numbers.isEmpty()) {
            return 0;
        }
        String delimitersRegex = "[,\\n]";

        if(numbers.startsWith("//")) {
            int nl = numbers.indexOf('\n');
            String rawDelimiter = numbers.substring(2, nl);
            delimitersRegex = Pattern.quote(rawDelimiter);
            numbers = numbers.substring(nl + 1);
        }

        String[] parts = numbers.split(delimitersRegex + "|[\\n]");

        int sum = 0;
        for(String p: parts) {
            if(p.isEmpty()) continue;
            sum += Integer.parseInt(p);
        }
        return sum;
    }
}
