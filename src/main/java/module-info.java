module com.ivantarabay.passman {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ivantarabay.passman to javafx.fxml;
    exports com.ivantarabay.passman;
}