package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.dtos.UserDto;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.services.UserService;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/profile")
    public ModelAndView getProfile(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        if (authentication == null) {
            modelAndView.setViewName("redirect:/signin");
            return modelAndView;
        }
        User user = (User) authentication.getPrincipal();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("profile");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ModelAndView users() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userService.getUsers();
        modelAndView.addObject("users", users);
        modelAndView.setViewName("userList");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public String addUser(UserDto userDto) {
        userService.addUser(userDto);
        return "redirect:/users";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    public ModelAndView getUserById(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUserById(id);
        modelAndView.addObject("users", List.of(user));
        modelAndView.setViewName("userAddPage");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ModelAndView getUserByLastName(@RequestParam(required = false) String lastName) {
        ModelAndView modelAndView = new ModelAndView();
        if (!StringUtils.isEmpty(lastName)) {
            int userCountByLastName = userService.getUserCountByLastName(lastName);
            modelAndView.addObject("usersCount", userCountByLastName);
        } else {
            modelAndView.addObject("usersCount", 0);
        }
        modelAndView.setViewName("userSearchPage");
        return modelAndView;
    }

}
