/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hpc.narm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root
 */
public class Login {
    public static int  empolyee_login(String user,String pass) {
        //query to database
        PreparedStatement pst=MainApp.q.getPST("select * from empolyee where user=? and pass=?");
        try{
            pst.setString(1,user);
            pst.setString(2, pass);
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                Empolyee emp=new Empolyee(rs.getInt(1),rs.getString(4),rs.getString(5),user,pass,rs.getString(6));
                MainApp.setWho(emp);
                return 0;
            }
        } catch (SQLException ex){
            System.out.println(ex.getLocalizedMessage());
        }
        //if find user return empolyee object
        return 1;
    }
}
