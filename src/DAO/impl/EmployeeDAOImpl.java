/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.impl;
import DAO.EmployeeDAO;
import dbconfig.DbConnection;
import model.EmployeeModel;
import java.sql.Connection;
import java.sql.PreparedStatement; 

/**
 *
 * @author dolch
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public boolean create(EmployeeModel em) {
      boolean status = false;
    Connection conn = null;
    PreparedStatement pstmt = null;
    
    try {
        conn = DbConnection.getConnection();
        pstmt = conn.prepareStatement("INSERT INTO employees (name, email, job_title) VALUES (?, ?, ?)");

        pstmt.setString(1, em.getName());
        pstmt.setString(2, em.getEmail());
        pstmt.setString(3, em.getJob_title());

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
    public boolean view(EmployeeModel em) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean select(EmployeeModel em) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(EmployeeModel em) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(EmployeeModel em) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean edit(EmployeeModel em) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
