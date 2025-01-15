package brainacad.org.autobase_hw.Service.RequestService;

import brainacad.org.autobase_hw.InterfacesDAO.RequestDAO;
import brainacad.org.autobase_hw.Model.Request;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService_Impl implements RequestService
{
    private final RequestDAO requestDAO;

    public RequestService_Impl(RequestDAO requestDAO)
    {
        this.requestDAO = requestDAO;
    }

    @Override
    public Request create(Request request)
    {
        if (request.getStartPoint() == null || request.getEndPoint() == null)
        {
            throw new IllegalArgumentException("Start point and end point cannot be null");
        }
        return requestDAO.save(request);
    }

    @Override
    public Request getById(Long id)
    {
        Optional<Request> request = requestDAO.findById(id);
        return request.orElseThrow(() -> new RuntimeException("Request with ID " + id + " not found"));
    }

    @Override
    public List<Request> getAll()
    {
        return requestDAO.findAll();
    }

    @Override
    public Request update(Long id, Request updatedRequest)
    {
        Request existingRequest = getById(id);

        existingRequest.setStartPoint(updatedRequest.getStartPoint());
        existingRequest.setEndPoint(updatedRequest.getEndPoint());
        existingRequest.setCargoWeight(updatedRequest.getCargoWeight());
        existingRequest.setCargoType(updatedRequest.getCargoType());

        return requestDAO.save(existingRequest);
    }

    @Override
    public void delete(Long id)
    {
        if (!requestDAO.existsById(id))
        {
            throw new RuntimeException("Request with ID " + id + " not found");
        }
        requestDAO.deleteById(id);
    }
}