package brainacad.org.autobase_hw.Service.OrderService;



import brainacad.org.autobase_hw.Model.Order;

import java.util.List;

public interface OrderService
{
    Order create(Order order);
    Order getById(Long id);
    List<Order> getAll();
    Order update(Long id, Order order);
    void delete(Long id);
}
