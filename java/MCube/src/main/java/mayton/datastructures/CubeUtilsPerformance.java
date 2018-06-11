package mayton.datastructures;

import org.openjdk.jmh.annotations.*;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CubeUtilsPerformance {

    @Benchmark
    @Warmup(iterations = 4, time = 5, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1, time = 5, timeUnit = TimeUnit.SECONDS)
    @BenchmarkMode(Mode.Throughput)
    public void test_big_integer(){
        int[] dimensions = new int[] {2,3,5,7};
        int[] point = new int[4];
        Random r = new Random();
        for(int i=0;i<1000;i++){
            point[0] = r.nextInt(100);
            point[1] = r.nextInt(100);
            point[2] = r.nextInt(100);
            point[3] = r.nextInt(100);
            BigInteger res = CubeUtils.calculateOffset(dimensions, point);
        }
    }

    @Benchmark
    @Warmup(iterations = 4, time = 5, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1, time = 5, timeUnit = TimeUnit.SECONDS)
    @BenchmarkMode(Mode.Throughput)
    public void test_long(){
        int[] dimensions = new int[] {2,3,5,7};
        int[] point = new int[4];
        Random r = new Random();
        for(int i=0;i<1000;i++){
            point[0] = r.nextInt(100);
            point[1] = r.nextInt(100);
            point[2] = r.nextInt(100);
            point[3] = r.nextInt(100);
            long res = CubeUtils.calculateOffsetLong(dimensions, point);
        }
    }


}
