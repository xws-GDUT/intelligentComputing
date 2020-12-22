package com.vsen.service.impl;

import com.vsen.dao.BestDao;
import com.vsen.service.BestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("bestServiceImpl")
public class BestServiceImpl implements BestService {
    @Resource(name="bestDao")
    BestDao bestDao;
    @Override
    public Boolean updateF1(String strategy,double fitness) {
        return bestDao.updateF1(strategy,fitness);
    }

    @Override
    public Boolean updateF2(String strategy, double fitness) {
        return bestDao.updateF2(strategy,fitness);
    }

    @Override
    public Boolean updateF3(String strategy, double fitness) {
        return bestDao.updateF3(strategy,fitness);
    }

    @Override
    public Boolean updateF4(String strategy, double fitness) {
        return bestDao.updateF4(strategy,fitness);
    }

    @Override
    public Boolean updateF5(String strategy, double fitness) {
        return bestDao.updateF5(strategy,fitness);
    }

    @Override
    public Boolean updateF6(String strategy, double fitness) {
        return bestDao.updateF6(strategy,fitness);
    }

    @Override
    public Boolean updateF7(String strategy, double fitness) {
        return bestDao.updateF7(strategy,fitness);
    }

    @Override
    public Boolean updateF8(String strategy, double fitness) {
        return bestDao.updateF8(strategy,fitness);
    }

    @Override
    public Boolean updateF9(String strategy, double fitness) {
        return bestDao.updateF9(strategy,fitness);
    }

    @Override
    public Boolean updateF10(String strategy, double fitness) {
        return bestDao.updateF10(strategy,fitness);
    }

    @Override
    public Boolean updateF11(String strategy, double fitness) {
        return bestDao.updateF11(strategy,fitness);
    }

    @Override
    public Boolean updateF12(String strategy, double fitness) {
        return bestDao.updateF12(strategy,fitness);
    }

    @Override
    public Boolean updateF13(String strategy, double fitness) {
        return bestDao.updateF13(strategy,fitness);
    }
}
