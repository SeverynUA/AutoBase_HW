package brainacad.org.autobuse_.InterfacesDAO;

import brainacad.org.autobase.DAO.InterfacesDAO.СustomRepository.CustomRepository;
import brainacad.org.autobase.Model.CargoType;
import brainacad.org.autobase.Model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverDAO extends JpaRepository<Driver, Long>, CustomRepository<Driver>
{
    Driver findByFullName(String fullName);
}
