package brainacad.org.autobase_hw.ControllerView;

import brainacad.org.autobase_hw.Model.CargoType;
import brainacad.org.autobase_hw.Model.Driver;
import brainacad.org.autobase_hw.Service.CargoTypeService.CargoTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cargoType")
public class CargoTypeViewController implements ControllerViewDAO<CargoType>
{
    private final CargoTypeService cargoTypeService;

    public CargoTypeViewController(CargoTypeService cargoTypeService) {
        this.cargoTypeService = cargoTypeService;
    }

    @GetMapping("/view")
    @Override
    public String View(@RequestParam(name = "name", required = false) String name, Model model) {
        List<CargoType> cargoTypes;

        if (name != null && !name.isEmpty()) {cargoTypes = cargoTypeService.findCargoTypesByName(name);
        } else {cargoTypes = cargoTypeService.getAll();}

        model.addAttribute("cargoTypes", cargoTypes);
        model.addAttribute("name", name);

        return "Drivers/drivers";
    }

    @GetMapping("/view/{id}")
    @Override
    public String Details(@PathVariable Long id, Model model) {
        CargoType cargoType = cargoTypeService.getById(id);
        model.addAttribute("cargoType", cargoType);
        return "CargoType/details";
    }

    @GetMapping("/create")
    @Override
    public String ShowForm(Model model)
    {
        model.addAttribute("cargoType", new CargoType());
        return "CargoType/create";
    }

    @PostMapping("/create")
    @Override
    public String Create(@ModelAttribute CargoType cargoType, RedirectAttributes redirectAttributes)
    {
        cargoTypeService.create(cargoType);
        redirectAttributes.addFlashAttribute("successMessage", "Тип вантажу успішно створено!");
        return "redirect:/cargoType/view";
    }

    @GetMapping("/edit/{id}")
    @Override
    public String ShowEdit(@PathVariable Long id, Model model)
    {
        CargoType cargoType = cargoTypeService.getById(id);
        model.addAttribute("cargoType", cargoType);
        return "CargoType/edit";
    }

    @PostMapping("/edit/{id}")
    @Override
    public String Update(@PathVariable Long id,@ModelAttribute CargoType entity, RedirectAttributes redirectAttributes) {
        cargoTypeService.update(id, entity);
        redirectAttributes.addFlashAttribute("successMessage", "Тип вантажу успішно оновлено!");
        return "redirect:/cargoType/view";
    }

    @PostMapping("/delete/{id}")
    @Override
    public String Delete(@PathVariable Long id, RedirectAttributes redirectAttributes)
    {
        cargoTypeService.delete(id);
        redirectAttributes.addFlashAttribute("successMessage", "Тип вантажу успішно видалено!");
        return "redirect:/cargoType/view";
    }
}

