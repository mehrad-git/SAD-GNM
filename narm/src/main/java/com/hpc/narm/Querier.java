/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hpc.narm;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class Querier {
    private Connection con ;
    //private PreparedStatement pst = null;
    private Statement st = null;
    //private ResultSet rs = null;

    private String url = "jdbc:mysql://localhost:8889/gomrok";
    private String user = "root";
    private String password = "root";
    
    public Querier()  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url+"?useUnicode=true&characterEncoding=UTF-8", user, password);
        } catch (SQLException ex){
            System.out.print("error connecting database:"+ex.getLocalizedMessage());
        } catch (ClassNotFoundException ex){
            System.out.print("error connecting database:"+ex.getLocalizedMessage());
        }
    }
    
    public PreparedStatement getPST(String query){
        try {
            return con.prepareStatement(query);
        } catch (SQLException ex){
            System.out.print("error getting prepared statement: "+ex.getLocalizedMessage());
            return null;
        }
    }
}
