package com.hpc.narm;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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

public class FXMLController2 implements Initializable {
    
    private boolean old=false;
    @FXML
    private TextField name,fname,id,way,cost,country,number,mname,mnumber,mmass,mcompany,mprice;
    @FXML
    private DatePicker date;
    
    @FXML 
    private Pane message;
    
    @FXML
    private void sabt(ActionEvent event){
        Ezharname ez=(Ezharname) MainApp.getMain().get_current();
        ez.setEzharname(name.getText(),fname.getText(), country.getText(),number.getText(),date.getValue().toString());
        ez.estimateCost();
        if (ez.sabt()==0)
            message.setVisible(true);
    }
    
    @FXML
    private void addway(ActionEvent event){
        Ezharname ez=(Ezharname) MainApp.getMain().get_current();
        Mahmoole temp=new Mahmoole(mname.getText(),mcompany.getText(),Double.valueOf(mmass.getText()), mnumber.getText(), Long.valueOf(mprice.getText()));
        ez.addMahmoole(temp);
        mname.clear();
        mcompany.clear();
        mmass.clear();
        mnumber.clear();
        mprice.clear();
        cost.setText(String.valueOf(ez.estimateCost()));
    }
    
    @FXML
    private void cancel(ActionEvent event) throws IOException{
        MainApp.getMain().changeScene("karshenas");
    }
    
    @FXML
    private void l(ActionEvent event) throws IOException{
        if (old)
            MainApp.getMain().changeScene("mojavez-old");
        else{
            Ezharname ez=(Ezharname) MainApp.getMain().get_current();
            ez.setEzharname(name.getText(),fname.getText(), country.getText(),number.getText(),date.getValue().toString());
            ez.searchRules();
            MainApp.getMain().changeScene("mojavez-new");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        message.setVisible(false);
        old=false;
    }

    public void setOld(){
        old=true;
    }
}
