package mayton.datastructures;

import org.junit.Test;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;
import static mayton.datastructures.CubeUtils.calculateOffset;
import static org.junit.Assert.assertEquals;

public class CubeUtilsTest {

    @Test(expected = NullPointerException.class)
    public void test_calculate_offset_null_argument() {
        calculateOffset(null,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_calculate_offset_size() {
        calculateOffset(new int[0],new int[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_calculate_offset_size_equals() {
        calculateOffset(new int[1],new int[2]);
    }

    @Test
    public void test_calculate_offset_zero() {
        assertEquals(ZERO, calculateOffset(
                new int[] {7,11,13},
                new int[] {0,0,0}
        ));
    }

    @Test
    public void test_calculate_offset_one() {
        assertEquals(ONE, calculateOffset(
                new int[] {7,11,13},
                new int[] {1,0,0}
        ));
    }

    @Test
    public void test_calculate_custom_offset() {
        assertEquals(valueOf(1000), calculateOffset(
                new int[] {7,11,13},
                new int[] {6,10,12}
        ));
        assertEquals(valueOf(999), calculateOffset(
                new int[] {7,11,13},
                new int[] {5,10,12}
        ));
    }

}
