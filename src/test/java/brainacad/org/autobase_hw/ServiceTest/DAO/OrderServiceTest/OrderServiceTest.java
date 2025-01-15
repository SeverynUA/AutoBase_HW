package brainacad.org.autobuse_.ServiceTest.DAO.OrderServiceTest;

import brainacad.org.autobase.DAO.InterfacesDAO.OrderDAO;
import brainacad.org.autobase.Model.*;
import brainacad.org.autobase.Service.OrderService.OrderService_Impl;
import brainacad.org.autobase.ServiceTest.DAO.CRUDService_Interface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderServiceTest implements CRUDService_Interface<Order>
{
    private OrderDAO orderDAO;
    private OrderService_Impl orderService;

    @BeforeEach
    @Override
    public void setUp()
    {
        orderDAO = Mockito.mock(OrderDAO.class);
        orderService = new OrderService_Impl(orderDAO);
    }

    @Test
    @Override
    public void create_ReturnsClass_WhenValidInputProvided()
    {
        CargoType cargoType = CargoType.builder().name("Electronics").description("D").build();cargoType.setId(1L);
        Driver driver = Driver.builder().fullName("John Doe").experience(5).payByKm(2.5).available(true).build();
        Request request = Request.builder().startPoint("Point A").endPoint("Point B").cargoWeight(100.0).cargoType(cargoType).build();
        Vehicle vehicle = Vehicle.builder().model("Truck").maxLoad(5000.0).available(true).broken(false).build();
        Order order = Order.builder().driver(driver).request(request).vehicle(vehicle).build();

        when(orderDAO.save(order)).thenReturn(order);

        Order createdOrder = orderService.create(order);

        assertNotNull(createdOrder);
        assertEquals(driver, createdOrder.getDriver());
        verify(orderDAO, times(1)).save(order);
    }

    @Test
    @Override
    public void getById_ReturnsClass_WhenRequestExists()
    {
        CargoType cargoType = CargoType.builder().name("Electronics").description("D").build();cargoType.setId(1L);
        Driver driver = Driver.builder().fullName("John Doe").experience(5).payByKm(2.5).available(true).build();
        Request request = Request.builder().startPoint("Point A").endPoint("Point B").cargoWeight(100.0).cargoType(cargoType).build();
        Vehicle vehicle = Vehicle.builder().model("Truck").maxLoad(5000.0).available(true).broken(false).build();
        Order order = Order.builder().driver(driver).request(request).vehicle(vehicle).build();

        order.setId(1L);

        when(orderDAO.findById(1L)).thenReturn(Optional.of(order));

        Order foundOrder = orderService.getById(1L);

        assertNotNull(foundOrder);
        assertEquals(1L, foundOrder.getId());
        verify(orderDAO, times(1)).findById(1L);
    }

    @Test
    @Override
    public void delete_DoesNotThrow_WhenRequestExists()
    {
        when(orderDAO.existsById(1L)).thenReturn(true);

        assertDoesNotThrow(() -> orderService.delete(1L));

        verify(orderDAO, times(1)).deleteById(1L);
    }
}
