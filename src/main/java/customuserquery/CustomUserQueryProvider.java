package customuserquery;

import org.keycloak.models.KeycloakSession;
import org.keycloak.models.utils.ModelToRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.keycloak.services.resource.RealmResourceProvider;
import org.keycloak.utils.MediaType;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserQueryProvider implements RealmResourceProvider {
    private final KeycloakSession session;

    public CustomUserQueryProvider(KeycloakSession session) {
        this.session = session;
    }

    public Object getResource() {
        return this;
    }

    public void close() {
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<UserRepresentation> getUsersByCustomQuery(
            @QueryParam("key") String key,
            @QueryParam("value") String value
    ) {
        return session
                .users()
                .searchForUserByUserAttribute(key, value, session.getContext().getRealm())
                .stream()
                .map(userModel -> ModelToRepresentation.toRepresentation(session, session.getContext().getRealm(), userModel))
                .collect(Collectors.toList());
    }
}
