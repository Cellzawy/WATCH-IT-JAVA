package com.example.oopjavafx;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import static java.lang.Integer.parseInt;


public class MovieSceneController implements Initializable {

    @FXML
    private AnchorPane pane1;

    @FXML
    private AnchorPane pane2;

    @FXML
    private AnchorPane pane3;

    @FXML
    private AnchorPane pane4;

    @FXML
    private Button num1;

    @FXML
    private Button num2;

    @FXML
    private Button num3;

    @FXML
    private Button num4;

    @FXML
    private Button num5;

    @FXML
    private Button num6;

    @FXML
    private Button num7;

    @FXML
    private Button num8;

    @FXML
    private Button num9;

    @FXML
    private Button num10;

    @FXML
    private Button Furga;

    @FXML
    private ImageView MoviePoster;

    @FXML
    private ImageView menu;

    @FXML
    private Label movieTitle;

    @FXML
    private Button Rate;

    @FXML
    private Label yourRating;

    @FXML
    private Button RatingTheMovie;

    private boolean menuOpened = false;

    private boolean BlockingPaneExists = false;

    private boolean menuOpened1 = false;

    private boolean BlockingPaneExists1 = false;

    private Scene scene1;
    private Stage stage;
    private Parent root;

    private HashMap numbersCondition = new HashMap();
    private Button[] numbers = {num1, num2, num3, num4, num5, num6, num7, num8, num9, num10};

