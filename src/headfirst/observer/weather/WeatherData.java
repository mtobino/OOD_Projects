package headfirst.observer.weather;

import rowan.ood.beansobserver.BeansObservable;
import rowan.ood.beansobserver.BeansObserver;
import rowan.ood.beansobserver.Observable;

import java.util.*;

public class WeatherData implements Subject {
	// Beans Observable to use Weather data as its own adapter
	private final Observable beansObservable;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		beansObservable = new BeansObservable();
	}
	
	public void registerObserver(Observer o) {
		BeansObserver beansObserver = new ObserverAdapter(o);
		beansObservable.addObserver(beansObserver);
	}
	
	public void removeObserver(Observer o) {
		BeansObserver beansObserver = new ObserverAdapter(o);
		beansObservable.removeObserver(beansObserver);
	}
	
	public void notifyObservers() {
		beansObservable.notifyObservers(this);
	}
	
	public void measurementsChanged() {
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	public float getHumidity() {
		return humidity;
	}
	
	public float getPressure() {
		return pressure;
	}
}
