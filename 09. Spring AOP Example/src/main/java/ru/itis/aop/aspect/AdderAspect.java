package ru.itis.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdderAspect {

    private Logger logger = LoggerFactory.getLogger(AdderAspect.class);

    @Around("@annotation(ru.itis.aop.annotation.Adder)")
    public Object logAdder(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Выполнился метод add {}", joinPoint.getSignature());
        return joinPoint.proceed();
    }

    @AfterThrowing(value = "execution(* ru.itis.aop.service.SimpleAdderService.addPositive(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        logger.error("Произошла ошибка, НЕМЕДЛЕННО ИСПРАВЬТЕ!!! {}, \n {}", ex.getMessage(), joinPoint.getSignature());
    }
}
