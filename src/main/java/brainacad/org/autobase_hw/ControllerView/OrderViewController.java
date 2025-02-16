package brainacad.org.autobase_hw.ControllerView;

import brainacad.org.autobase_hw.Model.Order;
import brainacad.org.autobase_hw.Service.OrderService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderViewController implements ControllerViewDAO<Order> {

    private final OrderService orderService;

    @Autowired
    public OrderViewController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    @GetMapping("/view")
    public String View(@RequestParam(name = "name", required = false) String name, Model model)
    {
        List<Order> orders = orderService.getAll();;

        model.addAttribute("orders", orders);
        model.addAttribute("name", name);

        return "Order/view";
    }

    @Override
    @GetMapping("/details/{id}")
    public String Details(@PathVariable Long id, Model model) {
        Order order = orderService.getById(id);
        model.addAttribute("order", order);
        return "Order/details";
    }

    @Override
    @GetMapping("/create")
    public String ShowForm(Model model) {
        model.addAttribute("order", new Order());
        return "Order/create";
    }

    @Override
    @PostMapping("/create")
    public String Create(@ModelAttribute Order entity, RedirectAttributes redirectAttributes) {
        orderService.create(entity);
        redirectAttributes.addFlashAttribute("successMessage", "Замовлення успішно створено!");
        return "redirect:/orders/view";
    }

    @Override
    @GetMapping("/edit/{id}")
    public String ShowEdit(@PathVariable Long id, Model model) {
        Order order = orderService.getById(id);
        model.addAttribute("order", order);
        return "Order/edit";
    }

    @Override
    @PostMapping("/edit/{id}")
    public String Update(@PathVariable Long id, @ModelAttribute Order entity, RedirectAttributes redirectAttributes) {
        orderService.update(id, entity);
        redirectAttributes.addFlashAttribute("successMessage", "Замовлення успішно оновлено!");
        return "redirect:/orders/view";
    }

    @Override
    @PostMapping("/delete/{id}")
    public String Delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        orderService.delete(id);
        redirectAttributes.addFlashAttribute("successMessage", "Замовлення успішно видалено!");
        return "redirect:/orders/view";
    }
}
