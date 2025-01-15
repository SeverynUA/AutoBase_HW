package brainacad.org.autobase_hw.InterfacesDAO;


import brainacad.org.autobase_hw.InterfacesDAO.СustomRepository.CustomRepository;
import brainacad.org.autobase_hw.Model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverDAO extends JpaRepository<Driver, Long>, CustomRepository<Driver>
{
    Driver findByFullName(String fullName);
}
