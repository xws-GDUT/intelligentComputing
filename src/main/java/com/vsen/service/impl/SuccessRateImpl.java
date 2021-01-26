package com.vsen.service.impl;

import com.vsen.dao.SuccessRateDao;
import com.vsen.service.SuccessRateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("successRateImpl")
public class SuccessRateImpl implements SuccessRateService {
    @Resource(name="successRateDao")
    SuccessRateDao successRateDao;

    @Override
    public Boolean updateSuccessRate(String strategy, int successCount, String targetFunction) {
        return successRateDao.updateSuccessRate(strategy,successCount,targetFunction);
    }


//
//    @Override
//    public Boolean updateF1(String strategy,int successCount) {
//        return successRateDao.updateF1(strategy,successCount);
//    }
//
//    @Override
//    public Boolean updateF2(String strategy, int successCount) {
//        return successRateDao.updateF2(strategy,successCount);
//    }
//
//    @Override
//    public Boolean updateF3(String strategy, int successCount) {
//        return successRateDao.updateF3(strategy,successCount);
//    }
//
//    @Override
//    public Boolean updateF4(String strategy, int successCount) {
//        return successRateDao.updateF4(strategy,successCount);
//    }
//
//    @Override
//    public Boolean updateF5(String strategy, int successCount) {
//        return successRateDao.updateF5(strategy,successCount);
//    }
//
//    @Override
//    public Boolean updateF6(String strategy, int successCount) {
//        return successRateDao.updateF6(strategy,successCount);
//    }
//
//    @Override
//    public Boolean updateF7(String strategy, int successCount) {
//        return successRateDao.updateF7(strategy,successCount);
//    }
//
//    @Override
//    public Boolean updateF8(String strategy, int successCount) {
//        return successRateDao.updateF8(strategy,successCount);
//    }
//
//    @Override
//    public Boolean updateF9(String strategy, int successCount) {
//        return successRateDao.updateF9(strategy,successCount);
//    }
//
//    @Override
//    public Boolean updateF10(String strategy, int successCount) {
//        return successRateDao.updateF10(strategy,successCount);
//    }
//
//    @Override
//    public Boolean updateF11(String strategy, int successCount) {
//        return successRateDao.updateF11(strategy,successCount);
//    }
//
//    @Override
//    public Boolean updateF12(String strategy, int successCount) {
//        return successRateDao.updateF12(strategy,successCount);
//    }
//
//    @Override
//    public Boolean updateF13(String strategy, int successCount) {
//        return successRateDao.updateF13(strategy,successCount);
//    }
}
