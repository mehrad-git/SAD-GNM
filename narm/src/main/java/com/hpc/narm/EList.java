/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hpc.narm;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 *
 * @author nasim
 */

public class EList {
    
    public static ArrayList<Ezharname> findListOfE(){
        PreparedStatement pst=MainApp.q.getPST("select * from ezhars");
        ArrayList<Ezharname> ezSet=new ArrayList<>();
        try{
            //pst.executeQuery();
            ResultSet rs=pst.executeQuery();
           // System.out.println(rs);
            while (rs.next()){
                Ezharname ez=new Ezharname();
                ez.setEzharname(rs.getString(1), rs.getString(2), rs.getString(5), rs.getString(6), rs.getString(7));
                ezSet.add(ez);
            }
        } catch (SQLException ex){
            System.out.println(ex.getLocalizedMessage());
        }
        return ezSet;
    }
}
