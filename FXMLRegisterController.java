package com.hpc.narm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLRegisterController implements Initializable {
    @FXML
    private PasswordField pass,repass;
    @FXML
    private TextField name,lastname,user,role;
    @FXML
    private Label general_err,pass_err,success;

    //private Label error;
    @FXML
    private void cancel(ActionEvent event) throws IOException {
        MainApp.getMain().changeScene("main","/fxml/Scene.fxml");
    }
    @FXML
    private void register(ActionEvent event)throws IOException{
        // initialize
        general_err.setVisible(false);
        pass_err.setVisible(false);
        success.setVisible(false);

        if(!(pass.getText()).equals(repass.getText())){
            pass_err.setVisible(true);
            return;
        }
        int retVal;
        retVal=Register.reg_emp(name.getText(),lastname.getText(),user.getText(),role.getText(),pass.getText());
        if(retVal==0){
            success.setVisible(true);
        }
        else
            general_err.setVisible(true);
    }

    public void initialize(URL url, ResourceBundle rb){
        general_err.setVisible(false);
        pass_err.setVisible(false);
        success.setVisible(false);
    }
}
