package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/new")
    public String createUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);


        return "new";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }


    @RequestMapping("/users")
    public String printUsers(ModelMap model) {
            model.addAttribute("allUsers", userService.getAllUsers());

        return "users";
    }

}
//, @RequestParam(value = "name", required = false) String name,
//@RequestParam(value = "surname", required = false) String surname,
//@RequestParam(value = "age",required = false) int age