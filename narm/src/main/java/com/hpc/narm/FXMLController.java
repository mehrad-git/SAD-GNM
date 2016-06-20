package com.hpc.narm;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class FXMLController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private AnchorPane loginPage;
    
    @FXML
    private PasswordField passField;
    @FXML
    private TextField userField;
    @FXML 
    private Label error;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    
    //for login!
    @FXML
    private void log_in(javafx.event.ActionEvent event) throws IOException{
        String username = userField.getText();
        String password = passField.getText();
        if (Login.empolyee_login(username, password)==1)
            error.setVisible(true);
        else {
            error.setVisible(false);
            MainApp.getMain().changeScene("home");
        }
    }
    
    @FXML
    private void go_register(ActionEvent event) throws IOException{
        MainApp.getMain().changeScene("register");
    }
    
    @FXML
    private void test(ActionEvent event) throws IOException{
        //MainApp.getMain().changeScene("mojavezRule");
        //MainApp.getMain().retrieve_ezharname(3);
    }
    
    
    
    public void initialize(URL url, ResourceBundle rb){
        error.setVisible(false);
        
    }    
}
