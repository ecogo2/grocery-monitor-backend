package ba.ecogo.grocerymonitor.service;

import ba.ecogo.grocerymonitor.model.AuthUser;
import ba.ecogo.grocerymonitor.model.EmailMessage;
import ba.ecogo.grocerymonitor.model.Registration;
import ba.ecogo.grocerymonitor.model.base.BaseException;
import ba.ecogo.grocerymonitor.repository.RegistrationRepository;
import ba.ecogo.grocerymonitor.service.base.BaseService;
import ba.ecogo.grocerymonitor.service.fun.ServiceFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RegistrationService extends BaseService<Registration, RegistrationRepository> {

    @Autowired AuthUserService userService;
    @Autowired PrivilegeService privilegeService;
    @Autowired EmailService emailService;

    @Override
    public Registration createModel(Registration input) {
        logger.info("Saving {} without user id", Registration.class.getSimpleName());
        return ServiceFunctions.createAndSendEmail(
                input,
                repository::saveAndFlush,
                this::constructEmail,
                emailService::sendEmail
        );
    }

    @Override
    public Registration getModel(UUID input) {
        logger.info("Getting {} without user id", Registration.class.getSimpleName());
        return repository.findById(input).orElseThrow(() -> new BaseException("Registration not found."));
    }

    public void confirmRegistrationAndCreateUser(UUID token) {
        ServiceFunctions.confirmAndCreateUser(
                token,
                this::getModel,
                privilegeService::getModel,
                AuthUser::new,
                userService::createModel,
                this::constructEmail,
                emailService::sendEmail
        );
    }

    private EmailMessage constructEmail(String email, String subject, String body) {
        return new EmailMessage(email, subject, body);
    }

}
