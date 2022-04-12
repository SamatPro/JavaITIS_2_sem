package ru.kpfu.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Controller
public class ChatController {

    @GetMapping("/")
    public String getChatPage(Model model) {
        model.addAttribute("id", UUID.randomUUID().toString());
        return "chatPage";
    }
}
