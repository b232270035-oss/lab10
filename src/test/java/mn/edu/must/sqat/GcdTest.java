package mn.edu.must.sqat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GcdTest {
    @Test
    @DisplayName("gcd_7_0 covers x13->return20 and y13->while15")
    void gcdWithZeroSkipsLoop() {
        assertEquals(7, DataFlowTargets.gcd(7, 0));
    }

    @Test
    @DisplayName("gcd_12_8 covers loop DU pairs at lines 16-20")
    void gcdRunsTwoIterations() {
        assertEquals(4, DataFlowTargets.gcd(12, 8));
    }

    @Test
    @DisplayName("gcd_0_5 covers initial x use and tmp definitions")
    void gcdWithZeroFirstArgument() {
        assertEquals(5, DataFlowTargets.gcd(0, 5));
    }
}
