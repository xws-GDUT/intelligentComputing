package com.vsen.dao;

import com.vsen.util.DBUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;

@Repository("successRateDao")
public class SuccessRateDao {
    @Resource(name = "dbUtils")
    DBUtils dbUtils;

    public Boolean updateSuccessRate(String strategy, int successCount, String targetFunction) {
        String sql = "UPDATE success_rate " +
                "SET "+targetFunction+"=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(successCount),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
