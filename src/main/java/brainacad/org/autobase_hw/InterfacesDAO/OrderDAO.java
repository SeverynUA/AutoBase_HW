package brainacad.org.autobase_hw.InterfacesDAO;


import brainacad.org.autobase_hw.InterfacesDAO.СustomRepository.CustomRepository;
import brainacad.org.autobase_hw.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long>, CustomRepository<Order>
{
}