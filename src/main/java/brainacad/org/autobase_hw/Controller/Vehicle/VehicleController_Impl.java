package brainacad.org.autobase_hw.Controller.Vehicle;

import brainacad.org.autobase_hw.Model.Vehicle;
import brainacad.org.autobase_hw.Service.VehicleService.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController_Impl implements VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController_Impl(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    @Override
    public ResponseEntity<Vehicle> create(@RequestBody Vehicle entity) {
        Vehicle createdVehicle = vehicleService.create(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVehicle);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Vehicle> getById(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.getById(id);
        return ResponseEntity.ok(vehicle);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Vehicle>> getAll() {
        List<Vehicle> vehicles = vehicleService.getAll();
        return ResponseEntity.ok(vehicles);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Vehicle> update(@PathVariable Long id, @RequestBody Vehicle entity) {
        Vehicle updatedVehicle = vehicleService.update(id, entity);
        return ResponseEntity.ok(updatedVehicle);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vehicleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
