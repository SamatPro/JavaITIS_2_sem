package ru.kpfu.itis.springbootexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private String model;
    private String number;
    private String mark;
    private String color;
}
