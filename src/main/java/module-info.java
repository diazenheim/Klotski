module com.klotski.klotski {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.klotski.klotski to javafx.fxml;
    exports com.klotski.klotski;
    exports com.klotski.klotski.model;
    opens com.klotski.klotski.model to javafx.fxml;
    exports com.klotski.klotski.controller;
    opens com.klotski.klotski.controller to javafx.fxml;
}