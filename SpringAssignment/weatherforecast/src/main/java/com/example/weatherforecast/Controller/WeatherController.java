package com.example.weatherforecast.Controller;

import com.example.weatherforecast.Service.WeatherService;
import com.example.weatherforecast.Util.ExcelReader;
import com.example.weatherforecast.Model.CityCoordinates;
import com.example.weatherforecast.Model.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    private final List<CityCoordinates> cityList;

    public WeatherController() {
        this.cityList = ExcelReader.readCityCoordinates("cities.xlsx");
    }

    @GetMapping
    public List<CityCoordinates> getAvailableCities() {
        return cityList;
    }

    @GetMapping("/forecast")
    public List<WeatherData> getForecast(@RequestParam String city) {
        CityCoordinates coords = ExcelReader.getCoordinatesForCity(city, cityList);
        if (coords == null) {
            throw new IllegalArgumentException("City not found: " + city);
        }

        return weatherService.getForecastForCity(coords);
    }

    @GetMapping("/compare")
    public Object compareForecasts(@RequestParam String city1, @RequestParam String city2) {
        CityCoordinates coords1 = ExcelReader.getCoordinatesForCity(city1, cityList);
        CityCoordinates coords2 = ExcelReader.getCoordinatesForCity(city2, cityList);

        if (coords1 == null || coords2 == null) {
            throw new IllegalArgumentException("One or both cities not found.");
        }

        return weatherService.compareCities(coords1, coords2);
    }
}
