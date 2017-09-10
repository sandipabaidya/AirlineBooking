package airline.Utility;

import java.util.*;

/**
 * Created by Sandipa on 9/9/2017.
 */

public abstract class CollectionTransformer<E, F> {

    abstract F transform(E e);

    public List<F> transform(List<E> list) {
        List<F> newList = new ArrayList<F>();
        for (E e : list) {
            newList.add(transform(e));
        }
        return newList;
    }
}
