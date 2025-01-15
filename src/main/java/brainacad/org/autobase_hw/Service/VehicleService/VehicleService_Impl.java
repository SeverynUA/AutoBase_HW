package brainacad.org.autobase_hw.Service.VehicleService;

import brainacad.org.autobase_hw.InterfacesDAO.VehicleDAO;
import brainacad.org.autobase_hw.Model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService_Impl implements VehicleService
{
    private final VehicleDAO vehicleDAO;

    public VehicleService_Impl(VehicleDAO vehicleDAO)
    {
        this.vehicleDAO = vehicleDAO;
    }

    @Override
    public Vehicle create(Vehicle vehicle)
    {
        if (vehicle.getModel() == null || vehicle.getModel().isEmpty())
        {
            throw new IllegalArgumentException("Model cannot be empty");
        }
        return vehicleDAO.save(vehicle);
    }

    @Override
    public Vehicle getById(Long id)
    {
        Optional<Vehicle> vehicle = vehicleDAO.findById(id);
        return vehicle.orElseThrow(() -> new RuntimeException("Vehicle with ID " + id + " not found"));
    }

    @Override
    public List<Vehicle> getAll()
    {
        return vehicleDAO.findAll();
    }

    @Override
    public Vehicle update(Long id, Vehicle updatedVehicle)
    {
        Vehicle existingVehicle = getById(id);

        existingVehicle.setModel(updatedVehicle.getModel());
        existingVehicle.setMaxLoad(updatedVehicle.getMaxLoad());
        existingVehicle.setAvailable(updatedVehicle.isAvailable());
        existingVehicle.setBroken(updatedVehicle.isBroken());

        return vehicleDAO.save(existingVehicle);
    }

    @Override
    public void delete(Long id)
    {
        if (!vehicleDAO.existsById(id))
        {
            throw new RuntimeException("Vehicle with ID " + id + " not found");
        }
        vehicleDAO.deleteById(id);
    }

    @Override
    public List<Vehicle> getAvailableVehicles()
    {
        return vehicleDAO.findByAvailableTrue();
    }

    @Override
    public List<Vehicle> getBrokenVehicles()
    {
        return vehicleDAO.findByBrokenTrue();
    }
}
