package ba.ecogo.grocerymonitor.service;

import ba.ecogo.grocerymonitor.model.Privilege;
import ba.ecogo.grocerymonitor.model.base.BaseException;
import ba.ecogo.grocerymonitor.repository.PrivilegeRepository;
import ba.ecogo.grocerymonitor.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PrivilegeService extends BaseService<Privilege, PrivilegeRepository> {

    @Override
    public Privilege getModel(UUID input) {
        return repository.findById(input).orElseThrow(() -> new BaseException("Privilege not found."));
    }

}
