package brainacad.org.autobase_hw.Service.DriverService;



import brainacad.org.autobase_hw.Model.Driver;

import java.util.List;

public interface DriverService
{
    Driver create(Driver driver);
    Driver getById(Long id);
    List<Driver> getAll();
    Driver update(Long id, Driver driver);
    void delete(Long id);
}
