package hiber.controller;

import hiber.entity.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;
    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    //возвращает список людей из Дао
    public String allUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users/users";
    }

    @GetMapping("/create")
    public String createUserFrom(User user) {
        return "users/create";
    }
    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.removeUser(userService.getUser(id));
        return "redirect:/users";
    }
    @GetMapping("/update/{id}")
    public String updateUserFrom(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "users/update";
    }
    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }
}


