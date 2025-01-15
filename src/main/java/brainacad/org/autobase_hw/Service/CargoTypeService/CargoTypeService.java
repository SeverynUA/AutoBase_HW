package brainacad.org.autobuse_.Service.CargoTypeService;


import brainacad.org.autobuse_.Model.CargoType;

import java.util.List;

public interface CargoTypeService
{
    CargoType create(CargoType cargoType);
    CargoType getById(Long id);
    List<CargoType> getAll();
    CargoType update(Long id, CargoType cargoType);
    void delete(Long id);
}