    public void ChangeScene(ActionEvent event) {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene1 = new Scene(root);
        stage.setScene(scene1);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        pane1.setVisible(false);

        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.25),pane1);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.01),pane2);
        translateTransition.setByY(+758);
        translateTransition.play();

        Rate.setOnMouseClicked(event -> {
            BlockingPaneExists = false;

            if(!menuOpened) {
                menuOpened = true;
                pane1.setVisible(true);
                FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.25), pane1);
                fadeTransition1.setFromValue(0);
                fadeTransition1.setToValue(0.15);
                fadeTransition1.play();

                TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.25), pane2);
                translateTransition1.setByY(-758);
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
                translateTransition1.setByY(+758);
                translateTransition1.play();
            }
        });

        RatingTheMovie.setOnMouseClicked(event -> {
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
                translateTransition1.setByY(+758);
                translateTransition1.play();
            }
        });

        pane4.setVisible(false);

        FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.25),pane4);
        fadeTransition1.setFromValue(1);
        fadeTransition1.setToValue(0);
        fadeTransition1.play();

        TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.01),pane3);
        translateTransition1.setByX(+600);
        translateTransition1.play();

        menu.setOnMouseClicked(event -> {
            BlockingPaneExists1 = false;

            if(!menuOpened1) {
                menuOpened1 = true;
                pane4.setVisible(true);
                FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(0.25), pane4);
                fadeTransition2.setFromValue(0);
                fadeTransition2.setToValue(0.15);
                fadeTransition2.play();

                TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.25), pane3);
                translateTransition2.setByX(-600);
                translateTransition2.play();
            }
        });

        pane4.setOnMouseClicked(event -> {
            menuOpened1 = false;
            if(!BlockingPaneExists1) {
                BlockingPaneExists1 = true;
                FadeTransition fadeTransition3 = new FadeTransition(Duration.seconds(0.25), pane4);
                fadeTransition3.setFromValue(0.15);
                fadeTransition3.setToValue(0);
                fadeTransition3.play();

                fadeTransition3.setOnFinished(event1 -> {
                    pane4.setVisible(false);
                });
                TranslateTransition translateTransition4 = new TranslateTransition(Duration.seconds(0.25), pane3);
                translateTransition4.setByX(+600);
                translateTransition4.play();
            }
        });


        numbersCondition.put(num1,false);
        numbersCondition.put(num2,false);
        numbersCondition.put(num3,false);
        numbersCondition.put(num4,false);
        numbersCondition.put(num5,false);
        numbersCondition.put(num6,false);
        numbersCondition.put(num7,false);
        numbersCondition.put(num8,false);
        numbersCondition.put(num9,false);
        numbersCondition.put(num10,false);
        MakeImageRounded(MoviePoster, "Images/image1.png");
            num1.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
            num2.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
            num3.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
            num4.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
            num5.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
            num6.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
            num7.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
            num8.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
            num9.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
            num10.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
            num1.setOnMouseEntered(mouseEvent -> {
                num1.setTextFill(Color.BLACK);
                num1.setBackground(new Background(new BackgroundFill(Color.valueOf("#4dde90"), new CornerRadii(50), Insets.EMPTY)));
            });
            num1.setOnMouseExited(mouseEvent -> {
                if(!(boolean) numbersCondition.get(num1)) {
                    num1.setTextFill(Color.WHITE);
                    num1.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
                }
            });

            num2.setOnMouseEntered(mouseEvent -> {
                num2.setTextFill(Color.BLACK);
                num2.setBackground(new Background(new BackgroundFill(Color.valueOf("#4dde90"), new CornerRadii(50), Insets.EMPTY)));
            });
            num2.setOnMouseExited(mouseEvent -> {
                if(!(boolean) numbersCondition.get(num2)) {
                    num2.setTextFill(Color.WHITE);
                    num2.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
                }
            });

            num3.setOnMouseEntered(mouseEvent -> {
                num3.setTextFill(Color.BLACK);
                num3.setBackground(new Background(new BackgroundFill(Color.valueOf("#4dde90"), new CornerRadii(50), Insets.EMPTY)));
            });
            num3.setOnMouseExited(mouseEvent -> {
                if(!(boolean) numbersCondition.get(num3)) {
                    num3.setTextFill(Color.WHITE);
                    num3.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
                }
            });

            num4.setOnMouseEntered(mouseEvent -> {
                num4.setTextFill(Color.BLACK);
                num4.setBackground(new Background(new BackgroundFill(Color.valueOf("#4dde90"), new CornerRadii(50), Insets.EMPTY)));
            });
            num4.setOnMouseExited(mouseEvent -> {
                if(!(boolean) numbersCondition.get(num4)) {
                    num4.setTextFill(Color.WHITE);
                    num4.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
                }
            });

            num5.setOnMouseEntered(mouseEvent -> {
                num5.setTextFill(Color.BLACK);
                num5.setBackground(new Background(new BackgroundFill(Color.valueOf("#4dde90"), new CornerRadii(50), Insets.EMPTY)));
            });
            num5.setOnMouseExited(mouseEvent -> {
                if(!(boolean) numbersCondition.get(num5)) {
                    num5.setTextFill(Color.WHITE);
                    num5.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
                }
            });

            num6.setOnMouseEntered(mouseEvent -> {
                num6.setTextFill(Color.BLACK);
                num6.setBackground(new Background(new BackgroundFill(Color.valueOf("#4dde90"), new CornerRadii(50), Insets.EMPTY)));
            });
            num6.setOnMouseExited(mouseEvent -> {
                if(!(boolean) numbersCondition.get(num6)) {
                    num6.setTextFill(Color.WHITE);
                    num6.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
                }
            });

            num7.setOnMouseEntered(mouseEvent -> {
                num7.setTextFill(Color.BLACK);
                num7.setBackground(new Background(new BackgroundFill(Color.valueOf("#4dde90"), new CornerRadii(50), Insets.EMPTY)));
            });
            num7.setOnMouseExited(mouseEvent -> {
                if(!(boolean) numbersCondition.get(num7)) {
                    num7.setTextFill(Color.WHITE);
                    num7.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
                }
            });

            num8.setOnMouseEntered(mouseEvent -> {
                num8.setTextFill(Color.BLACK);
                num8.setBackground(new Background(new BackgroundFill(Color.valueOf("#4dde90"), new CornerRadii(50), Insets.EMPTY)));
            });
            num8.setOnMouseExited(mouseEvent -> {
                if(!(boolean) numbersCondition.get(num8)) {
                    num8.setTextFill(Color.WHITE);
                    num8.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
                }
            });

            num9.setOnMouseEntered(mouseEvent -> {
                num9.setTextFill(Color.BLACK);
                num9.setBackground(new Background(new BackgroundFill(Color.valueOf("#4dde90"), new CornerRadii(50), Insets.EMPTY)));
            });
            num9.setOnMouseExited(mouseEvent -> {
                if(!(boolean) numbersCondition.get(num9)) {
                    num9.setTextFill(Color.WHITE);
                    num9.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
                }
            });

            num10.setOnMouseEntered(mouseEvent -> {
                num10.setTextFill(Color.BLACK);
                num10.setBackground(new Background(new BackgroundFill(Color.valueOf("#4dde90"), new CornerRadii(50), Insets.EMPTY)));
            });
            num10.setOnMouseExited(mouseEvent -> {
                if(!(boolean) numbersCondition.get(num10)) {
                    num10.setTextFill(Color.WHITE);
                    num10.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
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
    public void HomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        ChangeScene(event);
        stage.setResizable(true);
    }

    public void SetRating (ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        numbersCondition.put(clickedButton,true);
        if(!(clickedButton == num1)) {
            numbersCondition.put(num1,false);
            num1.setTextFill(Color.WHITE);
            num1.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
        }
        if(!(clickedButton == num2)) {
            numbersCondition.put(num2,false);
            num2.setTextFill(Color.WHITE);
            num2.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
        }
        if(!(clickedButton == num3)) {
            numbersCondition.put(num3,false);
            num3.setTextFill(Color.WHITE);
            num3.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
        }
        if(!(clickedButton == num4)) {
            numbersCondition.put(num4,false);
            num4.setTextFill(Color.WHITE);
            num4.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
        }
        if(!(clickedButton == num5)) {
            numbersCondition.put(num5,false);
            num5.setTextFill(Color.WHITE);
            num5.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
        }
        if(!(clickedButton == num6)) {
            numbersCondition.put(num6,false);
            num6.setTextFill(Color.WHITE);
            num6.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
        }
        if(!(clickedButton == num7)) {
            numbersCondition.put(num7,false);
            num7.setTextFill(Color.WHITE);
            num7.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
        }
        if(!(clickedButton == num8)) {
            numbersCondition.put(num8,false);
            num8.setTextFill(Color.WHITE);
            num8.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
        }
        if(!(clickedButton == num9)) {
            numbersCondition.put(num9,false);
            num9.setTextFill(Color.WHITE);
            num9.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
        }
        if(!(clickedButton == num10)) {
            numbersCondition.put(num10,false);
            num10.setTextFill(Color.WHITE);
            num10.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(50), Insets.EMPTY)));
        }
        yourRating.setText(clickedButton.getText().toString()+"/10");
        clickedButton.setTextFill(Color.BLACK);
        clickedButton.setBackground(new Background(new BackgroundFill(Color.valueOf("#4dde90"), new CornerRadii(50), Insets.EMPTY)));
    }

    @FXML
    void WatchedList(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("WatchList.fxml"));
        ChangeScene(event);
        stage.setResizable(true);
    }

    @FXML
    void Logout(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        ChangeScene(event);
        stage.setResizable(false);
        stage.setWidth(1045);
        stage.setHeight(645);
        stage.setY(180);
        stage.setX(437.5);
    }

    @FXML
    void Later(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Later.fxml"));
        ChangeScene(event);
        stage.setResizable(true);
    }
}
