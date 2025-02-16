package brainacad.org.autobase_hw.Controller.Driver;

import brainacad.org.autobase_hw.Controller.DAO_Controller;
import brainacad.org.autobase_hw.Model.Driver;
import brainacad.org.autobase_hw.Service.DriverService.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController_Impl implements DriverController
{
    private final DriverService driverService;

    @Autowired
    public DriverController_Impl(DriverService driverService) {this.driverService = driverService;}

    @GetMapping("/available")
    @Override
    public ResponseEntity<List<Driver>> getAvailableDrivers()
    {
        List<Driver> drivers = driverService.FindAllAvailableDrivers();
        return  ResponseEntity.ok(drivers);
    }

    @GetMapping("/available/{id}")
    @Override
    public ResponseEntity<Driver> ChangeAvailableDriverById(@PathVariable Long id)
    {
        Driver driver = driverService.ChangeAvailableDriverById(id);
        return ResponseEntity.ok(driver);
    }

    @GetMapping("/drivers/{fullName}")
    @Override
    public ResponseEntity<List<Driver>> FindByFullName(@PathVariable String fullName)
    {
        List<Driver> driver = driverService.FindByFullName(fullName);
        return ResponseEntity.ok(driver);
    }

    @PostMapping
    @Override
    public ResponseEntity<Driver> create(@RequestBody Driver entity)
    {
        Driver driver = driverService.create(entity);
        return ResponseEntity.ok(driver);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Driver> getById(@PathVariable Long id)
    {
        Driver driver = driverService.getById(id);
        return ResponseEntity.ok(driver);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Driver>> getAll()
    {
       List<Driver> drivers = driverService.getAll();
       return ResponseEntity.ok(drivers);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Driver> update(@PathVariable Long id ,@RequestBody Driver entity)
    {
        Driver driver = driverService.update(id, entity);
        return ResponseEntity.ok(driver);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
       driverService.delete(id);
       return ResponseEntity.noContent().build();
    }
}