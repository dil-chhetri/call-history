/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.RecordDAO;
import DAO.impl.RecordDAOImpl;
import dbconfig.DbConnection;
import java.sql.ResultSet;
import model.RecordModel;
/**
 *
 * @author dolch
 */
public class RecordController {
    
    public int call_id;
    public String name;
    public String phone;
    public String duration;
    public String zone;
    
    
    public RecordController(int call_id, String name, String phone, String duration, String zone){
    this.call_id = call_id;
    this.name = name;
    this.phone = phone;
    this.duration = duration;
    this.zone = zone;
    }
    
    public RecordController( String name, String phone, String duration, String zone){
    
    this.name = name;
    this.phone = phone;
    this.duration = duration;
    this.zone = zone;
    }
    
     public RecordController() {
        
    }
    
              public ResultSet getCallList() {
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM call_records";
            rs = DbConnection.select(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
              
              
              public boolean addRecord(RecordController rc){
    RecordDAO rd = new RecordDAOImpl();
    RecordModel rm = new RecordModel();
    rm.setName(rc.name);
    rm.setPhone(rc.phone);
    rm.setDuration(rc.duration);
    rm.setZone(rc.zone);
    if(rd.create(rm)){
        return true;
    }
    return false;
    }
              
                public boolean updateRecord(RecordController rc){
       RecordDAO rd = new RecordDAOImpl();
        RecordModel rm = new RecordModel();
       
        rm.setCall_id(rc.call_id);
        
        rm.setName(rc.name);

        rm.setPhone(rc.phone);
        rm.setDuration(rc.duration);
        
        rm.setZone(rc.zone);
        
            
        
        
        if(rd.update(rm)){
            return true;
        }
        return false;
    }
                
                 public boolean deleteRecord(RecordController rc){
             RecordDAO rd = new RecordDAOImpl();
        RecordModel rm = new RecordModel();
        rm.setCall_id(rc.call_id);
        
            
      
        
        if(rd.delete(rm)){
            return true;
        }
        return false;
    }
    
}
