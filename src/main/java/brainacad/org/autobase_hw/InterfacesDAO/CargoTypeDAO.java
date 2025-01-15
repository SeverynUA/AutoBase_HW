package brainacad.org.autobase_hw.InterfacesDAO;



import brainacad.org.autobase_hw.InterfacesDAO.СustomRepository.CustomRepository;
import brainacad.org.autobase_hw.Model.CargoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoTypeDAO extends JpaRepository<CargoType, Long>, CustomRepository<CargoType>
{
}
