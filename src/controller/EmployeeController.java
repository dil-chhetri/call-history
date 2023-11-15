/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.EmployeeDAO;
import DAO.impl.EmployeeDAOImpl;
import dbconfig.DbConnection;
import java.sql.ResultSet;
import model.EmployeeModel;

/**
 *
 * @author dolch
 */
public class EmployeeController {
    public int emp_id;
    public String name;
    public String email;
    public String job_title;
    
    public EmployeeController(String name, String email, String job_title){
    this.name = name;
    this.email = email;
    this.job_title = job_title;
    }
    
    
    public boolean addEmployee(EmployeeController ec){
    EmployeeDAO ed = new EmployeeDAOImpl();
    EmployeeModel em = new EmployeeModel();
    em.setName(ec.name);
    em.setEmail(ec.email);
    em.setJob_title(ec.job_title);
    if(ed.create(em)){
        return true;
    }
    return false;
    }
}
