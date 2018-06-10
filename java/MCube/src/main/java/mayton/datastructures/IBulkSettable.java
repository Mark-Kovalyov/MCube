package mayton.datastructures;

import java.util.Iterator;

/**
 * Presents top-level multidimensional Cube interface
 * All cubes must extends from.
 */
public interface IBulkSettable {
    /**
     * BulkSet to inition population of Cube
     * @param iterator
     */
    void bulkSet(Iterator<String[]> iterator);

}
