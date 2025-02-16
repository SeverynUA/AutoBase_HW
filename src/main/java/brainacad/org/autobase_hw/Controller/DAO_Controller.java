package brainacad.org.autobase_hw.Controller;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DAO_Controller<E>
{
    ResponseEntity<E> create(E entity);
    ResponseEntity<E> getById(@NotNull Long id);
    ResponseEntity<List<E>> getAll();
    ResponseEntity<E> update(@NotNull Long id,E entity);
    ResponseEntity <Void> delete(@NotNull Long id);
}
