/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.UserDAO;
import DAO.impl.UserDAOImpl;
import model.UserModel;
import java.sql.ResultSet;
import dbconfig.DbConnection;
/**
 *
 * @author dolch
 */
public class UserController {
      public int user_id;
    public int emp_id;
    public  String name;
    public String email;
    public String password;
    public String phone;
    public String gender;
    public String job_title;
    public String usertype;
    
    public UserController(int emp_id, String name, String email, String password, String phone, String gender, String job_title,String usertype)
    {
    this.emp_id = emp_id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.phone = phone;
    this.gender = gender;
    this.job_title = job_title;
    this.usertype = usertype;
    }
    
        public boolean addUser(UserController uc){
    UserDAO ud = new UserDAOImpl();
    UserModel um = new UserModel();
    um.setEmp_id(uc.emp_id);
    um.setName(uc.name);
    um.setUsertype(uc.usertype);
    um.setEmail(uc.email);
    um.setPassword(uc.password);
    um.setPhone(uc.phone);
    um.setGender(uc.gender);
    um.setJob_title(uc.job_title);
    if(ud.create(um)){
        return true;
    }
    return false;
    }
        
         public UserController(String email, String password, int emp_id, String user_type){
        this.email = email;
        this.password = password;
        this.emp_id = emp_id;
        this.usertype = user_type;
    }
        public boolean doLogin(UserController uc) {
        UserDAO ud = new UserDAOImpl();
        UserModel um = new UserModel();
        um.setEmp_id(uc.emp_id);
        um.setEmail(uc.email);
        um.setPassword(uc.password);
        um.setUsertype(uc.usertype);
        
        if (!ud.login(um)){
            return false;
        }
        return true;
    }
        
        
      
      public UserController() {
        
    }
          
          public ResultSet getUserList() {
        ResultSet rs = null;
        try {
            String sql = "SELECT user_id,emp_id, name, email, password, phone, gender, job_title FROM users WHERE usertype = 'USER' ";
            rs = DbConnection.select(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
          
          
              public boolean updateUser(UserController uc){
       UserDAO ud = new UserDAOImpl();
        UserModel um = new UserModel();
       
        um.setUser_id(uc.user_id);
        um.setEmp_id(uc.emp_id);
        um.setName(uc.name);
        um.setEmail(uc.email);
        um.setPassword(uc.password);
        um.setPhone(uc.phone);
        um.setGender(uc.gender);
        um.setJob_title(uc.job_title);
        um.setUsertype(uc.usertype);
        
            
        
        
        if(ud.update(um)){
            return true;
        }
        return false;
    }
              
         public boolean deleteUser(UserController uc){
             UserDAO ud = new UserDAOImpl();
        UserModel um = new UserModel();
        um.setUser_id(uc.user_id);
        um.setEmp_id(uc.emp_id);
            
      
        
        if(ud.delete(um)){
            return true;
        }
        return false;
    }
}

