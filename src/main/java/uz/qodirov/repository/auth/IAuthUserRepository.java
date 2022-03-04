package uz.qodirov.repository.auth;

import uz.qodirov.security.auth.Session;

public interface IAuthUserRepository {
    Session login(String username, String password);

    Boolean leader(long projectId, long userId);
}
