
package com.hpc.narm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Register {
    public static int reg_emp(String fname,String lname,String uname,String role,String pass){
        try {
            PreparedStatement pst1 = MainApp.q.getPST("SELECT COUNT(*) FROM Empolyee");
            ResultSet tedad_tuple = pst1.executeQuery();
            tedad_tuple.next();
            int id,tedad=tedad_tuple.getInt(1),recordsAffected;
            id=tedad+1;
            PreparedStatement pst2 = MainApp.q.getPST("insert into Empolyee(id, user, pass, first, last, role) values(?,?,?,?,?,?)");
            pst2.setInt(1,id);
            pst2.setString(2,uname);
            pst2.setString(3,pass);
            pst2.setString(4,fname);
            pst2.setString(5,lname);
            pst2.setString(6,role);
            recordsAffected=pst2.executeUpdate();
            if(recordsAffected<1)
                return -1;
            else
                return 0;
        }catch (java.sql.SQLException ex1){
            System.out.println(ex1.getMessage());
            return -2;
        }
    }
}