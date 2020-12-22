package com.vsen.benchmark;

import java.util.List;

/**
 * Created by wansenxu@163.com on 2020/12/10
 */
public interface Evaluator{
    Double evaluate(List<Double> solution);
    Bound getBound();
}
