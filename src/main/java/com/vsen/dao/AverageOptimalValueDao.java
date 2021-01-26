package com.vsen.dao;

import com.vsen.util.DBUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;

@Repository("averageOptimalValueDao")
public class AverageOptimalValueDao {
    @Resource(name = "dbUtils")
    DBUtils dbUtils;

    public Boolean updateAverageOptimalValue(String strategy,double fitness,String targetFunction) {
        String sql = "UPDATE average_optimal_value " +
                "SET "+targetFunction+"=? where strategy = ? ";
        Boolean result = false;
        try {
            result = dbUtils.executeUpdate(sql,String.valueOf(fitness),strategy);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

}
