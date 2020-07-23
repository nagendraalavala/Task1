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
    @ExceptionHandler(CityNotFoundException.class)
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<String> getTemperature(@PathVariable String city)
    {
        double temp = weatherService.getweatherByCityName(city);


        return (temp!=0) ? new ResponseEntity(temp,HttpStatus.FOUND) :
                new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }


}
