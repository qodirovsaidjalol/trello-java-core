package uz.qodirov.ui;

import uz.qodirov.security.auth.PermissionsItem;
import uz.jl.utils.Color;
import uz.jl.utils.Print;

import java.util.Objects;

import static uz.qodirov.security.SecurityHolder.authUserSession;

public class Menu {

    public static void getMainMenu() {
        if (Objects.isNull(authUserSession)) Print.println(Color.GREEN, "Login -> LOGIN");
        else {
            for (PermissionsItem permission : authUserSession.getPermissions()) {
                System.out.printf("%s%s%s\n", permission.getName(), " -> ", permission.getCode());
            }

        }
        Print.println(Color.GREEN, "Exit -> EXIT");
    }

}
