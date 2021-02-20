package ba.ecogo.grocerymonitor.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component("authenticationEventListner")
public class AuthenticationEventListener implements AuthenticationEventPublisher {
    static final Logger logger = LoggerFactory.getLogger(AuthenticationEventListener.class);

    private @Autowired
    HttpServletRequest request;

    @Override
    public void publishAuthenticationSuccess(Authentication authentication) {
        logger.info("User: {} has logged in successfully", authentication.getName());
    }

    @Override
    public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
        logger.info("User: {} Login failed", authentication.getName());
    }

    // --

    private String getIpAddress() {
        final String xfHeader = request.getHeader("X-Forwarded-For");
        String ipAddress = "";
        if (xfHeader == null)
            ipAddress = request.getRemoteAddr();
        else
            ipAddress = xfHeader.split(",")[0];

        return ipAddress;
    }

}
