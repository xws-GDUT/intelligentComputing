package com.vsen.service.impl;

import com.vsen.dao.AverageOptimalValueDao;
import com.vsen.service.AverageOptimalValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("averageOptimalValueServiceImpl")
public class AverageOptimalValueServiceImpl implements AverageOptimalValueService {
    @Resource(name="averageOptimalValueDao")
    AverageOptimalValueDao averageOptimalValueDao;
    @Override
    public Boolean updateAverageOptimalValue(String strategy,double fitness,String targetFunction) {
        return averageOptimalValueDao.updateAverageOptimalValue(strategy,fitness,targetFunction);
    }
}
