package mayton.datastructures;

import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigInteger;
import java.util.*;

import static java.math.BigInteger.ONE;

class DictOptions {
    // Count == multiplier
    public int count;
    // Value, code, frequency
    public Map<String, Pair<Integer,Integer>> value2code;
    // Code, value
    public Map<Integer, String> code2value;
}

@NotThreadSafe
public class HashCube implements ICube, IModifableCube {

    protected static Logger logger = LoggerFactory.getLogger(HashCube.class);

    // TODO: Should be private
    public Map<String, DictOptions> cardinalityMap = new HashMap<>();

    /**
     * TODO: Contains concatenated codes lile : 1,2,3,1,
     */
    private Set<String> data;

    /**
     * Dictionary names and multipliers
     */
    private List<Pair<String,Integer>> orderedDictNames;

    private int dimensions;
    private int count;
    private int[] dimensionSizes;

    private static BigInteger calculateOffset(Integer ...args){
        return ONE;
    }


    public void printReport(String dictName) {

        DictOptions dict = cardinalityMap.get(dictName);

        logger.info(" =========================================================================== ");
        logger.info("Field name : {}, size = {} records", dictName, dict.count);
        logger.info("--------------------------------");
        Map<String, Pair<Integer, Integer>> key2valmap = dict.value2code;
        for(Map.Entry<String,Pair<Integer, Integer>> valueEntry : key2valmap.entrySet()) {
            logger.info("Value Record : {}, count = {}, frequency = {}",
                    valueEntry.getKey(),
                    valueEntry.getValue().getLeft(),
                    valueEntry.getValue().getRight());
        }
    }

    public HashCube(@Nonnull String... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Not enough arguments! Please provide even one.");
        }
        this.dimensions = args.length;
        this.count = 0;
        for(int i=0;i<dimensions;i++) {
            cardinalityMap.put(args[i], null);
        }
        data = new HashSet<>();
    }

    @Override
    public boolean check(@Nonnull String... args) {
        if (args.length > dimensions) {
            throw new IllegalArgumentException("Too much arguments : " + args.length + ", expected : " + dimensions);
        }

        return false;
    }

    private int[] transformDictionay(String[] args) {
        int[] arr = new int[dimensions];
        int i = 0;
        for(String s : args) {
            DictOptions options = cardinalityMap.get(s);
            arr[i] = options.count;
        }
        return arr;
    }

    public void set(@Nonnull String... args) {
        if (args.length > dimensions) {
            throw new IllegalArgumentException("Too much arguments : " + args.length + ", expected : " + dimensions);
        }
        // TODO: Improove
        Integer[] iargs = new Integer[dimensions];

        data.add(calculateOffset(iargs).toString());
        count++;
        logger.trace("set");
    }

    public void unset(@Nonnull String... args) {
        if (args.length > dimensions) {
            throw new IllegalArgumentException("Too much arguments : " + args.length + ", expected : " + dimensions);
        }
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public void bulkSet(Iterator<String[]> iterator) {

    }

}
