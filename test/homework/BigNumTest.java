package homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BigNumTest {

    @Test
    void remembersDigits() {
        BigNum a = new BigNum("12345678901234567890");
        assertEquals("12345678901234567890", a.toString());
    }

    @Test
    void representsZero() {
        BigNum a = new BigNum("");
        assertEquals("0", a.toString());
    }

    @Test
    void addsSmallNumbers() {
        BigNum a = new BigNum("2");
        BigNum b = new BigNum("2");
        BigNum c = a.plus(b);
        assertEquals("4", c.toString());
    }

    @Test
    void addsLargeNumbers() {
        BigNum a = new BigNum("5000000206");
        BigNum b = new BigNum("6000000005");
        BigNum c = a.plus(b);
        assertEquals("11000000211", c.toString());
    }

    @Test
    void additionDoesNotModifyArguments() {
        BigNum a = new BigNum("5000000206");
        BigNum b = new BigNum("6000000005");
        a.plus(b);
        assertEquals("5000000206", a.toString());
        assertEquals("6000000005", b.toString());
    }

    @Test
    void addsNumbersOfDifferentLengths() {
        BigNum a = new BigNum("12");
        BigNum b = new BigNum("340");
        BigNum c = a.plus(b);
        assertEquals("352", c.toString());
        c = b.plus(a);
        assertEquals("352", c.toString());
    }

    @Test
    void multipliesSmallNumbers() {
        BigNum a = new BigNum("2");
        BigNum b = new BigNum("3");
        BigNum c = a.times(b);
        assertEquals("6", c.toString());
    }

    @Test
    void multipliesLargeNumbers() {
        BigNum a = new BigNum("20000003");
        BigNum b = new BigNum("40000005");
        BigNum c = a.times(b);
        assertEquals("800000220000015", c.toString());
    }

    @Test
    void multiplicationDoesNotModifyArguments() {
        BigNum a = new BigNum("20000003");
        BigNum b = new BigNum("40000005");
        a.times(b);
        assertEquals("20000003", a.toString());
        assertEquals("40000005", b.toString());
    }

    @Test
    void adds9to99() {
        BigNum a = new BigNum("9");
        BigNum b = new BigNum("99");
        BigNum c = a.plus(b);
        assertEquals("108", c.toString());
    }

    @Test
    void multiplies3by33() {
        BigNum a = new BigNum("3");
        BigNum b = new BigNum("33");
        BigNum c = a.times(b);
        assertEquals("99", c.toString());
    }

}
