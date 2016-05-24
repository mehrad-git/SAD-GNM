package com.hpc.narm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


/**
 * FXML Controller class
 *
 * @author nasim
 */
public class HomeKController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private int page;
    @FXML
    Button b1,b2,b3,b4,b5,next,prev;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        page=1;
        b2.setDisable(true);
        b3.setDisable(true);
        b4.setDisable(true);
        b5.setDisable(true);
        b1.setDisable(true);
        next.setDisable(true);
        prev.setDisable(true);
        if (EList.findListOfE().size() > 5) 
            next.setDisable(false);
        show_page(page);
    } 
    
    private void show_page(int p){
        Button[] b={b1,b2,b3,b4,b5};
        //Label[] l={l1,l2,l3,l4,l5};
        
        ArrayList< Ezharname > ezList=EList.findListOfE();

        if (p==1)
            prev.setDisable(true);
        else 
            prev.setDisable(false);
        if (p*5 >= ezList.size())
            next.setDisable(true);
        else
            next.setDisable(false);
                
        int number=ezList.size();
        
        for (int i=0;i<5;i++){
            if (i >= number){
                b[i].setVisible(false);
                b[i].setText("");
            }
            else{
                b[i].setVisible(true);
                b[i].setText(ezList.get(i+(p-1)*5).getName()+ "  " +ezList.get(i+(p-1)*5).getFname());
                b[i].setDisable(false);
            }
        }
    }
    
    
    
    @FXML
    private void exit(ActionEvent event)throws IOException{
        MainApp.getMain().changeScene("login");
    }
    
    @FXML
    private void createL(ActionEvent event)throws IOException{
        MainApp.getMain().changeScene("mojavezRule");
    }
    
    @FXML
    private void createE(ActionEvent event)throws IOException{
        MainApp.getMain().changeScene("ezharname");
    }
    
    @FXML
    private void retrieveEz1(ActionEvent event) throws IOException{
        MainApp.getMain().retrieve_ezharname(5*(page-1)+1);
    }
    
    @FXML
    private void retrieveEz2(ActionEvent event) throws IOException{
        MainApp.getMain().retrieve_ezharname(5*(page-1)+2);
    }
    
    @FXML
    private void retrieveEz3(ActionEvent event) throws IOException{
        MainApp.getMain().retrieve_ezharname(5*(page-1)+3);
    }
    
    @FXML
    private void retrieveEz4(ActionEvent event) throws IOException{
        MainApp.getMain().retrieve_ezharname(5*(page-1)+4);
    }
    
    @FXML
    private void retrieveEz5(ActionEvent event) throws IOException{
        MainApp.getMain().retrieve_ezharname(5*(page-1)+5);
    }
}
