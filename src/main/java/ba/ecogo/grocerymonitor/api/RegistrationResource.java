package ba.ecogo.grocerymonitor.api;

import ba.ecogo.grocerymonitor.api.base.BaseResource;
import ba.ecogo.grocerymonitor.model.Registration;
import ba.ecogo.grocerymonitor.repository.RegistrationRepository;
import ba.ecogo.grocerymonitor.service.RegistrationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registrations")
public class RegistrationResource extends BaseResource<Registration, RegistrationRepository, RegistrationService> {
}
