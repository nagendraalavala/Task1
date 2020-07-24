package com.example.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1",headers = "Accept=application/json")
public class weatherController
{
    @Autowired
    private weatherService weatherService;

    @GetMapping("/{city}")
    public ResponseEntity<WeatherResponse> getTemperature(@PathVariable String city)
    {
        WeatherResponse response = weatherService.getweatherByCityName(city);


        return (response != null) ? new ResponseEntity(response,HttpStatus.OK) :
                new ResponseEntity( HttpStatus.NO_CONTENT);
    }


}
