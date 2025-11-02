package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        if(numbers == null || numbers.isEmpty()) {
            return 0;
        }
        String delimitersRegex = "[,\\n]";

        if(numbers.startsWith("//")) {
            int nl = numbers.indexOf('\n');
            if (nl == -1) {
                throw new IllegalArgumentException("Invalid input: missing newline after custom delimiter");
            }
            String rawDelimiter = numbers.substring(2, nl);
            String quoted = Pattern.quote(rawDelimiter);
            delimitersRegex = quoted;
            numbers = numbers.substring(nl + 1);
        }

        String[] parts = numbers.split(delimitersRegex + "|[\\n,]");

        int sum = 0;
        List<Integer> negatives = new ArrayList<>();
        for(String p: parts) {
            if(p.isEmpty() || p == null) continue;
            int n = Integer.parseInt(p);
            if(n < 0) negatives.add(n);
            sum += n;
        }

        if(!negatives.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < negatives.size(); i++) {
                if(i > 0) sb.append(',');
                sb.append(negatives.get(i));
            }
            throw new IllegalArgumentException("Negative numbers not allowed " + sb.toString());
        }
        return sum;
    }
}
