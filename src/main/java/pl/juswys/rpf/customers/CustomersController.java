package pl.juswys.rpf.customers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.juswys.rpf.users.CurrentUser;
import pl.juswys.rpf.users.Users;
import pl.juswys.rpf.users.UsersRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/customers")
public class CustomersController {

    private final CustomersRepository customersRepository;
    private final UsersRepository usersRepository;


    public CustomersController(CustomersRepository customersRepository, UsersRepository usersRepository) {
        this.customersRepository = customersRepository;
        this.usersRepository = usersRepository;

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(Model model) {
        model.addAttribute("customers", new Customers());
        return "customers/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String added(@Valid Customers customers, BindingResult result, @AuthenticationPrincipal CurrentUser currentUser) {
        if (result.hasErrors()) {
            return "customers/add";
        }
        customersRepository.save(customers);
        Users users = usersRepository.findById(currentUser.getUser().getId()).orElseGet(null);
        users.getCustomers().add(customers);
        usersRepository.save(users);
        return "redirect:/user/main";
    }

    @RequestMapping("/data")
    public String main(Model model, @AuthenticationPrincipal CurrentUser currentUser) {

        model.addAttribute("users", usersRepository.findById(currentUser.getUser().getId()).get());
        return "customers/customerData";
    }

    @RequestMapping("/delete/{customersId}")
    public String delete(@PathVariable Long customersId) {
        Customers customer = customersRepository.findById(customersId).get();
        Users users = usersRepository.findByCustomers(customer);


        customersRepository.delete(customer);
        return "redirect:/customers/data";
    }

}
