package com.example.oopjavafx;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HomePageController implements Initializable {

    private boolean menuOpened = false;

    private boolean BlockingPaneExists = false;

    private Scene scene1;
    private Stage stage;
    private Parent root;

    @FXML
    private Button ForYouButton;

    @FXML
    private ImageView ImageView1;

    @FXML
    private ImageView ImageView2;

    @FXML
    private ImageView ImageView3;

    @FXML
    private ImageView ImageView4;

    @FXML
    private Button Later;

    @FXML
    private Button Logout;

    @FXML
    private Button PopularButton;

    @FXML
    private Button TrendingButton;

    @FXML
    private ImageView menu;

    @FXML
    private Button myButton1;

    @FXML
    private Button myButton2;

    @FXML
    private Button myButton3;

    @FXML
    private Button myButton4;

    @FXML
    private AnchorPane pane1;

    @FXML
    private AnchorPane pane2;

    public void ChangeScene(ActionEvent event) {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene1 = new Scene(root);
        stage.setScene(scene1);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        pane1.setVisible(false);

        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.25),pane1);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.01),pane2);
        translateTransition.setByX(+600);
        translateTransition.play();

        menu.setOnMouseClicked(event -> {
            BlockingPaneExists = false;

            if(!menuOpened) {
                menuOpened = true;
                pane1.setVisible(true);
                FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.25), pane1);
                fadeTransition1.setFromValue(0);
                fadeTransition1.setToValue(0.15);
                fadeTransition1.play();

                TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.25), pane2);
                translateTransition1.setByX(-600);
                translateTransition1.play();
            }
        });

        pane1.setOnMouseClicked(event -> {
            menuOpened = false;
            if(!BlockingPaneExists) {
                BlockingPaneExists = true;
                FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.25), pane1);
                fadeTransition1.setFromValue(0.15);
                fadeTransition1.setToValue(0);
                fadeTransition1.play();

                fadeTransition1.setOnFinished(event1 -> {
                    pane1.setVisible(false);
                });
                TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.25), pane2);
                translateTransition1.setByX(+600);
                translateTransition1.play();
            }
        });
    }

    public void MakeImageRounded(ImageView im, String path){

        Image myImage = new Image(getClass().getResourceAsStream(path));
        im.setImage(myImage);

        // set a clip to apply rounded border to the original image.
        Rectangle clip = new Rectangle(im.getFitWidth(), im.getFitHeight());
        clip.setArcHeight(50);
        clip.setArcWidth(50);
        im.setClip(clip);

        // snapshot the rounded image.
        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        WritableImage image = im.snapshot(parameters, null);


        // store the rounded image in the imageView.
        im.setImage(image);
    }



    public void ForYou_Controller(ActionEvent e){
        ForYouButton.setStyle("-fx-text-fill:  #4dde90");
        MakeImageRounded(ImageView1,"Images/image1.png");
        TrendingButton.setStyle("-fx-text-fill:  #ffffff");
        PopularButton.setStyle("-fx-text-fill:  #ffffff");
    }

    public void Trending_Controller(ActionEvent e){
        TrendingButton.setStyle("-fx-text-fill:  #4dde90");
        MakeImageRounded(ImageView2,"Images/image2.png");
        ForYouButton.setStyle("-fx-text-fill:  #ffffff");
        PopularButton.setStyle("-fx-text-fill:  #ffffff");
    }

    public void Popular_Controller(ActionEvent e){
        PopularButton.setStyle("-fx-text-fill:  #4dde90");
        MakeImageRounded(ImageView3,"Images/image3.png");
        TrendingButton.setStyle("-fx-text-fill:  #ffffff");
        ForYouButton.setStyle("-fx-text-fill:  #ffffff");
    }

    public void Logout(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        ChangeScene(event);
        stage.setResizable(false);
        stage.setWidth(1045);
        stage.setHeight(645);
        stage.setY(180);
        stage.setX(437.5);
    }

    public void WatchedList(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("WatchList.fxml"));
        ChangeScene(event);
        stage.setResizable(true);
    }

    public void Later(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Later.fxml"));
        ChangeScene(event);
        stage.setResizable(true);
        stage.setResizable(true);
    }

}