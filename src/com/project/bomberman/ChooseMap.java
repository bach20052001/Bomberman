package com.project.bomberman;

import com.project.bomberman.graphics.SpriteSheet;
import com.project.bomberman.gui.Frame;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChooseMap {


    public void onClickMap1(ActionEvent actionEvent) {
        Stage st = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        st.hide();
        SpriteSheet.tiles = new SpriteSheet("/textures/classicBlue.bmp", 256);
        Frame MainWindow = new Frame();
    }

    public void onClickMap2(ActionEvent actionEvent) {
        Stage st = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        st.hide();
        SpriteSheet.tiles = new SpriteSheet("/textures/classicman.bmp", 256);
        Frame MainWindow = new Frame();
    }

    public void onClickStartButton(ActionEvent actionEvent) throws IOException {
        Parent choose = FXMLLoader.load(getClass().getResource("chooseMap.fxml"));
        Scene choose_scene = new Scene(choose);
        Stage choose_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        choose_stage.setScene(choose_scene);
        choose_stage.show();
    }
}
