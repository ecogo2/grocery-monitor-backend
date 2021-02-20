package ba.ecogo.grocerymonitor.api;

import ba.ecogo.grocerymonitor.api.base.BaseResource;
import ba.ecogo.grocerymonitor.model.Registration;
import ba.ecogo.grocerymonitor.model.base.BaseException;
import ba.ecogo.grocerymonitor.repository.RegistrationRepository;
import ba.ecogo.grocerymonitor.service.RegistrationService;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/registrations")
public class RegistrationResource extends BaseResource<Registration, RegistrationRepository, RegistrationService> {

    @PatchMapping(path = "confirm/{token}")
    public void confirmRegistration(@PathVariable("token") UUID token) {
        service.confirmRegistrationAndCreateUser(token);
    }

    @Override
    public Registration getModel(UUID id) {
        throw new BaseException("Method not implemented.");
    }
}
