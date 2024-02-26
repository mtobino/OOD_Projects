package rowan.ood.beansobserver;

/**
 *
 * Observer abstraction in pub-sub using java beans API
 *
 * @author Dr. Baliga
 *
 */

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public abstract class BeansObserver implements Observer, PropertyChangeListener {

    @Override
    public final void propertyChange(PropertyChangeEvent event) {
        this.update((Observable) event.getSource(), event.getNewValue());
    }
}
