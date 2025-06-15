package com.example.weatherforecast.Service;

import com.example.weatherforecast.Model.CityCoordinates;
import com.example.weatherforecast.Model.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.*;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<WeatherData> getForecastForCity(CityCoordinates coords) {
        List<WeatherData> forecastList = new ArrayList<>();

        try {
            String url = "https://api.open-meteo.com/v1/forecast?latitude=" + coords.getLatitude()
                    + "&longitude=" + coords.getLongitude()
                    + "&daily=temperature_2m_max"
                    + "&timezone=auto";

            ResponseEntity<Map> responseEntity = restTemplate.getForEntity(url, Map.class);
            Map<String, Object> response = responseEntity.getBody();

            if (response == null || !response.containsKey("daily")) {
                throw new RuntimeException("Missing 'daily' data in API response");
            }

            Map<String, Object> daily = (Map<String, Object>) response.get("daily");
            List<String> dates = (List<String>) daily.get("time");
            List<Double> temperatures = (List<Double>) daily.get("temperature_2m_max");

            for (int i = 0; i < dates.size(); i++) {
                WeatherData data = new WeatherData();
                data.setDate(LocalDate.parse(dates.get(i)));

                Double temp = (temperatures != null && i < temperatures.size()) ? temperatures.get(i) : 0.0;
                data.setTemperature(temp);

                forecastList.add(data);
            }

        } catch (RestClientException e) {
            System.err.println("Failed to fetch weather data: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error while parsing weather data: " + e.getMessage());
        }

        return forecastList;
    }

    public Map<String, List<WeatherData>> compareCities(CityCoordinates city1, CityCoordinates city2) {
        List<WeatherData> forecast1 = getForecastForCity(city1);
        List<WeatherData> forecast2 = getForecastForCity(city2);

        Map<String, List<WeatherData>> comparison = new HashMap<>();
        comparison.put(city1.getCity(), forecast1);
        comparison.put(city2.getCity(), forecast2);

        return comparison;
    }
}
