import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 19/12/2016.
 */
public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setUp() throws Exception{
        calculator = new Calculator();
    }

    @Test
    public void emptyStringReturnsZero() {
        int result = calculator.add("");
        assertEquals(0, result);
    }

    @Test
    public void stringReturnsSomething() {
        int result = calculator.add("Rhian");
        assertFalse(result == 0);
    }

    @Test
    public void singleNumberReturnsAValue() {
        int result = calculator.add("7");
        assertEquals(7, result);
    }

    @Test
    public void singleNumberReturnsAnotherValue() {
        int result = calculator.add("3");
        assertEquals(3, result);
    }

    @Test
    public void twoNumberAddCorrectlyWithCommas()throws Exception {
        int result = calculator.add("5,7");
        assertEquals(12, result);
    }

    @Test
    public void twoNumberAddCorrectlyWithSpace()throws Exception {
        int result = calculator.add("5 5");
        assertEquals(10, result);
    }


    @Test
    public void twoNumberAddCorrectlyWithNewLineDelimited()throws Exception {
        int result = calculator.add("4\n4");
        assertEquals(8, result);
    }

    @Test
    public void threeNumberAddCorrectlyWithAnythingDelimited()throws Exception {
        int result = calculator.add("10\n5,5");
        assertEquals(20, result);
    }

    @Test
    public void threeNumberAddCorrectlyWithAnythingDelimitedTestNumberTwo()throws Exception {
        int result = calculator.add("10 3\n5");
        assertEquals(18, result);
    }

    @Test
    public void fourNumberAddCorrectlyWithAnythingDelimited()throws Exception {
        int result = calculator.add("10\n 3, 5 3");
        assertEquals(21, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeNumberThrowsAnException()throws Exception {
            int r = calculator.add("-2");

    }
    @Test
    public void numbersGreaterThanThousandTreatedAsThousand()throws Exception {
        int result = calculator.add("3500");
        assertEquals(1000, result);
    }
    @Test
    public void twoNumbersGreaterThanThousandTreatedAsThousand()throws Exception {
        int result = calculator.add("3500,6000");
        assertEquals(2000, result);
    }
    @Test
    public void twoNumbersOneGreaterThanThousandOneLessThanThousand()throws Exception {
        int result = calculator.add("3500,6");
        assertEquals(1006, result);
    }
    @Test
    public void twoNumbersOneGreaterThanThousandOneLessThanThousandWithSpace()throws Exception {
        int result = calculator.add("3500 8");
        assertEquals(1008, result);
    }
    @Test
    public void tenNumbersFourGreaterThanThousandSixLessThanThousand()throws Exception {
        int result = calculator.add("3500 500\n50,60\n3001,30 900\n4509,10005\n1");
        assertEquals(5541, result);
    }

}
