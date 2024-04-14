package rowan.ood.wrappedset;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Dr. Baliga on 1/20/18.
 */


public class WrapperSet<T> implements Set<T> {

    private final Set<T> wrappedSet;

    public WrapperSet(Set<T> wrappedSet) {
        // All behavior is delegated to the wrapped set
        this.wrappedSet = wrappedSet;
    }

    @Override
    public int size() {
        return wrappedSet.size(); // Delegation!
    }

    @Override
    public boolean isEmpty() {
        return wrappedSet.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return wrappedSet.contains(o);
    }

    // And other methods from the Set interface

    @Override
    public Iterator<T> iterator() {
        return wrappedSet.iterator();
    }

    @Override
    public Object[] toArray() {
        return wrappedSet.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return wrappedSet.toArray(a);
    }

    @Override
    public boolean add(T t) {
        return wrappedSet.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return wrappedSet.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return wrappedSet.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return wrappedSet.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return wrappedSet.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return wrappedSet.removeAll(c);
    }

    @Override
    public void clear() {
        wrappedSet.clear();
    }

    @Override
    public boolean equals(Object o) {
        return wrappedSet.equals(o);
    }

    @Override
    public int hashCode() {
        return wrappedSet.hashCode();
    }
}
