package headfirst.observer.weather;
	
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;

	
	public CurrentConditionsDisplay(){ }
	
	public void update(Subject subject) {
		if(subject instanceof WeatherData data)
		{
            this.temperature = data.getTemperature();
			this.humidity = data.getHumidity();
			display();
		}
	}
	
	public void display() {
		System.out.println("Current conditions: " + temperature 
			+ "F degrees and " + humidity + "% humidity");
	}
}
