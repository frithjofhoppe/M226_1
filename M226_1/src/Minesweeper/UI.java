package Minesweeper;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class UI {
    PlayingField playingField;

    public Scene init()
    {
        BorderPane root = new BorderPane();
        playingField = new PlayingField();
        root.setCenter(playingField.getPlayingField());
        root.setRight(sideBar());
        Scene scene = new Scene(root, 600, 500);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        return scene;
    }

    public VBox sideBar()
    {
        VBox back = new VBox();
        Button start = new Button();
        start.setText("Start");
        Button reset = new Button();
        reset.setText("Stop");
        start.getStyleClass().add("ControlButton");
        reset.getStyleClass().add("ControlButton");
        back.getChildren().add(start);
        back.getChildren().add(reset);
        return back;
    }
}
