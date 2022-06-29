package api.services.impl;

import api.models.Target;
import api.repositories.ITargetRepository;
import api.services.ITargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TargetServiceImpl implements ITargetService {

    @Autowired
    ITargetRepository iTargetRepository;

    @Override
    public List<Target> getAllTarget() {
        return iTargetRepository.getAllTarget();
    }
}
