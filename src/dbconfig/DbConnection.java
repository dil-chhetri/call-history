/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbconfig;

/**
 *
 * @author dolch
 */

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DbConnection {

    private static Connection con = null;
    public static Statement stmt;
    private static String db_name = "phone_call_record";
    private static String db_user = "root";
    private static String db_password = "";
    private static String db_host = "localhost";
    private static String db_port = "3306";
    private static String url = "jdbc:mysql://" + db_host + ":" + db_port + "/" + db_name;

    static {
        
        try {
            con = DriverManager.getConnection(url, db_user, db_password);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
    }
/**
 * 
 * @param String sql
 * @return ResultSet
 * @exception SQLException
 * 
 * This function is for creating sql select query and execute the query
 * This function returns the resultset of data from the database
 */
    public static ResultSet select(String sql) {
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

        } catch (SQLException e){
            
           System.out.println("Error: " + e.getMessage());
            }
            return rs;
        }
        

        /**
         * i = insert
         *  u = update
         * d = delete
         * @return int
         * @param sql
         */
        
        public static int iud(String sql){
            int result = 0;
            try {
                stmt = con.createStatement();
                result = stmt.executeUpdate(sql);
                
            }catch(SQLException e){
                System.out.println("Error:" + e.getMessage());
            }
        
            return result;
        } 
   
    public static Connection getConnection() {
        return con;
    }

}
