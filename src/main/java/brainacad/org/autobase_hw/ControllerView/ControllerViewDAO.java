package brainacad.org.autobase_hw.ControllerView;

import brainacad.org.autobase_hw.Model.CargoType;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface ControllerViewDAO<E>
{
    String View(@RequestParam(name = "name", required = false) String name, Model model);
    String Details(@PathVariable Long id, Model model);
    String ShowForm(Model model);
    String Create(@Valid @ModelAttribute E entity, RedirectAttributes redirectAttributes);
    String ShowEdit(@PathVariable Long id, Model model);
    String Update(@PathVariable Long id, @ModelAttribute E entity, RedirectAttributes redirectAttributes);
    String Delete(@PathVariable Long id, RedirectAttributes redirectAttributes);
}
