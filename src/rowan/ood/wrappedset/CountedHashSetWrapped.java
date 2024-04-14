package rowan.ood.wrappedset;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Dr. Baliga on 1/20/18.
 */
public class CountedHashSetWrapped<T> extends WrapperSet<T>  {
    private int adds;
    public CountedHashSetWrapped() {
        super(new HashSet<>());
        adds = 0;
    }

    public int getAdditions() {
        return adds;
    }

    @Override
    public boolean add(T t) {
        adds++;
        return super.add(t);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        adds += c.size();
        return super.addAll(c);
    }
}
