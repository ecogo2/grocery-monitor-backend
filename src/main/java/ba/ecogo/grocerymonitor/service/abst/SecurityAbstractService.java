package ba.ecogo.grocerymonitor.service.abst;

import ba.ecogo.grocerymonitor.service.fun.SecurityServiceFunctions;
import org.slf4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;

import java.util.List;

public abstract class SecurityAbstractService {

    protected Logger logger;

    protected SecurityAbstractService(Logger logger) {
        this.logger = logger;
    }

    public void generateAuthenticationToken(String username, List<GrantedAuthority> authorities) {
        logger.debug("Generate Oauth2Authentication - username: {}, Authorities: {}", username, authorities);
        // @formatter:off
        SecurityServiceFunctions.generateAuthenticationToken(
                username,
                authorities,
                this::constructOAuth2Request,
                UsernamePasswordAuthenticationToken::new,
                OAuth2Authentication::new,
                this::constructOAuth2AccessToken,
                this::setOAuth2Authentication
        );
        // @formatter:on
    }

    protected abstract UsernamePasswordAuthenticationToken constructUsernamePasswordAuthenticationToken(String username, List<GrantedAuthority> authorities);
    protected abstract OAuth2Request constructOAuth2Request(String username, List<GrantedAuthority> authorities);
    protected abstract OAuth2AccessToken constructOAuth2AccessToken(OAuth2Authentication authentication);
    protected abstract void setOAuth2Authentication(OAuth2Authentication authentication, OAuth2AccessToken token);

}