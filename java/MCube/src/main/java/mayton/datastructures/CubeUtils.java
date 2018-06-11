package mayton.datastructures;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import java.math.BigInteger;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.Math.addExact;
import static java.lang.Math.multiplyExact;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

@ThreadSafe
public class CubeUtils {

    private CubeUtils() {}

    /**
     * Calculate distance from imaginable center of cartezian
     * coordinates to multidimensional point
     *
     * Example:
     *  For dimensionSizes { 7, 11, 13 }
     *
     *
     *  All cells = 7 * 11 * 13 = 1001
     *              F(0,0,0)   == 0
     *              F(1,0,0)   == 1
     *              F(5,10,12) == 1001 - 1 - 1 = 999
     *              F(6,10,12) == 1001 - 1 = 1000
     *
     *  6 + 10 * (7) + 12 * (7 * 11) = 1000
     *
     * @param dimensionSizes
     * @param point
     * @return
     */
    @Nonnull
    public static BigInteger calculateOffset(@Nonnull int[] dimensionSizes, @Nonnull int[] point) {
        checkNotNull(dimensionSizes, "Dimension sizes musn't be null");
        checkNotNull(point,          "Point vector musn't be null");
        checkArgument(dimensionSizes.length > 0, "Dimension sizes vector must be > 0");
        checkArgument(point.length > 0, "Dimension sizes vector must be > 0");
        checkArgument(dimensionSizes.length == point.length, "Sizes must be equals");
        BigInteger sum = valueOf(point[0]);
        BigInteger k = ONE;
        for (int i = 1; i < dimensionSizes.length; i++) {
            k = k.multiply(valueOf(dimensionSizes[i - 1]));
            sum = sum.add(k.multiply(valueOf(point[i])));
        }
        return sum;
    }

    public static long calculateOffsetLong(@Nonnull int[] dimensionSizes, @Nonnull int[] point) {
        checkNotNull(dimensionSizes, "Dimension sizes musn't be null");
        checkNotNull(point,          "Point vector musn't be null");
        checkArgument(dimensionSizes.length > 0, "Dimension sizes vector must be > 0");
        checkArgument(point.length > 0, "Dimension sizes vector must be > 0");
        checkArgument(dimensionSizes.length == point.length, "Sizes must be equals");
        long sum = point[0];
        long k = 1L;
        for (int i = 1; i < dimensionSizes.length; i++) {
            // k = k * dimensionSizes[i - 1];
            k = multiplyExact(k, dimensionSizes[i - 1]);
            // sum = sum + k * point[i];
            sum = addExact(sum, multiplyExact(k, point[i]));
        }
        return sum;
    }




}
