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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    private ArrayList<mojavezStatus> rule_id=new ArrayList<>();

    private void searchKala() {
        java.sql.PreparedStatement pst=MainApp.q.getPST("SELECT * FROM `bar` WHERE ezharid=? ;");
        try{
            pst.setInt(1,id);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                String name=rs.getString(1);
                String company = rs.getString(2);
                Double mass=rs.getDouble(3);
                String number=rs.getString(4);
                Long price = rs.getLong(5);
                bar.add(new Mahmoole(name,company,mass,number, price));
            }
        } catch (SQLException ex){
            System.out.println("error in retrieving Ezharname.searching kala: "+ex.getLocalizedMessage());  
        } 
    }

    private void retrieveRules() {
        java.sql.PreparedStatement pst=MainApp.q.getPST("SELECT * FROM `ezhar_mojavez` WHERE ezhar_id=? ;");
        try{
            pst.setInt(1,id);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                mojavezStatus mj=new mojavezStatus();
                mj.id=rs.getInt(2);
                if (rs.getInt(3)==1)
                    mj.status=true;
                else mj.status=false;
                rule_id.add(mj);
            }
        } catch (SQLException ex){
            System.out.println("error in retrieving Ezharname.searching rules: "+ex.getLocalizedMessage());  
        } 
    }
    
    private  class mojavezStatus{
        public int id;
        public boolean status;
    }
    
    
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
        searchRules();
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
        this.id=ID;
        for(Mahmoole m : bar){
            m.sabt(ID);
        }
        } catch (SQLException ex){
            System.out.println("error : "+ex.getLocalizedMessage());
            return 1;
        }
        if (sabt_mojavez(this.id)==0)
            return 0;
        else 
            return 1;
    }

    void addMahmoole(Mahmoole temp) {
        bar.add(temp);
    }
    
    public Mahmoole getWay(int id){
        return bar.get(id);
    }
    
    public int get_way_count(){
        return bar.size();
    }
    
    public void searchRules() {
        rule_id.clear();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.PreparedStatement pst=MainApp.q.getPST("select * from rules");
        try{
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                Long cost_up = rs.getLong(3);
                if (rs.wasNull()){
                    cost_up=null;
                }
                Long cost_down = rs.getLong(4);
                if (rs.wasNull()){
                    cost_down=null;
                }
                String _country=rs.getString(5);
                if (rs.wasNull()){
                    _country=null;
                }
                String temp=rs.getString(6);
                Date date_up;
                if (rs.wasNull()){
                    date_up=null;
                }
                else{
                    date_up=(Date) formatter.parse(temp);
                }
                temp=rs.getString(7);
                Date date_down;
                if (rs.wasNull()){
                    date_down=null;
                }
                else{
                    date_down=(Date) formatter.parse(temp);
                }
                String kala_name=rs.getString(8);
                if (rs.wasNull()){
                    kala_name=null;
                }
                String kala_company=rs.getString(9);
                if (rs.wasNull()){
                    kala_company=null;
                }
                Double mass_up = rs.getDouble(10);
                if (rs.wasNull()){
                    mass_up=null;
                }
                Double mass_down = rs.getDouble(11);
                if (rs.wasNull()){
                    mass_down=null;
                }
                String kala_number=rs.getString(12);
                if (rs.wasNull()){
                    kala_number=null;
                }
                Long price_up=rs.getLong(13);
                if (rs.wasNull()){
                    price_up=null;
                }
                Long price_down=rs.getLong(14);
                if (rs.wasNull()){
                    price_down=null;
                }
                for (Mahmoole m :bar){
                    long p =m.getPrice();
                    if ((cost_up==null || cost_up >= p )&& (cost_down==null || cost_down <= p) && (_country==null || _country.equals(this.country)) && (date_up==null || date_up.compareTo(formatter.parse(this.date)) >= 0) && (date_down==null || date_down.compareTo(formatter.parse(this.date)) <= 0) && (kala_name==null || kala_name.equals(m.getName())) && (kala_company==null || kala_company.equals(m.getCompany())) && (mass_up==null || mass_up >= m.getMass()) && (mass_down==null || mass_down <= m.getMass()) && (kala_number==null || kala_number.equals(m.getNumber())) && (price_up==null || price_up >= m.pricePerMass()) && (price_down==null || price_down <= m.pricePerMass()) ){
                        mojavezStatus temp2 =new mojavezStatus();
                        temp2.id=rs.getInt(1);
                        temp2.status=false;
                        rule_id.add(temp2);
                    }
                }
            }
        } catch ( SQLException ex){
            System.out.println("error in search rules: "+ex.getLocalizedMessage());
        } catch (ParseException ex){
            System.out.println("error in search rules: "+ex.getLocalizedMessage());
        }
        
    }
    
    private int sabt_mojavez(int id){
        for (mojavezStatus m:rule_id){
            try{
                java.sql.PreparedStatement pst=MainApp.q.getPST("insert into ezhar_mojavez (ezhar_id,rule,state) values(?,?,?);");
                pst.setInt(1,id);
                pst.setInt(2,m.id);
                if (m.status)
                    pst.setInt(3,1);
                else 
                    pst.setInt(3,0);
                pst.executeUpdate();
            } catch (SQLException ex){
                System.out.println("error in sabt_mojavez: "+ex.getLocalizedMessage());
                return 1;
            }
        }
        return 0;
    }
    
    public ArrayList<String> getMojavazDesc(int page){
        ArrayList<String> result=new ArrayList<>();
        for (int i=page*5-5;i<page*5;i++){
            if (i < rule_id.size()){
                try{
                    java.sql.PreparedStatement pst=MainApp.q.getPST("select description from rules where id=?");
                    pst.setInt(1,rule_id.get(i).id);
                    ResultSet rst=pst.executeQuery();
                    if (rst.next())
                        result.add(rst.getString(1));
                } catch (SQLException ex){
                    System.out.println("error in getMojavezDesc: "+ex.getLocalizedMessage());
                }
            }
        }
        return result;
    }
    
    public ArrayList<Boolean> getMojavazStat(int page){
       ArrayList<Boolean> result=new ArrayList<>(); 
       for (int i=page*5-5;i<page*5;i++){
           if (i < rule_id.size())
               result.add(rule_id.get(i).status);
       }
       return result;
    }
    
    public int getMojavezCounter(){
        return rule_id.size();
    }
    
    public Ezharname(int id){
        java.sql.PreparedStatement pst=MainApp.q.getPST("SELECT * FROM `ezhars` WHERE id=? ;");
        try{
            pst.setInt(1,id);
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
               name=rs.getString(1);
               fname=rs.getString(2);
               cost=rs.getLong(4);
               country=rs.getString(5);
               number=rs.getString(6);
               date=rs.getString(7);
               this.id=id;
               searchKala();
               retrieveRules();
            }
            
        } catch (SQLException ex){
            System.out.println("error in retrieving Ezharname: "+ex.getLocalizedMessage());
        }
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getFname(){
        return fname;
    }
    
    public String getCountry(){
        return country;
    }
    
    public String getNumber(){
        return number;
    }
    
    public Ezharname(){
        
    }
    
    protected void tayeed(int i){
        rule_id.get(i).status=true;
        try{
                java.sql.PreparedStatement pst=MainApp.q.getPST("update ezhar_mojavez set state=? where ezhar_id=? and rule=?;");
                pst.setInt(1,1);
                pst.setInt(2, id);
                pst.setInt(3,rule_id.get(i).id);
                pst.executeUpdate();
            } catch (SQLException ex){
                System.out.println("error in tayeed_mojavez: "+ex.getLocalizedMessage());
            }
    }
}
