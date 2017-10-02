package net.sandipabaidya.airlinebooking.utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sandipa on 9/9/2017.
 */

public abstract class ObjectTransformer<E, F> {

    public abstract F transform(E e);

    public List<F> transformList(List<E> list) {
        List<F> newList = new ArrayList<F>();
        for (E e : list) {
            newList.add(transform(e));
        }
        return newList;
    }
}
