package com.example.weatherforecast.Util;

import com.example.weatherforecast.Model.CityCoordinates;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public static List<CityCoordinates> readCityCoordinates(String filePath) {
        List<CityCoordinates> cities = new ArrayList<>();
        try (InputStream is = ExcelReader.class.getClassLoader().getResourceAsStream(filePath);
             Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                String city = row.getCell(0).getStringCellValue();
                double latitude = row.getCell(1).getNumericCellValue();
                double longitude = row.getCell(2).getNumericCellValue();
                cities.add(new CityCoordinates(city.trim().toLowerCase(), latitude, longitude));
            }
        } catch (Exception e) {
            System.err.println("Error reading Excel file: " + e.getMessage());
        }
        return cities;
    }
    public static CityCoordinates getCoordinatesForCity(String cityName, List<CityCoordinates> cities) {
        return cities.stream()
                .filter(c -> c.getCity().equalsIgnoreCase(cityName.trim()))
                .findFirst()
                .orElse(null);
    }
}
