package Minesweeper;

import com.sun.istack.internal.Nullable;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class PlayingField {

    VBox playingField;
    Launcher launcher;
    int clickedFields;
    int bombsCount;
    int probability = 5; // 20% of all fields are bombs
    int dimensionOfField = 7;

    public PlayingField(Launcher launcher) {
        clickedFields = 0;
        bombsCount = 0;
        playingField = create(dimensionOfField, probability);
        this.launcher = launcher;
    }

    VBox create(int expansion, int chance) {
        VBox toReturn = new VBox();

        for (int a = 0; a < expansion; a++) {
            HBox line = new HBox();

            for (int b = 0; b < expansion; b++) {
                Field f;
                if (Logic.getRandomNumber(chance) == 1) {
                    f = new Field(true);
                    bombsCount++;
                } else {
                    f = new Field(false);
                }
                f.getStyleClass().add("FieldButtonNotClicked");
                f.setYPos(a);
                f.setXPos(b);

                //f.setOnAction(e -> fieldClicked(f));
                f.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                    if (e.getButton() == MouseButton.SECONDARY)
                    {
                        if(!f.isTurned) {
                            fieldClickedMark(f);
                        }
                    }
                    else
                    {
                        fieldClickedTurn(f);
                    }
                    e.consume();
                });
                line.getChildren().add(f);
            }
            toReturn.getChildren().add(line);
        }
        return toReturn;
    }

    private void fieldClickedTurn(Field f) {
        if(!f.isMarked) {
            clickedFields++;
            if (!f.isBomb) {
                f.getStyleClass().add("FieldButtonClicked");
                f.setText(Integer.toString(getBombCount(f.getXPos(), f.getYPos())));
                if (Logic.checkEnd(this)) {
                    launcher.endGame(true);
                }
            } else {
                f.getStyleClass().add("FieldBomb");
                launcher.endGame(false);
            }
        } else
        {
            launcher.gui.showMarkErrorMessage();
        }
    }

    private void fieldClickedMark(Field f) {
        f.isMarked = !f.isMarked;
        if(f.isMarked)
            f.getStyleClass().add("FieldButtonMarked");
        else
            f.getStyleClass().remove("FieldButtonMarked");
    }

    private void markField(Field f)
    {
        f.setMarked(!f.isMarked);
    }

    @Nullable
    private Field getFieldByPosition(int x, int y) {
        try {
            HBox box = (HBox) playingField.getChildren().get(y);
            if (box != null) {
                Field fe = (Field) box.getChildren().get(x);
                if (fe != null) {
                    return fe;
                }
            }
        } catch (Exception e) {
            System.out.println("WARNING: Field not found!");
        }
        return null;
    }

    public VBox getPlayingField() {
        return playingField;
    }

    private HBox findRowByIndex(int index) {
        try {
            HBox test = (HBox) playingField.getChildren().get(index);
            return test;
        } catch (Exception error) {
            System.out.println("ERROR There is no row " + Integer.toString(index));
        }
        return null;
    }

    private int isBomb(Field f) {
        if (f != null) {
            if (f.isBomb) {
                return 1;
            }
        }
        return 0;
    }

    public int getBombCount(int x, int y) {
        int toReturn = 0;

        toReturn += isBomb(getFieldByPosition( x + 1, y - 1));
        toReturn += isBomb(getFieldByPosition(x + 1, y + 1));
        toReturn += isBomb(getFieldByPosition(x, y + 1));
        toReturn += isBomb(getFieldByPosition(x - 1, y + 1));
        toReturn += isBomb(getFieldByPosition(x - 1, y));
        toReturn += isBomb(getFieldByPosition(x - 1, y - 1));
        toReturn += isBomb(getFieldByPosition(x, y - 1));
        toReturn += isBomb(getFieldByPosition(x + 1, y));

        return toReturn;
    }
}