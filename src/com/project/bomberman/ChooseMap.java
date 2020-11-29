package com.project.bomberman;

import com.project.bomberman.gui.Frame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class ChooseMap {
    public void onClickMap1() {
        Frame MainWindow = new Frame();
    }

    public void onClickMap2() {

    }

    public void onClickStartButton(ActionEvent actionEvent) throws IOException {
        Parent choose = FXMLLoader.load(getClass().getResource("chooseMap.fxml"));
        Scene choose_scene = new Scene(choose);
        Stage choose_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        choose_stage.setScene(choose_scene);
        choose_stage.show();
    }
}
