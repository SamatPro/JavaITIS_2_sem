package ru.kpfu.itis.springbootexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.springbootexample.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
