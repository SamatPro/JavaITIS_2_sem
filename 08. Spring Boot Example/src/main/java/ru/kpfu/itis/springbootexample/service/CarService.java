package ru.kpfu.itis.springbootexample.service;

import ru.kpfu.itis.springbootexample.dto.CarDto;
import ru.kpfu.itis.springbootexample.model.Car;

public interface CarService {
    Car add(CarDto carDto);
    Car getById(Long id);
}
