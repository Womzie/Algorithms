package homework;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LogarithmsTest {

    @Test
    void worksForExactPower() {
        assertEquals(4, Logarithms.log(3, 81));
    }

    @Test
    void worksForInexactPower() {
        assertEquals(2, Logarithms.log(2, 7));
    }

    @Test
    void worksIfAIsGreaterThanB() {
        assertEquals(0, Logarithms.log(2, 1));
    }

    @Test
    void worksIfDivisionWouldSkipOver1() {
        assertEquals(1, Logarithms.log(3, 8));
    }

    @Test
    void matchesMathLibrary() {
        for (int i = 0; i < 100; i++) {
            int a = StdRandom.uniform(2, 11);
            int b = StdRandom.uniform(1, Integer.MAX_VALUE);
            assertEquals((int)Math.floor(Math.log(b) / Math.log(a)), Logarithms.log(a, b));
        }
    }

}