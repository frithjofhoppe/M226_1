package Minesweeper;

import com.sun.istack.internal.Nullable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Random;

public class PlayingField {

    VBox playingField;
    int probability = 5;
    int dimensionOfField = 7;

    public PlayingField() {
        playingField = createPlayingField(dimensionOfField, probability);
    }

    VBox createPlayingField(int expansion, int chance) {
        VBox toReturn = new VBox();

        for (int a = 0; a < expansion; a++) {
            HBox line = new HBox();

            for (int b = 0; b < expansion; b++) {
                Field f;
                if (getRandomNumber(chance) == 1) {
                    f = new Field(true);
                } else {
                    f = new Field(false);
                }
                f.getStyleClass().add("FieldButtonNotClicked");
                f.setYPos(a);
                f.setXPos(b);

                f.setOnAction(e -> {
                    fieldClicked(f);
                });
                line.getChildren().add(f);
            }
            toReturn.getChildren().add(line);
        }
        return toReturn;
    }

    public int getRandomNumber(int max) {
        Random rnd = new Random();
        return rnd.nextInt(max) + 1;
    }

    private void fieldClicked(Field f) {
        if (f.isBomb == false) {
            f.getStyleClass().add("FieldButtonClicked");
            f.setText(Integer.toString(getBombCount(f.getXPos(), f.getYPos())));
        }
        else
        {
            f.getStyleClass().add("FieldBomb");
        }
    }

    @Nullable
    private Field getFieldByPosition(int x, int y) {
        Field f;

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

    private int getBombCount(int x, int y) {
        int toReturn = 0;

        toReturn += isBomb(getFieldByPosition( x + 1, y - 1));
        toReturn += isBomb(getFieldByPosition(x + 1, y + 1));
        toReturn += isBomb(getFieldByPosition(x, y + 1));
        toReturn += isBomb(getFieldByPosition(x - 1, y + 1));
        toReturn += isBomb(getFieldByPosition(x - 1, y));
        toReturn += isBomb(getFieldByPosition(x - 1, y - 1));
        toReturn += isBomb(getFieldByPosition(x, y - 1));
        toReturn += isBomb(getFieldByPosition(x + 1, y));
        toReturn += isBomb(getFieldByPosition(x , y));

        return toReturn;
    }
}
