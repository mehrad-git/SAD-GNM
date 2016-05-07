package com.hpc.narm;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class FXMLController2 implements Initializable {
    
    @FXML
    private TextField name,fname,id,way,cost,country,number;
    @FXML
    private DatePicker date;
    
    @FXML 
    private Pane message;
    
    @FXML
    private void sabt(ActionEvent event){
        Ezharname ez = new Ezharname(name.getText(),fname.getText(), Integer.valueOf(id.getText()),way.getText(),Long.valueOf(cost.getText()), country.getText(),number.getText(),date.getValue().toString());
        if (ez.sabt()==0)
            message.setVisible(true);
    }
    @FXML
    private void cancel(ActionEvent event) throws IOException{
        MainApp.getMain().changeScene("karshenas");
    }
    
    
    public void initialize(URL url, ResourceBundle rb){
        message.setVisible(false);
    }    
}
