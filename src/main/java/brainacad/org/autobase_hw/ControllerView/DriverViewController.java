package brainacad.org.autobase_hw.ControllerView;

import brainacad.org.autobase_hw.Model.Driver;
import brainacad.org.autobase_hw.Service.DriverService.DriverService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/drivers")
public class DriverViewController implements ControllerViewDAO<Driver>
{
    private final DriverService driverService;

    public DriverViewController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/add")
    public String addDriver(@Valid @ModelAttribute("driver") Driver driver, BindingResult result)
    {
        if (result.hasErrors()) {
            return "Drivers/add-driver";
        }
        driverService.create(driver);
        return "redirect:/drivers/view";
    }

    @GetMapping("/view")
    @Override
    public String View(String name, Model model) {
        List<Driver> drivers = (name != null && !name.isEmpty()) ?
                driverService.FindByFullName(name) :
                driverService.getAll();
        model.addAttribute("drivers", drivers);
        model.addAttribute("name", name);
        return "Drivers/drivers";
    }

    @Override
    public String Details(Long id, Model model) {
        return "";
    }

    @GetMapping("/add")
    @Override
    public String ShowForm(Model model) {
        model.addAttribute("driver", new Driver());
        return "Drivers/add-driver";
    }

    @Override
    public String Create(@ModelAttribute Driver entity, RedirectAttributes redirectAttributes) {
        driverService.create(entity);
        return "redirect:/drivers/view";
    }

    @GetMapping("/edit/{id}")
    @Override
    public String ShowEdit(@PathVariable Long id, Model model) {

        Driver driver = driverService.getById(id);
        model.addAttribute("driver", driver);
        return "Drivers/edit-driver";
    }

    @PostMapping("/edit/{id}")
    @Override
    public String Update(@PathVariable Long id, @ModelAttribute Driver entity, RedirectAttributes redirectAttributes)
    {
        driverService.update(id, entity);
        return "redirect:/drivers/view";
    }

    @GetMapping("/delete/{id}")
    @Override
    public String Delete(@PathVariable Long id, RedirectAttributes redirectAttributes)
    {
        driverService.delete(id);
        return "redirect:/drivers/view";
    }
}
