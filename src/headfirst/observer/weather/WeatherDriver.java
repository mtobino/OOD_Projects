package headfirst.observer.weather;

public class WeatherDriver {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
	
		CurrentConditionsDisplay currentDisplay =
			new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

		weatherData.setMeasurements(80, 65, 30.4f);

		weatherData.removeObserver(currentDisplay);
		weatherData.setMeasurements(82, 70, 29.2f);

		weatherData.removeObserver(statisticsDisplay);
		weatherData.setMeasurements(78, 90, 29.2f);

		weatherData.removeObserver(forecastDisplay);
		weatherData.registerObserver(currentDisplay);
		weatherData.setMeasurements(75, 88, 29.6f);


	}
}
