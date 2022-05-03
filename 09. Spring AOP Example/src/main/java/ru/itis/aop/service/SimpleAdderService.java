package ru.itis.aop.service;

import org.springframework.stereotype.Service;
import ru.itis.aop.annotation.Adder;

@Service
public class SimpleAdderService {

    @Adder
    public int addPositive(int a, int b) {
        if (a > 0 && b > 0) {
            return a + b;
        } else {
            throw new IllegalArgumentException("Arguments must be positive");
        }
    }
}
