package api.services;

import api.models.Target;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITargetService {
    List<Target> getAllTarget();
}
