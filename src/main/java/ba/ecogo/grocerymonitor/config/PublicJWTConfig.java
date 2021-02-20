package ba.ecogo.grocerymonitor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

@Configuration
public class PublicJWTConfig {

    @Autowired
    Environment env;
    private String jwtPublicKeyPath;

    @Bean
    @Qualifier("tokenStore")
    public TokenStore tokenStore(JwtAccessTokenConverter jwtAccessTokenConverter) {
        return new JwtTokenStore(jwtAccessTokenConverter);
    }

    @Autowired
    public PublicJWTConfig(@Value("${jks.key-path:src/main/resources/public.cert}") String prop) {
        super();
        this.jwtPublicKeyPath = prop;
    }

    @Bean
    protected JwtAccessTokenConverter jwtTokenEnhancer() throws Exception {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        Resource resource = null;

        if (jwtPublicKeyPath != null && !jwtPublicKeyPath.equals(""))
            resource = new FileSystemResource(jwtPublicKeyPath);
        else
            resource = new ClassPathResource("public.cert");

        String publicKey = null;

        try {
            publicKey = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
        } catch (IOException e) {
            throw new Exception(e.getMessage());
        }

        converter.setVerifierKey(publicKey);
        return converter;
    }

    public void setJwtPublicKeyPath(String jwtPublicKeyPath) {
        this.jwtPublicKeyPath = jwtPublicKeyPath;
    }

}
