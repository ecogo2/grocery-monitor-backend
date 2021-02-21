package ba.ecogo.grocerymonitor.api;

import ba.ecogo.grocerymonitor.api.base.BaseResource;
import ba.ecogo.grocerymonitor.model.AuthUser;
import ba.ecogo.grocerymonitor.model.Privilege;
import ba.ecogo.grocerymonitor.repository.AuthUserRepository;
import ba.ecogo.grocerymonitor.service.AuthUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/users")
public class AuthUserResource extends BaseResource<AuthUser, AuthUserRepository, AuthUserService> {

    @GetMapping("/{username}")
    @ResponseBody
    @PreAuthorize("hasAuthority('USER')")
    public AuthUser getUserByName(@PathVariable("username") String username) {
        return (AuthUser) service.loadUserByUsername(username);
    }

}
