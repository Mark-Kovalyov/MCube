package mayton.datastructures.experimental;

import mayton.datastructures.ICube;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.Iterator;

@NotThreadSafe
public class BitmapCube implements ICube {

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
