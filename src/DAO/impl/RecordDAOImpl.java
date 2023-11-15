/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.impl;
import DAO.RecordDAO;
import dbconfig.DbConnection;
import model.RecordModel;
import java.sql.Connection;
import java.sql.PreparedStatement; 
/**
 *
 * @author dolch
 */
public class RecordDAOImpl implements RecordDAO{

    @Override
    public boolean create(RecordModel rm) {
     boolean status = false;
     Connection conn = null;
    PreparedStatement pstmt = null;
    
    try {
        conn = DbConnection.getConnection();
        pstmt = conn.prepareStatement("INSERT INTO call_records (name, phone,duration, zone) VALUES (?, ?, ?,?)");

        pstmt.setString(1, rm.getName());
        pstmt.setString(2, rm.getPhone());
        pstmt.setString(3, rm.getDuration());
        pstmt.setString(4, rm.getZone());

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
    public boolean view(RecordModel um) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(RecordModel rm) {
        boolean status = false;
    try {
        String sql = "UPDATE `call_records` SET `name`=?, `phone`=?, `duration`=?, `zone`=? WHERE `call_id`=?";
        PreparedStatement pstmt = DbConnection.getConnection().prepareStatement(sql);
        pstmt.setString(1, rm.getName());
        pstmt.setString(2, rm.getPhone());
        pstmt.setString(3, rm.getDuration());
        pstmt.setString(4, rm.getZone());
        pstmt.setInt(5, rm.getCall_id());
       

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
    public boolean delete(RecordModel rm) {
           boolean status = false;
        try {
            String sql = "DELETE FROM `call_records` WHERE call_id ='"+rm.getCall_id()+"'";
            if (DbConnection.iud(sql) > 0) {
                status = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return status;
    }
    
}
