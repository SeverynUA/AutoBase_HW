package brainacad.org.autobase_hw.Controller.Order;

import brainacad.org.autobase_hw.Model.Order;
import brainacad.org.autobase_hw.Service.OrderService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController_Impl implements OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController_Impl(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @Override
    public ResponseEntity<Order> create(@RequestBody Order entity) {
        Order createdOrder = orderService.create(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Order> getById(@PathVariable Long id) {
        Order order = orderService.getById(id);
        return ResponseEntity.ok(order);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Order>> getAll() {
        List<Order> orders = orderService.getAll();
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order entity) {
        Order updatedOrder = orderService.update(id, entity);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

