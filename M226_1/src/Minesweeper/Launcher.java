package Minesweeper;

import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        UI gui = new UI();
        primaryStage.setScene(gui.init());
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
