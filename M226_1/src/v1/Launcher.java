package v1;

import javafx.application.Application;
import javafx.stage.Stage;
import v1.Interfaces.IGUI;

public class Launcher extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        IGUI gui = new GUI(primaryStage, new Logic());
        gui.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
