package brainacad.org.autobase_hw.Service.DriverService;

import brainacad.org.autobase_hw.Repository.DriverDAO;
import brainacad.org.autobase_hw.Model.Driver;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService_Impl implements DriverService
{
    private final DriverDAO driverDAO;

    public DriverService_Impl(DriverDAO driverDAO)
    {
        this.driverDAO = driverDAO;
    }

    @Override
    public Driver create(Driver driver)
    {
        if (driver.getFullName() == null || driver.getFullName().isEmpty())
        {
            throw new IllegalArgumentException("Driver's full name cannot be empty");
        }
        return driverDAO.save(driver);
    }

    @Override
    public Driver getById(Long id)
    {
        Optional<Driver> driver = driverDAO.findById(id);
        return driver.orElseThrow(() -> new RuntimeException("Driver with ID " + id + " not found"));
    }

    @Override
    public List<Driver> getAll()
    {
        return driverDAO.findAll();
    }

    @Override
    public Driver update(Long id, Driver updatedDriver)
    {
        Driver existingDriver = getById(id);

        existingDriver.setFullName(updatedDriver.getFullName());
        existingDriver.setExperience(updatedDriver.getExperience());
        existingDriver.setPayByKm(updatedDriver.getPayByKm());
        existingDriver.setAvailable(updatedDriver.isAvailable());

        return driverDAO.save(existingDriver);
    }

    @Override
    public void delete(Long id)
    {
        if (!driverDAO.existsById(id))
        {
            throw new RuntimeException("Driver with ID " + id + " not found");
        }
        driverDAO.deleteById(id);
    }

    @Override
    public List<Driver> FindAllAvailableDrivers()
    {
        return driverDAO.findAllAvailableDrivers();
    }

    @Override
    @Transactional
    public Driver ChangeAvailableDriverById(Long id) {
        int updatedRows = driverDAO.updateAvailability(id);

        if (updatedRows == 0) {
            throw new RuntimeException("Driver with ID " + id + " not found or already updated");
        }

        return driverDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver with ID " + id + " not found"));
    }

    @Override
    public List<Driver> FindByFullName(String fullName) {return driverDAO.findByFullName(fullName);}
}