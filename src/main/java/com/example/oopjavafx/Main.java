package com.example.oopjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setTitle("Furga");
        Image logo = new Image("Watchit_Logo.png");
        stage.getIcons().add(logo);
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("Register.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("WatchList.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("MovieScene.css").toExternalForm());
    }

    public static void main(String[] args) {
        launch();
    }
}