package brainacad.org.autobase_hw.Service.CargoTypeService;

import brainacad.org.autobase_hw.Repository.CargoTypeDAO;
import brainacad.org.autobase_hw.Model.CargoType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoTypeService_Impl implements CargoTypeService
{
    private final CargoTypeDAO cargoTypeDAO;

    public CargoTypeService_Impl(CargoTypeDAO cargoTypeDAO)
    {
        this.cargoTypeDAO = cargoTypeDAO;
    }

    @Override
    public CargoType create(CargoType cargoType)
    {
        if (cargoType.getName() == null || cargoType.getName().isEmpty())
        {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        return cargoTypeDAO.save(cargoType);
    }

    @Override
    public CargoType getById(Long id)
    {
        Optional<CargoType> cargoType = cargoTypeDAO.findById(id);
        return cargoType.orElseThrow(() -> new RuntimeException("CargoType with ID " + id + " not found"));
    }

    @Override
    public List<CargoType> getAll()
    {
        return cargoTypeDAO.findAll();
    }

    @Override
    public CargoType update(Long id, CargoType updatedCargoType)
    {
        CargoType existingCargoType = getById(id);
        existingCargoType.setName(updatedCargoType.getName());
        return cargoTypeDAO.save(existingCargoType);
    }

    @Override
    public void delete(Long id)
    {
        if (!cargoTypeDAO.existsById(id))
        {
            throw new RuntimeException("CargoType with ID " + id + " not found");
        }
        cargoTypeDAO.deleteById(id);
    }

    @Override
    public List<CargoType> findCargoTypesByName(String Name) {return cargoTypeDAO.findByName(Name);}
}
