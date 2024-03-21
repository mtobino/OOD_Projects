package headfirst.observer.weather;

import rowan.ood.beansobserver.BeansObserver;
import rowan.ood.beansobserver.Observable;

/**
 * Adapter Class to adapt a Weather Observer into a BeansObserver
 *
 * @author Matthew Tobino
 */
public class ObserverAdapter extends BeansObserver {

    // Specifying that this observer that is being adapted is from the Weather package
    private final headfirst.observer.weather.Observer weatherObserver;

    /**
     * Constructor for the Adapater
     *
     * @param weatherObserver  The Weather Observer that will go through the adaptation
     */
    public ObserverAdapter(headfirst.observer.weather.Observer weatherObserver){
        this.weatherObserver = weatherObserver;
    }

    /**
     * A Beans Observer Update method which will call the Weather Observer's update
     *
     * @param source    The beans observable (not used)
     * @param data      The weather data that will be used to update the observers
     */
    public void update(Observable source, Object data)
    {
        WeatherData weatherData = (WeatherData) data;
        weatherObserver.update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());

    }

    /**
     * A custom equals to determine if to adapters contain the same weather observer
     *
     * @param obj   The Adapter that is being compared against
     * @return      True iff the weather adapters of the classes are the same
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ObserverAdapter other){
            return other.getWeatherObserver().equals(weatherObserver);
        }
        return false;
    }

    /**
     * Return the Weather Observer stored in the adapter
     *
     * @return  the Weather Observer
     */
    public Observer getWeatherObserver() {
        return weatherObserver;
    }
}
