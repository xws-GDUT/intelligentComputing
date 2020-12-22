package com.vsen.util;

import com.sun.rowset.CachedRowSetImpl;
import org.springframework.stereotype.Component;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created by wansenxu@163.com on 2020/12/7
 */
@Component("dbUtils")
public class DBUtils {

    private String username;
    private String password;
    private String url;
    static {
        new DBUtils();
    }
    public DBUtils(){
        try {
            ResourceBundle resourceBundle= ResourceBundle.getBundle("database");
            String driver = resourceBundle.getString("driver");
            Class.forName(driver);
            username = resourceBundle.getString("username");
            password = resourceBundle.getString("password");
            url = resourceBundle.getString("url");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("----------------------------------");
        }
    }

    public RowSet executeQuery(String sql, String... paraments) throws SQLException {
        CachedRowSet  rowSet=new CachedRowSetImpl();

        try (
            Connection connection = DriverManager.getConnection(this.url, this.username,this.password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            for (int i = 0; i < paraments.length; i++) {
                preparedStatement.setString(i + 1, paraments[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            rowSet.populate(resultSet);
        }
        return rowSet;
    }
    public boolean executeUpdate(String sql, String... paraments) throws SQLException {
        boolean result;
        try (
            Connection connection = DriverManager.getConnection(this.url, this.username,this.password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){
            for (int i = 0; i < paraments.length; i++) {
                preparedStatement.setString(i + 1, paraments[i]);
            }
            result = preparedStatement.execute();
        }
        return result;
    }
}
