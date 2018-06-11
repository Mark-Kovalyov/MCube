package mayton.datastructures.experimental;

import mayton.datastructures.ICube;
import org.apache.hadoop.util.bloom.BloomFilter;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.*;

@NotThreadSafe
public class BloomCube implements ICube {

    private BloomFilter filter;

    private int columns;

    private Set<List<String>> hashSet;

    public BloomCube(int columns) {
        this.columns = columns;

    }

    @Override
    public boolean check(String... args) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }


    @Override
    public void bulkSet(Iterator<String[]> iterator) {
        throw new RuntimeException("Not implemented yet!");
    }
}
