package EECS_Proj;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class gui extends Application{
    TextField user = new TextField();
    TextField pw = new TextField();
    Button login = new Button("Login");

    @Override
    public void start(Stage primaryStage){
        GridPane gridPane = new GridPane(); //init the pane 
        gridPane.setHgap(10); //set grid cell boundaries
        gridPane.setVgap(10);
        gridPane.add(new Label("Username:"), 0, 0);
        gridPane.add(new Label("Password:"), 0, 1);
        gridPane.add(new Button("Register"), 0, 2);
        gridPane.add(login, 1, 2);
        gridPane.add(user, 1, 0);
        gridPane.add(pw, 1, 1);

        login session = new login(user.getText(), pw.getText());
        login.setOnAction((e) -> loginHandler(session.attemptLogin()));

        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void loginHandler(boolean success){
        if(success){

        }
    }

    public static void main(String[] args) { 
        launch(args);
      }
}
