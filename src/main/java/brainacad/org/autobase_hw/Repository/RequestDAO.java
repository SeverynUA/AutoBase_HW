package brainacad.org.autobase_hw.Repository;


import brainacad.org.autobase_hw.Repository.СustomRepository.CustomRepository;
import brainacad.org.autobase_hw.Model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestDAO extends JpaRepository<Request, Long>, CustomRepository<Request>
{
    Request findByStartPoint(String startPoint);
}
