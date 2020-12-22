package com.vsen.benchmark.function;

import com.vsen.benchmark.Bound;
import com.vsen.benchmark.Evaluator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wansenxu@163.com on 2020/12/11
 */
@Component("f11")
public class F11 implements Evaluator {
    @Resource(name = "f11_bound")
    private Bound bound;
    @Override
    public Double evaluate(List<Double> solution) {
        double sum;
        double sum_plus=0;
        double sum_multiply=1;
        for (int i = 0; i < solution.size(); i++){
            sum_plus += Math.pow(solution.get(i),2);
            sum_multiply *= Math.cos(solution.get(i)/Math.sqrt(i+1));
        }
        sum = (1.0/4000.0)*sum_plus - sum_multiply +1;
        return sum;
    }

    @Override
    public Bound getBound() {
        return bound;
    }

    public void setBound(Bound bound) {
        this.bound = bound;
    }
}
