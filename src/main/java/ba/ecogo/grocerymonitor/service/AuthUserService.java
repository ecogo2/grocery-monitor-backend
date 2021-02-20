package ba.ecogo.grocerymonitor.service;

import ba.ecogo.grocerymonitor.model.AuthUser;
import ba.ecogo.grocerymonitor.repository.AuthUserRepository;
import ba.ecogo.grocerymonitor.service.base.BaseService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Service
public class AuthUserService extends BaseService<AuthUser, AuthUserRepository> implements UserDetailsService {

    public UserDetails loadUserByUsername(String username) {
        AuthUser user = repository.findByUsername(username);
        return user != null ? new UserRepositoryUserDetails(user) : null;
    }

    private static final class UserRepositoryUserDetails extends AuthUser implements UserDetails {
        private static final long serialVersionUID = -487688845028610536L;

        private UserRepositoryUserDetails(AuthUser user) {
            super(user);
        }


        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Set.of(super.getPrivilege());
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }

}
