package uz.qodirov.repository.auth;

import uz.qodirov.repository.AbstractRepository;
import uz.qodirov.security.auth.Session;

import java.sql.Types;

public class AuthUserRepository extends AbstractRepository
        implements IAuthUserRepository {

    @Override
    public Session login(String userName, String password) {
        prepareArguments(userName, password);
        String jsonDATA = (String) callProcedure(property.get("auth.login"), Types.VARCHAR);
        return gson.fromJson(jsonDATA, Session.class);
    }

    @Override
    public Boolean leader(long projectId, long userId) {
        prepareArguments(userId, projectId);
        return (Boolean) callProcedure(property.get("auth.isLead"), Types.BOOLEAN);
    }
}
