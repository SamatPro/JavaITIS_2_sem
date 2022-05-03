package ru.itis.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itis.aop.service.SimpleAdderService;

@SpringBootApplication
public class AopApplication {

    private static Logger logger = LoggerFactory.getLogger(AopApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AopApplication.class, args);
        SimpleAdderService service = context.getBean(SimpleAdderService.class);
        int result = service.addPositive(111, 225);
        logger.info("Результат сложения {}",  result);
        int result2 = service.addPositive(-111, 225);
    }

}
