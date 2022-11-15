package project.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application
{
    //Launcher:
    public static void main(String[] args) {launch();}

    //Build:
    @Override
    public void start(Stage stage) throws IOException
    {
        Scene scene = new Scene(new Login());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


}