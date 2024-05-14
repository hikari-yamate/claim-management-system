package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MySqlConnection implements IConnection {
    
    private final String url = "jdbc:mysql://localhost:3306/library_management";
    private final String username = "root";
    private final String password = "20112001";

    @Override
    public Connection getConnetion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


}