package pl.juswys.rpf.home;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.juswys.rpf.users.Users;
import pl.juswys.rpf.users.UserServiceImpl;


import javax.validation.Valid;

@Controller
public class HomeController {


    private final UserServiceImpl userService;

    public HomeController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("user", new Users());
        return "home/loginUser";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addFormUser(Model model) {
        model.addAttribute("users", new Users());
        return "home/addUser";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addedUsers(@Valid Users users, BindingResult result) {
        if (result.hasErrors()) {
            return "home/addUser";
        }
        userService.saveUser(users);
        return "redirect:/";
    }

    @RequestMapping("/editor")
    public String editor() {
        return "/editor";
    }
}