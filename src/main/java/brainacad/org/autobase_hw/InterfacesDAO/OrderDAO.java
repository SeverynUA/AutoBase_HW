package brainacad.org.autobuse_.InterfacesDAO;

import brainacad.org.autobase.DAO.InterfacesDAO.СustomRepository.CustomRepository;
import brainacad.org.autobase.Model.Driver;
import brainacad.org.autobase.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long>, CustomRepository<Order>
{
}