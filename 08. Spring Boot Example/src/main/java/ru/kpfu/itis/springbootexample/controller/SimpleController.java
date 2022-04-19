package ru.kpfu.itis.springbootexample.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {

    private Logger logger = Logger.getLogger(SimpleController.class);

    @Value("${custom.mail.password}")
    private String password;

    @GetMapping("/")
    public String getPage(ModelMap modelMap) {
        logger.info("Зашли в метод getPage обычного контроллера");
        modelMap.addAttribute("attribute","simpledimple");
        modelMap.addAttribute("password", password);
        logger.info("Засетили аттрибуты");
        return "example";
    }
}
