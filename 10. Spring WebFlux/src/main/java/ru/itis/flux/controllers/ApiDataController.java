package ru.itis.flux.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.itis.flux.entries.DataSample;
import ru.itis.flux.services.ApiDataService;

import java.time.Instant;

@RestController
public class ApiDataController {

    @Autowired
    private ApiDataService apiDataService;

    @RequestMapping(value = "/records",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE,
            method = RequestMethod.GET)
    public Flux<DataSample> getAll(){
        Instant startTime = Instant.now();
        try {
            return apiDataService.getAll();
        } finally {
            Instant endTime = Instant.now();
            System.out.println(endTime.minusMillis(startTime.toEpochMilli()).toEpochMilli());
        }
    }
}
