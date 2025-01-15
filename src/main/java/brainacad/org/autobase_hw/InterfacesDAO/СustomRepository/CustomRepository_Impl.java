package brainacad.org.autobase_hw.InterfacesDAO.СustomRepository;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CustomRepository_Impl<T> implements CustomRepository<T>
{
}