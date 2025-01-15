package brainacad.org.autobuse_.ServiceTest.DAO.DriverServiceTest;

import brainacad.org.autobuse_.InterfacesDAO.DriverDAO;
import brainacad.org.autobuse_.Model.Driver;
import brainacad.org.autobuse_.Service.DriverService.DriverService_Impl;
import brainacad.org.autobuse_.ServiceTest.DAO.CRUDService_Interface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DriverServiceTest implements CRUDService_Interface<Driver>
{
    private DriverDAO driverDAO;
    private DriverService_Impl driverService;

    @BeforeEach
    @Override
    public void setUp() {
        driverDAO = Mockito.mock(DriverDAO.class);
        driverService = new DriverService_Impl(driverDAO);
    }

    @Override
    @Test
    public void create_ReturnsClass_WhenValidInputProvided()
    {
        Driver driver = Driver.builder().fullName("John Doe").experience(5).payByKm(2.5).available(true).build();

        when(driverDAO.save(driver)).thenReturn(driver);

        Driver createdDriver = driverService.create(driver);

        assertNotNull(createdDriver);
        assertEquals("John Doe", createdDriver.getFullName());
        verify(driverDAO, times(1)).save(driver);
    }

    @Override
    @Test
    public void getById_ReturnsClass_WhenRequestExists()
    {
        Driver driver = Driver.builder().fullName("John Doe").experience(5).payByKm(2.5).available(true).build();

        when(driverDAO.findById(1L)).thenReturn(Optional.of(driver));

        Driver foundDriver = driverService.getById(1L);

        assertNotNull(foundDriver);
        assertEquals(1L, foundDriver.getId());
        verify(driverDAO, times(1)).findById(1L);
    }

    @Override
    @Test
    public void delete_DoesNotThrow_WhenRequestExists()
    {
        when(driverDAO.existsById(1L)).thenReturn(true);

        assertDoesNotThrow(() -> driverService.delete(1L));

        verify(driverDAO, times(1)).deleteById(1L);
    }
}
