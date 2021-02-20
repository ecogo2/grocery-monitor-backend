package ba.ecogo.grocerymonitor.service;

import ba.ecogo.grocerymonitor.model.AuthUser;
import ba.ecogo.grocerymonitor.model.Registration;
import ba.ecogo.grocerymonitor.model.base.BaseException;
import ba.ecogo.grocerymonitor.repository.RegistrationRepository;
import ba.ecogo.grocerymonitor.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RegistrationService extends BaseService<Registration, RegistrationRepository> {

    @Override
    public Registration createModel(Registration input) {
        logger.info("Saving {} without user id", Registration.class.getSimpleName());
        return repository.saveAndFlush(input);
    }

    @Override
    public Registration getModel(UUID input) {
        logger.info("Getting {} without user id", Registration.class.getSimpleName());
        Registration model = repository.findById(input).orElseThrow(() -> new BaseException("registration not found."));
        model.setPassword("");
        return model;
    }
}
