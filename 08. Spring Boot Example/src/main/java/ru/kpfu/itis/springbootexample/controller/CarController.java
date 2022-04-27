package ru.kpfu.itis.springbootexample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.springbootexample.dto.CarDto;
import ru.kpfu.itis.springbootexample.model.Car;
import ru.kpfu.itis.springbootexample.service.CarService;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/cars")
public class CarController {

    private Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarService carService;

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        try {
            Car car = carService.getById(id);
            logger.info(car.toString());
            return ResponseEntity.ok(car);
        } catch (NoSuchElementException e) {
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Car> addCar(CarDto carDto) {
        return ResponseEntity.ok(carService.add(carDto));
    }
}
