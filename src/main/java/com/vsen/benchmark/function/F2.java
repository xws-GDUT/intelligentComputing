package com.vsen.benchmark.function;

import com.vsen.benchmark.Bound;
import com.vsen.benchmark.Evaluator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wansenxu@163.com on 2020/11/5
 */
@Component("f2")
public class F2 implements Evaluator {
    @Resource(name = "f2_bound")
    private Bound bound;
    @Override
    public Double evaluate(List<Double> solution) {
        double sum_plus=0;
        double sum_multiply=1;
        for (int i = 0; i < solution.size(); i++){
            sum_plus += Math.abs(solution.get(i));
            sum_multiply*=Math.abs(solution.get(i));
        }
        return sum_plus+sum_multiply;
    }

    @Override
    public Bound getBound() {
        return bound;
    }

    public void setBound(Bound bound) {
        this.bound = bound;
    }
}
