package ba.ecogo.grocerymonitor.service.fun;

import ba.ecogo.grocerymonitor.model.AuthUser;
import ba.ecogo.grocerymonitor.model.EmailMessage;
import ba.ecogo.grocerymonitor.model.Privilege;
import ba.ecogo.grocerymonitor.model.Registration;

import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ServiceFunctions {

    @FunctionalInterface
    public interface ConstructEmail {
        EmailMessage execute(String email, String subject, String body);
    }

    public static Registration createAndSendEmail(
            Registration input,
            UnaryOperator<Registration> saveRegistration,
            ConstructEmail createEmail,
            Consumer<EmailMessage> sendEmail
    ) {
        String body = "<a href=\"http://localhost:8080/registrations/confirm/{token}\">Click here to finish registration.</a>";
        Registration registration = saveRegistration.apply(input);
        sendEmail.accept(createEmail.execute(input.getEmail(), "Registration confirmation", body.replace("{token}", registration.getId().toString())));
        return registration;
    }

    public static void confirmAndCreateUser(
          UUID token,
          Function<UUID, Registration> getRegistration,
          Function<UUID, Privilege> getPrivilege,
          BiFunction<Registration, Privilege, AuthUser> createModel,
          UnaryOperator<AuthUser> persistUser,
          ConstructEmail createEmail,
          Consumer<EmailMessage> sendEmail
    ) {
        Registration reg = getRegistration.apply(token);
        Privilege priv = getPrivilege.apply(reg.getPrivilege());
        AuthUser user = createModel.apply(reg, priv);
        persistUser.apply(user);

        sendEmail.accept(createEmail.execute(user.getEmail(), "Registration success", "Thank you for registering!"));
    }
}
