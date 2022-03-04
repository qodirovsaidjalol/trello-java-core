package uz.qodirov.services.auth;

import uz.qodirov.exception.ApiRuntimeException;
import uz.qodirov.exception.CustomerSQLException;
import uz.qodirov.repository.auth.AuthUserRepository;
import uz.qodirov.response.Data;
import uz.qodirov.response.ResponseEntity;
import uz.qodirov.security.SecurityHolder;
import uz.qodirov.security.auth.Session;
import uz.qodirov.services.AbstractService;

public class AuthUserService extends AbstractService<AuthUserRepository> {


    public AuthUserService(AuthUserRepository repository) {
        super(repository);
    }

    public ResponseEntity<Data<Boolean>> login(String username, String password) {
        try {
            Session sessionUser = repository.login(username, password);
            SecurityHolder.setSessionUser(sessionUser);
            return new ResponseEntity<>(new Data<>(true));
        } catch (CustomerSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }
}
