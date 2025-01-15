package brainacad.org.autobase_hw.Service.RequestService;

import brainacad.org.autobase_hw.Model.Request;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;

import java.util.List;

public interface RequestService
{
    Request create(Request request);
    Request getById(Long id);
    List<Request> getAll();
    Request update(Long id, Request request);
    void delete(Long id);
}
