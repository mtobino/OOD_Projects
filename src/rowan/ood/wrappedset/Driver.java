package rowan.ood.wrappedset;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Dr. Baliga
 */

public class Driver {
    static private void test() {

        CountedHashSetWrapped<Integer> set = new CountedHashSetWrapped<>();

        Set<Integer> anotherSet = new TreeSet<>();

        set.add(10);
        set.add(20);
        set.add(30);

        anotherSet.add(100);
        anotherSet.add(200);

        set.addAll(anotherSet);
        System.out.format ("Added %d values",  set.getAdditions()); // What is the output?

    }

    public static void main(String[] args) {
        test();
    }
}
