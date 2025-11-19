import org.example.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    @Test
    public void emptyStringReturnsZero() {
        StringCalculator calc = new StringCalculator();
        assertEquals(0, calc.add(""));
    }
    @Test
    public void singleNumberReturnsValue() {
        StringCalculator calc = new StringCalculator();
        assertEquals(1, calc.add("1"));
    }
    @Test
    public void twoNumbersCommaSeparated() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("1,5"));
    }
    @Test
    public void manyNumbers() {
        StringCalculator calc = new StringCalculator();
        assertEquals(10, calc.add("1,2,3,4"));
    }
    @Test
    public void newlinesAllowedBetweenNumbers() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("1\n2,3"));
    }
    @Test
    public void customDelimiter() {
        StringCalculator calc = new StringCalculator();
        assertEquals(3, calc.add("//;\n1;2"));
    }
    @Test
    public void customDelimiterWithAsterisk() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("//*\n3*2"));
    }
    @Test
    public void negativeNumberThrowsException_single() {
        StringCalculator calc = new StringCalculator();
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> calc.add("1,-2,3"));
        assertEquals("Negative numbers not allowed -2", ex.getMessage());
    }
    @Test
    public void negativeNumberThrowsException_multiple() {
        StringCalculator calc = new StringCalculator();
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> calc.add("-1,2,-3,4"));
        assertEquals("Negative numbers not allowed -1,-3", ex.getMessage());
    }
    @Test
    public void ignoreEmptyTokens() {
        StringCalculator calc = new StringCalculator();
        assertEquals(3, calc.add("1,2,"));
    }
}
