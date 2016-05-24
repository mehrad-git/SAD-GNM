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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class FXMLControllerMojavez implements Initializable {
    private static boolean old;
    private int page;
    private Ezharname ez;
    @FXML
    Button b1,b2,b3,b4,b5,next,prev;
    @FXML 
    Label l1,l2,l3,l4,l5;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        page=1;
        b1.setDisable(true);
        b2.setDisable(true);
        b3.setDisable(true);
        b4.setDisable(true);
        b5.setDisable(true);
        next.setDisable(true);
        prev.setDisable(true);
        ez=(Ezharname) MainApp.getMain().get_current();
        if (ez.getMojavezCounter() > 5) 
            next.setDisable(false);
        show_page(page);
    }
    
    private void show_page(int p){
        Button[] b={b1,b2,b3,b4,b5};
        Label[] l={l1,l2,l3,l4,l5};
        if (p==1)
            prev.setDisable(true);
        else 
            prev.setDisable(false);
        if (p*5 >= ez.getMojavezCounter())
            next.setDisable(true);
        else
            next.setDisable(false);
        ArrayList<String> desc=ez.getMojavazDesc(p);
        ArrayList<Boolean> status=ez.getMojavazStat(p);
        int number=desc.size();
        for (int i=0;i<5;i++){
            if (i >= number){
                b[i].setVisible(false);
                l[i].setText("");
            }
            else{
                b[i].setVisible(true);
                if (status.get(i) || !MainApp.getMain().old)
                    b[i].setDisable(true);
                else 
                    b[i].setDisable(false);
                l[i].setText(desc.get(i));
            }
        }
    }
    
    @FXML
    private void tayeed1(ActionEvent event){
        ez=(Ezharname) MainApp.getMain().get_current();
        ez.tayeed(5*(page-1)+0);
        b1.setDisable(true);
    }
    
    @FXML
    private void tayeed2(ActionEvent event){
        ez=(Ezharname) MainApp.getMain().get_current();
        ez.tayeed(5*(page-1)+1);
        b2.setDisable(true);
    }
    
    @FXML
    private void tayeed3(ActionEvent event){
        ez=(Ezharname) MainApp.getMain().get_current();
        ez.tayeed(5*(page-1)+2);
        b3.setDisable(true);
    }
    
    @FXML
    private void tayeed4(ActionEvent event){
        ez=(Ezharname) MainApp.getMain().get_current();
        ez.tayeed(5*(page-1)+3);
        b4.setDisable(true);
    }
    
    @FXML
    private void tayeed5(ActionEvent event){
        ez=(Ezharname) MainApp.getMain().get_current();
        ez.tayeed(5*(page-1)+4);
        b5.setDisable(true);
    }
    
    public void  DisableTayeed(){
        Button[] b={b1,b2,b3,b4,b5};
        for (Button t : b){
            t.setDisable(true);
        }
    }
}
