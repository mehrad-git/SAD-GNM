/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hpc.narm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mehrad
 */
public class RuleDB {
    public List getRules(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.PreparedStatement pst=MainApp.q.getPST("select * from rules");
        List rules=new ArrayList<>();
        try{
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                Map rule=new HashMap<>();
                Long cost_up = rs.getLong(3);
                if (rs.wasNull()){
                    cost_up=null;
                }
                rule.put("cost_up",cost_up);
                ////////
                Long cost_down = rs.getLong(4);
                if (rs.wasNull()){
                    cost_down=null;
                }
                rule.put("cost_down",cost_down);
                /////////
                String _country=rs.getString(5);
                if (rs.wasNull()){
                    _country=null;
                }
                rule.put("country",_country);
                ////////
                String temp=rs.getString(6);
                Date date_up;
                if (rs.wasNull()){
                    date_up=null;
                }
                else{
                    date_up=(Date) formatter.parse(temp);
                }
                rule.put("date_up",date_up);
                ///////
                temp=rs.getString(7);
                Date date_down;
                if (rs.wasNull()){
                    date_down=null;
                }
                else{
                    date_down=(Date) formatter.parse(temp);
                }
                rule.put("date_down",date_down);
                //////
                String kala_name=rs.getString(8);
                if (rs.wasNull()){
                    kala_name=null;
                }
                rule.put("kala_name",kala_name);
                //////
                String kala_company=rs.getString(9);
                if (rs.wasNull()){
                    kala_company=null;
                }
                rule.put("company",kala_company);
                ///////
                Double mass_up = rs.getDouble(10);
                if (rs.wasNull()){
                    mass_up=null;
                }
                rule.put("mass_up",mass_up);
                //////
                Double mass_down = rs.getDouble(11);
                if (rs.wasNull()){
                    mass_down=null;
                }
                rule.put("mass_down",mass_down);
                /////
                String kala_number=rs.getString(12);
                if (rs.wasNull()){
                    kala_number=null;
                }
                rule.put("kala_number",kala_number);
                /////
                Long price_up=rs.getLong(13);
                if (rs.wasNull()){
                    price_up=null;
                }
                rule.put("price_up",price_up);
                /////
                Long price_down=rs.getLong(14);
                if (rs.wasNull()){
                    price_down=null;
                }
                rule.put("price_down",price_down);
                /////
                rule.put("id",rs.getInt(1));
                rules.add(rule);
            }
        } catch(SQLException ex){
            System.out.println("error 3365"+ex.getLocalizedMessage());
        } catch (ParseException ex){
            System.out.println("error 3366"+ex.getLocalizedMessage());
        }
        return rules;
    }
    
    public int test(){
        return 2;
    }
}
