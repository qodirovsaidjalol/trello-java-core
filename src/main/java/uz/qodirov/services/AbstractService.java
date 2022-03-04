package uz.qodirov.services;

import uz.qodirov.repository.AbstractRepository;
import uz.qodirov.security.SecurityHolder;
import uz.qodirov.security.auth.PermissionsItem;
import uz.qodirov.security.auth.RolesItem;
import uz.qodirov.security.auth.Session;

import java.util.List;
import java.util.Objects;

/**
 * @param <R> -> Repository
 *            CR -> Create Dto
 *            D-> Dto
 *            K->Key
 */
public abstract class AbstractService<R extends AbstractRepository> {

    protected final R repository;

    public AbstractService(R repository) {
        this.repository = repository;
    }

    protected boolean hasRole(String role) {
        Session session = SecurityHolder.authUserSession;
        if (Objects.isNull(session)) return false;
        List<RolesItem> roles = session.getRoles();
        if (Objects.isNull(roles)) return false;
        return roles.stream().anyMatch(r -> r.getCode().equalsIgnoreCase(role));
    }

    protected boolean hasPermission(String permission) {
        Session session = SecurityHolder.authUserSession;
        if (Objects.isNull(session)) return false;
        List<PermissionsItem> permissions = session.getPermissions();
        if (Objects.isNull(permissions)) return false;
        return permissions.stream().anyMatch(p -> p.getCode().equalsIgnoreCase(permission));
    }

}
