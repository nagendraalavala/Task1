package com.example.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class weatherController
{
    @Autowired
    private weatherService weatherService;

    @GetMapping("/{city}")
    @ExceptionHandler(CityNotFoundException.class)
    public String getTemperature(@PathVariable String city)
    {
        return weatherService.getweatherByCityName(city);
    }
}
