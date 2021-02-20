package ba.ecogo.grocerymonitor.model.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "oauth_client_details",
        uniqueConstraints = { @UniqueConstraint(name = "UK_oauthclntdtls_clnt", columnNames = { "client_id" }) })
// @formatter:on
public class CustomClientDetails extends BaseModel {
    private static final long serialVersionUID = 1111095458889272533L;

    @Column(name = "client_id", nullable = false)
    private String clientId;

    @Column(name = "description", nullable = false, length = 80)
    private String description;

    @Column(name = "resource_ids", nullable = false, length = 256)
    private String resourceId;

    @Column(name = "client_secret", nullable = false, length = 256)
    private String clientSecret;

    @Column(name = "scope", nullable = false, length = 256)
    private String scope;

    @Column(name = "authorized_grant_types", nullable = false, length = 256)
    private String authorizedGrantTypes;

    @Column(name = "web_server_redirect_uri", nullable = true, length = 256)
    private String webServerRedirectUri;

    @Column(name = "authorities", nullable = false, length = 256)
    private String authorities;

    @Column(name = "access_token_validity", nullable = false)
    private int accessTokenValidity;

    @Column(name = "refresh_token_validity", nullable = false)
    private int refreshTokenValidity;

    @Column(name = "additional_information", nullable = true)
    private String additionalInformation;

    @Column(name = "autoapprove", nullable = false)
    private String autoapprove;
}
