/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import model.UserModel;

/**
 *
 * @author dolch
 */
public interface UserDAO {
    public abstract boolean create(UserModel um);
    
    public abstract boolean login(UserModel um);
    
    public abstract boolean view(UserModel um);
    
    public abstract boolean update(UserModel um);
    
    public abstract boolean delete(UserModel um);
}
