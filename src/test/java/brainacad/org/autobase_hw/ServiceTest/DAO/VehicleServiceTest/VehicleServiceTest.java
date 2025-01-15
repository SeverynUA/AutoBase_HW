package brainacad.org.autobase_hw.ServiceTest.DAO.VehicleServiceTest;

import brainacad.org.autobase_hw.InterfacesDAO.DriverDAO;
import brainacad.org.autobase_hw.InterfacesDAO.VehicleDAO;
import brainacad.org.autobase_hw.Model.Driver;
import brainacad.org.autobase_hw.Model.Vehicle;
import brainacad.org.autobase_hw.Service.VehicleService.VehicleService_Impl;
import brainacad.org.autobase_hw.ServiceTest.DAO.CRUDService_Abstract;
import brainacad.org.autobase_hw.ServiceTest.DAO.CRUDService_Interface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VehicleServiceTest extends CRUDService_Abstract<Vehicle, VehicleDAO> implements CRUDService_Interface<Vehicle>
{
    private VehicleDAO vehicleDAO;
    private VehicleService_Impl vehicleService;

    @BeforeEach
    @Override
    public void setUp()
    {
        vehicleDAO = Mockito.mock(VehicleDAO.class);
        vehicleService = new VehicleService_Impl(vehicleDAO);
    }

    @Test
    @Override
    public void create_ReturnsClass_WhenValidInputProvided()
    {
        Vehicle vehicle = Vehicle.builder().model("Truck").maxLoad(5000.0).available(true).broken(false).build();

        when(vehicleDAO.save(vehicle)).thenReturn(vehicle);

        Vehicle createdVehicle = vehicleService.create(vehicle);

        assertNotNull(createdVehicle);
        assertEquals("Truck", createdVehicle.getModel());
        verify(vehicleDAO, times(1)).save(vehicle);
    }

    @Test
    @Override
    public void getById_ReturnsClass_WhenRequestExists()
    {
        Vehicle vehicle = Vehicle.builder().model("Truck").maxLoad(5000.0).available(true).broken(false).build();vehicle.setId(1L);

        when(vehicleDAO.findById(1L)).thenReturn(Optional.of(vehicle));

        Vehicle foundVehicle = vehicleService.getById(1L);

        assertNotNull(foundVehicle);
        assertEquals(1L, foundVehicle.getId());
        verify(vehicleDAO, times(1)).findById(1L);
    }

    @Test
    @Override
    public void delete_DoesNotThrow_WhenRequestExists()
    {
        when(vehicleDAO.existsById(1L)).thenReturn(true);

        assertDoesNotThrow(() -> vehicleService.delete(1L));

        verify(vehicleDAO, times(1)).deleteById(1L);
    }
}
