package Minesweeper;

import javafx.application.Application;
import javafx.stage.Stage;
import Minesweeper.Interfaces.IGUI;

public class Launcher extends Application {
    IGUI gui;
    @Override
    public void start(Stage primaryStage){
        gui = new GUI(primaryStage, this);
        gui.show();
        gui.showInitMessage();
    }
    public static void main(String[] args) {
        launch(args);
    }

    public void endGame(boolean won){
        if(gui.showEndMessage(won))
        {
            gui.restart();
        } else {
            System.exit(0);
        }


    }
}
