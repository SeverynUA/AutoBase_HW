package brainacad.org.autobase_hw.ServiceTest.DAO.RequestServiceTest;


import brainacad.org.autobase_hw.Repository.RequestDAO;
import brainacad.org.autobase_hw.Model.CargoType;
import brainacad.org.autobase_hw.Model.Request;
import brainacad.org.autobase_hw.Service.RequestService.RequestService_Impl;
import brainacad.org.autobase_hw.ServiceTest.DAO.CRUDService_Abstract;
import brainacad.org.autobase_hw.ServiceTest.DAO.CRUDService_Interface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RequestServiceTest extends CRUDService_Abstract<Request, RequestDAO> implements CRUDService_Interface<Request>
{
    private RequestDAO requestDAO;
    private RequestService_Impl requestService;

    @BeforeEach
    @Override
    public void setUp()
    {
        requestDAO = Mockito.mock(RequestDAO.class);
        requestService = new RequestService_Impl(requestDAO);
    }

    @Override
    @Test
    public void create_ReturnsClass_WhenValidInputProvided()
    {
        CargoType cargoType = CargoType.builder().name("Electronics").description("D").build();
        Request request = Request.builder().startPoint("Point A").endPoint("Point B").cargoWeight(100.0).cargoType(cargoType).build();

        when(requestDAO.save(request)).thenReturn(request);

        Request createdRequest = requestService.create(request);

        assertNotNull(createdRequest);
        assertEquals("Point A", createdRequest.getStartPoint());
        verify(requestDAO, times(1)).save(request);
    }

    @Override
    @Test
    public void getById_ReturnsClass_WhenRequestExists()
    {
        CargoType cargoType = CargoType.builder().name("Electronics").description("D").build();
        Request request = Request.builder().startPoint("Point A").endPoint("Point B").cargoWeight(100.0).cargoType(cargoType).build();request.setId(1L);

        when(requestDAO.findById(1L)).thenReturn(Optional.of(request));

        Request foundRequest = requestService.getById(1L);

        assertNotNull(foundRequest);
        assertEquals(1L, foundRequest.getId());
        verify(requestDAO, times(1)).findById(1L);
    }

    @Override
    @Test
    public void delete_DoesNotThrow_WhenRequestExists()
    {
        when(requestDAO.existsById(1L)).thenReturn(true);

        assertDoesNotThrow(() -> requestService.delete(1L));

        verify(requestDAO, times(1)).deleteById(1L);
    }
}
