package headfirst.observer.weather;

import rowan.ood.beansobserver.BeansObserver;
import rowan.ood.beansobserver.Observable;


public class ObserverAdapter extends BeansObserver {

    private final headfirst.observer.weather.Observer observer;
    public ObserverAdapter(headfirst.observer.weather.Observer observer){
        this.observer = observer;
    }
    public void update(Observable source, Object data)
    {
        WeatherData weatherData = (WeatherData) data;
        observer.update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());

    }
}
