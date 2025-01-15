package brainacad.org.autobuse_.Service.DriverService;


import brainacad.org.autobuse_.Model.Driver;

import java.util.List;

public interface DriverService
{
    Driver create(Driver driver);
    Driver getById(Long id);
    List<Driver> getAll();
    Driver update(Long id, Driver driver);
    void delete(Long id);
}
