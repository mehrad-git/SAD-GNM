/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hpc.narm;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author root
 */
public class Mahmoole {
    private String name;
    private String company;
    private double mass;
    private String number;
    private long price; //per mass unit 
    
    public Mahmoole(String n,String c,double m,String num,long p){
        name=n;
        company=c;
        mass=m;
        number=num;
        price=p;
    }
    
    public long getPrice(){
        return (long)(price*mass);
    }
    
    public void  sabt(int id){
        java.sql.PreparedStatement pst=MainApp.q.getPST("insert into bar (name,company,mass,number,price,ezharid) values(?,?,?,?,?,?);");
        try{
            pst.setString(1, name);
            pst.setString(2, company);
            pst.setDouble(3, mass);
            pst.setString(4,number);
            pst.setLong(5, price);
            pst.setInt(6, id);
            pst.executeUpdate();
        } catch(SQLException ex){
            System.out.println("error in mahmoole sabt: "+ex.getLocalizedMessage());
        }
    }
}
