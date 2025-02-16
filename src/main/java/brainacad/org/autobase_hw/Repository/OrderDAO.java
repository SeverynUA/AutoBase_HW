package brainacad.org.autobase_hw.Repository;


import brainacad.org.autobase_hw.Repository.СustomRepository.CustomRepository;
import brainacad.org.autobase_hw.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long>, CustomRepository<Order>
{

}