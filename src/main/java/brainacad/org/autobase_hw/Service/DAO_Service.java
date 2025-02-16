package brainacad.org.autobase_hw.Service;

import java.util.List;

public interface DAO_Service<E>
{
    E create(E e);
    E getById(Long id);
    List<E> getAll();
    E update(Long id ,E e);
    void delete(Long id);
}
