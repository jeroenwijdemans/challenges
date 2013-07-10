package nl.wijdemans.euler;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.is;

public class Euler17Test {

    public Euler17InJ euler17;

    @Before
    public void setUp() throws Exception {
        euler17 = new Euler17InJ();

    }

    // 20964
    @Test
    public void countOneThousandShouldReturnTheAnswer() {
        assertEquals(21124, euler17.calculate(1000));
    }

    @Test
    public void countOneShouldReturnThree() {
        assertEquals(euler17.calculate(1), 3);
    }

    @Test
    public void countTwoShouldReturnSix() {
        assertEquals(euler17.calculate(2), 6);
    }

    // EIGHTEEN (1 t)
    @Test
    public void count18ShouldReturn8() {
        assertEquals(8,euler17.calculateSingleDigit(18));
    }

    @Test
    public void countFiveShouldReturnNineteen() {
        assertEquals(euler17.calculate(5), 19);
    }

    // ONE THOUSAND (11)
    @Test
    public void digit1000ShouldReturn11() {
        assertEquals(euler17.calculateSingleDigit(1000), 11);
    }

    @Test
    public void digit500ShouldReturn11() {
        // FIVE HUNDRED
        assertEquals(11, euler17.calculateSingleDigit(500));
    }

    @Test
    public void digit501ShouldReturn11() {
        // FIVE HUNDRED AND ONE
        assertEquals(17, euler17.calculateSingleDigit(501));
    }

    //342 (three hundred and forty-two) contains 23 letters
    //       5   7  3  5 3 = 23
    @Test
    public void digit342ShouldContains23Letters() {
        assertEquals(euler17.calculateSingleDigit(342), 23);
    }

    @Test
    public void digit42ShouldContains8Letters() {
        assertEquals(euler17.calculateSingleDigit(42), 8);
    }

    // EIGHT HUNDRED AND EIGHTY EIGHT (11)
    @Test
    public void digit888ShouldContains26Letters() {
        assertEquals(26, euler17.calculateSingleDigit(888));
    }

    // SEVEN HUNDRED AND SEVENTY SEVEN (11)
    @Test
    public void digit777ShouldContains27Letters() {
        assertEquals(27, euler17.calculateSingleDigit(777));
    }

    // ELEVEN (11)
    // TWENTY TWO (11)
    // THIRTY THREE (11)
    // FORTY FOUR (11)
    // FIFTY FIVE (11)
    // SIXTY SIX (11)
    @Test
    public void digit222ShouldContains27Letters() {
        assertEquals(6, euler17.calculateSingleDigit(11));
        assertEquals(9, euler17.calculateSingleDigit(22));
        assertEquals(11, euler17.calculateSingleDigit(33));
        assertEquals(9, euler17.calculateSingleDigit(44));
        assertEquals(9, euler17.calculateSingleDigit(55));
        assertEquals(8, euler17.calculateSingleDigit(66));
    }

    // 115 (one hundred and fifteen) contains 20 letters
    @Test
    public void digit115ShouldContains20Letters() {
        assertEquals(20, euler17.calculateSingleDigit(115));
    }

    // 116 (one hundred and sixteen) contains 20 letters
    @Test
    public void digit116ShouldContains20Letters() {
        assertEquals(20, euler17.calculateSingleDigit(116));
    }

    // ONE HUNDRED AND NINETY (19)
    @Test
    public void digit190ShouldContains20Letters() {
        assertEquals(19, euler17.calculateSingleDigit(190));
    }
}
