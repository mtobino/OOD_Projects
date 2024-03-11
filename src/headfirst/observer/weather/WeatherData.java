package headfirst.observer.weather;

import rowan.ood.beansobserver.BeansObservable;
import rowan.ood.beansobserver.BeansObserver;
import rowan.ood.beansobserver.Observable;

import java.util.*;

public class WeatherData implements Subject {
	//private ArrayList observers;
	private final Observable beansObservable;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		//observers = new ArrayList();
		beansObservable = new BeansObservable();
	}
	
	public void registerObserver(Observer o) {
		//observers.add(o);
		BeansObserver beansObserver = new ObserverAdapter(o);
		beansObservable.addObserver(beansObserver);
	}
	
	public void removeObserver(Observer o) {
//		int i = observers.indexOf(o);
//		if (i >= 0) {
//			observers.remove(i);
//		}
		BeansObserver beansObserver = new ObserverAdapter(o);
		beansObservable.removeObserver(beansObserver);
	}
	
	public void notifyObservers() {
//		for (int i = 0; i < observers.size(); i++) {
//			Observer observer = (Observer)observers.get(i);
//			observer.update(temperature, humidity, pressure);
//		}
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
