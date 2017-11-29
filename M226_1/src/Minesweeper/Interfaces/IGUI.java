package v1.Interfaces;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public interface IGUI {
    Scene init();
    VBox sideBar();
    void show();
}
