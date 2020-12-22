package com.vsen.dao;

import com.vsen.util.DBUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;

@Repository("bestDao")
public class BestDao {
    @Resource(name = "dbUtils")
    DBUtils dbUtils;

    public Boolean updateF1(String strategy,double fitness) {
        String sql = "UPDATE best " +
                "SET F1=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(fitness),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public Boolean updateF2(String strategy, double fitness) {
        String sql = "UPDATE best " +
                "SET F2=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(fitness),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public Boolean updateF3(String strategy, double fitness) {
        String sql = "UPDATE best " +
                "SET F3=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(fitness),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public Boolean updateF4(String strategy, double fitness) {
        String sql = "UPDATE best " +
                "SET F4=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(fitness),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public Boolean updateF5(String strategy, double fitness) {
        String sql = "UPDATE best " +
                "SET F5=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(fitness),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public Boolean updateF6(String strategy, double fitness) {
        String sql = "UPDATE best " +
                "SET F6=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(fitness),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public Boolean updateF7(String strategy, double fitness) {
        String sql = "UPDATE best " +
                "SET F7=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(fitness),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public Boolean updateF8(String strategy, double fitness) {
        String sql = "UPDATE best " +
                "SET F8=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(fitness),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public Boolean updateF9(String strategy, double fitness) {
        String sql = "UPDATE best " +
                "SET F9=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(fitness),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public Boolean updateF10(String strategy, double fitness) {
        String sql = "UPDATE best " +
                "SET F10=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(fitness),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public Boolean updateF11(String strategy, double fitness) {
        String sql = "UPDATE best " +
                "SET F11=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(fitness),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public Boolean updateF12(String strategy, double fitness) {
        String sql = "UPDATE best " +
                "SET F12=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(fitness),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public Boolean updateF13(String strategy, double fitness) {
        String sql = "UPDATE best " +
                "SET F13=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(fitness),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
