module org.encountermanager.encountermanager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.google.gson;

    opens org.encountermanager.encountermanager to javafx.fxml;
    exports org.encountermanager.encountermanager;
}