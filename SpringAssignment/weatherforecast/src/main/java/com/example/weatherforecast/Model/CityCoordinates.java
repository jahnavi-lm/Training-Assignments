package com.example.weatherforecast.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityCoordinates {
    private String city;
    private double latitude;
    private double longitude;
}
