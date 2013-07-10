package nl.wijdemans.euler;

import java.util.HashMap;
import java.util.Map;

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there
 * are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * <p/>
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words,
 * how many letters would be used?
 * <p/>
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two)
 * contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and"
 * when writing out numbers is in compliance with British usage.
 */

public class Euler17InJ {

    enum NUMBERS {ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FIFTEEN, EIGHTEEN}

    enum TENS {TEEN, TWENTY, THIRTY, FORTY, FIFTY, EIGHTY}

    enum SPECIAL {TY, THOUSAND, AND, HUNDRED}

    final static Map<Integer, NUMBERS> KNOWN_NUMBERS = new HashMap<Integer, NUMBERS>();
    final static Map<Integer, TENS> SUFFIX_NUMBERS = new HashMap<Integer, TENS>();

    static {
        KNOWN_NUMBERS.put(1, NUMBERS.ONE);
        KNOWN_NUMBERS.put(2, NUMBERS.TWO);
        KNOWN_NUMBERS.put(3, NUMBERS.THREE);
        KNOWN_NUMBERS.put(4, NUMBERS.FOUR);
        KNOWN_NUMBERS.put(5, NUMBERS.FIVE);
        KNOWN_NUMBERS.put(6, NUMBERS.SIX);
        KNOWN_NUMBERS.put(7, NUMBERS.SEVEN);
        KNOWN_NUMBERS.put(8, NUMBERS.EIGHT);
        KNOWN_NUMBERS.put(9, NUMBERS.NINE);
        KNOWN_NUMBERS.put(10, NUMBERS.TEN);
        KNOWN_NUMBERS.put(11, NUMBERS.ELEVEN);
        KNOWN_NUMBERS.put(12, NUMBERS.TWELVE);
        KNOWN_NUMBERS.put(13, NUMBERS.THIRTEEN);
        KNOWN_NUMBERS.put(15, NUMBERS.FIFTEEN);
        KNOWN_NUMBERS.put(18, NUMBERS.EIGHTEEN);

        SUFFIX_NUMBERS.put(1, TENS.TEEN);
        SUFFIX_NUMBERS.put(2, TENS.TWENTY);
        SUFFIX_NUMBERS.put(3, TENS.THIRTY);
        SUFFIX_NUMBERS.put(4, TENS.FORTY);
        SUFFIX_NUMBERS.put(5, TENS.FIFTY);
        SUFFIX_NUMBERS.put(8, TENS.EIGHTY);


    }

    //,SIXTY,SEVENTY,EIGHTY,NINETY}

    private final String TEN_RANGE_SUFFIX = "TEEN";
    private final String HUNDRED_RANGE_SUFFIX = "TY";

    public int calculate(int i) {
        if (i == 0) {
            return 0;
        }
        return calculate(i - 1) + calculateSingleDigit(i);
    }

    public int calculateSingleDigit(int digit) {
        if (digit == 0) {
            return 0;
        }
        if (digit <= 18) {
            NUMBERS n = KNOWN_NUMBERS.get(digit);
            if (n != null) {
                return n.name().length();
            }
        }
        if (digit >= 1000) {
            return NUMBERS.ONE.name().length() + SPECIAL.THOUSAND.name().length();
        }
        if (digit >= 100) {
            int extra = calculateSingleDigit(digit % 100);
            if (extra != 0) {
                extra += SPECIAL.AND.name().length();
            }
            return extra
                    + calculateSingleDigit(digit / 100)
                    + SPECIAL.HUNDRED.name().length();
        }
        if (digit >= 10) {
            int tiental = digit / 10;
            int extra = 0;
            if (tiental != 0) {
                TENS t = (SUFFIX_NUMBERS.get(tiental));
                if (t != null) {
                    extra = t.name().length();
                } else {
                    extra = calculateSingleDigit(tiental) + SPECIAL.TY.name().length();
                }
            }

            return extra + calculateSingleDigit(digit % 10);
        }

        //enum n = KNOWN_NUMBERS.get(digit);
        return 0;
    }
}
