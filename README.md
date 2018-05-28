# MCube
Multidimensional datastructure to store set of facts (tuples).

## Features:
- Works in memory
- Works fast
- Stores set of tuples
- Consumes small amount of memoty (1 bit per tuple)
- Unlike bloom-filter works exactly

## Methods
- put tuple into MCube
- check for tuple exits
- remove tuple

## Iterators/Enumerators
Actually not supported, but technically, possible.

## When to use:
- Tuple contains from 1 to 4 elements. Actually it's depends on dimensions cardinality product.
- Elements cardinality is not so huge. For example 'DayOfWeek', 'Gender', 'ProductTypes' e.t.c.
- Real world numbers like float/double are not good candidate to store in MCube.

## Where to use:
- Hm.. have no idea :) Try to imagine.

## Ways to improove
- Extend MCube to disk store with mmap.
- Add amount of mechanism to store (compressed bitmap structures, tree-s e.t.c)
