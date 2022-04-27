package ru.kpfu.itis.springbootexample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.springbootexample.dto.CarDto;
import ru.kpfu.itis.springbootexample.model.Car;
import ru.kpfu.itis.springbootexample.repository.CarRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car add(CarDto carDto) {
        Car car = Car.builder()
                .color(carDto.getColor())
                .mark(carDto.getMark())
                .number(carDto.getNumber())
                .model(carDto.getModel())
                .build();

        return carRepository.save(car);
    }

    @Override
    public Car getById(Long id) throws NoSuchElementException {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isPresent()) {
            return carOptional.get();
        } else {
            logger.warn("Машина с id={} не найдена", id);
            throw new NoSuchElementException("Машина с id=" + id + " не найдена");
        }
    }
}
