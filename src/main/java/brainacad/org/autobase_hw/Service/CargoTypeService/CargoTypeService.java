package brainacad.org.autobase_hw.Service.CargoTypeService;




import brainacad.org.autobase_hw.Model.CargoType;

import java.util.List;

public interface CargoTypeService
{
    CargoType create(CargoType cargoType);
    CargoType getById(Long id);
    List<CargoType> getAll();
    CargoType update(Long id, CargoType cargoType);
    void delete(Long id);
    List<CargoType> findCargoTypesByName(String Name);
}