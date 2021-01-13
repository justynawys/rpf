package pl.juswys.rpf.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.juswys.rpf.cabinets.Cabinets;
import pl.juswys.rpf.cabinets.CabinetsRepository;
import pl.juswys.rpf.customers.Customers;
import pl.juswys.rpf.customers.CustomersRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectsController {


    private final CabinetsRepository cabinetsRepository;
    private final CustomersRepository customersRepository;
    private final ProjectsRepository projectsRepository;

    public ProjectsController(CabinetsRepository cabinetsRepository, CustomersRepository customersRepository, ProjectsRepository projectsRepository) {
        this.cabinetsRepository = cabinetsRepository;
        this.customersRepository = customersRepository;
        this.projectsRepository = projectsRepository;
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String addForm(Model model, @PathVariable Long id) {
        model.addAttribute("projects", new Projects());
        return "projects/add";
    }

    @RequestMapping(value = "/add/{projectsId}", method = RequestMethod.POST)
    public String added(@Valid Projects projects, BindingResult result, @PathVariable Long projectsId) {
        if (result.hasErrors()) {
            return "projects/add";
        }
        projectsRepository.save(projects);
        Customers customers = customersRepository.findById(projectsId).orElseGet(null);
        customers.getProjects().add(projects);
        customersRepository.save(customers);
        return "redirect:/projects/all/{projectsId}";
    }

    @RequestMapping("/all/{id}")
    public String details(Model model, @PathVariable Long id) {
        model.addAttribute("customers", customersRepository.findById(id).get());
        return "projects/allProjectsForCustomer";
    }

    @RequestMapping("/delete/{customerId}/{projectId}")
    public String delete(@PathVariable Long customerId, @PathVariable Long projectId) {
        Projects project = projectsRepository.findById(projectId).get();
        Customers customer = customersRepository.findByProjects(project);
        customer.getProjects().remove(project);
        projectsRepository.delete(project);
        return "redirect:/projects/all/{customerId}";
    }

    @ModelAttribute("cabinets")
    public List<Cabinets> cabinets() {
        return cabinetsRepository.findAll();
    }


}
