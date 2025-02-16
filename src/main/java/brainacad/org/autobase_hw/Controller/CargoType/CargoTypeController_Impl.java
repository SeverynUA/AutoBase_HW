package brainacad.org.autobase_hw.Controller.CargoType;

import brainacad.org.autobase_hw.Model.CargoType;
import brainacad.org.autobase_hw.Model.Driver;
import brainacad.org.autobase_hw.Service.CargoTypeService.CargoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargoType")
public class CargoTypeController_Impl implements CargoTypeController
{
    private final CargoTypeService cargoTypeService;

    @Autowired
    public CargoTypeController_Impl(CargoTypeService cargoTypeService) {this.cargoTypeService = cargoTypeService;}

    @PostMapping
    @Override
    public ResponseEntity<CargoType> create(CargoType entity)
    {
        CargoType cargoType = cargoTypeService.create(entity);
        return ResponseEntity.ok(cargoType);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<CargoType> getById(Long id) {
        CargoType cargoType = cargoTypeService.getById(id);
        return ResponseEntity.ok(cargoType);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<CargoType>> getAll() {
        List<CargoType> cargoType = cargoTypeService.getAll();
        return ResponseEntity.ok(cargoType);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<CargoType> update(Long id, CargoType entity) {
        CargoType cargoType = cargoTypeService.update(id, entity);
        return ResponseEntity.ok(cargoType);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(Long id)
    {
        cargoTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
