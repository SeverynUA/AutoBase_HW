package brainacad.org.autobase_hw.InterfacesDAO;

import brainacad.org.autobase_hw.InterfacesDAO.СustomRepository.CustomRepository;
import brainacad.org.autobase_hw.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleDAO extends JpaRepository<Vehicle, Long>, CustomRepository<Vehicle>
{
    List<Vehicle> findByAvailableTrue();
    List<Vehicle> findByBrokenTrue();
}