package mayton.datastructures;

import org.junit.Ignore;
import org.junit.Test;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;
import static mayton.datastructures.CubeUtils.calculateOffset;
import static mayton.datastructures.CubeUtils.calculateOffsetLong;
import static org.junit.Assert.assertEquals;

public class CubeUtilsTest {


    @Ignore("Flaky test! WTF?")

    /*
    Caused by: java.lang.IllegalArgumentException: Argument for @Nonnull parameter 'dimensionSizes' of mayton/datastructures/CubeUtils.calculateOffset must not be null
    at mayton.datastructures.CubeUtils.$$$reportNull$$$0(CubeUtils.java)
    at mayton.datastructures.CubeUtils.calculateOffset(CubeUtils.java)
    at mayton.datastructures.CubeUtilsTest.test_calculate_offset_null_argument(CubeUtilsTest.java:19)
    at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke(Method.java:498)
    at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
    at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
    at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
    at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
    at org.junit.internal.runners.statements.ExpectException.evaluate(ExpectException.java:19)
    */
    @Test(expected = IllegalArgumentException.class)
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

    /////////////////////////////////// Long ///////////////////////////////////////////


    @Test
    public void test_calculate_offset_zero_long() {
        assertEquals(0, calculateOffsetLong(
                new int[] {7,11,13},
                new int[] {0,0,0}
        ));
    }

    @Test
    public void test_calculate_offset_one_long() {
        assertEquals(1L, calculateOffsetLong(
                new int[] {7,11,13},
                new int[] {1,0,0}
        ));
    }

    @Test
    public void test_calculate_custom_offset_long() {
        assertEquals(1000L, calculateOffsetLong(
                new int[] {7,11,13},
                new int[] {6,10,12}
        ));
        assertEquals(999, calculateOffsetLong(
                new int[] {7,11,13},
                new int[] {5,10,12}
        ));
    }

}
