package brainacad.org.autobuse_.InterfacesDAO;

import brainacad.org.autobase.DAO.InterfacesDAO.СustomRepository.CustomRepository;
import brainacad.org.autobase.Model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestDAO extends JpaRepository<Request, Long>, CustomRepository<Request>
{
    Request findByStartPoint(String startPoint);
}
