package model;

import java.sql.*;

public class DBModel {

    public Connection CONN;
    public Statement STMT;
    public ResultSet RS,RS1,RS2,RS3,RS4;
    public PreparedStatement PSTMT,PSTMT1,PSTMT2,PSTMT3,PSTMT4;
    public String LOAD_DRIVER = "com.mysql.jdbc.Driver";
    public String CONN_STRING = "jdbc:mysql://localhost:3306/harian";
    public String CONN_STRING2 = "jdbc:mysql://localhost:3306/harian";
    public String DB_USER = "root";
    public String DB_PWD = "root";
    public String QUERY,QUERY1,QUERY2,QUERY3,QUERY4;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(LOAD_DRIVER);
        CONN = DriverManager.getConnection(CONN_STRING, DB_USER, DB_PWD);
        return CONN;
    }

    public void queryExecuter(String QUERY) throws SQLException, ClassNotFoundException {
        DBModel d = new DBModel();
        CONN = d.getConnection();
        STMT = CONN.createStatement();
        STMT.executeUpdate(QUERY);
        // CONN.close();
    }

    public ResultSet queryReturner(String QUERY) throws SQLException, ClassNotFoundException {
        DBModel d = new DBModel();
        CONN = d.getConnection();
        STMT = CONN.createStatement();
        RS = STMT.executeQuery(QUERY);
        //CONN.close();
        return RS;
    }

    public PreparedStatement prePare(String QUERY) throws SQLException, ClassNotFoundException {
        DBModel d = new DBModel();
        CONN = d.getConnection();
        PSTMT = CONN.prepareStatement(QUERY);
        CONN.close();
        return PSTMT;
    }
//*========================================================================================================================*/
    /*===================this fo harian_db ======================================*/
    public Connection getConnectionHarian_db() throws ClassNotFoundException, SQLException {
        Class.forName(LOAD_DRIVER);
        CONN = DriverManager.getConnection(CONN_STRING2, DB_USER, DB_PWD);
        return CONN;
    }

    public void queryExecuterHarian_db(String QUERY) throws SQLException, ClassNotFoundException {
        DBModel d = new DBModel();
        CONN = d.getConnectionHarian_db();
        STMT = CONN.createStatement();
        STMT.executeUpdate(QUERY);
        CONN.close();
    }

    public ResultSet queryReturnerHarian_db(String QUERY) throws SQLException, ClassNotFoundException {
        DBModel d = new DBModel();
        CONN = d.getConnectionHarian_db();
        STMT = CONN.createStatement();
        RS = STMT.executeQuery(QUERY);
        
        return RS;
        //CONN.close();
    }

    public PreparedStatement prePareHarian_db(String QUERY) throws SQLException, ClassNotFoundException {
        DBModel d = new DBModel();
        CONN = d.getConnectionHarian_db();
        PSTMT = CONN.prepareStatement(QUERY);
        CONN.close();
        return PSTMT;
    }

    
}