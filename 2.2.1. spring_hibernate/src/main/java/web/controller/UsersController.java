package web.controller;

import hiber.entity.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    //возвращает список людей из Дао
    public String index(Model model) {
//        model.addAttribute("users", userService.listUsers());
        return "users/index";
    }

    @GetMapping("/{id}")
    //получаем человека по id
    public String show(@PathVariable("id") int id, Model model) {
//        model.addAttribute("users",userService.getUser(id));
        return "users/show";
    }
}


