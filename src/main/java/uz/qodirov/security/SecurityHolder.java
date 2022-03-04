package uz.qodirov.security;

import lombok.Setter;
import uz.qodirov.security.auth.Session;

@Setter
public class SecurityHolder {
    public static Session authUserSession;

    public static void setSessionUser(Session authUser) {
        authUserSession = authUser;
    }
}
