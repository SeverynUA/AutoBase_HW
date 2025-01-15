package brainacad.org.autobase_hw.Service.OrderService;

import brainacad.org.autobase_hw.InterfacesDAO.OrderDAO;
import brainacad.org.autobase_hw.Model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService_Impl implements OrderService
{
    private final OrderDAO orderDAO;

    public OrderService_Impl(OrderDAO orderDAO)
    {
        this.orderDAO = orderDAO;
    }

    @Override
    public Order create(Order order)
    {
        if (order.getDriver() == null || order.getRequest() == null || order.getVehicle() == null) {
            throw new IllegalArgumentException("Driver, Request, and Vehicle cannot be null");
        }
        return orderDAO.save(order);
    }

    @Override
    public Order getById(Long id)
    {
        Optional<Order> order = orderDAO.findById(id);
        return order.orElseThrow(() -> new RuntimeException("Order with ID " + id + " not found"));
    }

    @Override
    public List<Order> getAll()
    {
        return orderDAO.findAll();
    }

    @Override
    public Order update(Long id, Order updatedOrder)
    {
        Order existingOrder = getById(id);

        existingOrder.setDriver(updatedOrder.getDriver());
        existingOrder.setRequest(updatedOrder.getRequest());
        existingOrder.setVehicle(updatedOrder.getVehicle());

        return orderDAO.save(existingOrder);
    }

    @Override
    public void delete(Long id)
    {
        if (!orderDAO.existsById(id))
        {
            throw new RuntimeException("Order with ID " + id + " not found");
        }
        orderDAO.deleteById(id);
    }
}