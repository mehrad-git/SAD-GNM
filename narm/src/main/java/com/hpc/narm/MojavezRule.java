/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hpc.narm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

/**
 *
 * @author root
 */
public class MojavezRule {
    private String description;
    private Long cost_up=null;
    private Long cost_down=null;
    private String country;
    private String date_up;
    private String date_down;
    private String name;
    private String company;
    private Double mass_up=null;
    private Double mass_down=null;
    private String number;
    private Long price_up=null;
    private Long price_down=null;
    
    
    public void setMojavez(String desc,String c1,String c2,String c,String d1,String d2,String n,String com,String m1,String m2,String num,String p1,String p2){
        description=desc;
        if (!"".equals(c1))
            cost_up=Long.valueOf(c1);
        if (!"".equals(c2))
            cost_down=Long.valueOf(c2);
        country=c;
        date_up=d1;
        date_down=d2;
        name=n;
        company=com;
        if (!"".equals(m1))
            mass_up=Double.valueOf(m1);
        if (!"".equals(m2))
            mass_down=Double.valueOf(m2);
        number=num;
        if (!"".equals(p1))
            price_up=Long.valueOf(p1);
        if (!"".equals(p2))
            price_down=Long.valueOf(p2);
    }
    
    public int sabt(){
        //
        java.sql.PreparedStatement pst=MainApp.q.getPST("INSERT INTO `gomrok`.`rules` (`description`, `cost-up`, `cost-dwon`, `country`, `date-up`, `date-down`, `name`, `company`, `mass-up`, `mass-down`, `number`, `price-up`, `price-down`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);",Statement.RETURN_GENERATED_KEYS); 
        try{
            pst.setString(1, description);
            if (cost_up != null)
                pst.setLong(2, cost_up);
            else 
                pst.setNull(2,Types.BIGINT);
            
            if (cost_down != null)
                pst.setLong(3, cost_down);
            else 
                pst.setNull(3,Types.BIGINT);
            
            if (!"".equals(country))
                pst.setString(4, country);
            else 
                pst.setNull(4,Types.VARCHAR);
            
            if (!"".equals(date_up))
                pst.setString(5, date_up);
            else 
                pst.setNull(5,Types.VARCHAR);
            
            if (!"".equals(date_down))
                pst.setString(6, date_down);
            else 
                pst.setNull(6,Types.VARCHAR);
            
            if (!"".equals(name))
                pst.setString(7, name);
            else 
                pst.setNull(7,Types.VARCHAR);
            
            if (!"".equals(company))
                pst.setString(8, company);
            else 
                pst.setNull(8,Types.VARCHAR);
            
            if (mass_up != null)
                pst.setDouble(9, mass_up);
            else 
                pst.setNull(9,Types.DOUBLE);
            
            if (mass_down != null)
                pst.setDouble(10, mass_down);
            else 
                pst.setNull(10,Types.DOUBLE);
            
            if (!"".equals(number))
                pst.setString(11, number);
            else 
                pst.setNull(11,Types.VARCHAR);
            
            if (price_up != null)
                pst.setLong(12, price_up);
            else 
                pst.setNull(12,Types.BIGINT);
            
            if (price_down != null)
                pst.setLong(13, price_down);
            else 
                pst.setNull(13,Types.BIGINT);
     
            pst.executeUpdate();
            
        } catch (SQLException ex){
            System.out.println("error : "+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
    }
}
