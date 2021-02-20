package ba.ecogo.grocerymonitor.service.fun;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class SecurityServiceFunctions {

    private SecurityServiceFunctions() {
        // ..
    }

    public static <T extends AbstractAuthenticationToken> void generateAuthenticationToken(
            String username,
            List<GrantedAuthority> authorities,
            BiFunction<String, List<GrantedAuthority>, OAuth2Request> constructOAuth2Request,
            BiFunction<String, List<GrantedAuthority>, T> constructUsernamePasswordAuthenticationToken,
            BiFunction<OAuth2Request, T, OAuth2Authentication> constructOAuth2Authentication,
            Function<OAuth2Authentication, OAuth2AccessToken> constructOAuth2AccessToken, BiConsumer<OAuth2Authentication, OAuth2AccessToken> setOAuth2Authentication) {

        OAuth2Authentication auth = constructOAuth2Authentication.apply(constructOAuth2Request.apply(username, authorities),
                constructUsernamePasswordAuthenticationToken.apply(username, authorities));
        setOAuth2Authentication.accept(auth, constructOAuth2AccessToken.apply(auth));
    }

}
