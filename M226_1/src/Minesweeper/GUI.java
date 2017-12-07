package Minesweeper;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Minesweeper.Interfaces.IGUI;

import java.util.Optional;

public class GUI implements IGUI {
    BorderPane root;
    PlayingField playingField;
    Stage primaryStage;
    Launcher launcher;

    public GUI(Stage primaryStage, Launcher launcher)
    {
        this.launcher = launcher;
        this.primaryStage = primaryStage;
        this.primaryStage.setScene(init());
    }

    public Scene init()
    {
        root = new BorderPane();
        playingField = new PlayingField(launcher);
        root.setCenter(playingField.getPlayingField());
        //root.setRight(sideBar());
        //root.setBottom(bottomControl());
        Scene scene = new Scene(root, 400, 400);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        return scene;
    }

    public void restart()
    {
        playingField = new PlayingField(launcher);
        root.setCenter(playingField.getPlayingField());
        //root.setRight(sideBar());
        //root.setBottom(bottomControl());
    }

    public void showInitMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Get started!");
        alert.setHeaderText("Instructions");
        alert.setContentText("You can turn fields by left-clicking them.\nTo mark fields, you have to right-click them.\nDon't click on bombs!");

        ButtonType buttonTypeOK = new ButtonType("OK");

        alert.getButtonTypes().setAll(buttonTypeOK);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOK){
            alert.close();
        } else {
            alert.close();
        }
    }

    public void showMarkErrorMessage() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Field marked!");
        alert.setHeaderText("Field is marked!");
        alert.setContentText("You can't turn a marked field.\nTo turn this field, unmark it by right-clicking it.");

        ButtonType buttonTypeOK = new ButtonType("OK");

        alert.getButtonTypes().setAll(buttonTypeOK);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOK){
            alert.close();
        } else {
            alert.close();
        }
    }

    public void show()
    {
        primaryStage.show();
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

    public VBox bottomControl()
    {
        HBox align = new HBox();
        Label probLabel = new Label(" Probability of bombs: ");
        Spinner<Integer> probField = new Spinner<>(0, 100, 0, 1);
        probField.valueProperty().addListener((obs, oldValue, newValue) ->
                playingField.probability = newValue);
        VBox placeholder = new VBox();
        placeholder.setMinHeight(100);
        align.getChildren().add(probLabel);
        align.getChildren().add(probField);
        placeholder.getChildren().add(align);
        VBox toReturn = new VBox();
        toReturn.getChildren().add(placeholder);
        return toReturn;
    }

    public boolean showEndMessage(boolean won){
        if(won)
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("You've won!");
            alert.setHeaderText("Congratulations!");
            alert.setContentText("You've won the Minesweeper game.\nTo restart, click the restart-Button.\nIf you want to exit this game, click exit.");

            ButtonType buttonTypeRestart = new ButtonType("Restart");
            ButtonType buttonTypeCancel = new ButtonType("Exit", ButtonBar.ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonTypeRestart, buttonTypeCancel);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeRestart){
                return true;
            } else {
                return false;
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("You've lost!");
            alert.setHeaderText("Looser!");
            alert.setContentText("You've lost the Minesweeper game.\nTo restart, click the restart-Button.\nIf you want to exit this game, click exit.");

            ButtonType buttonTypeRestart = new ButtonType("Restart");
            ButtonType buttonTypeCancel = new ButtonType("Exit", ButtonBar.ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonTypeRestart, buttonTypeCancel);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeRestart){
                return true;
            } else {
                return false;
            }
        }
    }
}
