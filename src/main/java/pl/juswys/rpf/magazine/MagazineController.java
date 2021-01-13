package pl.juswys.rpf.magazine;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.juswys.rpf.cabinets.details.typeBord.TypeBord;
import pl.juswys.rpf.cabinets.details.typeBord.TypeBordRepository;
import pl.juswys.rpf.cabinets.details.colors.Colors;
import pl.juswys.rpf.cabinets.details.colors.ColorsRepository;
import pl.juswys.rpf.users.CurrentUser;
import pl.juswys.rpf.users.Users;
import pl.juswys.rpf.users.UsersRepository;

import javax.validation.Valid;
import java.util.List;

@Repository
@RequestMapping("/magazine")
public class MagazineController {

    private final MagazineRepository magazineRepository;
    private final ColorsRepository colorsRepository;
    private final TypeBordRepository typeBordRepository;
    private final UsersRepository usersRepository;

    public MagazineController(MagazineRepository magazineRepository, ColorsRepository colorsRepository, TypeBordRepository typeBordRepository, UsersRepository usersRepository) {
        this.magazineRepository = magazineRepository;
        this.colorsRepository = colorsRepository;
        this.typeBordRepository = typeBordRepository;
        this.usersRepository = usersRepository;
    }

    @RequestMapping("/allBoard")
    public String all(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("users", usersRepository.findById(currentUser.getUser().getId()).get());
        return "magazine/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(Model model) {
        model.addAttribute("magazine", new Magazine());
        return "magazine/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String added(@Valid Magazine magazine, BindingResult result, @AuthenticationPrincipal CurrentUser currentUser) {
        if (result.hasErrors()) {
            return "magazine/add";
        }
        magazineRepository.save(magazine);
        Users user = usersRepository.findById(currentUser.getUser().getId()).orElseGet(null);
        user.getMagazines().add(magazine);
        usersRepository.save(user);
        return "redirect:/magazine/allBoard";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        Magazine magazine = magazineRepository.findById(id).get();
        Users users = usersRepository.findByMagazines(magazine);
        users.getMagazines().remove(magazine);
        magazineRepository.delete(magazine);
        return "redirect:/magazine/allBoard";

    }


    @ModelAttribute("colors")
    public List<Colors> colors() {
        return colorsRepository.findAll();
    }

    @ModelAttribute("typeBord")
    public List<TypeBord> typeBord() {
        return typeBordRepository.findAll();
    }
}
