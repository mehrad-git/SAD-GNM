/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hpc.narm;

/**
 *
 * @author root
 */
public class Empolyee {
    public String first_name;
    public String last_name;
    public String username;
    private String password;
    public Integer id; 
    public static String Role;
    
    public Empolyee(Integer id,String fname,String lname,String uname,String pass,String role){
        first_name=fname;
        last_name=lname;
        username=uname;
        password=pass;
        this.id=id;
        this.Role=role;
    }
    
}
