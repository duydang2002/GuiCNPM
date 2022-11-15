module project.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    opens project.app to javafx.fxml;
    exports project.app;
}