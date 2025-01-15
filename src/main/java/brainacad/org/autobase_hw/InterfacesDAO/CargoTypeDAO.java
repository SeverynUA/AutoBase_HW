package brainacad.org.autobuse_.InterfacesDAO;


import brainacad.org.autobuse_.InterfacesDAO.СustomRepository.CustomRepository;
import brainacad.org.autobuse_.Model.CargoType;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoTypeDAO extends JpaRepository<CargoType, Long>, CustomRepository<CargoType>
{
}
