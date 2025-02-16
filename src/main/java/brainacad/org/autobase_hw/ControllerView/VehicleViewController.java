package brainacad.org.autobase_hw.ControllerView;

import brainacad.org.autobase_hw.Model.Vehicle;
import brainacad.org.autobase_hw.Service.VehicleService.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/vehicles")
public class VehicleViewController implements ControllerViewDAO<Vehicle> {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleViewController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Override
    @GetMapping("/view")
    public String View(@RequestParam(name = "name", required = false) String name, Model model) {
        List<Vehicle> vehicles = vehicleService.getAll();;

        model.addAttribute("vehicles", vehicles);
        model.addAttribute("name", name);

        return "Vehicle/view";
    }

    @Override
    @GetMapping("/details/{id}")
    public String Details(@PathVariable Long id, Model model) {
        Vehicle vehicle = vehicleService.getById(id);
        model.addAttribute("vehicle", vehicle);
        return "Vehicle/details";
    }

    @Override
    @GetMapping("/create")
    public String ShowForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "Vehicle/create";
    }

    @Override
    @PostMapping("/create")
    public String Create(@ModelAttribute Vehicle entity, RedirectAttributes redirectAttributes) {
        vehicleService.create(entity);
        redirectAttributes.addFlashAttribute("successMessage", "Транспортний засіб успішно створено!");
        return "redirect:/vehicles/view";
    }

    @Override
    @GetMapping("/edit/{id}")
    public String ShowEdit(@PathVariable Long id, Model model) {
        Vehicle vehicle = vehicleService.getById(id);
        model.addAttribute("vehicle", vehicle);
        return "Vehicle/edit";
    }

    @Override
    @PostMapping("/edit/{id}")
    public String Update(@PathVariable Long id, @ModelAttribute Vehicle entity, RedirectAttributes redirectAttributes) {
        vehicleService.update(id, entity);
        redirectAttributes.addFlashAttribute("successMessage", "Транспортний засіб успішно оновлено!");
        return "redirect:/vehicles/view";
    }

    @Override
    @PostMapping("/delete/{id}")
    public String Delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        vehicleService.delete(id);
        redirectAttributes.addFlashAttribute("successMessage", "Транспортний засіб успішно видалено!");
        return "redirect:/vehicles/view";
    }
}
