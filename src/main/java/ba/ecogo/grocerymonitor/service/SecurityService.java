package ba.ecogo.grocerymonitor.service;


import ba.ecogo.grocerymonitor.model.base.JWT;
import ba.ecogo.grocerymonitor.service.abst.SecurityAbstractService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerEndpointsConfiguration;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class SecurityService extends SecurityAbstractService {

    private @Autowired
    AuthorizationServerEndpointsConfiguration configuration;

    public SecurityService() {
        super(LoggerFactory.getLogger(SecurityService.class));
    }

    public JWT getToken() throws Exception {
        String tokenValue = null;
        final Authentication authenticationObject = SecurityContextHolder.getContext().getAuthentication();
        if (authenticationObject != null) {
            final Object detailObject = authenticationObject.getDetails();
            if (detailObject instanceof OAuth2AuthenticationDetails)
                tokenValue = ((OAuth2AuthenticationDetails) detailObject).getTokenValue();
            else if (detailObject instanceof OAuth2AccessToken)
                tokenValue = ((OAuth2AccessToken) detailObject).getValue();
        }

        try {
            return new ObjectMapper().readValue(
                    new String(Base64.getDecoder().decode(new ArrayList<>(Arrays.asList(tokenValue != null ? tokenValue.split(Pattern.quote(".")) : null)).get(1))).trim(),
                    JWT.class);

        } catch (Exception e) {
            throw new Exception(e.getLocalizedMessage());
        }
    }

    protected UsernamePasswordAuthenticationToken constructUsernamePasswordAuthenticationToken(String username, List<GrantedAuthority> authorities) {
        return new UsernamePasswordAuthenticationToken(username, "N/A", authorities);
    }

    @Override
    protected OAuth2Request constructOAuth2Request(String username, List<GrantedAuthority> authorities) {
        // @formatter:off
        return new OAuth2Request(new HashMap<>(),
                "gmclient",
                authorities,
                true,
                new HashSet<>(Arrays.asList("read", "write")),
                new HashSet<>(Arrays.asList("gmservice")),
                null,
                new HashSet<>(),
                new HashMap<>());
        // @formatter:on
    }

    @Override
    protected OAuth2AccessToken constructOAuth2AccessToken(OAuth2Authentication authentication) {
        return configuration.getEndpointsConfigurer().getTokenServices().createAccessToken(authentication);
    }

    @Override
    protected void setOAuth2Authentication(OAuth2Authentication authentication, OAuth2AccessToken token) {
        logger.debug("Set Oauth2Authentication - username: {}, authorities: {}", authentication.getName(), authentication.getAuthorities());
        authentication.setDetails(token);
        authentication.setAuthenticated(true);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}