/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import DAO.ReportDAO;
import DAO.impl.ReportDAOImpl;
import dbconfig.DbConnection;
import java.sql.ResultSet;
import model.ReportModel;
/**
 *
 * @author dolch
 */
public class ReportController {
    public int rep_id;
    public String title;
    public String description;
    public String category;
    public String date; 
    
    
    public ReportController(int rep_id, String title, String description, String category, String date){
    this.rep_id = rep_id;
    this.title = title;
    this.description = description;
    this.category = category;
    this.date = date;
    }
    
    public ReportController( String title, String description, String category, String date){
    
    this.title = title;
    this.description = description;
    this.category = category;
    this.date = date;
    }
    
     public ReportController() {
        
    }
    
              public ResultSet getReportList() {
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM reports";
            rs = DbConnection.select(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
              
              
              public boolean addReport(ReportController rc){
    ReportDAO rd = new ReportDAOImpl();
    ReportModel rm = new ReportModel();
    rm.setTitle(rc.title);
    rm.setDescription(rc.description);
    rm.setCategory(rc.category);
    rm.setDate(rc.date);
    if(rd.create(rm)){
        return true;
    }
    return false;
    }
              
                public boolean updateReport(ReportController rc){
       ReportDAO rd = new ReportDAOImpl();
        ReportModel rm = new ReportModel();
       
        rm.setRep_id(rc.rep_id);
        
        rm.setTitle(rc.title);

        rm.setDescription(rc.description);
        rm.setCategory(rc.category);
        
        rm.setDate(rc.date);
        
            
        
        
        if(rd.update(rm)){
            return true;
        }
        return false;
    }
                
                 public boolean deleteReport(ReportController rc){
             ReportDAO rd = new ReportDAOImpl();
        ReportModel rm = new ReportModel();
        rm.setRep_id(rc.rep_id);
        
            
      
        
        if(rd.delete(rm)){
            return true;
        }
        return false;
    }
    
}
