package ba.ecogo.grocerymonitor.repository;

import ba.ecogo.grocerymonitor.model.AuthUser;

public interface AuthUserRepository extends BaseModelRepository<AuthUser> {

    AuthUser findByUsername(String username);

}
