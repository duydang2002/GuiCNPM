package project.app;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import project.Formatting.*;

public class Login extends Pane
{
    //Components:
    private ImageView BackgroundImage;
    private Rectangle BackgroundRec1, BackgroundRec2;
    private FormattedText LoginTitle;
    private FormattedText UsernameTitle, PasswordTitle;
    private Rectangle UsernameTypeBox, PasswordTypeBox;
    private TextField UsernameTypeField;
    private PasswordField PasswordTypeField;
    private FormattedText LoginButtonText;
    private Rectangle LoginButtonBox;
    private Button LoginButtonFrame;
    private FormattedText LoginNotification;

    private Color MainColor=Color.rgb(231, 231, 238);
    private Font TextFont=CustomFont.createFont("GreycliffCF-Medium", "otf", 14);

    private void signincheck()
    {
        boolean check; //=true/false
        /*
        Insert code here to check signing in, return boolean check.
        Get text by:
        UsernameTypeField.getText();
        PasswordTypeField.getText();
         */

        LoginNotification.setVisible(true);
        if(check==false)
        {
            LoginNotification.setText("Wrong username or password", false);
            LoginNotification.setLayoutX(572); LoginNotification.setLayoutY(476);
            LoginNotification.setFill(Color.rgb(233, 63, 40));
        }
        else
        {
            LoginNotification.setText("Login successfully", false);
            LoginNotification.setLayoutX(606); LoginNotification.setLayoutY(476);
            LoginNotification.setFill(Color.rgb(40, 233, 59));
        }
    }

    //Build:
    private void build()
    {
        //Background:
        try {BackgroundImage=new ImageView(new Image(new FileInputStream("materials/BackgroundImage.gif")));}
        catch(FileNotFoundException f) {}
        BackgroundImage.setLayoutX(0); BackgroundImage.setLayoutY(0);
        BackgroundImage.setFitWidth(800); BackgroundImage.setFitHeight(600);
        BackgroundImage.setCache(true); BackgroundImage.setSmooth(true);

        Stop[] GradientStops1={new Stop(0, Color.rgb(15, 19, 24, 0)), new Stop(1, Color.rgb(15, 19, 24, 0.8))};
        BackgroundRec1=new Rectangle(500, 600);
        BackgroundRec1.setFill(new LinearGradient(0, 0.5, 1, 0.5, true, CycleMethod.NO_CYCLE, GradientStops1));
        BackgroundRec1.setLayoutX(0); BackgroundRec1.setLayoutY(0);

        Stop[] GradientStops2={new Stop(0, Color.rgb(14, 19, 24, 0.8)), new Stop(1, Color.rgb(15, 19, 24, 1))};
        BackgroundRec2=new Rectangle(300, 600);
        BackgroundRec2.setFill(new LinearGradient(0, 0.5, 1, 0.5, true, CycleMethod.NO_CYCLE, GradientStops2));
        BackgroundRec2.setLayoutX(500); BackgroundRec2.setLayoutY(0);

        //LoginTitle:
        LoginTitle=new FormattedText("LOGIN", -0.5, 0, false);
        LoginTitle.setFill(MainColor);
        LoginTitle.setFont(CustomFont.createFont("GreycliffCF-Bold", "otf", 32));
        LoginTitle.setLayoutX(601); LoginTitle.setLayoutY(84);

        //Username:
        UsernameTitle=new FormattedText("Username", -0.5, 0, false);
        UsernameTitle.setFill(MainColor);
        UsernameTitle.setFont(TextFont);
        UsernameTitle.setLayoutX(549); UsernameTitle.setLayoutY(170);

        UsernameTypeBox=new Rectangle(220, 30, Color.TRANSPARENT);
        UsernameTypeBox.setArcWidth(10); UsernameTypeBox.setArcHeight(10);
        UsernameTypeBox.setStroke(MainColor); UsernameTypeBox.setStrokeType(StrokeType.INSIDE); UsernameTypeBox.setStrokeWidth(2);
        UsernameTypeBox.setLayoutX(540); UsernameTypeBox.setLayoutY(190);

        UsernameTypeField=new TextField();
        UsernameTypeField.setPromptText("Type username here...");
        UsernameTypeField.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 8px; -fx-text-fill: #E7E7EE;");
        UsernameTypeField.setFont(CustomFont.createFont("GreycliffCF-Medium", "otf", 13));
        UsernameTypeField.setAlignment(Pos.CENTER_LEFT);
        UsernameTypeField.setPrefWidth(222); UsernameTypeField.setPrefHeight(20);
        UsernameTypeField.setLayoutX(540); UsernameTypeField.setLayoutY(189);
        UsernameTypeField.focusedProperty().addListener
        (
            new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
                {
                    if (newPropertyValue) {UsernameTypeField.setPromptText("");}
                    else {UsernameTypeField.setPromptText("Type username here...");}
                }
            }
        );

