package brainacad.org.autobase_hw.Controller.Driver;

import brainacad.org.autobase_hw.Controller.DAO_Controller;
import brainacad.org.autobase_hw.Model.Driver;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DriverController extends DAO_Controller<Driver>
{
    ResponseEntity<List<Driver>> getAvailableDrivers();
    ResponseEntity<Driver> ChangeAvailableDriverById(Long id);
    ResponseEntity<List<Driver>> FindByFullName(String fullName);
}
