package rowan.ood.wrappedset;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Dr. Baliga on 1/20/18.
 * Credited to Joshua Bloch
 *
 */

public class CountedHashSet<T> extends HashSet<T> {

    private int adds;

    public CountedHashSet() {
        super();
        adds = 0;
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

    public int getAdditions() {
        return adds;
    }

    static private void test() {
        CountedHashSet<Integer> set = new CountedHashSet<>();
        CountedHashSet<Integer> anotherSet = new CountedHashSet<>();

        set.add(10);
        set.add(20);

        anotherSet.add(100);
        anotherSet.add(200);
        anotherSet.add(300);

        set.addAll(anotherSet);

        // What is the output?
        System.out.format ("Added %d values", set.getAdditions());

    }

    public static void main(String[] args) {
        test();
    }

}
