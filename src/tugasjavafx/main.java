/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasjavafx;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class main extends Application {

   
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = createRegistrationFormPane();
        addUIControls(gridPane);
        Scene scene = new Scene(gridPane, 800, 500);	
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }


    private GridPane createRegistrationFormPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(40.0));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        Label headerLabel = new Label("Registration Form");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 1,0);
        GridPane.setHalignment(headerLabel, HPos.LEFT);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        Label FirstNameLabel = new Label("First Name : ");
        gridPane.add(FirstNameLabel, 0,1);

        TextField FirstNameField = new TextField();
        FirstNameField.setPrefHeight(40);
        gridPane.add(FirstNameField, 1,1);

        Label LastNameLabel = new Label("Last Name: ");
        gridPane.add(LastNameLabel, 0, 2);

        TextField LastNameField = new TextField();
        LastNameField.setPrefHeight(40);
        gridPane.add(LastNameField, 1, 2);

        Label EmailAddressLabel = new Label("E-Mail Address : ");
        gridPane.add(EmailAddressLabel, 0, 3);

        TextField EmailAddressField  = new TextField();
        EmailAddressField.setPrefHeight(40);
        gridPane.add(EmailAddressField , 1, 3);
        
        Label ContactNoLabel = new Label("Contact No : ");
        gridPane.add(ContactNoLabel, 0, 4);
        
        TextField ContactNoField  = new TextField();
        ContactNoField.setPrefHeight(40);
        gridPane.add(ContactNoField , 1, 4);
        
        Label passwordLabel = new Label("Password : ");
        gridPane.add(passwordLabel, 0, 5);

        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        gridPane.add(passwordField, 1, 5);
        
        Label PasswordLabel = new Label("confirm Password : ");
        gridPane.add(PasswordLabel, 0, 6);
        
        PasswordField ConfirmpasswordLabel = new PasswordField();
        ConfirmpasswordLabel.setPrefHeight(40);
        gridPane.add(ConfirmpasswordLabel, 1, 6);

        Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 7);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(FirstNameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your First name");
                    return;
                }
                 if(LastNameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your Last name");
                    return;
                }
                if(EmailAddressField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your email id");
                    return;
                }
                 if(ContactNoField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your Contact No");
                    return;
                }
                if(passwordField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a password");
                    
                }
       
                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Welcome " + FirstNameField.getText());
            }
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}