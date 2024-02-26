package rowan.ood.beansobserver;

/**
 *
 * Publisher implementation using java beans API
 *
 * @author Dr. Baliga
 *
 */

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

public class BeansObservable implements Observable {

    PropertyChangeSupport notificationStrategy;

    public BeansObservable( ) {
        notificationStrategy = new PropertyChangeSupport(this);
    }

    @Override
    public void addObserver(Observer observer) {
        notificationStrategy.addPropertyChangeListener((BeansObserver) observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        notificationStrategy.removePropertyChangeListener((BeansObserver) observer);
    }

    @Override
    public void notifyObservers(Object data) {
        notificationStrategy.firePropertyChange(
                new PropertyChangeEvent(this, null, null, data )
        );
    }

    @Override
    public String toString() {
        return "Mr. Observable";
    }
}
