package com.vsen.benchmark.function;

import com.vsen.benchmark.Bound;
import com.vsen.benchmark.Evaluator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wansenxu@163.com on 2020/12/11
 */
@Component("f3")
public class F3 implements Evaluator {
    @Resource(name = "f3_bound")
    private Bound bound;
    @Override
    public Double evaluate(List<Double> solution) {
        double sum=0;
        for (int i = 0; i < solution.size(); i++){
            double sub_sum=0;
            for(int j=0;j<solution.size();j++){
                sub_sum+=solution.get(j);
            }
            sum+=Math.pow(sub_sum,2);
        }
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
