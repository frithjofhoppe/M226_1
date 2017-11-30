package v1;

import javafx.application.Application;
import javafx.stage.Stage;
import v1.Interfaces.IGUI;

public class Launcher extends Application {
    IGUI gui;
    @Override
    public void start(Stage primaryStage){
        gui = new GUI(primaryStage, this);
        gui.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    public void endGame(boolean won){
        if(gui.showEndMessage(won))
        {
            start(new Stage());
        } else {
            System.exit(0);
        }


    }
}
