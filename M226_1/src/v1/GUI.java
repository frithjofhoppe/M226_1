package v1;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import v1.Interfaces.IGUI;

import java.util.Optional;

public class GUI implements IGUI {
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
        BorderPane root = new BorderPane();
        playingField = new PlayingField(launcher);
        root.setCenter(playingField.getPlayingField());
        root.setRight(sideBar());
        Scene scene = new Scene(root, 600, 500);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        return scene;
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
