package uz.qodirov;

import uz.qodirov.container.UNIContainer;
import uz.qodirov.ui.Menu;
import uz.qodirov.ui.UI;
import uz.jl.utils.Color;
import uz.jl.utils.Input;
import uz.jl.utils.Print;

import java.util.Locale;

public class Application {
    private static final UI ui = UNIContainer.getBean(UI.class);

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Menu.getMainMenu();
        String choice = Input.getStr("Enter your choice: ").toUpperCase(Locale.ROOT);
        switch (choice) {
            case "LOGIN" -> ui.login();
            case "USER_BLOCK" -> ui.userBlock();
            case "USER_CREATE" -> ui.userCreate();
            case "USER_DELETE" -> ui.userDelete();
            case "USER_GET_LIST" -> ui.userList();
            case "USER_INFO" -> ui.userDetails();
            case "USER_UNBLOCK" -> ui.userUnblock();
            case "PROJECT_CREATE" -> ui.projectCreate();
            case "COLUMN_CREATE" -> ui.columnCreate();
            case "PROJECT_DETAILS" -> ui.projectDetails();

            case "ORGANIZATION_UPDATE" -> ui.organizationUpdate();
            case "ORGANIZATION_BLOCK" -> ui.organizationBlock();
            case "ORGANIZATION_UNBLOCK" -> ui.organizationUnblock();
            case "ORGANIZATION_DELETE" -> ui.organizationDelete();
            case "ORGANIZATION_GET" -> ui.organizationGet();
            case "ORGANIZATION_GET_LIST" -> ui.organizationList();

            case "1" -> ui.loginAsSuper();
            case "2" -> ui.loginAsAdmin();
            case "3" -> ui.loginAsHr();
            case "4" -> ui.loginAsEmp();
            case "EXIT" -> {
                Print.println(Color.GREEN, "Bye");
                return;
            }
            default -> Print.println(Color.RED, "Wrong choice");
        }
        run();
    }
}
