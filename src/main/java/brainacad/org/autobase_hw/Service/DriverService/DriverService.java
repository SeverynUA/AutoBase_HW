package brainacad.org.autobase_hw.Service.DriverService;



import brainacad.org.autobase_hw.Model.Driver;
import brainacad.org.autobase_hw.Service.DAO_Service;

import java.util.List;

public interface DriverService extends DAO_Service<Driver>
{
    List<Driver> FindAllAvailableDrivers();
    Driver ChangeAvailableDriverById(Long id);
    List<Driver> FindByFullName(String fullName);
}
