/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import model.EmployeeModel;

/**
 *
 * @author dolch
 */
public interface EmployeeDAO {
    public abstract boolean create(EmployeeModel em);
    
    public abstract boolean view(EmployeeModel em);
    
    public abstract boolean select(EmployeeModel em);
    
    public abstract boolean delete(EmployeeModel em);
    
    public abstract boolean update(EmployeeModel em);
    
    public abstract boolean edit(EmployeeModel em);
}
