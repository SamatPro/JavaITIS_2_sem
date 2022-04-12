package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.dtos.LoginDto;
import ru.kpfu.itis.dtos.RegistrationDto;
import ru.kpfu.itis.exceptions.UserAlreadyExistException;
import ru.kpfu.itis.services.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/signUp")
    public String signUpPage() {
        return "signUp";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signUp")
    public ModelAndView signUpUser(ModelAndView modelAndView, RegistrationDto registrationDto) {
        try {
            userService.signUp(registrationDto);
        } catch (UserAlreadyExistException e) {
            modelAndView.addObject("registrationStatus", "Пользователь с таким email уже существует");
            modelAndView.setViewName("signUp");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/signIn");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/signIn")
    public String getLoginForm(HttpServletRequest request, ModelMap model) {
        if (request.getParameter("error") != null) {
            model.addAttribute("error", "Неправильный логин или пароль");
        }
        return "signIn";
    }

}
