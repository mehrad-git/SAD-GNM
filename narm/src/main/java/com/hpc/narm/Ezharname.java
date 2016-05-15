/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hpc.narm;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    private ArrayList<Mahmoole> bar=new ArrayList<>();
    
    
    public void setEzharname(String n,String fn,String cr,String num,String d){
        name=n;
        fname=fn;
        country=cr;
        number=num;
        date=d;
    }
    
    public Long estimateCost(){
        long temp=0;
        for (Mahmoole m:bar){
            temp += m.getPrice();
        }
        cost=temp;
        return cost;
    }
    
    public int sabt(){
        //
        java.sql.PreparedStatement pst=MainApp.q.getPST("insert into ezhars (name,fname,cost,country,number,date) values(?,?,?,?,?,?);",Statement.RETURN_GENERATED_KEYS);
        try{
        pst.setString(1,name);
        pst.setString(2,fname);
       // pst.setInt(3,id);
        //pst.setString(4, way);
        pst.setLong(3,cost);
        pst.setString(4,country);
        pst.setString(5, number);
        pst.setString(6, date);
        
        //pst.executeLargeUpdate();
        pst.executeUpdate();
        ResultSet tableKeys=pst.getGeneratedKeys();
        tableKeys.next();
        int ID = tableKeys.getInt(1);
        for(Mahmoole m : bar){
            m.sabt(ID);
        }
        } catch (SQLException ex){
            System.out.println("error : "+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
    }

    void addMahmoole(Mahmoole temp) {
        bar.add(temp);
    }
}
