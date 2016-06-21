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
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author root
 */
public class RuleController {
    private List rules=new ArrayList<>();
    private String[] range_fields={"cost","date","mass","price"};
    private static RuleController instance=new RuleController();
    private boolean updated=false;
    private RuleController(){}
    public static RuleController getRuleController(){
        return instance;
    }
    public void update(){
        rules.clear();
        RuleDB rdb=new RuleDB();
        rules=rdb.getRules();
        updated=true;
    }
    
    public void load(){
        if (!updated){
            this.update();
        }
    }
    
    public List compare(Map input){
        List res=new ArrayList<Integer>();
        for (Object r : rules){
            boolean matched=true;
            Map rule = (Map) r;
            for (Object k:input.keySet()){
                String key = (String) k ;
                if (Arrays.asList(range_fields).contains(key)){
                    String k1=key+"_up";
                    String k2=key+"_down";
                    if (key == "date"){
                        Date d = (Date)input.get(k);
                        if (rule.get((Object)k1) != null){
                            Date d_up=(Date)rule.get((Object)k1);
                            if (d_up.compareTo(d)< 0){
                                matched = false;
                                break;
                            }
                        }
                        if (rule.get((Object)k2) != null){
                            Date d_down=(Date)rule.get((Object)k2);
                            if (d_down.compareTo(d)> 0){
                                matched = false;
                                break;
                            }
                        }
                    }
                    else if (key == "cost" || key == "price"){///long
                        long x=(long)input.get(k);
                        if (rule.get((Object)k1) != null && (long)rule.get((Object)k1) < x){
                            matched=false;
                            break;
                        }
                        if (rule.get((Object)k2) != null && (long)rule.get((Object)k2) > x){
                            matched=false;
                            break;
                        }
                    }
                    else{
                        double x = (double)input.get(k);
                        if (rule.get((Object)k1) != null && (double)rule.get((Object)k1) < x){
                            matched=false;
                            break;
                        }
                        if (rule.get((Object)k2) != null && (double)rule.get((Object)k2) > x){
                            matched=false;
                            break;
                        }
                    }
                    
                }
                else{
                    if (key == "kala_name"){
                        if (rule.get(k) == null)
                            continue;
                        String raw = (String)rule.get(k);
                        String[] names = raw.split("-");
                        if (!Arrays.asList(names).contains((String)input.get(k))){
                            matched=false;
                            break;
                        }
                    }
                    else if (rule.get(k) != null  && !rule.get(k).equals(input.get(k))){
                        matched=false;
                        break;
                    }
                }
            }
            if (matched == true )
                res.add(rule.get("id"));
        }
        //////
        return res;
    }
}
