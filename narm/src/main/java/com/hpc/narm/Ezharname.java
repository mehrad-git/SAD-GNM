/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hpc.narm;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root
 */
public class Ezharname {
    private String name;
    private String fname;
    private Integer id;
    private String way;
    private Long cost;
    private String country;
    private String number,date;
    
    public Ezharname(String n,String fn,Integer i,String w,Long c,String cr,String num,String d){
        name=n;
        fname=fn;
        id=i;
        way=w;
        cost=c;
        country=cr;
        number=num;
        date=d;
    }
    
    public int sabt(){
        //
        java.sql.PreparedStatement pst=MainApp.q.getPST("insert into ezhars (name,fname,id,way,cost,country,number,date) values(?,?,?,?,?,?,?,?);");
        try{
        pst.setString(1,name);
        pst.setString(2,fname);
        pst.setInt(3,id);
        pst.setString(4, way);
        pst.setLong(5,cost);
        pst.setString(6,country);
        pst.setString(7, number);
        pst.setString(8, date);
        
        //pst.executeLargeUpdate();
        pst.executeUpdate();
        } catch (SQLException ex){
            System.out.println("error : "+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
    }
}
