package brainacad.org.autobase_hw.Repository;

import brainacad.org.autobase_hw.Repository.СustomRepository.CustomRepository;
import brainacad.org.autobase_hw.Model.CargoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoTypeDAO extends JpaRepository<CargoType, Long>, CustomRepository<CargoType>
{
    List<CargoType> findByName(String fullName);
}
