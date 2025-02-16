package brainacad.org.autobase_hw.Repository;


import brainacad.org.autobase_hw.Repository.СustomRepository.CustomRepository;
import brainacad.org.autobase_hw.Model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverDAO extends JpaRepository<Driver, Long>, CustomRepository<Driver>
{
    List<Driver> findByFullName(String fullName);

    @Query("SELECT d FROM Driver d WHERE d.available = true")
    List<Driver> findAllAvailableDrivers();

    @Modifying
    @Query("UPDATE Driver d SET d.available = CASE WHEN d.available = true THEN false ELSE true END WHERE d.id = :id")
    int updateAvailability(@Param("id") Long id);

}
