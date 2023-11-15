/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import model.ReportModel;

/**
 *
 * @author dolch
 */
public interface ReportDAO {
    public abstract boolean create(ReportModel rm);
    
   
    
    public abstract boolean view(ReportModel rm);
    
    public abstract boolean update(ReportModel rm);
    
    public abstract boolean delete(ReportModel rm);
}
