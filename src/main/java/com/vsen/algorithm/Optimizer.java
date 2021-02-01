package com.vsen.algorithm;

import com.vsen.benchmark.Evaluator;
import com.vsen.pojo.Individual;

import java.util.List;

/**
 * Created by wansenxu@163.com on 2020/12/10
 */
public interface Optimizer {
    List<Individual> optimize(Evaluator evaluator);
}
