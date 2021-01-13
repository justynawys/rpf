package pl.juswys.rpf.users;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.juswys.rpf.customers.Customers;
import pl.juswys.rpf.customers.CustomersRepository;
import pl.juswys.rpf.project.Projects;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UsersController {
    private final UsersRepository usersRepository;
    private final CustomersRepository customersRepository;

    public UsersController(UsersRepository usersRepository, CustomersRepository customersRepository) {
        this.usersRepository = usersRepository;
        this.customersRepository = customersRepository;
    }

    @RequestMapping("/main")
    public String main(Model model, @AuthenticationPrincipal CurrentUser currentUser) {

        model.addAttribute("users", usersRepository.findById(currentUser.getUser().getId()).get());
        return "home/main";
    }

    @ModelAttribute("projects")
    public int allProjects(@AuthenticationPrincipal CurrentUser currentUser) {
        List<Customers> customersList = usersRepository.findCustomers(currentUser.getUser().getId());
        int quantity = 0;
        for (Customers customers : customersList) {
            List<Projects> projectsList = customersRepository.findProjects(customers.getId());
            quantity += projectsList.size();
        }
        return quantity;
    }

}