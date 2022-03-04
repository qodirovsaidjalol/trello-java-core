package uz.qodirov.container;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import uz.qodirov.property.ApplicationProperties;
import uz.qodirov.property.DatabaseProperties;
import uz.qodirov.repository.auth.AuthUserRepository;
import uz.qodirov.repository.column.ColumnRepository;
import uz.qodirov.repository.organization.OrganizationRepository;
import uz.qodirov.repository.project.ProjectRepository;
import uz.qodirov.repository.task.TaskRepository;
import uz.qodirov.repository.user.UserRepository;
import uz.qodirov.services.auth.AuthUserService;
import uz.qodirov.services.column.ColumnService;
import uz.qodirov.services.organization.OrganizationService;
import uz.qodirov.services.project.ProjectService;
import uz.qodirov.services.task.TaskService;
import uz.qodirov.services.user.UserService;
import uz.qodirov.ui.UI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class UNIContainer {
    private static final ApplicationProperties APPLICATION_PROPERTIES;
    private static final DatabaseProperties DATABASE_PROPERTIES;
    private static Connection CONNECTION;

    private static final OrganizationRepository ORGANIZATION_REPOSITORY;
    private static final ProjectRepository PROJECT_REPOSITORY;
    private static final ColumnRepository COLUMN_REPOSITORY;
    private static final TaskRepository TASK_REPOSITORY;
    private final static AuthUserRepository AUTH_USER_REPOSITORY;

    private static final OrganizationService ORGANIZATION_SERVICE;
    private static final ProjectService PROJECT_SERVICE;
    private static final ColumnService COLUMN_SERVICE;
    private static final TaskService TASK_SERVICE;
    private final static AuthUserService AUTH_USER_SERVICE;
    private final static UserService USER_SERVICE;
    private final static UserRepository USER_REPOSITORY;

    //    private static final OrganizationUI ORGANIZATION_UI;
//    private static final ProjectUI PROJECT_UI;
//    private static final ColumnUI COLUMN_UI;
//    private static final TaskUI TASK_UI;
//    private static final AuthUserUI AUTH_USER_UI;
    private static final UI UI;
    private static final Gson GSON;


    static {
        GSON = new GsonBuilder().setPrettyPrinting().create();
        APPLICATION_PROPERTIES = new ApplicationProperties();
        DATABASE_PROPERTIES = new DatabaseProperties();
        try {
            CONNECTION = DriverManager.getConnection(
                    APPLICATION_PROPERTIES.get("db.jdbc"),
                    APPLICATION_PROPERTIES.get("db.username"),
                    APPLICATION_PROPERTIES.get("db.password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ORGANIZATION_REPOSITORY = new OrganizationRepository();
        PROJECT_REPOSITORY = new ProjectRepository();
        COLUMN_REPOSITORY = new ColumnRepository();
        TASK_REPOSITORY = new TaskRepository();
        AUTH_USER_REPOSITORY = new AuthUserRepository();

        ORGANIZATION_SERVICE = new OrganizationService(ORGANIZATION_REPOSITORY);
        PROJECT_SERVICE = new ProjectService(PROJECT_REPOSITORY);
        COLUMN_SERVICE = new ColumnService(COLUMN_REPOSITORY);
        TASK_SERVICE = new TaskService(TASK_REPOSITORY);
        AUTH_USER_SERVICE = new AuthUserService(AUTH_USER_REPOSITORY);
        USER_REPOSITORY = new UserRepository();
        USER_SERVICE = new UserService(USER_REPOSITORY);


//        ORGANIZATION_UI = new OrganizationUI(ORGANIZATION_SERVICE);
//        PROJECT_UI = new ProjectUI(PROJECT_SERVICE);
//        COLUMN_UI = new ColumnUI(COLUMN_SERVICE);
//        TASK_UI = new TaskUI(TASK_SERVICE);
//        AUTH_USER_UI = new AuthUserUI(AUTH_USER_SERVICE);
        UI = new UI(AUTH_USER_SERVICE, USER_SERVICE, ORGANIZATION_SERVICE);
    }

    public static <T> T getBean(Class<T> bean) {
        return getBean(bean.getSimpleName().toUpperCase(Locale.ROOT));
    }

    public static <T> T getBean(String bean) {
        bean = bean.toUpperCase(Locale.ROOT);
        return switch (bean) {
            case "APPLICATIONPROPERTIES" -> (T) APPLICATION_PROPERTIES;
            case "DATABASEPROPERTIES" -> (T) DATABASE_PROPERTIES;
            case "CONNECTION" -> (T) CONNECTION;

            case "ORGANIZATIONSERVICE" -> (T) ORGANIZATION_SERVICE;
            case "PROJECTSERVICE" -> (T) PROJECT_SERVICE;
            case "COLUMNSERVICE" -> (T) COLUMN_SERVICE;
            case "TASKSERVICE" -> (T) TASK_SERVICE;
            case "AUTHUSERSERVICE" -> (T) AUTH_USER_SERVICE;

            case "ORGANIZATIONREPOSITORY" -> (T) ORGANIZATION_REPOSITORY;
            case "PROJECTREPOSITORY" -> (T) PROJECT_REPOSITORY;
            case "COLUMNREPOSITORY" -> (T) COLUMN_REPOSITORY;
            case "TASKREPOSITORY" -> (T) TASK_REPOSITORY;
            case "AUTHUSERREPOSITORY" -> (T) AUTH_USER_REPOSITORY;

            case "UI" -> (T) UI;
            case "GSON" -> (T) GSON;

            default -> throw new RuntimeException("Bean Not Found");
        };
    }


}
