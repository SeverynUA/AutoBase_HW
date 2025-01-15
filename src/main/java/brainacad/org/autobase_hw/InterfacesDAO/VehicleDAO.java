package brainacad.org.autobuse_.InterfacesDAO;

import brainacad.org.autobase.DAO.InterfacesDAO.СustomRepository.CustomRepository;
import brainacad.org.autobase.Model.Request;
import brainacad.org.autobase.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleDAO extends JpaRepository<Vehicle, Long>, CustomRepository<Vehicle>
{
    List<Vehicle> findByAvailableTrue();
    List<Vehicle> findByBrokenTrue();
}