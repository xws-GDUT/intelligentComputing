package com.vsen.dao;

import com.vsen.util.DBUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;

@Repository("successRateDao")
public class SuccessRateDao {
    @Resource(name = "dbUtils")
    DBUtils dbUtils;

    public Boolean updateF1(String strategy, int successCount) {
        String sql = "UPDATE success_rate " +
                "SET F1=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(successCount),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public Boolean updateF2(String strategy, int successCount) {
        String sql = "UPDATE success_rate " +
                "SET F2=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(successCount),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public Boolean updateF3(String strategy, int successCount) {
        String sql = "UPDATE success_rate " +
                "SET F3=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(successCount),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public Boolean updateF4(String strategy, int successCount) {
        String sql = "UPDATE success_rate " +
                "SET F4=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(successCount),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public Boolean updateF5(String strategy, int successCount) {
        String sql = "UPDATE success_rate " +
                "SET F5=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(successCount),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public Boolean updateF6(String strategy, int successCount) {
        String sql = "UPDATE success_rate " +
                "SET F6=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(successCount),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public Boolean updateF7(String strategy, int successCount) {
        String sql = "UPDATE success_rate " +
                "SET F7=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(successCount),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public Boolean updateF8(String strategy, int successCount) {
        String sql = "UPDATE success_rate " +
                "SET F8=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(successCount),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public Boolean updateF9(String strategy, int successCount) {
        String sql = "UPDATE success_rate " +
                "SET F9=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(successCount),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public Boolean updateF10(String strategy, int successCount) {
        String sql = "UPDATE success_rate " +
                "SET F10=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(successCount),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public Boolean updateF11(String strategy, int successCount) {
        String sql = "UPDATE success_rate " +
                "SET F11=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(successCount),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public Boolean updateF12(String strategy, int successCount) {
        String sql = "UPDATE success_rate " +
                "SET F12=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(successCount),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public Boolean updateF13(String strategy, int successCount) {
        String sql = "UPDATE success_rate " +
                "SET F13=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(successCount),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

//    public Boolean update(String strategy, String targetFunction, int successCount) {
//        String sql = "UPDATE success_rate " +
//                "SET ?=? where strategy = ? ";
//        Boolean result = false;
//        try {
//            result = dbUtils.executeUpdate(sql,targetFunction,String.valueOf(successCount),strategy);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return result;
//    }
}
