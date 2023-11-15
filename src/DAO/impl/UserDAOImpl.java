/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.impl;

import DAO.UserDAO;
import model.UserModel;
import dbconfig.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;

/**
 *
 * @author dolch
 */
public class UserDAOImpl implements UserDAO{

    @Override
    public boolean create(UserModel um) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
       try  {
         conn = DbConnection.getConnection();
        pstmt = conn.prepareStatement("INSERT INTO users ( emp_id, name, email, password, phone, gender, job_title, usertype)"
                 + "VALUES (?, ?, ?,?,?,?,?,?)");
        pstmt.setInt(1, um.getEmp_id());
        pstmt.setString(2, um.getName());
        pstmt.setString(3, um.getEmail());
        pstmt.setString(4, um.getPassword());
        pstmt.setString(5, um.getPhone());
        pstmt.setString(6, um.getGender());
        pstmt.setString(7, um.getJob_title());
        pstmt.setString(8,um.getUsertype());
       
        
        if (pstmt.executeUpdate() > 0) {
            status = true;
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    finally {
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
public boolean login(UserModel um) {
    String sql = "SELECT email, password, usertype, emp_id FROM users WHERE emp_id=?";
    boolean status = false;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        conn = DbConnection.getConnection();
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, um.getEmp_id());
        rs = pstmt.executeQuery();

        while (rs.next()) {
            if (rs.getString("email").equals(um.getEmail()) &&
                    rs.getString("usertype").equals(um.getUsertype()) &&
                    rs.getString("password").equals(um.getPassword()) &&
                    rs.getInt("emp_id") == um.getEmp_id()) {
                status = true;
                break;
            }
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    } finally {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                System.out.println("Error closing result set: " + e.getMessage());
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (Exception e) {
                System.out.println("Error closing prepared statement: " + e.getMessage());
            }
        }
       
    }

    return status;
}



    @Override
    public boolean view(UserModel um) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(UserModel um) {
      boolean status = false;
    try {
        Connection connection = DbConnection.getConnection();
        

        String usersQuery = "UPDATE users SET name=?, email=?, phone=?, password=?, gender=?, job_title=? WHERE emp_id=? AND user_id=?";
        PreparedStatement usersStatement = connection.prepareStatement(usersQuery);
        usersStatement.setString(1, um.getName());
        usersStatement.setString(2, um.getEmail());
        usersStatement.setString(3, um.getPhone());
        usersStatement.setString(4, um.getPassword());
        usersStatement.setString(5, um.getGender());
        usersStatement.setString(6, um.getJob_title());
        usersStatement.setInt(7, um.getEmp_id());
        usersStatement.setInt(8, um.getUser_id());
        
    
        String employeesQuery = "UPDATE employees SET name=?, email=?, job_title=? WHERE emp_id=?";
        PreparedStatement employeesStatement = connection.prepareStatement(employeesQuery);
        employeesStatement.setString(1, um.getName());
        employeesStatement.setString(2, um.getEmail());
        employeesStatement.setString(3, um.getJob_title());
        employeesStatement.setInt(4, um.getEmp_id());
        
      
        int usersUpdateCount = usersStatement.executeUpdate();
        int employeesUpdateCount = employeesStatement.executeUpdate();
   
        if (usersUpdateCount > 0 && employeesUpdateCount > 0) {
            status = true;
        }
    
        usersStatement.close();
        employeesStatement.close();
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return status;
    }

    @Override
    public boolean delete(UserModel um) {
 boolean status = false;
    try {
        Connection connection = DbConnection.getConnection();
        
      
        String usersQuery = "DELETE FROM users WHERE user_id = ?";
        PreparedStatement usersStatement = connection.prepareStatement(usersQuery);
        usersStatement.setInt(1, um.getUser_id());
        
        
        String employeesQuery = "DELETE FROM employees WHERE emp_id = ?";
        PreparedStatement employeesStatement = connection.prepareStatement(employeesQuery);
        employeesStatement.setInt(1, um.getEmp_id());
        
   
        int usersDeleteCount = usersStatement.executeUpdate();
        int employeesDeleteCount = employeesStatement.executeUpdate();
        
       
        if (usersDeleteCount > 0 && employeesDeleteCount > 0) {
            status = true;
        }
        
     
        usersStatement.close();
        employeesStatement.close();
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return status;
    }
}