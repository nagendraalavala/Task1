package com.example.task1;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class weatherService
{

    public WeatherResponse getweatherByCityName(String city)
    {
        double result=0;
        HashMap<String,Double> cityWeather = new HashMap<>();
        cityWeather.put("Rogers", 23.5);
        cityWeather.put("NYC", 21.8);
        cityWeather.put("Omaha", 22.3);
        cityWeather.put("VJA",40.0);

        for(String checkCity : cityWeather.keySet())
        {
            if(cityWeather.containsKey(city)) {
               result= cityWeather.get(city);
            }
        }


        return new WeatherResponse(2.3);
    }
}
