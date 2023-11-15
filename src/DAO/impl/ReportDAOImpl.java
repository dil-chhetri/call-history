/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.impl;
import DAO.ReportDAO;
import dbconfig.DbConnection;
import model.ReportModel;
import java.sql.Connection;
import java.sql.PreparedStatement; 
/**
 *
 * @author dolch
 */
public class ReportDAOImpl implements ReportDAO{

     @Override
    public boolean create(ReportModel rm) {
     boolean status = false;
     Connection conn = null;
    PreparedStatement pstmt = null;
    
    try {
        conn = DbConnection.getConnection();
        pstmt = conn.prepareStatement("INSERT INTO reports (title, description,category, date) VALUES (?, ?, ?,?)");

        pstmt.setString(1, rm.getTitle());
        pstmt.setString(2, rm.getDescription());
        pstmt.setString(3, rm.getCategory());
        pstmt.setString(4, rm.getDate());

        if (pstmt.executeUpdate() > 0) {
            status = true;
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    } finally {
        // Close the PreparedStatement
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (Exception e) {
                System.out.println("Failed to close PreparedStatement: " + e.getMessage());
            }
        }
        
     
    }
    
    return status;
    }

    @Override
    public boolean view(ReportModel um) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(ReportModel rm) {
        boolean status = false;
    try {
        String sql = "UPDATE `reports` SET `title`=?, `description`=?, `category`=?, `date`=? WHERE `rep_id`=?";
        PreparedStatement pstmt = DbConnection.getConnection().prepareStatement(sql);
        pstmt.setString(1, rm.getTitle());
        pstmt.setString(2, rm.getDescription());
        pstmt.setString(3, rm.getCategory());
        pstmt.setString(4, rm.getDate());
        pstmt.setInt(5, rm.getRep_id());
       

        if (pstmt.executeUpdate() > 0) {
            status = true;
        }

        pstmt.close();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }

    return status;
    }

    @Override
    public boolean delete(ReportModel rm) {
           boolean status = false;
        try {
            String sql = "DELETE FROM `reports` WHERE rep_id ='"+rm.getRep_id()+"'";
            if (DbConnection.iud(sql) > 0) {
                status = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return status;
    }
    
    
}
