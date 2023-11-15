/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import model.RecordModel;

/**
 *
 * @author dolch
 */
public interface RecordDAO {
    public abstract boolean create(RecordModel um);
    
   
    
    public abstract boolean view(RecordModel um);
    
    public abstract boolean update(RecordModel um);
    
    public abstract boolean delete(RecordModel um);
}
