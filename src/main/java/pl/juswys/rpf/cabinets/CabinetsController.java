package pl.juswys.rpf.cabinets;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.juswys.rpf.cabinets.details.backBoard.BackBoard;
import pl.juswys.rpf.cabinets.details.backBoard.BackBoardRepository;
import pl.juswys.rpf.cabinets.details.sideBoard.SideBoard;
import pl.juswys.rpf.cabinets.details.sideBoard.SideBoardRepository;
import pl.juswys.rpf.cabinets.details.typeBord.TypeBord;
import pl.juswys.rpf.cabinets.details.typeBord.TypeBordRepository;
import pl.juswys.rpf.cabinets.details.colors.Colors;
import pl.juswys.rpf.cabinets.details.colors.ColorsRepository;
import pl.juswys.rpf.cabinets.details.fronts.Fronts;
import pl.juswys.rpf.cabinets.details.fronts.FrontsRepository;
import pl.juswys.rpf.cabinets.details.fronts.optionsByFront.OptionsByFront;
import pl.juswys.rpf.cabinets.details.fronts.optionsByFront.OptionsByFrontRepository;
import pl.juswys.rpf.project.Projects;
import pl.juswys.rpf.project.ProjectsRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/cabinets")
public class CabinetsController {

    private final CabinetsRepository cabinetsRepository;
    private final ColorsRepository colorsRepository;
    private final TypeBordRepository typeBordRepository;
    private final OptionsByFrontRepository optionsByFrontRepository;
    private final SideBoardRepository sideBoardRepository;
    private final BackBoardRepository backBoardRepository;
    private final FrontsRepository frontsRepository;
    private final ProjectsRepository projectsRepository;


    public CabinetsController(ColorsRepository colorsRepository, TypeBordRepository typeBordRepository, CabinetsRepository cabinetsRepository, OptionsByFrontRepository optionsByFrontRepository, SideBoardRepository sideBoardRepository, BackBoardRepository backBoardRepository, FrontsRepository frontsRepository, ProjectsRepository projectsRepository) {
        this.colorsRepository = colorsRepository;
        this.typeBordRepository = typeBordRepository;
        this.cabinetsRepository = cabinetsRepository;
        this.optionsByFrontRepository = optionsByFrontRepository;

        this.sideBoardRepository = sideBoardRepository;
        this.backBoardRepository = backBoardRepository;
        this.frontsRepository = frontsRepository;
        this.projectsRepository = projectsRepository;
    }

    @RequestMapping("/details/{id}")
    public String detailsCabinet(Model model, @PathVariable Long id) {
        model.addAttribute("projects", projectsRepository.findById(id).get());

        return "cabinets/details";
    }

    @RequestMapping("/delete/{projectId}/{cabinetId}")
    public String delete(@PathVariable Long projectId, @PathVariable Long cabinetId) {
        Cabinets cabinet = cabinetsRepository.findById(cabinetId).get();
        Projects project = projectsRepository.findByCabinets(cabinet);
        project.getCabinets().remove(cabinet);
        cabinetsRepository.delete(cabinet);
        return "redirect:/cabinets/details/{projectId}";
    }


    @RequestMapping(value = "/add/{projectsId}", method = RequestMethod.GET)
    public String addForm(Model model, @PathVariable Long projectsId) {
        model.addAttribute("cabinets", new Cabinets());
        return "cabinets/add";
    }

    @RequestMapping(value = "/add/{projectsId}", method = RequestMethod.POST)
    public String added(@Valid Cabinets cabinets, BindingResult result, @PathVariable Long projectsId) {
        if (result.hasErrors()) {
            return "cabinets/add";
        }
        System.out.println(cabinets.getBoxQuantity());
        addedCabinets(cabinets);
        Projects projects = projectsRepository.findById(projectsId).get();
        System.out.println(projects.getId());
        projects.getCabinets().add(cabinets);
        projectsRepository.save(projects);

        return "redirect:/cabinets/details/{projectsId}";
    }


    @ModelAttribute("projects")
    public List<Projects> projects() {
        return projectsRepository.findAll();
    }

    @ModelAttribute("typeBord")
    public List<TypeBord> typeBord() {
        return typeBordRepository.findAll();
    }

    @ModelAttribute("colors")
    public List<Colors> colors() {
        return colorsRepository.findAll();
    }

    @ModelAttribute("optionsByFront")
    public List<OptionsByFront> optionsByFront() {
        return optionsByFrontRepository.findAll();
    }

    public void addedCabinets(Cabinets cabinets) {
        int height = cabinets.getHeight();
        int width = cabinets.getWidth();
        int depth = cabinets.getDepth();

        SideBoard sideBoard = new SideBoard();
        sideBoard.setShelfQuantity(cabinets.getSideBoard().getShelfQuantity());
        if (cabinets.getSideBoard().getShelfQuantity() > 0) {
            sideBoard.setShelfWidth(width - 36);
            sideBoard.setShelfLength(depth);
        }
        sideBoard.setSideWidth(depth);
        sideBoard.setSideLength(height);
        sideBoard.setBottomWidth(width - 36);
        sideBoard.setBottomLength(depth);
        sideBoard.setBarLength(width - 36);
        sideBoard.setBarWidth(100);

        sideBoard.setTypeBord(cabinets.getSideBoard().getTypeBord());
        sideBoard.setColors(cabinets.getSideBoard().getColors());
        sideBoardRepository.save(sideBoard);
        cabinets.setSideBoard(sideBoard);

        BackBoard backBoard = new BackBoard();
        backBoard.setWidth(width);
        backBoard.setLength(height);
        backBoard.setTypeBord(typeBordRepository.findById(6L).get());
        backBoard.setColors(cabinets.getBackBoard().getColors());
        backBoard.setTypeBord(cabinets.getBackBoard().getTypeBord());
        backBoardRepository.save(backBoard);
        cabinets.setBackBoard(backBoard);


        Fronts fronts = new Fronts();
        fronts.setLength(height);
        fronts.setOptions(cabinets.getFronts().getOptions());
        if (cabinets.getFronts().getOptions().getId() == 1) {
            fronts.setLeftWidth((width / 2) - 2);
            fronts.setRightWidth((width / 2) - 2);
        } else if (cabinets.getFronts().getOptions().getId() == 2) {
            fronts.setLeftWidth(width - 2);
        } else {
            fronts.setLeftWidth(cabinets.getFronts().getLeftWidth());
            fronts.setRightWidth(cabinets.getFronts().getRightWidth());
        }
        fronts.setTypeBord(cabinets.getFronts().getTypeBord());
        fronts.setColors(cabinets.getFronts().getColors());
        frontsRepository.save(fronts);
        cabinets.setFronts(fronts);


        cabinetsRepository.save(cabinets);
    }

}
