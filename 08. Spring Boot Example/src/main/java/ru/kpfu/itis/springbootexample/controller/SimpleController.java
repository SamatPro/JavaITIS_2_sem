package ru.kpfu.itis.springbootexample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {

    private Logger logger = LoggerFactory.getLogger(SimpleController.class);

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

    @GetMapping("/upload")
    public String getFileUploadPage() {
        logger.info("Зашли в метод getFileUploadPage обычного контроллера");
        logger.info("Открываем страничку загрузки файлов");
        return "files";
    }
}
