package customuserquery;

import org.keycloak.Config;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.services.resource.RealmResourceProvider;
import org.keycloak.services.resource.RealmResourceProviderFactory;

public class CustomUserQueryProviderFactory implements RealmResourceProviderFactory {
    public static final String ID = "custom-user-query";

    public RealmResourceProvider create(KeycloakSession keycloakSession) {
        return new CustomUserQueryProvider(keycloakSession);
    }

    public void init(Config.Scope scope) {
    }

    public void postInit(KeycloakSessionFactory keycloakSessionFactory) {
    }

    public void close() {
    }

    public String getId() {
        return ID;
    }
}
