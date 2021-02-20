package ba.ecogo.grocerymonitor.service.fun;

import ba.ecogo.grocerymonitor.model.AuthUser;
import ba.ecogo.grocerymonitor.model.Privilege;
import ba.ecogo.grocerymonitor.model.Registration;

import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ServiceFunctions {
    public static void confirmAndCreateUser(
          UUID token,
          Function<UUID, Registration> getRegistration,
          Function<UUID, Privilege> getPrivilege,
          BiFunction<Registration, Privilege, AuthUser> createModel,
          UnaryOperator<AuthUser> persistUser
    ) {
        Registration reg = getRegistration.apply(token);
        Privilege priv = getPrivilege.apply(reg.getPrivilege());
        AuthUser user = createModel.apply(reg, priv);
        persistUser.apply(user);
    }
}
