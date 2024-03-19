package proj;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class guiStart extends Application{
    TextField user = new TextField();
    TextField pw = new TextField();
    Button login = new Button("Login");
    Stage primaryStage = new Stage();
    GridPane gridPane = new GridPane(); //init the pane 
    login session = new login(user.getText(), pw.getText());
    Group group = new Group();

    @Override
    public void start(Stage primaryStage){
        group.getChildren().addAll(gridPane);
        gridPane.setHgap(10); //set grid cell boundaries
        gridPane.setVgap(10);
        gridPane.add(new Label("Username:"), 0, 0);
        gridPane.add(new Label("Password:"), 0, 1);
        gridPane.add(new Button("Register"), 0, 2);
        gridPane.add(login, 1, 2);
        gridPane.add(user, 1, 0);
        gridPane.add(pw, 1, 1);

        login.setOnAction(this::loginHandler);

        Scene scene = new Scene(group);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
    public void loginHandler(ActionEvent e){
        boolean success = session.attemptLogin();
        if(success){

        }
        else{
            Group temp = new Group();
            temp = group;
            group.getChildren().clear();
            TextField tf = new TextField("Login failure");
            HBox hbox = new HBox(tf);
            group.getChildren().addAll(hbox);

            try{
                Thread.sleep(5000);
            }catch(InterruptedException i){
                i.printStackTrace();
            }
            group = temp;
        }
    }



    public static void main(String[] args) { 
        launch(args);
      }
}
