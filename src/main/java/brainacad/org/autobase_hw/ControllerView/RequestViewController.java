package brainacad.org.autobase_hw.ControllerView;

import brainacad.org.autobase_hw.Model.Request;
import brainacad.org.autobase_hw.Service.RequestService.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/requests")
public class RequestViewController implements ControllerViewDAO<Request> {

    private final RequestService requestService;

    @Autowired
    public RequestViewController(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    @GetMapping("/view")
    public String View(@RequestParam(name = "name", required = false) String name, Model model) {
        List<Request> requests = requestService.getAll();;

        model.addAttribute("requests", requests);
        model.addAttribute("name", name);

        return "Request/view";
    }

    @Override
    @GetMapping("/details/{id}")
    public String Details(@PathVariable Long id, Model model) {
        Request request = requestService.getById(id);
        model.addAttribute("request", request);
        return "Request/details";
    }

    @Override
    @GetMapping("/create")
    public String ShowForm(Model model) {
        model.addAttribute("request", new Request());
        return "Request/create";
    }

    @Override
    @PostMapping("/create")
    public String Create(@ModelAttribute Request entity, RedirectAttributes redirectAttributes) {
        requestService.create(entity);
        redirectAttributes.addFlashAttribute("successMessage", "Запит успішно створено!");
        return "redirect:/requests/view";
    }

    @Override
    @GetMapping("/edit/{id}")
    public String ShowEdit(@PathVariable Long id, Model model) {
        Request request = requestService.getById(id);
        model.addAttribute("request", request);
        return "Request/edit";
    }

    @Override
    @PostMapping("/edit/{id}")
    public String Update(@PathVariable Long id, @ModelAttribute Request entity, RedirectAttributes redirectAttributes) {
        requestService.update(id, entity);
        redirectAttributes.addFlashAttribute("successMessage", "Запит успішно оновлено!");
        return "redirect:/requests/view";
    }

    @Override
    @PostMapping("/delete/{id}")
    public String Delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        requestService.delete(id);
        redirectAttributes.addFlashAttribute("successMessage", "Запит успішно видалено!");
        return "redirect:/requests/view";
    }
}