        //Password:
        PasswordTitle=new FormattedText("Password", -0.5, 0, false);
        PasswordTitle.setFill(MainColor);
        PasswordTitle.setFont(TextFont);
        PasswordTitle.setLayoutX(549); PasswordTitle.setLayoutY(250);

        PasswordTypeBox=new Rectangle(220, 30, Color.TRANSPARENT);
        PasswordTypeBox.setArcWidth(10); PasswordTypeBox.setArcHeight(10);
        PasswordTypeBox.setStroke(MainColor); PasswordTypeBox.setStrokeType(StrokeType.INSIDE); PasswordTypeBox.setStrokeWidth(2);
        PasswordTypeBox.setLayoutX(540); PasswordTypeBox.setLayoutY(270);

        PasswordTypeField=new PasswordField();
        PasswordTypeField.setPromptText("Type password here...");
        PasswordTypeField.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 8px; -fx-text-fill: #E7E7EE;");
        PasswordTypeField.setFont(CustomFont.createFont("GreycliffCF-Medium", "otf", 13));
        PasswordTypeField.setSkin(new PasswordMaskSkin(PasswordTypeField, '\u0078'));
        PasswordTypeField.setAlignment(Pos.CENTER_LEFT);
        PasswordTypeField.setPrefWidth(222); PasswordTypeField.setPrefHeight(20);
        PasswordTypeField.setLayoutX(540); PasswordTypeField.setLayoutY(269);
        PasswordTypeField.focusedProperty().addListener
        (
            new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
                {
                    if (newPropertyValue) {PasswordTypeField.setPromptText("");}
                    else {PasswordTypeField.setPromptText("Type password here...");}
                }
            }
        );

        //LoginButton:
        LoginButtonText=new FormattedText("Login", -0.5, 0, false);
        LoginButtonText.setFill(MainColor);
        LoginButtonText.setFont(TextFont);
        LoginButtonText.setLayoutX(633); LoginButtonText.setLayoutY(355);

        LoginButtonBox=new Rectangle(80, 30, Color.TRANSPARENT);
        LoginButtonBox.setArcWidth(10); LoginButtonBox.setArcHeight(10);
        LoginButtonBox.setStroke(MainColor); LoginButtonBox.setStrokeType(StrokeType.INSIDE); LoginButtonBox.setStrokeWidth(2);
        LoginButtonBox.setLayoutX(610); LoginButtonBox.setLayoutY(350);

        LoginButtonFrame=new Button();
        LoginButtonFrame.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 5px;");
        LoginButtonFrame.setLayoutX(610); LoginButtonFrame.setLayoutY(350);
        LoginButtonFrame.setPrefWidth(80); LoginButtonFrame.setPrefHeight(30);
        LoginButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent a) {signincheck();}
            }
        );
        LoginButtonFrame.setOnMouseEntered
        (
            new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent mouseEvent)
                {
                    LoginButtonBox.setFill(MainColor);
                    LoginButtonText.setFill(Color.TRANSPARENT);
                }
            }
        );
        LoginButtonFrame.setOnMouseExited
        (
            new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent mouseEvent)
                {
                    LoginButtonBox.setFill(Color.TRANSPARENT);
                    LoginButtonText.setFill(MainColor);
                }
            }
        );

        //LoginNotification:
        LoginNotification=new FormattedText("", -0.5, 0, false);
        LoginNotification.setFont(CustomFont.createFont("GreycliffCF-Regular", "otf", 12));
        LoginNotification.setVisible(false);

        //Layout:
        this.getChildren().addAll(BackgroundImage, BackgroundRec1, BackgroundRec2, LoginTitle, UsernameTitle, UsernameTypeBox, UsernameTypeField, PasswordTitle, PasswordTypeBox, PasswordTypeField, LoginButtonText, LoginButtonBox, LoginButtonFrame, LoginNotification);
        this.setLayoutX(0); this.setLayoutY(0);
        this.setPrefWidth(800); this.setPrefHeight(600);
    }

    //Constructor:
    public Login() {build();}
}