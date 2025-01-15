package brainacad.org.autobase_hw.Service.VehicleService;

import brainacad.org.autobase_hw.Model.Vehicle;

import java.util.List;

public interface VehicleService
{
    Vehicle create(Vehicle vehicle);
    Vehicle getById(Long id);
    List<Vehicle> getAll();
    Vehicle update(Long id, Vehicle vehicle);
    void delete(Long id);
    List<Vehicle> getAvailableVehicles();
    List<Vehicle> getBrokenVehicles();
}
