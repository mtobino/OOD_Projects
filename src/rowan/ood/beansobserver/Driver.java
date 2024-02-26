package rowan.ood.beansobserver;

/**
 * Simple test driver for:
 *      Observer pattern implemented using java beans API (replacing
 *      the deprecated Observer pattern implemented in java.util)
 *
 * @author Dr. Baliga
 *
 */

public class Driver {

    public static void main (String ... args) {
        Observable observable = new BeansObservable();

        Observer anObserver = new BeansObserver() {
            @Override
            public void update(Observable source, Object data) {
                System.out.format("Received message \"%s\" from \"%s\"\n", data, source);
            }
        };

        observable.addObserver(anObserver);
        observable.notifyObservers("Hello world!");

    }
}
