module com.klotski.klotski {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;



    opens com.klotski.klotski to javafx.fxml;
    exports com.klotski.klotski;
    exports com.klotski.klotski.model;
    opens com.klotski.klotski.model to javafx.fxml;
    exports com.klotski.klotski.controller;
    opens com.klotski.klotski.controller to javafx.fxml;
    exports com.klotski.klotski.view;
    opens com.klotski.klotski.view to javafx.fxml;
}