package Minesweeper.Interfaces;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public interface IGUI {
    Scene init();
    VBox sideBar();
    void show();
    void restart();
    void showInitMessage();
    boolean showEndMessage(boolean won);
    void showMarkErrorMessage();
}
