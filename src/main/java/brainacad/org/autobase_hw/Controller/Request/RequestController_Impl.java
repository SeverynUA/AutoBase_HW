package brainacad.org.autobase_hw.Controller.Request;

import brainacad.org.autobase_hw.Model.Request;
import brainacad.org.autobase_hw.Service.RequestService.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestController_Impl implements RequestController {

    private final RequestService requestService;

    @Autowired
    public RequestController_Impl(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping
    @Override
    public ResponseEntity<Request> create(@RequestBody Request entity) {
        Request createdRequest = requestService.create(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Request> getById(@PathVariable Long id) {
        Request request = requestService.getById(id);
        return ResponseEntity.ok(request);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Request>> getAll() {
        List<Request> requests = requestService.getAll();
        return ResponseEntity.ok(requests);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Request> update(@PathVariable Long id, @RequestBody Request entity) {
        Request updatedRequest = requestService.update(id, entity);
        return ResponseEntity.ok(updatedRequest);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        requestService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
