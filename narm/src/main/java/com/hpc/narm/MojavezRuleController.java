package com.hpc.narm;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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

public class MojavezRuleController implements Initializable {
    
    
    @FXML
    private TextField desc,cost_up,cost_down,country,number,name,company,mass_up,mass_down,price_up,price_down;
    @FXML
    private DatePicker date_up,date_down;
    
    @FXML 
    private Pane message;
    
    @FXML
    private void sabt(ActionEvent event){
        MojavezRule mj=(MojavezRule) MainApp.getMain().get_current();
        String du,dd;
        LocalDate d1=date_up.getValue();
        LocalDate d2=date_down.getValue();
        if (d1==null)
            du="";
        else
            du=d1.toString();
        if (d2==null)
            dd="";
        else
            dd=d2.toString();
        mj.setMojavez(desc.getText(),cost_up.getText(),cost_down.getText(),country.getText(),du,dd,name.getText(),company.getText(),mass_up.getText(),mass_down.getText(),number.getText(),price_up.getText(),price_down.getText());
        if(mj.sabt()==0)
            message.setVisible(true);
    }
    
    @FXML
    private void cancel(ActionEvent event) throws IOException{
        MainApp.getMain().changeScene("karshenas");
    }
    
    @FXML
    private void back(ActionEvent event) throws IOException{
        MainApp.getMain().changeScene("home");
    }
    
    
    public void initialize(URL url, ResourceBundle rb){
        message.setVisible(false);
    }    
}
