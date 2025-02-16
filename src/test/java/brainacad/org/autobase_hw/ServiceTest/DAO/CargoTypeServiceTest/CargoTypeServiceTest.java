package brainacad.org.autobase_hw.ServiceTest.DAO.CargoTypeServiceTest;

import brainacad.org.autobase_hw.Repository.CargoTypeDAO;
import brainacad.org.autobase_hw.Model.CargoType;
import brainacad.org.autobase_hw.Service.CargoTypeService.CargoTypeService_Impl;
import brainacad.org.autobase_hw.ServiceTest.DAO.CRUDService_Abstract;
import brainacad.org.autobase_hw.ServiceTest.DAO.CRUDService_Interface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CargoTypeServiceTest extends CRUDService_Abstract<CargoType, CargoTypeDAO> implements CRUDService_Interface<CargoType>
{
    private CargoTypeDAO cargoTypeDAO;
    private CargoTypeService_Impl cargoTypeService;

    @BeforeEach
    @Override
    public void setUp()
    {
        cargoTypeDAO = Mockito.mock(CargoTypeDAO.class);
        cargoTypeService = new CargoTypeService_Impl(cargoTypeDAO);
    }

    @Test
    @Override
    public void create_ReturnsClass_WhenValidInputProvided()
    {
        CargoType cargoType = CargoType.builder().name("Electronics").description("D").build();

        when(cargoTypeDAO.save(cargoType)).thenReturn(cargoType);

        CargoType createdCargoType = cargoTypeService.create(cargoType);

        assertNotNull(createdCargoType);
        assertEquals("Electronics", createdCargoType.getName());
        verify(cargoTypeDAO, times(1)).save(cargoType);
    }

    @Test
    @Override
    public void getById_ReturnsClass_WhenRequestExists()
    {
        CargoType cargoType = CargoType.builder().id(1L).name("Electronics").description("D").build();

        when(cargoTypeDAO.findById(1L)).thenReturn(Optional.of(cargoType));

        CargoType foundCargoType = cargoTypeService.getById(1L);

        assertNotNull(foundCargoType);
        assertEquals(1L, foundCargoType.getId());
        assertEquals("Electronics", foundCargoType.getName());
        verify(cargoTypeDAO, times(1)).findById(1L);
    }

    @Test
    @Override
    public void delete_DoesNotThrow_WhenRequestExists()
    {
        when(cargoTypeDAO.existsById(1L)).thenReturn(true);

        assertDoesNotThrow(() -> cargoTypeService.delete(1L));

        verify(cargoTypeDAO, times(1)).deleteById(1L);
    }
}
